package com.bartech.sales.sa.di.module;

import com.bartech.sales.sa.ui.PaymentWays.PaymentMvpPresenter;
import com.bartech.sales.sa.ui.PaymentWays.PaymentMvpView;
import com.bartech.sales.sa.ui.PaymentWays.PaymentPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvidePaymentPresenterFactory
    implements Factory<PaymentMvpPresenter<PaymentMvpView>> {
  private final ActivityModule module;

  private final Provider<PaymentPresenter<PaymentMvpView>> presenterProvider;

  public ActivityModule_ProvidePaymentPresenterFactory(
      ActivityModule module, Provider<PaymentPresenter<PaymentMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public PaymentMvpPresenter<PaymentMvpView> get() {
    return Preconditions.checkNotNull(
        module.providePaymentPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PaymentMvpPresenter<PaymentMvpView>> create(
      ActivityModule module, Provider<PaymentPresenter<PaymentMvpView>> presenterProvider) {
    return new ActivityModule_ProvidePaymentPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#providePaymentPresenter(PaymentPresenter)}. */
  public static PaymentMvpPresenter<PaymentMvpView> proxyProvidePaymentPresenter(
      ActivityModule instance, PaymentPresenter<PaymentMvpView> presenter) {
    return instance.providePaymentPresenter(presenter);
  }
}
