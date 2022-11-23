package com.cristobalbernal.pruebatabs;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.cristobalbernal.pruebatabs.ui.main.PersonalDataFragment;
import com.cristobalbernal.pruebatabs.ui.main.ProfesionalDataFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity implements PersonalDataFragment.IOnAttachListener, ProfesionalDataFragment.IOnAttachListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        setTitle("Joan tonto");
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        TabStateApdapter tabStateApdapter = new TabStateApdapter(this);
        viewPager.setAdapter(tabStateApdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Datos personales");
                    break;
                    case 1:
                        tab.setText("Datos Profesionales");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();

    }

    @Override
    public String getPersonalData() {
        return "Datos personales";
    }

    @Override
    public String getProfesional() {
        return "Datos profesionales";
    }

    public static class TabStateApdapter extends FragmentStateAdapter{

        public TabStateApdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new PersonalDataFragment();
                case 1:
                    return new ProfesionalDataFragment();
                default: new PersonalDataFragment();
            }
            return new Fragment();
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }



}