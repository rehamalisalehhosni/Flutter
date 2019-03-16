package com.bartech.sales.sa.ui.customersforinvoice;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 3/15/2018.
 */

public class CustomerInvoicePresenter<V extends CustomerInvoiceMvpView> extends BasePresenter<V>
        implements CustomerInvoiceMvpPresenter<V> {
    @Inject
    public CustomerInvoicePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onChooseCustomer(String customername) {

        if (customername == null || customername.isEmpty()) {
            getMvpView().onError(R.string.txt_customer);
        }
        getMvpView().openSalesActivity();
    }
}
