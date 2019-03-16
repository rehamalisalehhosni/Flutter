package com.bartech.sales.sa.ui.main;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainActivityActivity_MembersInjector
    implements MembersInjector<MainActivityActivity> {
  private final Provider<MainActivityMvpPresenter<MainActivityMvpView>> mPresenterProvider;

  public MainActivityActivity_MembersInjector(
      Provider<MainActivityMvpPresenter<MainActivityMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MainActivityActivity> create(
      Provider<MainActivityMvpPresenter<MainActivityMvpView>> mPresenterProvider) {
    return new MainActivityActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MainActivityActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      MainActivityActivity instance,
      Provider<MainActivityMvpPresenter<MainActivityMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
