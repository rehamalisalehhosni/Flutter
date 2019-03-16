package com.bartech.sales.sa.ui.PaymentWays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Customers;
import com.bartech.sales.sa.ui.base.BaseActivity;
import com.bartech.sales.sa.ui.cashpayment.CashActivity;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ahmed on 3/17/2018.
 */

public class PaymentActivity extends BaseActivity implements PaymentMvpView {

    @Inject
    PaymentMvpPresenter<PaymentMvpView> mPresenter;
    private String customerName = "";
    private ArrayAdapter<Customers> spinnerAdapter1;
    @BindView(R.id.spinner1)
    SearchableSpinner mSpinner;
    @BindView(R.id.btn_pay_cash)
    Button btnPayCash;
    @BindView(R.id.btn_check)
    Button btnPayCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(PaymentActivity.this);

        //Define spinner
        defineSpinner();

        Customers customers = new Customers();
        customers.setCustomerName("Hassan");
        Customers customers1 = new Customers();
        customers1.setCustomerName("Bartech");
        Customers customers2 = new Customers();
        customers2.setCustomerName("Swilam");
        Customers customers3 = new Customers();
        customers3.setCustomerName("Mohammed");
        spinnerAdapter1.add(customers);
        spinnerAdapter1.add(customers1);
        spinnerAdapter1.add(customers2);
        spinnerAdapter1.add(customers3);
        spinnerAdapter1.notifyDataSetChanged();
    }

    private void defineSpinner() {
        spinnerAdapter1 = new ArrayAdapter<Customers>(this,
                android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerAdapter1);


        // Applying Listener on Spinner :
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                customerName =  spinnerAdapter1.getItem(position).getCustomerName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    protected void setUp() {

    }
    @OnClick(R.id.btn_pay_cash)
    public void OnPayCashClicked(View v){
       mPresenter.onChooseCustomer(btnPayCash.getText().toString());
    }
    @OnClick(R.id.btn_check)
    public void OnCheckClicked(View v){
       mPresenter.onChooseCustomer1(btnPayCheck.getText().toString());
    }

    @Override
    public void openCashPaymentActivity() {
        Intent intent = new Intent(getApplicationContext(), CashActivity.class);
        intent.putExtra("customerName", customerName);
        startActivity(intent);
    }

    @Override
    public void openCheckPaymentActivity() {
        Intent intent1 = new Intent(getApplicationContext(), CheckActivity.class);
        intent1.putExtra("customerName", customerName);
        startActivity(intent1);
    }




}
