package com.example.bankingapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;
import com.example.bankingapp.pojo.TransferModel;

import java.util.ArrayList;
import java.util.List;

public class TransferAdapter extends RecyclerView.Adapter<TransferAdapter.TransferViewHolder>
{
    private List<TransferModel> transfersList = new ArrayList<>();

    @NonNull
    @Override
    public TransferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new TransferViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.transfer_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TransferViewHolder holder, int position)
    {
        holder.sender.setText(transfersList.get(position).getSender());
        holder.receiver.setText(transfersList.get(position).getReceiver());
        holder.amount.setText(transfersList.get(position).getAmount());
        holder.number.setText("Transfer  "+ String.valueOf(transfersList.get(position).getId()));
    }

    @Override
    public int getItemCount()
    {
        return transfersList.size();
    }

    public void setTransfersList(List<TransferModel> transfersList)
    {
        this.transfersList = transfersList;
        notifyDataSetChanged();
    }

    public class TransferViewHolder extends RecyclerView.ViewHolder
    {
        TextView sender, receiver, amount, number;

        public TransferViewHolder(@NonNull View itemView)
        {
            super(itemView);
            sender = itemView.findViewById(R.id.sender_txt_view);
            receiver = itemView.findViewById(R.id.receiver_txt_view);
            amount = itemView.findViewById(R.id.amount_txt_view);
            number = itemView.findViewById(R.id.transfer_num_txt_view);
        }
    }
}
