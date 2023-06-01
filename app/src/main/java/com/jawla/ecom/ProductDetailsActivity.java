package com.jawla.ecom;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
//import com.example.mr_pizza_app.Model.Product;
//import com.example.mr_pizza_app.Prevalent.Prevalent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jawla.ecom.Model.Product;
import com.jawla.ecom.Prevalent.Prevalent;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ProductDetailsActivity extends AppCompatActivity
{
//private FloatingActionButton addToCartBtn;
private Button addToCartButton;
private ImageView productImage;
private ElegantNumberButton numberButton;
private TextView productPrice, productDescription, productName;
private String productID = "", state = "Normal";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_product_details);

        productID = getIntent().getStringExtra("pid");

     addToCartButton = (Button) findViewById(R.id.pd_add_to_cart_button);
     numberButton = (ElegantNumberButton)findViewById(R.id.number_btn);
     productImage = (ImageView)findViewById(R.id.product_image_details);
     productName = (TextView) findViewById(R.id.product_name_details);
     productDescription = (TextView) findViewById(R.id.product_description_details);
     productPrice = (TextView) findViewById(R.id.product_price_details);

     getProductetails(productID);

     addToCartButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v)
         {


             if (state.equals("Order Placed") || state.equals("Order Shipped"))
             {
                 Toast.makeText(ProductDetailsActivity.this, "you can add purchase more Pizza Item's , Once  your order is  confirmed", Toast.LENGTH_LONG).show();

             }
             else
             {
                 addingToCartlist();
             }

         }
     });

    }

    @Override
    protected void onStart() {
        super.onStart();


        CheckOrderState();


    }

    private void addingToCartlist()
    {
        String saveCurrentTime, saveCurrentDate;

        Calendar calForDate = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("MMM, dd, yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForDate.getTime());

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List");

        final HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("pid", productID);
        cartMap.put("pname", productName.getText().toString());
        cartMap.put("price", productPrice.getText().toString());
        cartMap.put("date", saveCurrentDate);
        cartMap.put("time", saveCurrentTime);
        cartMap.put("quantity", numberButton.getNumber());
        cartMap.put("discount", "");

        cartListRef.child("User View").child(Prevalent.currentonlineUsers.getPhone())
                .child("Products").child(productID)
                .updateChildren(cartMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful())
                        {
                            cartListRef.child("Admin View").child(Prevalent.currentonlineUsers.getPhone())
                                    .child("Products").child(productID)
                                    .updateChildren(cartMap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task)
                                        {
                                            if (task.isSuccessful())
                                            {
                                                Toast.makeText(ProductDetailsActivity.this, "Added to Cart List.", Toast.LENGTH_SHORT).show();

                                                Intent intent = new Intent(ProductDetailsActivity.this, HomeActivity.class);
                                                startActivity(intent);
                                            }
                                        }
                                    });
                        }

                    }
                });


    }


    private void getProductetails(String productID)
    {
        DatabaseReference productRef = FirebaseDatabase.getInstance().getReference().child("Products");

        productRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
            if (dataSnapshot.exists())
            {
                Product product = dataSnapshot.getValue(Product.class);

                productName.setText(product.getPname());
                productPrice.setText(product.getPrice());
                productDescription.setText(product.getDescription());
                Picasso.get().load(product.getImage()).into(productImage);
            }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void CheckOrderState()
    {
        DatabaseReference orderRef;
        orderRef = FirebaseDatabase.getInstance().getReference().child("Orders").child(Prevalent.currentonlineUsers.getPhone());

        orderRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                {
                    String shippingState = dataSnapshot.child("state").getValue().toString();

                    if (shippingState.equals("shipped"))
                    {
                       state = "Order Shippedd";
                    }
                    else if (shippingState.equals("not shipped"))
                    {

                        state = "Order Placed";


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
