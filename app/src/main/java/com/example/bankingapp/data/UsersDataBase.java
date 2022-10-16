package com.example.bankingapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.bankingapp.pojo.UserModel;

@Database(entities = UserModel.class, version = 1)

public abstract class UsersDataBase extends RoomDatabase
{
    private static UsersDataBase instance;
    public abstract UsersDao usersDao();

    public static synchronized UsersDataBase getInstance(Context context){
        if(instance == null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,UsersDataBase.class, "users_table")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

