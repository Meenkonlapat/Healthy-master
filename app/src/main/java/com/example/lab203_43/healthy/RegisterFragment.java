package com.example.lab203_43.healthy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by LAB203_43 on 20/8/2561.
 */

public class RegisterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRegisterBtn();
    }

    // Action after click login button
    private void initRegisterBtn() {
        Button _registerBtn = (Button) getView().findViewById(R.id.register_register_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText _userId = (EditText) getView().findViewById(R.id.user_id);
                EditText _userName = (EditText) getView().findViewById(R.id.user_name);
                EditText _userAge = (EditText) getView().findViewById(R.id.user_age);
                EditText _password = (EditText) getView().findViewById(R.id.user_password);
                String _userIdStr = _userId.getText().toString();
                String _userNameStr = _userName.getText().toString();
                String _userAgeStr = _userAge.getText().toString();
                String _passwordStr = _password.getText().toString();
                if (_userIdStr.isEmpty() || _userNameStr.isEmpty() || _userAgeStr.isEmpty() || _passwordStr.isEmpty()) {
                    if (_userNameStr.isEmpty()) {
                        Log.d("USER", "USER ALREADY EXIST");
                    }
                    Toast.makeText(
                            getActivity(),
                            "กรุณาระบุข้อมูลให้ครบถ้วน",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    if (_userIdStr.equals("admin")) {
                        Toast.makeText(
                                getActivity(),
                                "user นี้มีอยู่ในระบบแล้ว",
                                Toast.LENGTH_SHORT
                        ).show();
                        Log.d("USER", "USER ALREADY EXIST");
                    }
                    else {
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_view, new BMIfragment())
                                .addToBackStack(null)
                                .commit();
                        Log.d("USER", "GOTO BMI”");
                    }
                }
            }
        });
    }
}
