package com.tlnk.employeelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.tlnk.employeelist.adapters.EmployeeAdapter;
import com.tlnk.employeelist.api.ApiFactory;
import com.tlnk.employeelist.api.ApiService;
import com.tlnk.employeelist.pojo.Employee;
import com.tlnk.employeelist.pojo.EmployeeResponse;
import com.tlnk.employeelist.screens.employees.EmployeeViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter employeeAdapter = new EmployeeAdapter();
    private EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeAdapter);
        employeeAdapter.setEmployeeList(new ArrayList<Employee>());

        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        employeeViewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                employeeAdapter.setEmployeeList(employees);
            }
        });
        employeeViewModel.loadData();

    }

}