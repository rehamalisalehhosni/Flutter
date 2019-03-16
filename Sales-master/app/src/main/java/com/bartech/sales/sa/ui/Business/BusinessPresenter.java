package com.bartech.sales.sa.ui.Business;

import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 3/12/2018.
 */

public class BusinessPresenter<V extends BusinessMvpView> extends BasePresenter<V>
        implements BusinessMvpPresenter<V> {
    @Inject
    public BusinessPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
