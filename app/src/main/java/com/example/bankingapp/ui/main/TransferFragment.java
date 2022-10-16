package com.example.bankingapp.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankingapp.R;
import com.example.bankingapp.data.TransfersDataBase;
import com.example.bankingapp.pojo.TransferModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static androidx.constraintlayout.widget.StateSet.TAG;

public class TransferFragment extends Fragment
{
    public TransferFragment()
    {}

    TransferViewModel transferViewModel;

    String sender, receiver, amount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.user_list, container, false);

        transferViewModel = ViewModelProviders.of(this).get(TransferViewModel.class);
        transferViewModel.getTransfers();

        RecyclerView transferRecycler = rootView.findViewById(R.id.users_recycler_view);
        final TransferAdapter transferAdapter = new TransferAdapter();
        transferRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        transferRecycler.setAdapter(transferAdapter);

        final TransfersDataBase transfersDataBase = TransfersDataBase.getInstance(getContext());

        transfersDataBase.transfersDao().getTransfers()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<TransferModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<TransferModel> transferModels)
                    {
                        transferAdapter.setTransfersList(transferModels);
                        transferAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return rootView;
    }
}