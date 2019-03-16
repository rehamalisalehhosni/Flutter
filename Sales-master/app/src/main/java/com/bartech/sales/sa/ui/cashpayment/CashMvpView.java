package com.bartech.sales.sa.ui.cashpayment;

import com.bartech.sales.sa.ui.base.MvpView;

/**
 * Created by Ahmed on 3/26/2018.
 */

public interface CashMvpView extends MvpView {

    void onShowCashPaymentClicked();
    void openCashActivity();
}
