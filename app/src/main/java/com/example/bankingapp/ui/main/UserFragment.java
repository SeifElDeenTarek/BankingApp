package com.example.bankingapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;
import com.example.bankingapp.data.UsersDataBase;
import com.example.bankingapp.pojo.UserModel;
import com.example.bankingapp.ui.transfer.TransferActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.StateSet.TAG;

public class UserFragment extends Fragment
{
    public UserFragment()
    {}

    UserViewModel userViewModel;
    UsersDataBase usersDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView =inflater.inflate(R.layout.user_list, container, false);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUsers();

        RecyclerView userRecycler = rootView.findViewById(R.id.users_recycler_view);
        final CardView details = rootView.findViewById(R.id.details);

        final TextView userName, userMob, userAge, userEmail, userBalance;
        userName = rootView.findViewById(R.id.name_details);
        userMob = rootView.findViewById(R.id.number_details);
        userAge = rootView.findViewById(R.id.age_details);
        userEmail = rootView.findViewById(R.id.email_details);
        userBalance = rootView.findViewById(R.id.balance_details);

        final Button transfer = rootView.findViewById(R.id.transfer_details);

        final UserAdapter userAdapter = new UserAdapter();
        userRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        userRecycler.setAdapter(userAdapter);

        usersDataBase = UsersDataBase.getInstance(getContext());

        if(usersDataBase.usersDao().getUsers() == null)
        {
            users();
        }



        userViewModel.userListMutableLiveData.observe(getViewLifecycleOwner(), new androidx.lifecycle.Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels)
            {
                usersDataBase.usersDao().getUsers()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<UserModel>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(List<UserModel> userModels) {

                                userAdapter.setUsersList(userModels, new UserAdapter.itemClickListener()
                                {
                                    @Override
                                    public void onItemClick(final UserModel userModel)
                                    {

                                        details.setVisibility(View.VISIBLE);
                                        userName.setText("Name: " + userModel.getUserName());
                                        userMob.setText("Mobile: " +userModel.getPhoneNumber());
                                        userAge.setText("Age: "+ userModel.getAge());
                                        userEmail.setText("Email: "+ userModel.getEmail());
                                        userBalance.setText("Balance: " + userModel.getUserBalance());

                                        transfer.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View v)
                                            {
                                                transferIntent(userModel.getId(), userModel.getUserName(), userModel.getPhoneNumber(),
                                                        userModel.getAge(), userModel.getEmail(), userModel.getUserBalance());
                                            }
                                        });
                                    }
                                });

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            }
        });


        OnBackPressedCallback callback = new OnBackPressedCallback(true)
        {
            @Override
            public void handleOnBackPressed()
            {
                details.setVisibility(View.GONE);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);

        return rootView;
    }

    public Intent transferIntent(int id, String name, String mobile, String age, String email, String balance)
    {
        Intent transferIntent = new Intent(getContext(), TransferActivity.class);
        transferIntent.putExtra("id", id);
        transferIntent.putExtra("sender_name", name);
        transferIntent.putExtra("sender_mobile", mobile);
        transferIntent.putExtra("sender_age", age);
        transferIntent.putExtra("sender_email", email);
        transferIntent.putExtra("sender_balance", balance);
        startActivity(transferIntent);
        return transferIntent;
    }

    public void users()
    {
        usersDataBase.usersDao().insertAllUsers(new UserModel(1, "Seif El-Deen", "011XXXXXXXXX",
                "name@email.com", "1000000000", "25"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(2, "Dwayne Johnson", "011XXXXXXXXX",
                "name@email.com", "1000000000", "54"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(3, "Mostafa Nagy", "011XXXXXXXXX",
                "name@email.com", "500000000", "25"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(4, "Ibrahim Hassan", "011XXXXXXXXX",
                "name@email.com", "65900000", "25"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(5, "John Cena", "011XXXXXXXXX",
                "name@email.com", "1000000000", "43"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(6, "Katy Perry", "011XXXXXXXXX",
                "name@email.com", "99999999", "32"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(7, "Lionel Messi", "011XXXXXXXXX",
                "name@email.com", "100000000000", "32"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(8, "Adel Emam", "011XXXXXXXXX",
                "name@email.com", "9555250000", "70"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(9, "Justin Bieber", "011XXXXXXXXX",
                "name@email.com", "1065326000", "27"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

        usersDataBase.usersDao().insertAllUsers(new UserModel(10, "Mohamed Abo Treka", "011XXXXXXXXX",
                "name@email.com", "999999999", "40"))
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
