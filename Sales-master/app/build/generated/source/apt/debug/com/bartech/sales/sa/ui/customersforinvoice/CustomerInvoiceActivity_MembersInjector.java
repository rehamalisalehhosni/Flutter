package com.bartech.sales.sa.ui.customersforinvoice;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CustomerInvoiceActivity_MembersInjector
    implements MembersInjector<CustomerInvoiceActivity> {
  private final Provider<CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>> mPresenterProvider;

  public CustomerInvoiceActivity_MembersInjector(
      Provider<CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CustomerInvoiceActivity> create(
      Provider<CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>> mPresenterProvider) {
    return new CustomerInvoiceActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CustomerInvoiceActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      CustomerInvoiceActivity instance,
      Provider<CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
