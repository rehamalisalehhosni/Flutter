package com.bartech.sales.sa.ui.cashpayment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Customers;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ahmed on 3/26/2018.
 */

public class CashAdapter extends RecyclerView.Adapter<CashAdapter.MyViewHolder> {
    private List<Customers> customersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_cash_customer)
        TextView txtCustomerName;
        @BindView(R.id.txt_total_cash)
        TextView txtTotalCash;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public CashAdapter(List<Customers> customersList) {
        this.customersList = customersList;
    }

    @Override
    public CashAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cash_list_cell, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CashAdapter.MyViewHolder holder, int position) {
        Customers customers = customersList.get(position);
        holder.txtCustomerName.setText(customers.getCustomerName());
        holder.txtTotalCash.setText(customers.getTotal());
    }

    @Override
    public int getItemCount() {
        return (customersList.size());
    }
}
