package com.bartech.sales.sa.ui.SalesOrder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.bartech.sales.sa.utils.AppConstants;
import com.bartech.sales.sa.utils.CommonUtils;
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
 * Created by Ahmed on 3/13/2018.
 */

public class OrderActivity extends BaseActivity implements SalesMvpView {

    private List<Product> productsList = new ArrayList<>();
    private static int cart_count = 0;
    private ArrayAdapter<Product> spinnerAdapter;
    private int selectedPosition;
    private Context mContext;
    private String customerName;
    private Realm realm;
    @BindView(R.id.spinner)
    SearchableSpinner mSpinner;
    @BindView(R.id.et_quantum)
    EditText quantumEditText;
    @BindView(R.id.txt_unit)
    TextView txtUnit;
    @BindView(R.id.et_price)
    EditText PriceEditText;
    @BindView(R.id.txt_total)
    TextView txtTotal;
    @BindView(R.id.txt_date)
    TextView txt_date;
    @BindView(R.id.btn_submit_sales)
    Button btnSubmitSales;
    @BindView(R.id.txt_customerName)
    TextView txtCustomerName;
    @BindView(R.id.et_details)
    EditText detailsEditText;
    @BindView(R.id.count)
    TextView txtCount;
    @Inject
    SalesMvpPresenter<SalesMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        realm = getRealm();
        mPresenter.onAttach(OrderActivity.this);
        //get customer name
        Intent intent = getIntent();
        customerName = intent.getExtras().getString("customerName");
        txtCustomerName.setText(customerName);
        //Date & Time
        txt_date.setText(DateUtils.formatDateTime(mContext, System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE |
                        DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_12HOUR));
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String date_str = df.format(cal.getTime());
        txt_date.setText(date_str);
        // query data recquantum and recprice
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
                txtTotal.setText(value.toString());


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
                txtTotal.setText(value.toString());

            }
        });
        //Define spinner
        // Applying Listener on Spinner :
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerAdapter.getItem(position).getProductName();
                selectedPosition = position;
                txtUnit.setText(spinnerAdapter.getItem(position).getUnit());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fillSpinnerData();
        RealmQuery<Product> query = realm.where(Product.class).equalTo("addedToCart", true);
        RealmResults<Product> results = query.findAll();
        if (results != null && results.size() > 0)
            txtCount.setText(String.valueOf(results.size()));
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
        productsList.add(product);
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);
        productsList.add(product4);
        spinnerAdapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerAdapter);
        mSpinner.setTitle("اختر المنتج المطلوب....");
        spinnerAdapter.addAll(productsList);
        spinnerAdapter.notifyDataSetChanged();

    }

    @Override
    protected void setUp() {
    }

    @OnClick(R.id.btn_submit_sales)
    public void onSubmitSalesClicked(View v) {
        if (CommonUtils.getPreference(this, AppConstants.CACHED_REFERENCE).equalsIgnoreCase("1")) {
            realm.beginTransaction();
            Product product = realm.createObject(Product.class, UUID.randomUUID().toString());
            product.setProductName(productsList.get(selectedPosition).getProductName());
            product.setUnit(productsList.get(selectedPosition).getUnit());
            product.setPrice(PriceEditText.getText().toString());
            product.setQuantum(quantumEditText.getText().toString());
            product.setTotal(txtTotal.getText().toString());
            product.setAddedToCart(true);
            realm.commitTransaction();
            mPresenter.onSubmitSalesOrderClicked(PriceEditText.getText().toString(),
                    quantumEditText.getText().toString(), txtTotal.getText().toString());
        }
    }

    @OnClick(R.id.count)
    public void onCartClicked(View v) {
        mPresenter.onCartButtonClicked();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openBusinessActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    public void onCartIconClicked() {
        Intent intent = new Intent(this, ProductsActivity.class);
        startActivity(intent);

    }

}