package com.bartech.sales.sa.di.module;

import com.bartech.sales.sa.ui.SalesOrder.SalesMvpPresenter;
import com.bartech.sales.sa.ui.SalesOrder.SalesMvpView;
import com.bartech.sales.sa.ui.SalesOrder.SalesPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideSalesPresenterFactory
    implements Factory<SalesMvpPresenter<SalesMvpView>> {
  private final ActivityModule module;

  private final Provider<SalesPresenter<SalesMvpView>> presenterProvider;

  public ActivityModule_ProvideSalesPresenterFactory(
      ActivityModule module, Provider<SalesPresenter<SalesMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public SalesMvpPresenter<SalesMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideSalesPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SalesMvpPresenter<SalesMvpView>> create(
      ActivityModule module, Provider<SalesPresenter<SalesMvpView>> presenterProvider) {
    return new ActivityModule_ProvideSalesPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideSalesPresenter(SalesPresenter)}. */
  public static SalesMvpPresenter<SalesMvpView> proxyProvideSalesPresenter(
      ActivityModule instance, SalesPresenter<SalesMvpView> presenter) {
    return instance.provideSalesPresenter(presenter);
  }
}
