package com.bartech.sales.sa.ui.cashpayment;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CashActivity_MembersInjector implements MembersInjector<CashActivity> {
  private final Provider<CashMvpPresenter<CashMvpView>> mPresenterProvider;

  public CashActivity_MembersInjector(Provider<CashMvpPresenter<CashMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CashActivity> create(
      Provider<CashMvpPresenter<CashMvpView>> mPresenterProvider) {
    return new CashActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CashActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      CashActivity instance, Provider<CashMvpPresenter<CashMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
