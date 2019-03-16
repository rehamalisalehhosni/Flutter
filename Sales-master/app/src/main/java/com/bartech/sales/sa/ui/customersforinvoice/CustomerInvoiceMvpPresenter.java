package com.bartech.sales.sa.ui.customersforinvoice;

import com.bartech.sales.sa.ui.base.MvpPresenter;

/**
 * Created by Ahmed on 3/15/2018.
 */

public interface CustomerInvoiceMvpPresenter<V extends CustomerInvoiceMvpView> extends MvpPresenter<V> {

    void onChooseCustomer(String customername);
}
