package com.bartech.sales.sa.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ahmed on 4/16/2018.
 */

public class LoginRequestt {
    private LoginRequestt() {
        // This class is not publicly instantiable
    }

    public static class ServerLoginRequestt {
        @Expose
        @SerializedName("UserName")
        private String UserName;

        @Expose
        @SerializedName("Password")
        private String Password;

        public ServerLoginRequestt(String userName, String password) {
            UserName = userName;
            Password = password;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }
    }
}
