package com.bartech.sales.sa.ui.cashpayment;

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
public final class CashPresenter_Factory<V extends CashMvpView>
    implements Factory<CashPresenter<V>> {
  private final MembersInjector<CashPresenter<V>> cashPresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  private final Provider<SchedulerProvider> schedulerProvider;

  private final Provider<CompositeDisposable> compositeDisposableProvider;

  public CashPresenter_Factory(
      MembersInjector<CashPresenter<V>> cashPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    assert cashPresenterMembersInjector != null;
    this.cashPresenterMembersInjector = cashPresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
    assert schedulerProvider != null;
    this.schedulerProvider = schedulerProvider;
    assert compositeDisposableProvider != null;
    this.compositeDisposableProvider = compositeDisposableProvider;
  }

  @Override
  public CashPresenter<V> get() {
    return MembersInjectors.injectMembers(
        cashPresenterMembersInjector,
        new CashPresenter<V>(
            dataManagerProvider.get(), schedulerProvider.get(), compositeDisposableProvider.get()));
  }

  public static <V extends CashMvpView> Factory<CashPresenter<V>> create(
      MembersInjector<CashPresenter<V>> cashPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider,
      Provider<SchedulerProvider> schedulerProvider,
      Provider<CompositeDisposable> compositeDisposableProvider) {
    return new CashPresenter_Factory<V>(
        cashPresenterMembersInjector,
        dataManagerProvider,
        schedulerProvider,
        compositeDisposableProvider);
  }
}
