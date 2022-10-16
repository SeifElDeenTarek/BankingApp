package com.example.bankingapp.pojo;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "transfers_table")
public class TransferModel
{
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("sender")
    @Expose
    private String sender;
    @SerializedName("receiver")
    @Expose
    private String receiver;
    @SerializedName("amount")
    @Expose
    private String amount;

    public TransferModel(String sender, String receiver, String amount)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }

    public String getAmount()
    {
        return amount;
    }

    public void setAmount(String amount)
    {
        this.amount = amount;
    }
}
