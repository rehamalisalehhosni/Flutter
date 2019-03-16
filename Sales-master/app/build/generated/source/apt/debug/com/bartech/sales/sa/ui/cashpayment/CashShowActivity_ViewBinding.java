// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.cashpayment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CashShowActivity_ViewBinding implements Unbinder {
  private CashShowActivity target;

  @UiThread
  public CashShowActivity_ViewBinding(CashShowActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CashShowActivity_ViewBinding(CashShowActivity target, View source) {
    this.target = target;

    target.mRecycler = Utils.findRequiredViewAsType(source, R.id.recycler_cash, "field 'mRecycler'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CashShowActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecycler = null;
  }
}
