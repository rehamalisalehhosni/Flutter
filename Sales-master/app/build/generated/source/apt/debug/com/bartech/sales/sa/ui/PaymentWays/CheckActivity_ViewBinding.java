// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.PaymentWays;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CheckActivity_ViewBinding implements Unbinder {
  private CheckActivity target;

  private View view2131230768;

  private View view2131230769;

  @UiThread
  public CheckActivity_ViewBinding(CheckActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CheckActivity_ViewBinding(final CheckActivity target, View source) {
    this.target = target;

    View view;
    target.txtDateCheck = Utils.findRequiredViewAsType(source, R.id.txt_date_check, "field 'txtDateCheck'", TextView.class);
    target.txtCustomerNameCheck = Utils.findRequiredViewAsType(source, R.id.txt_customerName_check, "field 'txtCustomerNameCheck'", TextView.class);
    target.etPaymentCheck = Utils.findRequiredViewAsType(source, R.id.et_check, "field 'etPaymentCheck'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_check_payment, "field 'btnCheckPayment' and method 'alertDialog'");
    target.btnCheckPayment = Utils.castView(view, R.id.btn_check_payment, "field 'btnCheckPayment'", Button.class);
    view2131230768 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.alertDialog();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_check_photo, "field 'btnCheckPhoto' and method 'openCamera'");
    target.btnCheckPhoto = Utils.castView(view, R.id.btn_check_photo, "field 'btnCheckPhoto'", Button.class);
    view2131230769 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openCamera();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CheckActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtDateCheck = null;
    target.txtCustomerNameCheck = null;
    target.etPaymentCheck = null;
    target.btnCheckPayment = null;
    target.btnCheckPhoto = null;

    view2131230768.setOnClickListener(null);
    view2131230768 = null;
    view2131230769.setOnClickListener(null);
    view2131230769 = null;
  }
}
