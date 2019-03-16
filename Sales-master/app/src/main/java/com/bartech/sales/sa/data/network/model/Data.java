
package com.bartech.sales.sa.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable
{

    @SerializedName("UserId")
    @Expose
    private Integer userId;
    @SerializedName("EmployeeId")
    @Expose
    private Integer employeeId;
    @SerializedName("TypeId")
    @Expose
    private Integer typeId;
    @SerializedName("NameAr")
    @Expose
    private Object nameAr;
    @SerializedName("NameEn")
    @Expose
    private Object nameEn;
    @SerializedName("Roles")
    @Expose
    private List<Object> roles = null;
    @SerializedName("IsSysAdmin")
    @Expose
    private Boolean isSysAdmin;
    private final static long serialVersionUID = 3522295721206920997L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Object getNameAr() {
        return nameAr;
    }

    public void setNameAr(Object nameAr) {
        this.nameAr = nameAr;
    }

    public Object getNameEn() {
        return nameEn;
    }

    public void setNameEn(Object nameEn) {
        this.nameEn = nameEn;
    }

    public List<Object> getRoles() {
        return roles;
    }

    public void setRoles(List<Object> roles) {
        this.roles = roles;
    }

    public Boolean getIsSysAdmin() {
        return isSysAdmin;
    }

    public void setIsSysAdmin(Boolean isSysAdmin) {
        this.isSysAdmin = isSysAdmin;
    }

}
