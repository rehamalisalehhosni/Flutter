package com.bartech.sales.sa.ui.salesinvoice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Product;
import com.bartech.sales.sa.ui.base.BaseActivity;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceActivity;
import com.bartech.sales.sa.utils.AppConstants;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ahmed on 3/18/2018.
 */

public class InvoiceActivity extends BaseActivity implements InvoiceMvpView {

    @Inject
    InvoiceMvpPresenter<InvoiceMvpView> mPresenter;
    private List<Product> productList = new ArrayList<>();
    private ArrayAdapter<Product> spinnerAdapter;
    private Realm realm;
    private int selectedPosition;
    private String customerName;
    @BindView(R.id.spinner_inv_data)
    SearchableSpinner mSpinner;
    @BindView(R.id.et_quantum_inv_data)
    EditText quantumEditText;
    @BindView(R.id.txt_unit_inv_data)
    TextView txtUnit;
    @BindView(R.id.et_price_inv_data)
    EditText PriceEditText;
    @BindView(R.id.txt_total_inv_data)
    TextView txtTotal;
    @BindView(R.id.txt_date_inv_data)
    TextView txtDate;
    @BindView(R.id.btn_submit_sales_inv_data)
    Button btnSubmitSales;
    @BindView(R.id.btnShowInvoices)
    Button btnShowInvoices;
    @BindView(R.id.txt_customerName_inv_data)
    TextView txtCustomerName;
    @BindView(R.id.et_details_inv_data)
    EditText detailsEditText;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_data);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(InvoiceActivity.this);
        realm = getRealm();
        setCustomerName();
        setDate();
        quantumEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                Double q = Double.parseDouble(!quantumEditText.getText().toString().isEmpty() ?
                        quantumEditText.getText().toString() : "0");
                Double p = Double.parseDouble(!PriceEditText.getText().toString().isEmpty() ?
                        PriceEditText.getText().toString() : "0");
                Double value = q * p;
                txtTotal.setText(String.valueOf(value));
            }
        });
        PriceEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                Double q = Double.parseDouble(!quantumEditText.getText().toString().isEmpty() ?
                        quantumEditText.getText().toString() : "0");
                Double p = Double.parseDouble(!PriceEditText.getText().toString().isEmpty() ?
                        PriceEditText.getText().toString() : "0");
                Double value = q * p;
                txtTotal.setText(String.valueOf(value));
            }
        });
        //Define spinner
        // Applying Listener on Spinner :
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPosition = position;
                txtUnit.setText(spinnerAdapter.getItem(position).getUnit());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fillSpinnerData();
        updateCachedInvoiceNumber();
    }

    private void setCustomerName() {
        Intent intent = getIntent();
        customerName = intent.getExtras().getString(CustomerInvoiceActivity.CUSTOMER_NAME);
        txtCustomerName.setText(customerName);
    }

    private void updateCachedInvoiceNumber() {
        RealmQuery<Product> query = realm.where(Product.class).equalTo("addedToCart",false);
        RealmResults<Product> results = query.findAll();
        if (results != null && results.size() > 0)
            btnShowInvoices.setText(String.valueOf(results.size()));
    }

    private void setDate() {
        //Date & Time
        txtDate.setText(DateUtils.formatDateTime(context, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_12HOUR));
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT_DATEFORMAT);
        String date_str = df.format(cal.getTime());
        txtDate.setText(date_str);
    }

    private void fillSpinnerData() {
        Product product = new Product();
        product.setProductName("Rice");
        product.setUnit("Kg");
        Product product1 = new Product();
        product1.setProductName("labtop");
        product1.setUnit("number");
        Product product2 = new Product();
        product2.setProductName("Mobile");
        product2.setUnit("Unit");
        Product product3 = new Product();
        product3.setProductName("chocolate");
        product3.setUnit("Package");
        Product product4 = new Product();
        product4.setProductName("Cloth");
        product4.setUnit("Meter");
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        spinnerAdapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerAdapter);
        mSpinner.setTitle("اختر المنتج المطلوب....");
        spinnerAdapter.addAll(productList);
        spinnerAdapter.notifyDataSetChanged();
    }


    @Override
    protected void setUp() {
    }

    @OnClick(R.id.btn_submit_sales_inv_data)
    public void alertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.alert_invoice_title);
        alertDialog.setMessage(R.string.alert_invoice_sure);
        alertDialog.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke YES event
                showMessage("تم اصدار الفاتوره للعميل");
                realm.beginTransaction();
                Product product = realm.createObject(Product.class, UUID.randomUUID().toString());
                product.setProductName(productList.get(selectedPosition).getProductName());
                product.setUnit(productList.get(selectedPosition).getUnit());
                product.setPrice(PriceEditText.getText().toString());
                product.setQuantum(quantumEditText.getText().toString());
                product.setTotal(txtTotal.getText().toString());
                product.setAddedToCart(false);
                realm.commitTransaction();
                mPresenter.onSubmitInvoice(PriceEditText.getText().toString(),
                        quantumEditText.getText().toString(), txtTotal.getText().toString());
                //Reload Activity
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("مراجعه", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
               showMessage("من فضلك تاكد من بيانات الفاتوره");
                dialog.cancel();
            }
        });
        alertDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnShowInvoices)
    public void onShowInvoices(View v) {
        mPresenter.onShowInvoiceClicked();
    }

    @Override
    public void openInvoiceActivity() {

    }

    @Override
    public void onShowSalesInvoiceClicked() {
        Intent intent = new Intent(this, InvoicesShowActivity.class);
        startActivity(intent);
    }
}




