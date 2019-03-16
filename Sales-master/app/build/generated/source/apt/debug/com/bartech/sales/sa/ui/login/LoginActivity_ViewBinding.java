// Generated code from Butter Knife. Do not modify!
package com.bartech.sales.sa.ui.login;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bartech.sales.sa.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131230783;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.mUserNameEditText = Utils.findRequiredViewAsType(source, R.id.et_email, "field 'mUserNameEditText'", EditText.class);
    target.mPasswordEditText = Utils.findRequiredViewAsType(source, R.id.et_password, "field 'mPasswordEditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_server_login, "method 'onServerLoginClick'");
    view2131230783 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onServerLoginClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserNameEditText = null;
    target.mPasswordEditText = null;

    view2131230783.setOnClickListener(null);
    view2131230783 = null;
  }
}
