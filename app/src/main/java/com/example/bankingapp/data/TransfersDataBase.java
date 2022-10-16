package com.example.bankingapp.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bankingapp.pojo.TransferModel;


@Database(entities = TransferModel.class, version = 1)

public abstract class TransfersDataBase extends RoomDatabase
{
    private static TransfersDataBase instance;
    public abstract TransfersDao transfersDao();

    public static synchronized TransfersDataBase getInstance(Context context){
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,TransfersDataBase.class, "transfers_table")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
