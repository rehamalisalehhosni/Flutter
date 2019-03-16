package com.bartech.sales.sa.ui.customersforinvoice;

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
public final class CustomerInvoicePresenter_Factory<V extends CustomerInvoiceMvpView>
    implements Factory<CustomerInvoicePresenter<V>> {
  private final MembersInjector<CustomerInvoicePresenter<V>>
      customerInvoicePresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public CustomerInvoicePresenter_Factory(
      MembersInjector<CustomerInvoicePresenter<V>> customerInvoicePresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert customerInvoicePresenterMembersInjector != null;
    this.customerInvoicePresenterMembersInjector = customerInvoicePresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public CustomerInvoicePresenter<V> get() {
    return MembersInjectors.injectMembers(
        customerInvoicePresenterMembersInjector,
        new CustomerInvoicePresenter<V>(
            dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get()));
  }

  public static <V extends CustomerInvoiceMvpView> Factory<CustomerInvoicePresenter<V>> create(
      MembersInjector<CustomerInvoicePresenter<V>> customerInvoicePresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new CustomerInvoicePresenter_Factory<V>(
        customerInvoicePresenterMembersInjector,
        dataManagerProvider,
        schedulerProvider,
        compositeDisposableProvider);
  }
}
