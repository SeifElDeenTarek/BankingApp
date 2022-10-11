package com.example.bankingapp.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;
import com.example.bankingapp.pojo.UserModel;
import com.example.bankingapp.ui.main.MainActivity;

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

        UserAdapter userAdapter = new UserAdapter(users);
        userRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        userRecycler.setAdapter(userAdapter);

        return rootView;
    }
}
