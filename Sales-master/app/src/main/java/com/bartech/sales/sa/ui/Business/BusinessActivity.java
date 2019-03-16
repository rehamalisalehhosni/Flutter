package com.bartech.sales.sa.ui.Business;

import android.os.Bundle;
import android.widget.Button;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ahmed on 3/12/2018.
 */

public class BusinessActivity extends BaseActivity implements BusinessMvpView {

    @Inject
    BusinessMvpPresenter<BusinessMvpView> mPresenter;
    @BindView(R.id.btn_sales_ord)
    Button btnSalesOrder;
    @BindView(R.id.btn_cash)
    Button btnCashTransaction;
    @BindView(R.id.btn_invoice)
    Button btnSalesInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(BusinessActivity.this);
    }
//    @OnClick(R.id.btn_sales_ord)
//    public void onSalesButtonClicked(){
//        startActivity(new Intent(BusinessActivity.this,CustomerActivity.class));
//    }
//    @OnClick(R.id.btn_cash)
//    public void onCashButtonClicked(){
//        startActivity(new Intent(BusinessActivity.this,PaymentActivity.class));
//
//    }
//    @OnClick(R.id.btn_invoice)
//    public void onFragmentInvoiceButtonClicked() {
//       startActivity(new Intent(BusinessActivity.this,CustomerInvoiceActivity.class));
//
//    }



    @Override
    protected void setUp() {

    }


}
