package com.bartech.sales.sa.ui.customer;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CustomerActivity_MembersInjector implements MembersInjector<CustomerActivity> {
  private final Provider<CustomerMvpPresenter<CustomerMvpView>> mPresenterProvider;

  public CustomerActivity_MembersInjector(
      Provider<CustomerMvpPresenter<CustomerMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<CustomerActivity> create(
      Provider<CustomerMvpPresenter<CustomerMvpView>> mPresenterProvider) {
    return new CustomerActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(CustomerActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      CustomerActivity instance,
      Provider<CustomerMvpPresenter<CustomerMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
