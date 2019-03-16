package com.bartech.sales.sa.di.module;

import com.bartech.sales.sa.ui.salesinvoice.InvoiceMvpPresenter;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceMvpView;
import com.bartech.sales.sa.ui.salesinvoice.InvoicePresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityModule_ProvideInvoicePresenterFactory
    implements Factory<InvoiceMvpPresenter<InvoiceMvpView>> {
  private final ActivityModule module;

  private final Provider<InvoicePresenter<InvoiceMvpView>> presenterProvider;

  public ActivityModule_ProvideInvoicePresenterFactory(
      ActivityModule module, Provider<InvoicePresenter<InvoiceMvpView>> presenterProvider) {
    assert module != null;
    this.module = module;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  @Override
  public InvoiceMvpPresenter<InvoiceMvpView> get() {
    return Preconditions.checkNotNull(
        module.provideInvoicePresenter(presenterProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<InvoiceMvpPresenter<InvoiceMvpView>> create(
      ActivityModule module, Provider<InvoicePresenter<InvoiceMvpView>> presenterProvider) {
    return new ActivityModule_ProvideInvoicePresenterFactory(module, presenterProvider);
  }

  /** Proxies {@link ActivityModule#provideInvoicePresenter(InvoicePresenter)}. */
  public static InvoiceMvpPresenter<InvoiceMvpView> proxyProvideInvoicePresenter(
      ActivityModule instance, InvoicePresenter<InvoiceMvpView> presenter) {
    return instance.provideInvoicePresenter(presenter);
  }
}
