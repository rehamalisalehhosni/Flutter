package com.bartech.sales.sa.ui.customer;

import com.androidnetworking.error.ANError;
import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.data.network.model.LoginRequest;
import com.bartech.sales.sa.data.network.model.LoginResponse;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Ahmed on 3/15/2018.
 */

public class CustomerPresenter<V extends CustomerMvpView> extends BasePresenter<V>
        implements CustomerMvpPresenter<V> {
    @Inject
    public CustomerPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onChooseCustomer(String customername) {

        if (customername == null || customername.isEmpty()) {
            getMvpView().onError(R.string.txt_customer);
        }
        getMvpView().openSalesActivity();
    }

    @Override
    public void getCustomers() {
        getCompositeDisposable().add(getDataManager()
                .getServerCustomers(new LoginRequest.ServerLoginRequest("email"," password"))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                     //   getDataManager().updateUserInfo(
//                                response.getAccessToken(),
//                                response.getUserId(),
//                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
//                                response.getUserName(),
//                                response.getUserEmail(),
//                                response.getGoogleProfilePicUrl());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();


                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));

    }
    }

