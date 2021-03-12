package com.tlnk.employeelist.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tlnk.employeelist.pojo.Employee;

/**
 * Created by Alexandr Egorshin on 12.03.2021.
 */

@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase database;
    private static final String DB_NAME = "employees.db";

    private static final Object LOCK = new Object();

    public static AppDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
            }
        }
        return database;
    }

    public abstract EmployeeDao employeeDao();
}
