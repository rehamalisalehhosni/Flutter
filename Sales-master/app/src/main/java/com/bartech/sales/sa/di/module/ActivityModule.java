/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.bartech.sales.sa.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bartech.sales.sa.data.network.model.BlogResponse;
import com.bartech.sales.sa.data.network.model.OpenSourceResponse;
import com.bartech.sales.sa.di.ActivityContext;
import com.bartech.sales.sa.di.PerActivity;
import com.bartech.sales.sa.ui.Business.BusinessMvpPresenter;
import com.bartech.sales.sa.ui.Business.BusinessMvpView;
import com.bartech.sales.sa.ui.Business.BusinessPresenter;
import com.bartech.sales.sa.ui.PaymentWays.PaymentMvpPresenter;
import com.bartech.sales.sa.ui.PaymentWays.PaymentMvpView;
import com.bartech.sales.sa.ui.PaymentWays.PaymentPresenter;
import com.bartech.sales.sa.ui.SalesOrder.SalesMvpPresenter;
import com.bartech.sales.sa.ui.SalesOrder.SalesMvpView;
import com.bartech.sales.sa.ui.SalesOrder.SalesPresenter;
import com.bartech.sales.sa.ui.about.AboutMvpPresenter;
import com.bartech.sales.sa.ui.about.AboutMvpView;
import com.bartech.sales.sa.ui.about.AboutPresenter;
import com.bartech.sales.sa.ui.cashpayment.CashMvpPresenter;
import com.bartech.sales.sa.ui.cashpayment.CashMvpView;
import com.bartech.sales.sa.ui.cashpayment.CashPresenter;
import com.bartech.sales.sa.ui.customer.CustomerMvpPresenter;
import com.bartech.sales.sa.ui.customer.CustomerMvpView;
import com.bartech.sales.sa.ui.customer.CustomerPresenter;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceMvpPresenter;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceMvpView;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoicePresenter;
import com.bartech.sales.sa.ui.feed.FeedMvpPresenter;
import com.bartech.sales.sa.ui.feed.FeedMvpView;
import com.bartech.sales.sa.ui.feed.FeedPagerAdapter;
import com.bartech.sales.sa.ui.feed.FeedPresenter;
import com.bartech.sales.sa.ui.feed.blogs.BlogAdapter;
import com.bartech.sales.sa.ui.feed.blogs.BlogMvpPresenter;
import com.bartech.sales.sa.ui.feed.blogs.BlogMvpView;
import com.bartech.sales.sa.ui.feed.blogs.BlogPresenter;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceAdapter;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceMvpPresenter;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceMvpView;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourcePresenter;
import com.bartech.sales.sa.ui.login.LoginMvpPresenter;
import com.bartech.sales.sa.ui.login.LoginMvpView;
import com.bartech.sales.sa.ui.login.LoginPresenter;
import com.bartech.sales.sa.ui.main.MainActivityMvpPresenter;
import com.bartech.sales.sa.ui.main.MainActivityMvpView;
import com.bartech.sales.sa.ui.main.MainActivityPresenter;
import com.bartech.sales.sa.ui.main.rating.RatingDialogMvpPresenter;
import com.bartech.sales.sa.ui.main.rating.RatingDialogMvpView;
import com.bartech.sales.sa.ui.main.rating.RatingDialogPresenter;
import com.bartech.sales.sa.ui.mainscreen.MainMvpPresenter;
import com.bartech.sales.sa.ui.mainscreen.MainMvpView;
import com.bartech.sales.sa.ui.mainscreen.MainPresenter;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceMvpPresenter;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceMvpView;
import com.bartech.sales.sa.ui.salesinvoice.InvoicePresenter;
import com.bartech.sales.sa.ui.splash.SplashMvpPresenter;
import com.bartech.sales.sa.ui.splash.SplashMvpView;
import com.bartech.sales.sa.ui.splash.SplashPresenter;
import com.bartech.sales.sa.utils.rx.AppSchedulerProvider;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    PaymentMvpPresenter<PaymentMvpView> providePaymentPresenter(
            PaymentPresenter<PaymentMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    CashMvpPresenter<CashMvpView> provideCashPresenter(
            CashPresenter<CashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    InvoiceMvpPresenter<InvoiceMvpView> provideInvoicePresenter(
            InvoicePresenter<InvoiceMvpView> presenter) {
        return presenter;
    }



    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    BusinessMvpPresenter<BusinessMvpView> provideBusinessPresenter(
            BusinessPresenter<BusinessMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    SalesMvpPresenter<SalesMvpView> provideSalesPresenter(
            SalesPresenter<SalesMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    CustomerMvpPresenter<CustomerMvpView> provideCustomerPresenter(
            CustomerPresenter<CustomerMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    CustomerInvoiceMvpPresenter<CustomerInvoiceMvpView> provideCustomerInvoicePresenter(
            CustomerInvoicePresenter<CustomerInvoiceMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainActivityMvpPresenter<MainActivityMvpView> provideMainActivityPresenter(
            MainActivityPresenter<MainActivityMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
