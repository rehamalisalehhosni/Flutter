package com.bartech.sales.sa.ui.salesinvoice;

import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class InvoicePresenter_Factory<V extends InvoiceMvpView>
    implements Factory<InvoicePresenter<V>> {
  private final MembersInjector<InvoicePresenter<V>> invoicePresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public InvoicePresenter_Factory(
      MembersInjector<InvoicePresenter<V>> invoicePresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert invoicePresenterMembersInjector != null;
    this.invoicePresenterMembersInjector = invoicePresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public InvoicePresenter<V> get() {
    return MembersInjectors.injectMembers(
        invoicePresenterMembersInjector,
        new InvoicePresenter<V>(
            dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get()));
  }

  public static <V extends InvoiceMvpView> Factory<InvoicePresenter<V>> create(
      MembersInjector<InvoicePresenter<V>> invoicePresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new InvoicePresenter_Factory<V>(
        invoicePresenterMembersInjector,
        dataManagerProvider,
        schedulerProvider,
        compositeDisposableProvider);
  }
}
