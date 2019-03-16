package com.bartech.sales.sa.ui.mainscreen;

import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 3/31/2018.
 */

public class MainPresenter <V extends MainMvpView> extends BasePresenter<V>
            implements MainMvpPresenter<V> {
    @Inject
    public MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
