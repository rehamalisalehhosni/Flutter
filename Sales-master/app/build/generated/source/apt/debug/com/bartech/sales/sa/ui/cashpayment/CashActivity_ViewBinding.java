// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.cashpayment;

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

public class CashActivity_ViewBinding implements Unbinder {
  private CashActivity target;

  private View view2131230766;

  private View view2131230788;

  @UiThread
  public CashActivity_ViewBinding(CashActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CashActivity_ViewBinding(final CashActivity target, View source) {
    this.target = target;

    View view;
    target.txtCustomerNamePayment = Utils.findRequiredViewAsType(source, R.id.txt_customerName_cash, "field 'txtCustomerNamePayment'", TextView.class);
    target.etPayment = Utils.findRequiredViewAsType(source, R.id.et_payment, "field 'etPayment'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_cash_payment, "field 'btnCashPayment' and method 'alertDialog'");
    target.btnCashPayment = Utils.castView(view, R.id.btn_cash_payment, "field 'btnCashPayment'", Button.class);
    view2131230766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.alertDialog();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnshowallinvoices, "field 'btnShowInvoices' and method 'onShowCashPayment'");
    target.btnShowInvoices = Utils.castView(view, R.id.btnshowallinvoices, "field 'btnShowInvoices'", Button.class);
    view2131230788 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onShowCashPayment(p0);
      }
    });
    target.txt_date_cash = Utils.findRequiredViewAsType(source, R.id.txt_date_cash, "field 'txt_date_cash'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CashActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtCustomerNamePayment = null;
    target.etPayment = null;
    target.btnCashPayment = null;
    target.btnShowInvoices = null;
    target.txt_date_cash = null;

    view2131230766.setOnClickListener(null);
    view2131230766 = null;
    view2131230788.setOnClickListener(null);
    view2131230788 = null;
  }
}
