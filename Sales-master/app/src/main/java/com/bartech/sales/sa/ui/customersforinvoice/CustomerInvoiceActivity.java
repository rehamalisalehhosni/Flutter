package com.bartech.sales.sa.ui.customersforinvoice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Customers;
import com.bartech.sales.sa.ui.base.BaseActivity;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceActivity;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ahmed on 3/15/2018.
 */

public class CustomerInvoiceActivity extends BaseActivity implements CustomerInvoiceMvpView {

    @Inject
    CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView> mPresenter;
    private ArrayAdapter<Customers> spinnerAdapter1;
    @BindView(R.id.txt_customer)
    TextView txtCustomer;
    @BindView(R.id.spinner1)
    SearchableSpinner mSpinner;
    @BindView(R.id.btn_customer_name)
    Button chooseButton;
    private String customerName = "";
    public  static  final  String CUSTOMER_NAME="customerName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(CustomerInvoiceActivity.this);

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

    @OnClick(R.id.btn_customer_name)
    public void onChooseCustomerSubmitted(View v) {
        mPresenter.onChooseCustomer(chooseButton.getText().toString());
    }

    @Override
    public void openSalesActivity() {
        Intent intent = new Intent(getApplicationContext(), InvoiceActivity.class);
        intent.putExtra(CUSTOMER_NAME, customerName);
        startActivity(intent);
        finish();
    }
}
