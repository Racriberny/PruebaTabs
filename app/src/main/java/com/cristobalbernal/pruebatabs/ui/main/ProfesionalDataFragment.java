package com.cristobalbernal.pruebatabs.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cristobalbernal.pruebatabs.R;

public class ProfesionalDataFragment extends Fragment {
    public interface IOnAttachListener{
        String getProfesional();
    }
    private String data;

    public ProfesionalDataFragment(){
        super(R.layout.fragment_profesional_data);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tcPersonalData = view.findViewById(R.id.tvProfesionalData);
        tcPersonalData.setText(data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        data = attachListener.getProfesional();
    }
}
