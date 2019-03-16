package com.bartech.sales.sa.ui.salesinvoice;

import com.bartech.sales.sa.ui.base.MvpPresenter;

/**
 * Created by Ahmed on 3/18/2018.
 */

public interface InvoiceMvpPresenter<V extends InvoiceMvpView> extends MvpPresenter<V> {
    void onChooseCustomer(String customername);

    void onSubmitInvoice(String s, String toString, String string);

    void onShowInvoiceClicked();
}
