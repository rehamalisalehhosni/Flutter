// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.Business;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BusinessActivity_ViewBinding implements Unbinder {
  private BusinessActivity target;

  @UiThread
  public BusinessActivity_ViewBinding(BusinessActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BusinessActivity_ViewBinding(BusinessActivity target, View source) {
    this.target = target;

    target.btnSalesOrder = Utils.findRequiredViewAsType(source, R.id.btn_sales_ord, "field 'btnSalesOrder'", Button.class);
    target.btnCashTransaction = Utils.findRequiredViewAsType(source, R.id.btn_cash, "field 'btnCashTransaction'", Button.class);
    target.btnSalesInvoice = Utils.findRequiredViewAsType(source, R.id.btn_invoice, "field 'btnSalesInvoice'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BusinessActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnSalesOrder = null;
    target.btnCashTransaction = null;
    target.btnSalesInvoice = null;
  }
}
