package com.example.bankingapp.ui.transfer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankingapp.R;
import com.example.bankingapp.data.TransfersDataBase;
import com.example.bankingapp.data.UsersDataBase;
import com.example.bankingapp.pojo.TransferModel;
import com.example.bankingapp.pojo.UserModel;
import com.example.bankingapp.ui.main.MainActivity;
import com.example.bankingapp.ui.main.TransferFragment;
import com.example.bankingapp.ui.main.UserFragment;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.StateSet.TAG;

public class TransferActivity extends AppCompatActivity
{

    String senderName, senderEmail, senderBalance, senderAge, senderMobile;
    String receiverName, receiverBalance, amountTransferred, finalBalance;
    int currentBalance, newSenderBalance, newReceiverBalance, senderId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final UserModel userModels = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        final EditText sender, amount;
        Button transfer = findViewById(R.id.transfer);

        final AutoCompleteTextView receiver;

        sender = findViewById(R.id.transfer_sender);

        receiver = findViewById(R.id.transfer_receiver);
        receiver.setAdapter(
                new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
                        getResources().getStringArray(R.array.Receivers)));

        amount = findViewById(R.id.transfer_amount);

        senderId = getIntent().getIntExtra("id", 1);
        senderName = getIntent().getStringExtra("sender_name");
        senderMobile = getIntent().getStringExtra("sender_mobile");
        senderAge = getIntent().getStringExtra("sender_age");
        senderEmail = getIntent().getStringExtra("sender_email");
        senderBalance = getIntent().getStringExtra("sender_balance");

        sender.setText(senderName);

        currentBalance = Integer.parseInt(senderBalance);

        Log.d(TAG, "onCreate: 111" + Integer.parseInt(senderBalance));


        final TransfersDataBase transfersDataBase = TransfersDataBase.getInstance(this);
        final UsersDataBase usersDataBase = UsersDataBase.getInstance(this);

        transfer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                senderName = sender.getText().toString().trim();
                receiverName = receiver.getText().toString().trim();
                amountTransferred = amount.getText().toString().trim();
                newSenderBalance = currentBalance - Integer.parseInt(amountTransferred);

                getReceiverBalance();

                newReceiverBalance = Integer.parseInt(amountTransferred) + Integer.parseInt(receiverBalance);

                transfersDataBase.transfersDao().insertTransfer(new TransferModel(senderName, receiverName, amountTransferred))
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

                usersDataBase.usersDao().updateSender(newSenderBalance, senderName)
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



                usersDataBase.usersDao().updateReceiver(newReceiverBalance, receiverName)
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("transferred", true);
                                startActivity(intent);


                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });

/**
                transfersDataBase.transfersDao().insertTransfer(new TransferModel(senderName, receiverName, amountTransferred))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver()
                        {
                            @Override
                            public void onSubscribe(Disposable d)
                            {

                            }

                            @Override
                            public void onComplete()
                            {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("transferred", true);
                                startActivity(intent);
                            }

                            @Override
                            public void onError(Throwable e)
                            {

                            }
                        });
**/

/**
                usersDataBase.usersDao().updateUser(new UserModel(senderName, senderMobile, senderEmail, senderAge, finalBalance))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "TEST" + senderId + senderName + senderMobile + senderEmail + senderAge + finalBalance);

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });**/
            }
        });
    }

    public String getReceiverBalance()
    {
        if(receiverName.equals("Seif El-Deen"))
        {
            receiverBalance = "1000000000";
        }
        else if(receiverName.equals("Dwayne Johnson"))
        {
            receiverBalance = "1000000000";
        }
        else if(receiverName.equals("Mostafa Nagy"))
        {
            receiverBalance = "500000000";
        }
        else if(receiverName.equals("Ibrahim Hassan"))
        {
            receiverBalance = "65900000";
        }
        else if(receiverName.equals("John Cena"))
        {
            receiverBalance = "1000000000";
        }
        else if(receiverName.equals("Katy Perry"))
        {
            receiverBalance = "99999999";
        }
        else if(receiverName.equals("Lionel Messi"))
        {
            receiverBalance = "100000000000";
        }
        else if(receiverName.equals("Adel Emam"))
        {
            receiverBalance = "9555250000";
        }
        else if(receiverName.equals("Justin Bieber"))
        {
            receiverBalance = "1065326000";
        }
        else if(receiverName.equals("Mohamed Abo Treka"))
        {
            receiverBalance = "999999999";
        }

        return receiverBalance;
    }
}