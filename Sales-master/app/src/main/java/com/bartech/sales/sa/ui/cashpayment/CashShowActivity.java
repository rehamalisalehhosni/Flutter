package com.bartech.sales.sa.ui.cashpayment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Customers;
import com.bartech.sales.sa.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ahmed on 3/26/2018.
 */

public class CashShowActivity extends BaseActivity {

    private List<Customers> customersList = new ArrayList<>();
    private CashAdapter mAdapter;
    private Realm realm;
    @BindView(R.id.recycler_cash)
    RecyclerView mRecycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_content);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        realm = getRealm();
        RealmQuery<Customers> query = realm.where(Customers.class);
        RealmResults<Customers> results = query.findAll();
        for (int i = 0; i < results.size(); i++) {
            Customers customers = new Customers();
            customers.setCustomerName(results.get(i).getCustomerName());
            customers.setId(results.get(i).getId());
            customers.setTotal(results.get(i).getTotal());
            customersList.add(customers);
        }
        mAdapter = new CashAdapter(customersList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setAdapter(mAdapter);

    }

    @Override
    protected void setUp() {

    }
}
