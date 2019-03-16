/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.bartech.sales.sa.ui.login;

import com.androidnetworking.error.ANError;
import com.bartech.sales.sa.R;
import com.bartech.sales.sa.data.DataManager;
import com.bartech.sales.sa.data.network.model.LoginRequestt;
import com.bartech.sales.sa.data.network.model.LoginResponse;
import com.bartech.sales.sa.ui.base.BasePresenter;
import com.bartech.sales.sa.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by janisharali on 27/01/17.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerLoginButtonClicked(final String username, final String password) {
        //validate username and password

        if (username == null && username.isEmpty()) {
            getMvpView().onError(R.string.empty_username);
            return;

        }
        if (password == null && password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;

        }
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequestt.ServerLoginRequestt(username, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        if (response.getData() != null) {
                            getMvpView().saveLoginResponse(response);
                            getMvpView().openMainScreenActivity();
                        }
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
