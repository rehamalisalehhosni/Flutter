package com.bartech.sales.sa.ui.customer;

import com.bartech.sales.sa.ui.base.MvpPresenter;

/**
 * Created by Ahmed on 3/15/2018.
 */

public interface CustomerMvpPresenter <V extends CustomerMvpView> extends MvpPresenter<V> {

    void onChooseCustomer(String customername);
    void getCustomers();
}
