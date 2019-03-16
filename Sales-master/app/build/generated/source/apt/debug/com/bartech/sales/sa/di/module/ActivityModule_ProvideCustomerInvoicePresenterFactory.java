package com.bartech.sales.sa.di.module;

import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceMvpPresenter;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceMvpView;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoicePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideCustomerInvoicePresenterFactory
    implements Factory<CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>> {
  private final ActivityModule module;

  private final Provider<CustomerInvoicePresenter<CustomerInvoiceMvpView>> presenterProvider;

  public ActivityModule_ProvideCustomerInvoicePresenterFactory(
      ActivityModule module,
      Provider<CustomerInvoicePresenter<CustomerInvoiceMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideCustomerInvoicePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>> create(
      ActivityModule module,
      Provider<CustomerInvoicePresenter<CustomerInvoiceMvpView>> presenterProvider) {
    return new ActivityModule_ProvideCustomerInvoicePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideCustomerInvoicePresenter(CustomerInvoicePresenter)}. */
  public static CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>
      proxyProvideCustomerInvoicePresenter(
          ActivityModule instance, CustomerInvoicePresenter<CustomerInvoiceMvpView> presenter) {
    return instance.provideCustomerInvoicePresenter(presenter);
  }
}
