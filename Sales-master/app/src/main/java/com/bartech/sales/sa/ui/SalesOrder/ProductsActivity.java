package com.bartech.sales.sa.ui.SalesOrder;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Product;
import com.bartech.sales.sa.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ahmed on 3/19/2018.
 */

public class ProductsActivity extends BaseActivity {
    private List<Product> productList = new ArrayList<>();
    private CachedOrderAdapter mAdapter;
    private Realm realm;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_content);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        realm = getRealm();
        readCachedData();
        mAdapter = new CachedOrderAdapter(productList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setAdapter(mAdapter);

    }

    private void readCachedData() {
        RealmQuery<Product> query = realm.where(Product.class).equalTo("addedToCart",true);
        RealmResults<Product> results = query.findAll();
        for (int i = 0; i < results.size(); i++) {
            Product product = new Product();
            product.setProductName(results.get(i).getProductName());
            product.setId(results.get(i).getId());
            product.setQuantum(results.get(i).getQuantum());
            product.setPrice(results.get(i).getPrice());
            product.setTotal(results.get(i).getTotal());
            product.setUnit(results.get(i).getUnit());
            productList.add(product);
        }
    }

    @Override
    protected void setUp() {

    }
}
