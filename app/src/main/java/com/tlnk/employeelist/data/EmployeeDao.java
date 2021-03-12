package com.tlnk.employeelist.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tlnk.employeelist.pojo.Employee;

import java.util.List;

/**
 * Created by Alexandr Egorshin on 12.03.2021.
 */
@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employees")
    LiveData<List<Employee>> getAllEmployees();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmployees(List<Employee> employees);

    @Query("DELETE FROM employees")
    void deleteAllEmployees();
}
