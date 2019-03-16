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

package com.bartech.sales.sa.di.component;

import com.bartech.sales.sa.di.PerActivity;
import com.bartech.sales.sa.di.module.ActivityModule;
import com.bartech.sales.sa.ui.Business.BusinessActivity;
import com.bartech.sales.sa.ui.PaymentWays.CheckActivity;
import com.bartech.sales.sa.ui.PaymentWays.PaymentActivity;
import com.bartech.sales.sa.ui.SalesOrder.OrderActivity;
import com.bartech.sales.sa.ui.SalesOrder.ProductsActivity;
import com.bartech.sales.sa.ui.about.AboutFragment;
import com.bartech.sales.sa.ui.cashpayment.CashActivity;
import com.bartech.sales.sa.ui.cashpayment.CashShowActivity;
import com.bartech.sales.sa.ui.customer.CustomerActivity;
import com.bartech.sales.sa.ui.customersforinvoice.CustomerInvoiceActivity;
import com.bartech.sales.sa.ui.feed.FeedActivity;
import com.bartech.sales.sa.ui.feed.blogs.BlogFragment;
import com.bartech.sales.sa.ui.feed.opensource.OpenSourceFragment;
import com.bartech.sales.sa.ui.login.LoginActivity;
import com.bartech.sales.sa.ui.main.MainActivityActivity;
import com.bartech.sales.sa.ui.main.rating.RateUsDialog;
import com.bartech.sales.sa.ui.mainscreen.MainScreenActivity;
import com.bartech.sales.sa.ui.salesinvoice.InvoiceActivity;
import com.bartech.sales.sa.ui.salesinvoice.InvoicesShowActivity;
import com.bartech.sales.sa.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivityActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

    void inject(BusinessActivity activity);

    void inject(OrderActivity orderActivity);

    void inject(CustomerActivity customerActivity);

    void inject(PaymentActivity paymentActivity);

    void inject(CheckActivity checkActivity);

    void inject(InvoiceActivity invoiceActivity);

    void inject(ProductsActivity productsActivity);

    void inject(InvoicesShowActivity invoicesShowActivity);

    void inject(CustomerInvoiceActivity customerInvoiceActivity);

    void inject(CashActivity cashActivity);

    void inject(CashShowActivity cashShowActivity);

    void inject(MainScreenActivity mainScreenActivity);
}
