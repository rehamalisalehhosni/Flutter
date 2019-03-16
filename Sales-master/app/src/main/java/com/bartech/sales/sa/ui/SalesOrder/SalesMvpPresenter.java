package com.bartech.sales.sa.ui.SalesOrder;

import com.bartech.sales.sa.ui.base.MvpPresenter;

/**
 * Created by Ahmed on 3/13/2018.
 */

public interface SalesMvpPresenter <V extends SalesMvpView> extends MvpPresenter<V> {

    void onSubmitSalesOrderClicked(String quantum,String price,String counter);
    void onCartButtonClicked();
}
