package com.bartech.sales.sa.ui.PaymentWays;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.ui.base.BaseActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ahmed on 3/17/2018.
 */

public class CheckActivity extends BaseActivity implements PaymentMvpView {
    final int CAMERA_PIC_REQUEST = 1337;
    public static int GALLERY_CODE = 74;
    public int PIC_CODE = 0;
    Activity activity;
    private String images = "";
    @Inject
    PaymentMvpPresenter<PaymentMvpView> mPresenter;
    private Context context;
    @BindView(R.id.txt_date_check)
    TextView txtDateCheck;
    @BindView(R.id.txt_customerName_check)
    TextView txtCustomerNameCheck;
    @BindView(R.id.et_check)
    EditText etPaymentCheck;
    @BindView(R.id.btn_check_payment)
    Button btnCheckPayment;
    @BindView(R.id.btn_check_photo)
    Button btnCheckPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        setUnBinder(ButterKnife.bind(this));
        getActivityComponent().inject(this);
        Intent intent = getIntent();
        String name = intent.getExtras().getString("customerName");
        txtCustomerNameCheck.setText(name);
        //Date & Time
        txtDateCheck.setText(DateUtils.formatDateTime(context, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE | DateUtils.FORMAT_12HOUR));
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String date_str = df.format(cal.getTime());
        txtDateCheck.setText(date_str);

    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.btn_check_payment)
    public void alertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.alert_title_check);
        alertDialog.setMessage(R.string.alert_sure_check);
        alertDialog.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                // Write your code here to invoke YES event
                Toast.makeText(getApplicationContext(), "تم قبض الشيكات من العميل", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialog.setNegativeButton("مراجعه", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                Toast.makeText(getApplicationContext(), "من فضلك تاكد من بيانات الشيكات", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }
        });
        alertDialog.show();


    }

    @OnClick(R.id.btn_check_photo)
    public void openCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PIC_REQUEST);
        btnCheckPhoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OpenCamera();
            }
        });

    }

    private void OpenCamera() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
    }


    @Override

//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == CAMERA_PIC_REQUEST) {
//
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                OpenCamera();
//                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
//
//            } else {
//
//                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
//
//            }
//
//        }
//    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQUEST && resultCode == Activity.RESULT_OK) {
            if (PIC_CODE < 11) {
                OpenCamera();
                PIC_CODE++;
                Bitmap image = (Bitmap) data.getExtras().get("data");
                if (PIC_CODE == 1){
                    ImageView imageview = (ImageView) findViewById(R.id.image_view);
                    imageview.setImageBitmap(image);
                }
                if (PIC_CODE == 2){
                    ImageView imageview1 = (ImageView) findViewById(R.id.image_view1);
                    imageview1.setImageBitmap(image);
                }
                if (PIC_CODE == 3){
                    ImageView imageview2 = (ImageView) findViewById(R.id.image_view2);
                    imageview2.setImageBitmap(image);
                }
                if (PIC_CODE == 4){
                    ImageView imageview3 = (ImageView) findViewById(R.id.image_view3);
                    imageview3.setImageBitmap(image);
                }
                if (PIC_CODE == 5){
                    ImageView imageview4 = (ImageView) findViewById(R.id.image_view4);
                    imageview4.setImageBitmap(image);
                }
                if (PIC_CODE == 6){
                    ImageView imageview5 = (ImageView) findViewById(R.id.image_view5);
                    imageview5.setImageBitmap(image);
                }
                if (PIC_CODE == 7){
                    ImageView imageview6 = (ImageView) findViewById(R.id.image_view6);
                    imageview6.setImageBitmap(image);
                }
                if (PIC_CODE == 8){
                    ImageView imageview7 = (ImageView) findViewById(R.id.image_view7);
                    imageview7.setImageBitmap(image);
                }
                if (PIC_CODE == 9){
                    ImageView imageview8 = (ImageView) findViewById(R.id.image_view8);
                    imageview8.setImageBitmap(image);
                }
                if (PIC_CODE == 10){
                    ImageView imageview9 = (ImageView) findViewById(R.id.image_view9);
                    imageview9.setImageBitmap(image);
                }
            }
        }
    }


    @Override
    public void openCashPaymentActivity() {

    }

    @Override
    public void openCheckPaymentActivity() {

    }




}
