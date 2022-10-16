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
    itemClickListener itemClickListener;

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position)
    {
        holder.userName.setText(usersList.get(position).getUserName());
        holder.userBalance.setText(usersList.get(position).getUserBalance());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                itemClickListener.onItemClick(usersList.get(position));
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return usersList.size();
    }

    public void setUsersList(List<UserModel> usersList, itemClickListener itemClickListener)
    {
        this.usersList = usersList;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }

    public void setUsersList1(List<UserModel> usersList)
    {
        this.usersList = usersList;
        notifyDataSetChanged();
    }

    public interface itemClickListener
    {
        void onItemClick(UserModel userModel);
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
