package com.bartech.sales.sa.ui.Business;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BusinessActivity_MembersInjector implements MembersInjector<BusinessActivity> {
  private final Provider<BusinessMvpPresenter<BusinessMvpView>> mPresenterProvider;

  public BusinessActivity_MembersInjector(
      Provider<BusinessMvpPresenter<BusinessMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<BusinessActivity> create(
      Provider<BusinessMvpPresenter<BusinessMvpView>> mPresenterProvider) {
    return new BusinessActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(BusinessActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      BusinessActivity instance,
      Provider<BusinessMvpPresenter<BusinessMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
