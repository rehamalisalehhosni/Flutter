package com.bartech.sales.sa.ui.PaymentWays;

import com.bartech.sales.sa.ui.base.MvpPresenter;

/**
 * Created by Ahmed on 3/17/2018.
 */

public interface PaymentMvpPresenter <V extends PaymentMvpView> extends MvpPresenter<V> {

    void onChooseCustomer(String customername);
    void onChooseCustomer1(String customername);



}
