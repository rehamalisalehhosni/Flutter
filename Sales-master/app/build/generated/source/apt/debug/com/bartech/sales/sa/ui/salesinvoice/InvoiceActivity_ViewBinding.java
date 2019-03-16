// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.salesinvoice;

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
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InvoiceActivity_ViewBinding implements Unbinder {
  private InvoiceActivity target;

  private View view2131230787;

  private View view2131230762;

  @UiThread
  public InvoiceActivity_ViewBinding(InvoiceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public InvoiceActivity_ViewBinding(final InvoiceActivity target, View source) {
    this.target = target;

    View view;
    target.mSpinner = Utils.findRequiredViewAsType(source, R.id.spinner_inv_data, "field 'mSpinner'", SearchableSpinner.class);
    target.quantumEditText = Utils.findRequiredViewAsType(source, R.id.et_quantum_inv_data, "field 'quantumEditText'", EditText.class);
    target.txtUnit = Utils.findRequiredViewAsType(source, R.id.txt_unit_inv_data, "field 'txtUnit'", TextView.class);
    target.PriceEditText = Utils.findRequiredViewAsType(source, R.id.et_price_inv_data, "field 'PriceEditText'", EditText.class);
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.txt_total_inv_data, "field 'txtTotal'", TextView.class);
    target.txtDate = Utils.findRequiredViewAsType(source, R.id.txt_date_inv_data, "field 'txtDate'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_submit_sales_inv_data, "field 'btnSubmitSales' and method 'alertDialog'");
    target.btnSubmitSales = Utils.castView(view, R.id.btn_submit_sales_inv_data, "field 'btnSubmitSales'", Button.class);
    view2131230787 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.alertDialog();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnShowInvoices, "field 'btnShowInvoices' and method 'onShowInvoices'");
    target.btnShowInvoices = Utils.castView(view, R.id.btnShowInvoices, "field 'btnShowInvoices'", Button.class);
    view2131230762 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onShowInvoices(p0);
      }
    });
    target.txtCustomerName = Utils.findRequiredViewAsType(source, R.id.txt_customerName_inv_data, "field 'txtCustomerName'", TextView.class);
    target.detailsEditText = Utils.findRequiredViewAsType(source, R.id.et_details_inv_data, "field 'detailsEditText'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InvoiceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSpinner = null;
    target.quantumEditText = null;
    target.txtUnit = null;
    target.PriceEditText = null;
    target.txtTotal = null;
    target.txtDate = null;
    target.btnSubmitSales = null;
    target.btnShowInvoices = null;
    target.txtCustomerName = null;
    target.detailsEditText = null;

    view2131230787.setOnClickListener(null);
    view2131230787 = null;
    view2131230762.setOnClickListener(null);
    view2131230762 = null;
  }
}
