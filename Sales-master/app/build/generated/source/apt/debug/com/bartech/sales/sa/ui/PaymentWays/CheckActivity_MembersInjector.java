package com.bartech.sales.sa.ui.PaymentWays;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CheckActivity_MembersInjector implements MembersInjector<CheckActivity> {
  private final Provider<PaymentMvpPresenter<PaymentMvpView>> mPresenterProvider;

  public CheckActivity_MembersInjector(
      Provider<PaymentMvpPresenter<PaymentMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CheckActivity> create(
      Provider<PaymentMvpPresenter<PaymentMvpView>> mPresenterProvider) {
    return new CheckActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CheckActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      CheckActivity instance, Provider<PaymentMvpPresenter<PaymentMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
