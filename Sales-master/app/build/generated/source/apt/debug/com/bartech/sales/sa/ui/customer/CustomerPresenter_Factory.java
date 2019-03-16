package com.bartech.sales.sa.ui.customer;

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
public final class CustomerPresenter_Factory<V extends CustomerMvpView>
    implements Factory<CustomerPresenter<V>> {
  private final MembersInjector<CustomerPresenter<V>> customerPresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public CustomerPresenter_Factory(
      MembersInjector<CustomerPresenter<V>> customerPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert customerPresenterMembersInjector != null;
    this.customerPresenterMembersInjector = customerPresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public CustomerPresenter<V> get() {
    return MembersInjectors.injectMembers(
        customerPresenterMembersInjector,
        new CustomerPresenter<V>(
            dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get()));
  }

  public static <V extends CustomerMvpView> Factory<CustomerPresenter<V>> create(
      MembersInjector<CustomerPresenter<V>> customerPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new CustomerPresenter_Factory<V>(
        customerPresenterMembersInjector,
        dataManagerProvider,
        schedulerProvider,
        compositeDisposableProvider);
  }
}
