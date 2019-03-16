package com.bartech.sales.sa.ui.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.LoginResponse;
import com.bartech.sales.sa.ui.PaymentWays.PaymentActivity;
import com.bartech.sales.sa.ui.base.BaseActivity;
import com.bartech.sales.sa.ui.customer.CustomerActivity;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceActivity;
import com.bartech.sales.sa.utils.AppConstants;
import com.bartech.sales.sa.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ahmed on 3/31/2018.
 */

public class MainScreenActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;
    @BindView(R.id.btn_cached_data)
    Button btnCachedData;
    @BindView(R.id.btn_sales_ord)
    Button btnSalesOrder;
    @BindView(R.id.btn_cash)
    Button btnCashTransaction;
    @BindView(R.id.btn_invoice)
    Button btnSalesInvoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(MainScreenActivity.this);

        LoginResponse response = CommonUtils.getUser(this);


    }

    @OnClick(R.id.btn_cached_data)
    public void onButtonCachedDataClicked() {
        CommonUtils.setPreference(this, AppConstants.CACHED_REFERENCE, "1");
    }

    @OnClick(R.id.btn_sales_ord)
    public void onSalesButtonClicked() {
        startActivity(new Intent(MainScreenActivity.this, CustomerActivity.class));
    }

    @OnClick(R.id.btn_cash)
    public void onCashButtonClicked() {
        startActivity(new Intent(MainScreenActivity.this, PaymentActivity.class));

    }

    @OnClick(R.id.btn_invoice)
    public void onFragmentInvoiceButtonClicked() {
        startActivity(new Intent(MainScreenActivity.this, CustomerInvoiceActivity.class));

    }

    @Override
    protected void setUp() {

    }


}
