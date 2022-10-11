package com.example.bankingapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;
import com.example.bankingapp.pojo.UserModel;
import com.example.bankingapp.ui.transfer.TransferActivity;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment
{
    public UserFragment()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView =inflater.inflate(R.layout.user_list, container, false);

        RecyclerView userRecycler = rootView.findViewById(R.id.users_recycler_view);
        final CardView details = rootView.findViewById(R.id.details);

        final TextView userName, userMob, userAge, userEmail, userBalance;
        userName = rootView.findViewById(R.id.name_details);
        userMob = rootView.findViewById(R.id.number_details);
        userAge = rootView.findViewById(R.id.age_details);
        userEmail = rootView.findViewById(R.id.email_details);
        userBalance = rootView.findViewById(R.id.balance_details);

        Button transfer = rootView.findViewById(R.id.transfer_details);


        final List<UserModel> users = new ArrayList<>();
        users.add(new UserModel("Seif El-Deen", "011XXXXXXXXX",
                "name@email.com", "1000000000", "25"));
        users.add(new UserModel("Ahmed Ahmed", "011XXXXXXXXX",
                "name@email.com", "1000000", "25"));
        users.add(new UserModel("Mostafa Mostafa", "011XXXXXXXXX",
                "name@email.com", "500000000", "25"));
        users.add(new UserModel("Ibrahim Ibrahim", "011XXXXXXXXX",
                "name@email.com", "65900000", "25"));
        users.add(new UserModel("Alaa Alaa", "011XXXXXXXXX",
                "name@email.com", "900000", "25"));
        users.add(new UserModel("Katy Perry", "011XXXXXXXXX",
                "name@email.com", "99999999", "32"));
        users.add(new UserModel("Lionel Messi", "011XXXXXXXXX",
                "name@email.com", "100000000000", "32"));
        users.add(new UserModel("Adel Emam", "011XXXXXXXXX",
                "name@email.com", "9555250000", "70"));
        users.add(new UserModel("Justin Bieber", "011XXXXXXXXX",
                "name@email.com", "1065326000", "27"));
        users.add(new UserModel("Mohamed Abo Treka", "011XXXXXXXXX",
                "name@email.com", "999999999", "40"));
        users.add(new UserModel("John Cena", "011XXXXXXXXX",
                "name@email.com", "1000000000", "43"));
        users.add(new UserModel("Dwayne Johnson", "011XXXXXXXXX",
                "name@email.com", "1000000000", "54"));

        UserAdapter userAdapter = new UserAdapter();
        userAdapter.setUsersList(users, new UserAdapter.itemClickListener()
        {
            @Override
            public void onItemClick(UserModel userModel)
            {
                details.setVisibility(View.VISIBLE);
                userName.setText("Name:" + userModel.getUserName());
                userMob.setText("Mobile: " +userModel.getPhoneNumber());
                userAge.setText("Age: "+ userModel.getAge());
                userEmail.setText("Email: "+ userModel.getEmail());
                userBalance.setText("Balance: " + userModel.getUserBalance());
            }
        });
        userRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        userRecycler.setAdapter(userAdapter);

        transfer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                transferIntent(userName.toString(), userBalance.toString());
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

    public Intent transferIntent(String name, String balance)
    {
        Intent transferIntent = new Intent(getContext(), TransferActivity.class);
        transferIntent.putExtra("product_id", name);
        transferIntent.putExtra("product_image_link", balance);
        startActivity(transferIntent);
        return transferIntent;
    }
}
