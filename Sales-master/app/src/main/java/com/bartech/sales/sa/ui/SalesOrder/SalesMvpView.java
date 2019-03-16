package com.bartech.sales.sa.ui.SalesOrder;

import com.bartech.sales.sa.ui.base.MvpView;

/**
 * Created by Ahmed on 3/13/2018.
 */

public interface SalesMvpView extends MvpView {
    void openBusinessActivity();
   // void onAddProduct(int position);
    void onCartIconClicked();
}
