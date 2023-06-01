package com.jawla.ecom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<MyItems> items;
    private final Context context;

    public MyAdapter(List<MyItems> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate( R.layout.recycleview_adapter_layout, null)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        MyItems myItems = items.get(position);

        holder.name.setText(myItems.getName());
        holder.phone.setText(myItems.getPhone());
        holder.password.setText(myItems.getPassword());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static  class  MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name, password, phone;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

             name = itemView.findViewById(R.id.fullname);
             password = itemView.findViewById(R.id.email);
             phone = itemView.findViewById(R.id.mobile);
        }
    }
}
