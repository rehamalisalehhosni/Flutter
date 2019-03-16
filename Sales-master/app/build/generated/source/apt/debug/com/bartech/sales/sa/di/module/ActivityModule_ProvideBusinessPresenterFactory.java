package com.bartech.sales.sa.di.module;

import com.bartech.sales.sa.ui.Business.BusinessMvpPresenter;
import com.bartech.sales.sa.ui.Business.BusinessMvpView;
import com.bartech.sales.sa.ui.Business.BusinessPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideBusinessPresenterFactory
    implements Factory<BusinessMvpPresenter<BusinessMvpView>> {
  private final ActivityModule module;

  private final Provider<BusinessPresenter<BusinessMvpView>> presenterProvider;

  public ActivityModule_ProvideBusinessPresenterFactory(
      ActivityModule module, Provider<BusinessPresenter<BusinessMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public BusinessMvpPresenter<BusinessMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideBusinessPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<BusinessMvpPresenter<BusinessMvpView>> create(
      ActivityModule module, Provider<BusinessPresenter<BusinessMvpView>> presenterProvider) {
    return new ActivityModule_ProvideBusinessPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideBusinessPresenter(BusinessPresenter)}. */
  public static BusinessMvpPresenter<BusinessMvpView> proxyProvideBusinessPresenter(
      ActivityModule instance, BusinessPresenter<BusinessMvpView> presenter) {
    return instance.provideBusinessPresenter(presenter);
  }
}
