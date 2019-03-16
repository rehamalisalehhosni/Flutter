package com.bartech.sales.sa.ui.cashpayment;

import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 3/26/2018.
 */

public class CashPresenter <V extends CashMvpView> extends BasePresenter<V> implements CashMvpPresenter<V> {
    @Inject
    public CashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onShowCashPaymentClicked() {
        getMvpView().onShowCashPaymentClicked();
    }

    @Override
    public void onSubmitCashInvoice(String customerName, String total) {
        getMvpView().openCashActivity();
    }
}
