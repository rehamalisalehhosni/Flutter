package com.bartech.sales.sa.ui.mainscreen;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainScreenActivity_MembersInjector
    implements MembersInjector<MainScreenActivity> {
  private final Provider<MainMvpPresenter<MainMvpView>> mPresenterProvider;

  public MainScreenActivity_MembersInjector(
      Provider<MainMvpPresenter<MainMvpView>> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<MainScreenActivity> create(
      Provider<MainMvpPresenter<MainMvpView>> mPresenterProvider) {
    return new MainScreenActivity_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(MainScreenActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }

  public static void injectMPresenter(
      MainScreenActivity instance, Provider<MainMvpPresenter<MainMvpView>> mPresenterProvider) {
    instance.mPresenter = mPresenterProvider.get();
  }
}
