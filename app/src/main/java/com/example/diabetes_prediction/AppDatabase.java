package com.example.diabetes_prediction;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@TypeConverters({DateTypeConverter.class})
@Database(entities = { UsernamePassword.class,Reminders.class }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE = null;

    public abstract RoomDAO getRoomDAO();

    public static AppDatabase geAppdatabase(Context context){

        return INSTANCE;

    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
