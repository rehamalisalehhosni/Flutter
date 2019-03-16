package com.bartech.sales.sa.ui.SalesOrder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ahmed on 3/19/2018.
 */

public class CachedOrderAdapter extends RecyclerView.Adapter<CachedOrderAdapter.MyViewHolder> {
    private List<Product> productList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_product)
        TextView txtProduct;
        @BindView(R.id.txt_quantum)
        TextView txtQuantum;
        @BindView(R.id.txt_price)
        TextView txtPrice;
        @BindView(R.id.txt_unit)
        TextView txtUnit;
        @BindView(R.id.txt_total)
        TextView txtTotal;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public CachedOrderAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public CachedOrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_cell, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(CachedOrderAdapter.MyViewHolder holder, int position) {
        Product product = productList.get(position);
        //holder.txtCustomerName.setText(product.get());
        holder.txtProduct.setText(product.getProductName());
        holder.txtQuantum.setText(product.getQuantum());
        holder.txtPrice.setText(product.getPrice());
        holder.txtTotal.setText(product.getTotal());
        holder.txtUnit.setText(product.getUnit());


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }
}
