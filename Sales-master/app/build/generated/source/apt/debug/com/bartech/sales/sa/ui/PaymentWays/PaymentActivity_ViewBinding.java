// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.PaymentWays;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PaymentActivity_ViewBinding implements Unbinder {
  private PaymentActivity target;

  private View view2131230778;

  private View view2131230767;

  @UiThread
  public PaymentActivity_ViewBinding(PaymentActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PaymentActivity_ViewBinding(final PaymentActivity target, View source) {
    this.target = target;

    View view;
    target.mSpinner = Utils.findRequiredViewAsType(source, R.id.spinner1, "field 'mSpinner'", SearchableSpinner.class);
    view = Utils.findRequiredView(source, R.id.btn_pay_cash, "field 'btnPayCash' and method 'OnPayCashClicked'");
    target.btnPayCash = Utils.castView(view, R.id.btn_pay_cash, "field 'btnPayCash'", Button.class);
    view2131230778 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnPayCashClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_check, "field 'btnPayCheck' and method 'OnCheckClicked'");
    target.btnPayCheck = Utils.castView(view, R.id.btn_check, "field 'btnPayCheck'", Button.class);
    view2131230767 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnCheckClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PaymentActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSpinner = null;
    target.btnPayCash = null;
    target.btnPayCheck = null;

    view2131230778.setOnClickListener(null);
    view2131230778 = null;
    view2131230767.setOnClickListener(null);
    view2131230767 = null;
  }
}
