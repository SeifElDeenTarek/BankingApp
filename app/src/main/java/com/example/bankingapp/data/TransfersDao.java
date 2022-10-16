package com.example.bankingapp.data;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bankingapp.pojo.TransferModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface TransfersDao
{
    @Insert
    Completable insertTransfer(TransferModel transferModel);

    @Query("select * from transfers_table")
    Observable<List<TransferModel>> getTransfers();
}
