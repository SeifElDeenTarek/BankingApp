package com.example.bankingapp.ui.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bankingapp.data.UsersDataBase;
import com.example.bankingapp.pojo.UserModel;
import com.example.bankingapp.ui.transfer.TransferActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel
{
    Context context;
    TransferActivity transferActivity;
    public MutableLiveData<List<UserModel>> userListMutableLiveData = new MutableLiveData<>();
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public void getUsers()
    {
        userListMutableLiveData.setValue(getUsersFromDatabase());

    }

    public ArrayList<UserModel> getUsersFromDatabase()
    {
        ArrayList<UserModel> users = new ArrayList<>();

        /**
        users.add(new UserModel(1, "Seif El-Deen", "011XXXXXXXXX",
                "name@email.com", "1000000000", "25"));
        users.add(new UserModel(2, "Menna Allah", "011XXXXXXXXX",
                "name@email.com", "1000000", "25"));
        users.add(new UserModel(3, "Mostafa Nagy", "011XXXXXXXXX",
                "name@email.com", "500000000", "25"));

        users.add(new UserModel(4, "Ibrahim Hassan", "011XXXXXXXXX",
                "name@email.com", "65900000", "25"));
        users.add(new UserModel(5, "Alaa Mohamed", "011XXXXXXXXX",
                "name@email.com", "900000", "25"));
        users.add(new UserModel(6, "Katy Perry", "011XXXXXXXXX",
                "name@email.com", "99999999", "32"));
        users.add(new UserModel(7, "Lionel Messi", "011XXXXXXXXX",
                "name@email.com", "100000000000", "32"));
        users.add(new UserModel(8, "Adel Emam", "011XXXXXXXXX",
                "name@email.com", "9555250000", "70"));
        users.add(new UserModel(9, "Justin Bieber", "011XXXXXXXXX",
                "name@email.com", "1065326000", "27"));
        users.add(new UserModel(10, "Mohamed Abo Treka", "011XXXXXXXXX",
                "name@email.com", "999999999", "40"));
        users.add(new UserModel(11, "John Cena", "011XXXXXXXXX",
                "name@email.com", "1000000000", "43"));
        users.add(new UserModel(12, "Dwayne Johnson", "011XXXXXXXXX",
                "name@email.com", "1000000000", "54"));
**/

        return users;
    }
}
