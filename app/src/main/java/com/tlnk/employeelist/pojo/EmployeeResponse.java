package com.tlnk.employeelist.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alexandr Egorshin on 12.03.2021.
 */
public class EmployeeResponse {
    @SerializedName("response")
    @Expose
    private List<Employee> response = null;

    public List<Employee> getResponse() {
        return response;
    }

    public void setResponse(List<Employee> response) {
        this.response = response;
    }
}
