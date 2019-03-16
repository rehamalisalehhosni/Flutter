package com.bartech.sales.sa.ui.salesinvoice;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class InvoiceActivity_MembersInjector implements MembersInjector<InvoiceActivity> {
  private final Provider<InvoiceMvpPresenter<InvoiceMvpView>> mPresenterProvider;

  public InvoiceActivity_MembersInjector(
      Provider<InvoiceMvpPresenter<InvoiceMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<InvoiceActivity> create(
      Provider<InvoiceMvpPresenter<InvoiceMvpView>> mPresenterProvider) {
    return new InvoiceActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(InvoiceActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      InvoiceActivity instance, Provider<InvoiceMvpPresenter<InvoiceMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
