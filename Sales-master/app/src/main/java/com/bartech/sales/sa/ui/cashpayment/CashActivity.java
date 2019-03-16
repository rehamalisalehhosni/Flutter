package com.bartech.sales.sa.ui.cashpayment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.network.model.Customers;
import com.bartech.sales.sa.ui.base.BaseActivity;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceActivity;
import com.bartech.sales.sa.utils.AppConstants;

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
 * Created by Ahmed on 3/26/2018.
 */

public class CashActivity extends BaseActivity implements CashMvpView {

    @Inject
    CashMvpPresenter<CashMvpView> mPresenter;
    private List<Customers> customersList = new ArrayList<>();
    private Realm realm;
    private String customerName;
    private int selectedPosition;
    @BindView(R.id.txt_customerName_cash)
    TextView txtCustomerNamePayment;
    @BindView(R.id.et_payment)
    EditText etPayment;
    @BindView(R.id.btn_cash_payment)
    Button btnCashPayment;
    @BindView(R.id.btnshowallinvoices)
    Button btnShowInvoices;
    @BindView(R.id.txt_date_cash)
    TextView txt_date_cash;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        mPresenter.onAttach(CashActivity.this);
        realm = getRealm();
        customerName();
        setDate();
        updateCashPaymentNumber();
    }

    private void setDate() {
        //Date & Time
        txt_date_cash.setText(DateUtils.formatDateTime(context, System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE |
                        DateUtils.FORMAT_12HOUR));
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT_DATEFORMAT);
        String date_str = df.format(cal.getTime());
        txt_date_cash.setText(date_str);
    }

    private void updateCashPaymentNumber() {
        RealmQuery<Customers> query = realm.where(Customers.class);
        RealmResults<Customers> results = query.findAll();
        if (results != null && results.size() > 0)
            btnShowInvoices.setText(String.valueOf(results.size()));
    }

    private void customerName() {
        Intent intent = getIntent();
        customerName = intent.getExtras().getString(CustomerInvoiceActivity.CUSTOMER_NAME);
        txtCustomerNamePayment.setText(customerName);
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.btn_cash_payment)
    public void alertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.alert_title);
        alertDialog.setMessage(R.string.alert_sure);
        alertDialog.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                showMessage("تم اصدار امر استلام نقديه من العميل");
                realm.beginTransaction();
                Customers customers = realm.createObject(Customers.class, UUID.randomUUID().toString());
                customers.setCustomerName(txtCustomerNamePayment.getText().toString());
                customers.setTotal(etPayment.getText().toString());
                realm.commitTransaction();
                mPresenter.onSubmitCashInvoice(txtCustomerNamePayment.getText().toString(), etPayment.getText().toString());
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("مراجعه", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                showMessage("من فضلك تاكد من بيانات امر استلام النقديه");
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

    @OnClick(R.id.btnshowallinvoices)
    public void onShowCashPayment(View v) {
        mPresenter.onShowCashPaymentClicked();
    }

    @Override
    public void onShowCashPaymentClicked() {
        Intent intent = new Intent(this, CashShowActivity.class);
        startActivity(intent);
    }

    @Override
    public void openCashActivity() {

    }
}
