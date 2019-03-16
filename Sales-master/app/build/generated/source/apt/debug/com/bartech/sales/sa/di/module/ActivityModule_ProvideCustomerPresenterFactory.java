package com.bartech.sales.sa.di.module;

import com.bartech.sales.sa.ui.customer.CustomerMvpPresenter;
import com.bartech.sales.sa.ui.customer.CustomerMvpView;
import com.bartech.sales.sa.ui.customer.CustomerPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideCustomerPresenterFactory
    implements Factory<CustomerMvpPresenter<CustomerMvpView>> {
  private final ActivityModule module;

  private final Provider<CustomerPresenter<CustomerMvpView>> presenterProvider;

  public ActivityModule_ProvideCustomerPresenterFactory(
      ActivityModule module, Provider<CustomerPresenter<CustomerMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public CustomerMvpPresenter<CustomerMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideCustomerPresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CustomerMvpPresenter<CustomerMvpView>> create(
      ActivityModule module, Provider<CustomerPresenter<CustomerMvpView>> presenterProvider) {
    return new ActivityModule_ProvideCustomerPresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideCustomerPresenter(CustomerPresenter)}. */
  public static CustomerMvpPresenter<CustomerMvpView> proxyProvideCustomerPresenter(
      ActivityModule instance, CustomerPresenter<CustomerMvpView> presenter) {
    return instance.provideCustomerPresenter(presenter);
  }
}
