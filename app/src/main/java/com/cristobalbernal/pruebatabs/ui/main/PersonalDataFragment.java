package com.cristobalbernal.pruebatabs.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.cristobalbernal.pruebatabs.R;

public class PersonalDataFragment extends Fragment {
    public interface IOnAttachListener{
        String getPersonalData();
    }
    private String data;

    public PersonalDataFragment(){
        super(R.layout.fragment_persona_data);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tcPersonalData = view.findViewById(R.id.tvPersonallData);
        tcPersonalData.setText(data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        data = attachListener.getPersonalData();
    }
}
