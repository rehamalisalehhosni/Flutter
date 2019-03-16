package com.bartech.sales.sa.ui.salesinvoice;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 3/18/2018.
 */

public class InvoicePresenter<V extends InvoiceMvpView> extends BasePresenter<V> implements InvoiceMvpPresenter<V> {

    @Inject
    public InvoicePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onChooseCustomer(String customername) {

        if (customername == null || customername.isEmpty()) {
            getMvpView().onError(R.string.txt_customer);
        }
        getMvpView().showLoading();
        getMvpView().openInvoiceActivity();
    }

    @Override
    public void onSubmitInvoice(String s, String toString, String string) {
        getMvpView().openInvoiceActivity();
    }

    @Override
    public void onShowInvoiceClicked() {
        getMvpView().onShowSalesInvoiceClicked();
    }
}
