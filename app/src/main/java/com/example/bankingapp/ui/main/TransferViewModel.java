package com.example.bankingapp.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bankingapp.data.TransfersDataBase;
import com.example.bankingapp.pojo.TransferModel;

import java.util.ArrayList;
import java.util.List;

public class TransferViewModel extends ViewModel
{
    public MutableLiveData<List<TransferModel>> transfersListMutableLiveData = new MutableLiveData<>();


    public void getTransfers()
    {
        transfersListMutableLiveData.setValue(getTransferFromDatabase());
    }

    private ArrayList<TransferModel> getTransferFromDatabase()
    {
        ArrayList<TransferModel> transferModels = new ArrayList<>();
        return transferModels;
    }
}
