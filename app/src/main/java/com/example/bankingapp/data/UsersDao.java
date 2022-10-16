package com.example.bankingapp.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bankingapp.pojo.UserModel;
import com.example.bankingapp.ui.main.UserViewModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface UsersDao
{
    @Update
    Completable updateUser(UserModel userModel);

    @Insert
    Completable insertUser(UserModel userModel);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAllUsers(UserModel userModel);

    @Query("select * from users_table")
    Observable<List<UserModel>> getUsers();

    @Query("UPDATE users_table SET userBalance = :amount WHERE userName =:name")
    Completable updateSender(int amount, String name);

    @Query("UPDATE users_table SET userBalance = :amount WHERE userName =:name")
    Completable updateReceiver(int amount, String name);
}
