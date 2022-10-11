package com.example.bankingapp.ui.transfer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bankingapp.R;
import com.example.bankingapp.ui.main.MainActivity;
import com.example.bankingapp.ui.main.TransferFragment;

import static androidx.constraintlayout.widget.StateSet.TAG;

public class TransferActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        TextView sender, receiver, amount;
        Button transfer = findViewById(R.id.transfer);

        sender = findViewById(R.id.transfer_sender);
        receiver = findViewById(R.id.transfer_receiver);
        amount = findViewById(R.id.transfer_amount);

        String senderName = getIntent().getStringExtra("sender_name");
        String senderBalance = getIntent().getStringExtra("sender_balance");

        Log.d(TAG, "onCreate: " + senderName);

        sender.setText(senderName);

        transfer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("transferred", true);
                startActivity(intent);
            }
        });
    }
}
