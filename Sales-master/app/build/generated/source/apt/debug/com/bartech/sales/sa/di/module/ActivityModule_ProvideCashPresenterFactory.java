package com.bartech.sales.sa.di.module;

import com.bartech.sales.sa.ui.cashpayment.CashMvpPresenter;
import com.bartech.sales.sa.ui.cashpayment.CashMvpView;
import com.bartech.sales.sa.ui.cashpayment.CashPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideCashPresenterFactory
    implements Factory<CashMvpPresenter<CashMvpView>> {
  private final ActivityModule module;

  private final Provider<CashPresenter<CashMvpView>> presenterProvider;

  public ActivityModule_ProvideCashPresenterFactory(
      ActivityModule module, Provider<CashPresenter<CashMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public CashMvpPresenter<CashMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideCashPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CashMvpPresenter<CashMvpView>> create(
      ActivityModule module, Provider<CashPresenter<CashMvpView>> presenterProvider) {
    return new ActivityModule_ProvideCashPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideCashPresenter(CashPresenter)}. */
  public static CashMvpPresenter<CashMvpView> proxyProvideCashPresenter(
      ActivityModule instance, CashPresenter<CashMvpView> presenter) {
    return instance.provideCashPresenter(presenter);
  }
}
