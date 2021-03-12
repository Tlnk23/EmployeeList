package com.tlnk.employeelist.api;

import com.tlnk.employeelist.pojo.EmployeeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Alexandr Egorshin on 12.03.2021.
 */
public interface ApiService {

    @GET("testTask.json")
    Observable<EmployeeResponse> getEmployees();

}
