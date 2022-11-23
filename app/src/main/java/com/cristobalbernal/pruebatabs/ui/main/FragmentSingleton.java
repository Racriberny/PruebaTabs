package com.cristobalbernal.pruebatabs.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cristobalbernal.pruebatabs.R;

public class FragmentSingleton extends Fragment {
    private static FragmentSingleton instance;
    private FragmentSingleton(){ }

    public static FragmentSingleton getInstance(){
        if (instance==null)
            instance = new FragmentSingleton();
        return instance;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_singleton_data,container,false);

    }
}
