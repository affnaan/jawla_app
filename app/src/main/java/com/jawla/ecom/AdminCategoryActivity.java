package com.jawla.ecom;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity
{
    private ImageView Ppizza, Ppizza1, Ppizza2, Ppizza3;
    private ImageView Pbpizza4, Pbpizza1, Pbpizza2, Pbpizza3;
    private ImageView Pcpiza, Pcpizz1, Pcpizz2, Pcpiza3;
    private Button maintainProducts, logouT, checkOrders;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_admin_category);

//
        Ppizza = (ImageView) findViewById(R.id.pizza);
        Ppizza1 = (ImageView) findViewById(R.id.pizza1);
        Ppizza2 = (ImageView) findViewById(R.id.pizz2);
//        Ppizza3 = (ImageView) findViewById(R.id.pizz3);

        Pbpizza1 = (ImageView) findViewById(R.id.bpizza1);
        Pbpizza2 = (ImageView) findViewById(R.id.bpizza2);
//        Pbpizza3 = (ImageView) findViewById(R.id.bpizza3);
//        Pbpizza4 = (ImageView) findViewById(R.id.bpizza4);

        Pcpiza = (ImageView) findViewById(R.id.e1);
//        Pcpizz1 = (ImageView) findViewById(R.id.e2);
        Pcpizz2 = (ImageView) findViewById(R.id.e3);
        Pcpiza3 = (ImageView) findViewById(R.id.e4);

        logouT = (Button) findViewById(R.id.admin_logout_btn);
        maintainProducts = (Button) findViewById(R.id.admin_maintain_btn);
        checkOrders = (Button) findViewById(R.id.check_orders_btn);





        maintainProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);

            }
        });

        checkOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminNewOrdersActivity.class);
                startActivity(intent);

            }
        });

        logouT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });



        Ppizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "airpods");
                startActivity(intent);
            }
        });


        Ppizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "charger");
                startActivity(intent);
            }
        });


        Ppizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "handfree");
                startActivity(intent);
            }
        });

//
//        Ppizza3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
//                intent.putExtra("category", "Sweathers");
//                startActivity(intent);
//            }
//        });


        Pbpizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "cabel");
                startActivity(intent);
            }
        });


        Pbpizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Wireless");
                startActivity(intent);
            }
        });


//
//        Pbpizza3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
//                intent.putExtra("category", "Wallets Bags Purses");
//                startActivity(intent);
//            }
//        });
//
//
//        Pbpizza4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
//                intent.putExtra("category", "Shoes");
//                startActivity(intent);
//            }
//        });



        Pcpiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "HeadPhones HandFree");
                startActivity(intent);
            }
        });


//        Pcpizz1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
//                intent.putExtra("category", "Laptops");
//                startActivity(intent);
//            }
//        });


        Pcpizz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });


        Pcpiza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "Mobile Phones");
                startActivity(intent);
            }
        });
    }
}
