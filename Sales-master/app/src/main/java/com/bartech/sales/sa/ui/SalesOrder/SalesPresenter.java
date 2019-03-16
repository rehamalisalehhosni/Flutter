package com.bartech.sales.sa.ui.SalesOrder;

import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ahmed on 3/13/2018.
 */

public class SalesPresenter <V extends SalesMvpView> extends BasePresenter<V> implements SalesMvpPresenter<V> {
    @Inject
    public SalesPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }



    @Override
    public void onSubmitSalesOrderClicked( String quantum, String price,String counter) {


        if (getMvpView()!= null){
//            if (recproduct == null || recproduct.isEmpty()){
//            getMvpView().onError(R.string.recproduct);
//            return;
//        }
                if (quantum == null || quantum.isEmpty()){
                    getMvpView().onError(R.string.quantum1);
                    return;

                }
                if (price == null || price.isEmpty()){
                    getMvpView().onError(R.string.price1);
                    return;

                }
//                getMvpView().showLoading();
                getMvpView().openBusinessActivity();
            }
        }

    @Override
    public void onCartButtonClicked() {
        getMvpView().onCartIconClicked();
    }

}
