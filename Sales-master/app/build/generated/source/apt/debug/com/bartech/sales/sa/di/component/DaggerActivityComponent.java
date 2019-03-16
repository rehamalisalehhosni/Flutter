package com.bartech.sales.sa.di.component;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.di.module.ActivityModule;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideAboutPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideActivityFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideBlogAdapterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideBlogMvpPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideBusinessPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideCashPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideCompositeDisposableFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideCustomerInvoicePresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideCustomerPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideFeedPagerAdapterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideFeedPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideInvoicePresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideLinearLayoutManagerFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideLoginPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideMainActivityPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideMainPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideOpenSourceAdapterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideOpenSourcePresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvidePaymentPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideRateUsPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideSalesPresenterFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideSchedulerProviderFactory;
import com.bartech.sales.sa.di.module.ActivityModule_ProvideSplashPresenterFactory;
import com.bartech.sales.sa.ui.Business.BusinessActivity;
import com.bartech.sales.sa.ui.Business.BusinessActivity_MembersInjector;
import com.bartech.sales.sa.ui.Business.BusinessMvpPresenter;
import com.bartech.sales.sa.ui.Business.BusinessMvpView;
import com.bartech.sales.sa.ui.Business.BusinessPresenter;
import com.bartech.sales.sa.ui.Business.BusinessPresenter_Factory;
import com.bartech.sales.sa.ui.PaymentWays.CheckActivity;
import com.bartech.sales.sa.ui.PaymentWays.CheckActivity_MembersInjector;
import com.bartech.sales.sa.ui.PaymentWays.PaymentActivity;
import com.bartech.sales.sa.ui.PaymentWays.PaymentActivity_MembersInjector;
import com.bartech.sales.sa.ui.PaymentWays.PaymentMvpPresenter;
import com.bartech.sales.sa.ui.PaymentWays.PaymentMvpView;
import com.bartech.sales.sa.ui.PaymentWays.PaymentPresenter;
import com.bartech.sales.sa.ui.PaymentWays.PaymentPresenter_Factory;
import com.bartech.sales.sa.ui.SalesOrder.OrderActivity;
import com.bartech.sales.sa.ui.SalesOrder.OrderActivity_MembersInjector;
import com.bartech.sales.sa.ui.SalesOrder.ProductsActivity;
import com.bartech.sales.sa.ui.SalesOrder.SalesMvpPresenter;
import com.bartech.sales.sa.ui.SalesOrder.SalesMvpView;
import com.bartech.sales.sa.ui.SalesOrder.SalesPresenter;
import com.bartech.sales.sa.ui.SalesOrder.SalesPresenter_Factory;
import com.bartech.sales.sa.ui.about.AboutFragment;
import com.bartech.sales.sa.ui.about.AboutFragment_MembersInjector;
import com.bartech.sales.sa.ui.about.AboutMvpPresenter;
import com.bartech.sales.sa.ui.about.AboutMvpView;
import com.bartech.sales.sa.ui.about.AboutPresenter;
import com.bartech.sales.sa.ui.about.AboutPresenter_Factory;
import com.bartech.sales.sa.ui.cashpayment.CashActivity;
import com.bartech.sales.sa.ui.cashpayment.CashActivity_MembersInjector;
import com.bartech.sales.sa.ui.cashpayment.CashMvpPresenter;
import com.bartech.sales.sa.ui.cashpayment.CashMvpView;
import com.bartech.sales.sa.ui.cashpayment.CashPresenter;
import com.bartech.sales.sa.ui.cashpayment.CashPresenter_Factory;
import com.bartech.sales.sa.ui.cashpayment.CashShowActivity;
import com.bartech.sales.sa.ui.customer.CustomerActivity;
import com.bartech.sales.sa.ui.customer.CustomerActivity_MembersInjector;
import com.bartech.sales.sa.ui.customer.CustomerMvpPresenter;
import com.bartech.sales.sa.ui.customer.CustomerMvpView;
import com.bartech.sales.sa.ui.customer.CustomerPresenter;
import com.bartech.sales.sa.ui.customer.CustomerPresenter_Factory;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceActivity;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceActivity_MembersInjector;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceMvpPresenter;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceMvpView;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoicePresenter;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoicePresenter_Factory;
import com.bartech.sales.sa.ui.feed.FeedActivity;
import com.bartech.sales.sa.ui.feed.FeedActivity_MembersInjector;
import com.bartech.sales.sa.ui.feed.FeedMvpPresenter;
import com.bartech.sales.sa.ui.feed.FeedMvpView;
import com.bartech.sales.sa.ui.feed.FeedPagerAdapter;
import com.bartech.sales.sa.ui.feed.FeedPresenter;
import com.bartech.sales.sa.ui.feed.FeedPresenter_Factory;
import com.bartech.sales.sa.ui.feed.blogs.BlogAdapter;
import com.bartech.sales.sa.ui.feed.blogs.BlogFragment;
import com.bartech.sales.sa.ui.feed.blogs.BlogFragment_MembersInjector;
import com.bartech.sales.sa.ui.feed.blogs.BlogMvpPresenter;
import com.bartech.sales.sa.ui.feed.blogs.BlogMvpView;
import com.bartech.sales.sa.ui.feed.blogs.BlogPresenter;
import com.bartech.sales.sa.ui.feed.blogs.BlogPresenter_Factory;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceAdapter;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceFragment;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceFragment_MembersInjector;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceMvpPresenter;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceMvpView;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourcePresenter;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourcePresenter_Factory;
import com.bartech.sales.sa.ui.login.LoginActivity;
import com.bartech.sales.sa.ui.login.LoginActivity_MembersInjector;
import com.bartech.sales.sa.ui.login.LoginMvpPresenter;
import com.bartech.sales.sa.ui.login.LoginMvpView;
import com.bartech.sales.sa.ui.login.LoginPresenter;
import com.bartech.sales.sa.ui.login.LoginPresenter_Factory;
import com.bartech.sales.sa.ui.main.MainActivityActivity;
import com.bartech.sales.sa.ui.main.MainActivityActivity_MembersInjector;
import com.bartech.sales.sa.ui.main.MainActivityMvpPresenter;
import com.bartech.sales.sa.ui.main.MainActivityMvpView;
import com.bartech.sales.sa.ui.main.MainActivityPresenter;
import com.bartech.sales.sa.ui.main.MainActivityPresenter_Factory;
import com.bartech.sales.sa.ui.main.rating.RateUsDialog;
import com.bartech.sales.sa.ui.main.rating.RateUsDialog_MembersInjector;
import com.bartech.sales.sa.ui.main.rating.RatingDialogMvpPresenter;
import com.bartech.sales.sa.ui.main.rating.RatingDialogMvpView;
import com.bartech.sales.sa.ui.main.rating.RatingDialogPresenter;
import com.bartech.sales.sa.ui.main.rating.RatingDialogPresenter_Factory;
import com.bartech.sales.sa.ui.mainscreen.MainMvpPresenter;
import com.bartech.sales.sa.ui.mainscreen.MainMvpView;
import com.bartech.sales.sa.ui.mainscreen.MainPresenter;
import com.bartech.sales.sa.ui.mainscreen.MainPresenter_Factory;
import com.bartech.sales.sa.ui.mainscreen.MainScreenActivity;
import com.bartech.sales.sa.ui.mainscreen.MainScreenActivity_MembersInjector;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceActivity;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceActivity_MembersInjector;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceMvpPresenter;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceMvpView;
import com.bartech.sales.sa.ui.salesinvoice.InvoicePresenter;
import com.bartech.sales.sa.ui.salesinvoice.InvoicePresenter_Factory;
import com.bartech.sales.sa.ui.salesinvoice.InvoicesShowActivity;
import com.bartech.sales.sa.ui.splash.SplashActivity;
import com.bartech.sales.sa.ui.splash.SplashActivity_MembersInjector;
import com.bartech.sales.sa.ui.splash.SplashMvpPresenter;
import com.bartech.sales.sa.ui.splash.SplashMvpView;
import com.bartech.sales.sa.ui.splash.SplashPresenter;
import com.bartech.sales.sa.ui.splash.SplashPresenter_Factory;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<DataManager> getDataManagerProvider;

  private Provider<SchedulerProvider> provideSchedulerProvider;

  private Provider<CompositeDisposable> provideCompositeDisposableProvider;

  private Provider<MainActivityPresenter<MainActivityMvpView>> mainActivityPresenterProvider;

  private Provider<MainActivityMvpPresenter<MainActivityMvpView>>
      provideMainActivityPresenterProvider;

  private MembersInjector<MainActivityActivity> mainActivityActivityMembersInjector;

  private Provider<LoginPresenter<LoginMvpView>> loginPresenterProvider;

  private Provider<LoginMvpPresenter<LoginMvpView>> provideLoginPresenterProvider;

  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private Provider<SplashPresenter<SplashMvpView>> splashPresenterProvider;

  private Provider<SplashMvpPresenter<SplashMvpView>> provideSplashPresenterProvider;

  private MembersInjector<SplashActivity> splashActivityMembersInjector;

  private Provider<FeedPresenter<FeedMvpView>> feedPresenterProvider;

  private Provider<FeedMvpPresenter<FeedMvpView>> provideFeedPresenterProvider;

  private Provider<AppCompatActivity> provideActivityProvider;

  private Provider<FeedPagerAdapter> provideFeedPagerAdapterProvider;

  private MembersInjector<FeedActivity> feedActivityMembersInjector;

  private Provider<AboutPresenter<AboutMvpView>> aboutPresenterProvider;

  private Provider<AboutMvpPresenter<AboutMvpView>> provideAboutPresenterProvider;

  private MembersInjector<AboutFragment> aboutFragmentMembersInjector;

  private Provider<OpenSourcePresenter<OpenSourceMvpView>> openSourcePresenterProvider;

  private Provider<OpenSourceMvpPresenter<OpenSourceMvpView>> provideOpenSourcePresenterProvider;

  private Provider<OpenSourceAdapter> provideOpenSourceAdapterProvider;

  private Provider<LinearLayoutManager> provideLinearLayoutManagerProvider;

  private MembersInjector<OpenSourceFragment> openSourceFragmentMembersInjector;

  private Provider<BlogPresenter<BlogMvpView>> blogPresenterProvider;

  private Provider<BlogMvpPresenter<BlogMvpView>> provideBlogMvpPresenterProvider;

  private Provider<BlogAdapter> provideBlogAdapterProvider;

  private MembersInjector<BlogFragment> blogFragmentMembersInjector;

  private Provider<RatingDialogPresenter<RatingDialogMvpView>> ratingDialogPresenterProvider;

  private Provider<RatingDialogMvpPresenter<RatingDialogMvpView>> provideRateUsPresenterProvider;

  private MembersInjector<RateUsDialog> rateUsDialogMembersInjector;

  private Provider<BusinessPresenter<BusinessMvpView>> businessPresenterProvider;

  private Provider<BusinessMvpPresenter<BusinessMvpView>> provideBusinessPresenterProvider;

  private MembersInjector<BusinessActivity> businessActivityMembersInjector;

  private Provider<SalesPresenter<SalesMvpView>> salesPresenterProvider;

  private Provider<SalesMvpPresenter<SalesMvpView>> provideSalesPresenterProvider;

  private MembersInjector<OrderActivity> orderActivityMembersInjector;

  private Provider<CustomerPresenter<CustomerMvpView>> customerPresenterProvider;

  private Provider<CustomerMvpPresenter<CustomerMvpView>> provideCustomerPresenterProvider;

  private MembersInjector<CustomerActivity> customerActivityMembersInjector;

  private Provider<PaymentPresenter<PaymentMvpView>> paymentPresenterProvider;

  private Provider<PaymentMvpPresenter<PaymentMvpView>> providePaymentPresenterProvider;

  private MembersInjector<PaymentActivity> paymentActivityMembersInjector;

  private MembersInjector<CheckActivity> checkActivityMembersInjector;

  private Provider<InvoicePresenter<InvoiceMvpView>> invoicePresenterProvider;

  private Provider<InvoiceMvpPresenter<InvoiceMvpView>> provideInvoicePresenterProvider;

  private MembersInjector<InvoiceActivity> invoiceActivityMembersInjector;

  private Provider<CustomerInvoicePresenter<CustomerInvoiceMvpView>>
      customerInvoicePresenterProvider;

  private Provider<CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView>>
      provideCustomerInvoicePresenterProvider;

  private MembersInjector<CustomerInvoiceActivity> customerInvoiceActivityMembersInjector;

  private Provider<CashPresenter<CashMvpView>> cashPresenterProvider;

  private Provider<CashMvpPresenter<CashMvpView>> provideCashPresenterProvider;

  private MembersInjector<CashActivity> cashActivityMembersInjector;

  private Provider<MainPresenter<MainMvpView>> mainPresenterProvider;

  private Provider<MainMvpPresenter<MainMvpView>> provideMainPresenterProvider;

  private MembersInjector<MainScreenActivity> mainScreenActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getDataManagerProvider =
        new Factory<DataManager>() {
          private final ApplicationComponent applicationComponent = builder.applicationComponent;

          @Override
          public DataManager get() {
            return Preconditions.checkNotNull(
                applicationComponent.getDataManager(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.provideSchedulerProvider =
        ActivityModule_ProvideSchedulerProviderFactory.create(builder.activityModule);

    this.provideCompositeDisposableProvider =
        ActivityModule_ProvideCompositeDisposableFactory.create(builder.activityModule);

    this.mainActivityPresenterProvider =
        MainActivityPresenter_Factory.create(
            MembersInjectors.<MainActivityPresenter<MainActivityMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideMainActivityPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideMainActivityPresenterFactory.create(
                builder.activityModule, mainActivityPresenterProvider));

    this.mainActivityActivityMembersInjector =
        MainActivityActivity_MembersInjector.create(provideMainActivityPresenterProvider);

    this.loginPresenterProvider =
        LoginPresenter_Factory.create(
            MembersInjectors.<LoginPresenter<LoginMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideLoginPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideLoginPresenterFactory.create(
                builder.activityModule, loginPresenterProvider));

    this.loginActivityMembersInjector =
        LoginActivity_MembersInjector.create(provideLoginPresenterProvider);

    this.splashPresenterProvider =
        SplashPresenter_Factory.create(
            MembersInjectors.<SplashPresenter<SplashMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideSplashPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideSplashPresenterFactory.create(
                builder.activityModule, splashPresenterProvider));

    this.splashActivityMembersInjector =
        SplashActivity_MembersInjector.create(provideSplashPresenterProvider);

    this.feedPresenterProvider =
        FeedPresenter_Factory.create(
            MembersInjectors.<FeedPresenter<FeedMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideFeedPresenterProvider =
        ActivityModule_ProvideFeedPresenterFactory.create(
            builder.activityModule, feedPresenterProvider);

    this.provideActivityProvider =
        ActivityModule_ProvideActivityFactory.create(builder.activityModule);

    this.provideFeedPagerAdapterProvider =
        ActivityModule_ProvideFeedPagerAdapterFactory.create(
            builder.activityModule, provideActivityProvider);

    this.feedActivityMembersInjector =
        FeedActivity_MembersInjector.create(
            provideFeedPresenterProvider, provideFeedPagerAdapterProvider);

    this.aboutPresenterProvider =
        AboutPresenter_Factory.create(
            MembersInjectors.<AboutPresenter<AboutMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideAboutPresenterProvider =
        ActivityModule_ProvideAboutPresenterFactory.create(
            builder.activityModule, aboutPresenterProvider);

    this.aboutFragmentMembersInjector =
        AboutFragment_MembersInjector.create(provideAboutPresenterProvider);

    this.openSourcePresenterProvider =
        OpenSourcePresenter_Factory.create(
            MembersInjectors.<OpenSourcePresenter<OpenSourceMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideOpenSourcePresenterProvider =
        ActivityModule_ProvideOpenSourcePresenterFactory.create(
            builder.activityModule, openSourcePresenterProvider);

    this.provideOpenSourceAdapterProvider =
        ActivityModule_ProvideOpenSourceAdapterFactory.create(builder.activityModule);

    this.provideLinearLayoutManagerProvider =
        ActivityModule_ProvideLinearLayoutManagerFactory.create(
            builder.activityModule, provideActivityProvider);

    this.openSourceFragmentMembersInjector =
        OpenSourceFragment_MembersInjector.create(
            provideOpenSourcePresenterProvider,
            provideOpenSourceAdapterProvider,
            provideLinearLayoutManagerProvider);

    this.blogPresenterProvider =
        BlogPresenter_Factory.create(
            MembersInjectors.<BlogPresenter<BlogMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideBlogMvpPresenterProvider =
        ActivityModule_ProvideBlogMvpPresenterFactory.create(
            builder.activityModule, blogPresenterProvider);

    this.provideBlogAdapterProvider =
        ActivityModule_ProvideBlogAdapterFactory.create(builder.activityModule);

    this.blogFragmentMembersInjector =
        BlogFragment_MembersInjector.create(
            provideBlogMvpPresenterProvider,
            provideBlogAdapterProvider,
            provideLinearLayoutManagerProvider);

    this.ratingDialogPresenterProvider =
        RatingDialogPresenter_Factory.create(
            MembersInjectors.<RatingDialogPresenter<RatingDialogMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideRateUsPresenterProvider =
        ActivityModule_ProvideRateUsPresenterFactory.create(
            builder.activityModule, ratingDialogPresenterProvider);

    this.rateUsDialogMembersInjector =
        RateUsDialog_MembersInjector.create(provideRateUsPresenterProvider);

    this.businessPresenterProvider =
        BusinessPresenter_Factory.create(
            MembersInjectors.<BusinessPresenter<BusinessMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideBusinessPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideBusinessPresenterFactory.create(
                builder.activityModule, businessPresenterProvider));

    this.businessActivityMembersInjector =
        BusinessActivity_MembersInjector.create(provideBusinessPresenterProvider);

    this.salesPresenterProvider =
        SalesPresenter_Factory.create(
            MembersInjectors.<SalesPresenter<SalesMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideSalesPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideSalesPresenterFactory.create(
                builder.activityModule, salesPresenterProvider));

    this.orderActivityMembersInjector =
        OrderActivity_MembersInjector.create(provideSalesPresenterProvider);

    this.customerPresenterProvider =
        CustomerPresenter_Factory.create(
            MembersInjectors.<CustomerPresenter<CustomerMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideCustomerPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideCustomerPresenterFactory.create(
                builder.activityModule, customerPresenterProvider));

    this.customerActivityMembersInjector =
        CustomerActivity_MembersInjector.create(provideCustomerPresenterProvider);

    this.paymentPresenterProvider =
        PaymentPresenter_Factory.create(
            MembersInjectors.<PaymentPresenter<PaymentMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.providePaymentPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvidePaymentPresenterFactory.create(
                builder.activityModule, paymentPresenterProvider));

    this.paymentActivityMembersInjector =
        PaymentActivity_MembersInjector.create(providePaymentPresenterProvider);

    this.checkActivityMembersInjector =
        CheckActivity_MembersInjector.create(providePaymentPresenterProvider);

    this.invoicePresenterProvider =
        InvoicePresenter_Factory.create(
            MembersInjectors.<InvoicePresenter<InvoiceMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideInvoicePresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideInvoicePresenterFactory.create(
                builder.activityModule, invoicePresenterProvider));

    this.invoiceActivityMembersInjector =
        InvoiceActivity_MembersInjector.create(provideInvoicePresenterProvider);

    this.customerInvoicePresenterProvider =
        CustomerInvoicePresenter_Factory.create(
            MembersInjectors.<CustomerInvoicePresenter<CustomerInvoiceMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideCustomerInvoicePresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideCustomerInvoicePresenterFactory.create(
                builder.activityModule, customerInvoicePresenterProvider));

    this.customerInvoiceActivityMembersInjector =
        CustomerInvoiceActivity_MembersInjector.create(provideCustomerInvoicePresenterProvider);

    this.cashPresenterProvider =
        CashPresenter_Factory.create(
            MembersInjectors.<CashPresenter<CashMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideCashPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideCashPresenterFactory.create(
                builder.activityModule, cashPresenterProvider));

    this.cashActivityMembersInjector =
        CashActivity_MembersInjector.create(provideCashPresenterProvider);

    this.mainPresenterProvider =
        MainPresenter_Factory.create(
            MembersInjectors.<MainPresenter<MainMvpView>>noOp(),
            getDataManagerProvider,
            provideSchedulerProvider,
            provideCompositeDisposableProvider);

    this.provideMainPresenterProvider =
        DoubleCheck.provider(
            ActivityModule_ProvideMainPresenterFactory.create(
                builder.activityModule, mainPresenterProvider));

    this.mainScreenActivityMembersInjector =
        MainScreenActivity_MembersInjector.create(provideMainPresenterProvider);
  }

  @Override
  public void inject(MainActivityActivity activity) {
    mainActivityActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(LoginActivity activity) {
    loginActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(SplashActivity activity) {
    splashActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(FeedActivity activity) {
    feedActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(AboutFragment fragment) {
    aboutFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(OpenSourceFragment fragment) {
    openSourceFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(BlogFragment fragment) {
    blogFragmentMembersInjector.injectMembers(fragment);
  }

  @Override
  public void inject(RateUsDialog dialog) {
    rateUsDialogMembersInjector.injectMembers(dialog);
  }

  @Override
  public void inject(BusinessActivity activity) {
    businessActivityMembersInjector.injectMembers(activity);
  }

  @Override
  public void inject(OrderActivity orderActivity) {
    orderActivityMembersInjector.injectMembers(orderActivity);
  }

  @Override
  public void inject(CustomerActivity customerActivity) {
    customerActivityMembersInjector.injectMembers(customerActivity);
  }

  @Override
  public void inject(PaymentActivity paymentActivity) {
    paymentActivityMembersInjector.injectMembers(paymentActivity);
  }

  @Override
  public void inject(CheckActivity checkActivity) {
    checkActivityMembersInjector.injectMembers(checkActivity);
  }

  @Override
  public void inject(InvoiceActivity invoiceActivity) {
    invoiceActivityMembersInjector.injectMembers(invoiceActivity);
  }

  @Override
  public void inject(ProductsActivity productsActivity) {
    MembersInjectors.<ProductsActivity>noOp().injectMembers(productsActivity);
  }

  @Override
  public void inject(InvoicesShowActivity invoicesShowActivity) {
    MembersInjectors.<InvoicesShowActivity>noOp().injectMembers(invoicesShowActivity);
  }

  @Override
  public void inject(CustomerInvoiceActivity customerInvoiceActivity) {
    customerInvoiceActivityMembersInjector.injectMembers(customerInvoiceActivity);
  }

  @Override
  public void inject(CashActivity cashActivity) {
    cashActivityMembersInjector.injectMembers(cashActivity);
  }

  @Override
  public void inject(CashShowActivity cashShowActivity) {
    MembersInjectors.<CashShowActivity>noOp().injectMembers(cashShowActivity);
  }

  @Override
  public void inject(MainScreenActivity mainScreenActivity) {
    mainScreenActivityMembersInjector.injectMembers(mainScreenActivity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private ApplicationComponent applicationComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException(
            ApplicationComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }

    public Builder applicationComponent(ApplicationComponent applicationComponent) {
      this.applicationComponent = Preconditions.checkNotNull(applicationComponent);
      return this;
    }
  }
}
