// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.salesinvoice;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CachedInvoiceAdapter$MyViewHolder_ViewBinding implements Unbinder {
  private CachedInvoiceAdapter.MyViewHolder target;

  @UiThread
  public CachedInvoiceAdapter$MyViewHolder_ViewBinding(CachedInvoiceAdapter.MyViewHolder target, View source) {
    this.target = target;

    target.txtProduct = Utils.findRequiredViewAsType(source, R.id.txt_product_invoice, "field 'txtProduct'", TextView.class);
    target.txtQuantum = Utils.findRequiredViewAsType(source, R.id.et_quantum_invoice, "field 'txtQuantum'", TextView.class);
    target.txtPrice = Utils.findRequiredViewAsType(source, R.id.txt_price_invoice, "field 'txtPrice'", TextView.class);
    target.txtUnit = Utils.findRequiredViewAsType(source, R.id.txt_unit_invoice, "field 'txtUnit'", TextView.class);
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.txt_total_invoice, "field 'txtTotal'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CachedInvoiceAdapter.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtProduct = null;
    target.txtQuantum = null;
    target.txtPrice = null;
    target.txtUnit = null;
    target.txtTotal = null;
  }
}
