// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.customersforinvoice;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CustomerInvoiceActivity_ViewBinding implements Unbinder {
  private CustomerInvoiceActivity target;

  private View view2131230770;

  @UiThread
  public CustomerInvoiceActivity_ViewBinding(CustomerInvoiceActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CustomerInvoiceActivity_ViewBinding(final CustomerInvoiceActivity target, View source) {
    this.target = target;

    View view;
    target.txtCustomer = Utils.findRequiredViewAsType(source, R.id.txt_customer, "field 'txtCustomer'", TextView.class);
    target.mSpinner = Utils.findRequiredViewAsType(source, R.id.spinner1, "field 'mSpinner'", SearchableSpinner.class);
    view = Utils.findRequiredView(source, R.id.btn_customer_name, "field 'chooseButton' and method 'onChooseCustomerSubmitted'");
    target.chooseButton = Utils.castView(view, R.id.btn_customer_name, "field 'chooseButton'", Button.class);
    view2131230770 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onChooseCustomerSubmitted(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CustomerInvoiceActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txtCustomer = null;
    target.mSpinner = null;
    target.chooseButton = null;

    view2131230770.setOnClickListener(null);
    view2131230770 = null;
  }
}
