package com.example.lab203_43.healthy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by LAB203_44 on 27/8/2561.
 */

public class MenuFragment extends Fragment{

    ArrayList<String> _menu = new ArrayList<>();

    public MenuFragment() {
        _menu.add("BMI");
        _menu.add("Weight");
        _menu.add("Setup");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        ArrayAdapter<String> _menuAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                _menu
        );

        ListView _menuList = (ListView) getView().findViewById(R.id.menu_list);
        _menuList.setAdapter(_menuAdapter);
        _menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("MENU", "Click on menu = " + _menu.get(i));
                switch (_menu.get(i)){
                    case "BMI":
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new BMIfragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case "Weight" :
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new WeightFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    case "Setup" :
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new WeightFromFragment())
                                .addToBackStack(null)
                                .commit();
                        break;
                    default: break;
                }

            }
        });
    }
}
