package com.bartech.sales.sa.ui.cashpayment;

import com.bartech.sales.sa.ui.base.MvpPresenter;

/**
 * Created by Ahmed on 3/26/2018.
 */

public interface CashMvpPresenter <V extends CashMvpView> extends MvpPresenter<V> {

    void onShowCashPaymentClicked();
    void onSubmitCashInvoice(String customerName, String total);
}
