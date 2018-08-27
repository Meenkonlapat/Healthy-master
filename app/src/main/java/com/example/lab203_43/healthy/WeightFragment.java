package com.example.lab203_43.healthy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.lab203_43.healthy.Weight.Weight;
import com.example.lab203_43.healthy.Weight.WeightAdapter;

import java.util.ArrayList;

/**
 * Created by LAB203_44 on 27/8/2561.
 */

public class WeightFragment extends Fragment
{

    ArrayList<Weight> _weight = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weight, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _weight.add(new Weight("01 Jan 2018", 63, "UP"));
        _weight.add(new Weight("02 Jan 2018", 64, "DOWN"));
        _weight.add(new Weight("03 Jan 2018", 63, "UP"));

        ListView  _weightlist = (ListView) getView().findViewById(R.id.weight_list);
        WeightAdapter _weightAdapter = new WeightAdapter(
                getActivity(),
                R.layout.fragment_weight_item,
                _weight);
        _weightlist.setAdapter(_weightAdapter);
        initAddWeightBtn();
    }

    private void initAddWeightBtn(){
        Button _addWeight = (Button) getView().findViewById(R.id.add_weight_btn);
        _addWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_view, new WeightFromFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
