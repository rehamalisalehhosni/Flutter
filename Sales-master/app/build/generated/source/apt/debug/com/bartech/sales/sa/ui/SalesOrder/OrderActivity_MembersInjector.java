package com.bartech.sales.sa.ui.SalesOrder;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OrderActivity_MembersInjector implements MembersInjector<OrderActivity> {
  private final Provider<SalesMvpPresenter<SalesMvpView>> mPresenterProvider;

  public OrderActivity_MembersInjector(
      Provider<SalesMvpPresenter<SalesMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<OrderActivity> create(
      Provider<SalesMvpPresenter<SalesMvpView>> mPresenterProvider) {
    return new OrderActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(OrderActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      OrderActivity instance, Provider<SalesMvpPresenter<SalesMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
