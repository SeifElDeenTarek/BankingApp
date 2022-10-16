package com.example.bankingapp.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.bankingapp.R;
import com.example.bankingapp.data.UsersDataBase;
import com.example.bankingapp.pojo.UserModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(fragmentAdapter);
        TabLayout tabLayout = findViewById(R.id.tabs);

        boolean transferred = getIntent().getBooleanExtra("transferred", false);

        if(transferred)
        {
            viewPager.setCurrentItem(1);
        }

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy()
        {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position)
            {
                switch(position)
                {
                    case 0:
                        tab.setText("Users");
                        break;
                    case 1:
                        tab.setText("Transfer");
                        break;
                }
            }
        }).attach();
    }
}
