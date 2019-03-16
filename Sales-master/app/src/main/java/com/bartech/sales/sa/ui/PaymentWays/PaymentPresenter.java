package com.bartech.sales.sa.ui.PaymentWays;

import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 3/17/2018.
 */

public class PaymentPresenter <V extends PaymentMvpView> extends BasePresenter<V> implements PaymentMvpPresenter<V> {
    @Inject
    public PaymentPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onChooseCustomer(String customername) {
        getMvpView().openCashPaymentActivity();
    }

    @Override
    public void onChooseCustomer1(String customername) {
        getMvpView().openCheckPaymentActivity();
    }




}
