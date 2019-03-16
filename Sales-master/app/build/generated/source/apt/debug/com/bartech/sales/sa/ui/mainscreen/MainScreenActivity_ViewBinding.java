// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.mainscreen;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainScreenActivity_ViewBinding implements Unbinder {
  private MainScreenActivity target;

  private View view2131230763;

  private View view2131230782;

  private View view2131230764;

  private View view2131230772;

  @UiThread
  public MainScreenActivity_ViewBinding(MainScreenActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainScreenActivity_ViewBinding(final MainScreenActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_cached_data, "field 'btnCachedData' and method 'onButtonCachedDataClicked'");
    target.btnCachedData = Utils.castView(view, R.id.btn_cached_data, "field 'btnCachedData'", Button.class);
    view2131230763 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButtonCachedDataClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_sales_ord, "field 'btnSalesOrder' and method 'onSalesButtonClicked'");
    target.btnSalesOrder = Utils.castView(view, R.id.btn_sales_ord, "field 'btnSalesOrder'", Button.class);
    view2131230782 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSalesButtonClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_cash, "field 'btnCashTransaction' and method 'onCashButtonClicked'");
    target.btnCashTransaction = Utils.castView(view, R.id.btn_cash, "field 'btnCashTransaction'", Button.class);
    view2131230764 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCashButtonClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_invoice, "field 'btnSalesInvoice' and method 'onFragmentInvoiceButtonClicked'");
    target.btnSalesInvoice = Utils.castView(view, R.id.btn_invoice, "field 'btnSalesInvoice'", Button.class);
    view2131230772 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onFragmentInvoiceButtonClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainScreenActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnCachedData = null;
    target.btnSalesOrder = null;
    target.btnCashTransaction = null;
    target.btnSalesInvoice = null;

    view2131230763.setOnClickListener(null);
    view2131230763 = null;
    view2131230782.setOnClickListener(null);
    view2131230782 = null;
    view2131230764.setOnClickListener(null);
    view2131230764 = null;
    view2131230772.setOnClickListener(null);
    view2131230772 = null;
  }
}
