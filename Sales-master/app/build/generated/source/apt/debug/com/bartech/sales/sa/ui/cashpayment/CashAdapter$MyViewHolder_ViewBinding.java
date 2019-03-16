// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.cashpayment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CashAdapter$MyViewHolder_ViewBinding implements Unbinder {
  private CashAdapter.MyViewHolder target;

  @UiThread
  public CashAdapter$MyViewHolder_ViewBinding(CashAdapter.MyViewHolder target, View source) {
    this.target = target;

    target.txtCustomerName = Utils.findRequiredViewAsType(source, R.id.txt_cash_customer, "field 'txtCustomerName'", TextView.class);
    target.txtTotalCash = Utils.findRequiredViewAsType(source, R.id.txt_total_cash, "field 'txtTotalCash'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CashAdapter.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtCustomerName = null;
    target.txtTotalCash = null;
  }
}
