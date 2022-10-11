package com.example.bankingapp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;
import com.example.bankingapp.pojo.UserModel;

import java.util.ArrayList;
import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>
{
    private List<UserModel> usersList = new ArrayList<>();

    public UserAdapter(List<UserModel> usersList)
    {
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position)
    {
        holder.userName.setText(usersList.get(position).getUserName());
        holder.userBalance.setText(usersList.get(position).getUserBalance());
    }

    @Override
    public int getItemCount()
    {
        return usersList.size();
    }

    public void setUsersList(List<UserModel> usersList)
    {
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder
    {
        TextView userName, userBalance;

        public UserViewHolder(@NonNull View itemView)
        {
            super(itemView);
            userName = itemView.findViewById(R.id.user_name_txt_view);
            userBalance = itemView.findViewById(R.id.user_balance_txt_view);
        }
    }
}
