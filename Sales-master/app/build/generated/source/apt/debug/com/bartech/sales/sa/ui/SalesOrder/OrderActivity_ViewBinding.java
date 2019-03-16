// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.SalesOrder;

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

public class OrderActivity_ViewBinding implements Unbinder {
  private OrderActivity target;

  private View view2131230786;

  private View view2131230808;

  @UiThread
  public OrderActivity_ViewBinding(OrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderActivity_ViewBinding(final OrderActivity target, View source) {
    this.target = target;

    View view;
    target.mSpinner = Utils.findRequiredViewAsType(source, R.id.spinner, "field 'mSpinner'", SearchableSpinner.class);
    target.quantumEditText = Utils.findRequiredViewAsType(source, R.id.et_quantum, "field 'quantumEditText'", EditText.class);
    target.txtUnit = Utils.findRequiredViewAsType(source, R.id.txt_unit, "field 'txtUnit'", TextView.class);
    target.PriceEditText = Utils.findRequiredViewAsType(source, R.id.et_price, "field 'PriceEditText'", EditText.class);
    target.txtTotal = Utils.findRequiredViewAsType(source, R.id.txt_total, "field 'txtTotal'", TextView.class);
    target.txt_date = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'txt_date'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_submit_sales, "field 'btnSubmitSales' and method 'onSubmitSalesClicked'");
    target.btnSubmitSales = Utils.castView(view, R.id.btn_submit_sales, "field 'btnSubmitSales'", Button.class);
    view2131230786 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSubmitSalesClicked(p0);
      }
    });
    target.txtCustomerName = Utils.findRequiredViewAsType(source, R.id.txt_customerName, "field 'txtCustomerName'", TextView.class);
    target.detailsEditText = Utils.findRequiredViewAsType(source, R.id.et_details, "field 'detailsEditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.count, "field 'txtCount' and method 'onCartClicked'");
    target.txtCount = Utils.castView(view, R.id.count, "field 'txtCount'", TextView.class);
    view2131230808 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCartClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSpinner = null;
    target.quantumEditText = null;
    target.txtUnit = null;
    target.PriceEditText = null;
    target.txtTotal = null;
    target.txt_date = null;
    target.btnSubmitSales = null;
    target.txtCustomerName = null;
    target.detailsEditText = null;
    target.txtCount = null;

    view2131230786.setOnClickListener(null);
    view2131230786 = null;
    view2131230808.setOnClickListener(null);
    view2131230808 = null;
  }
}
