package com.zukron.loginapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.zukron.loginapp.R;
import com.zukron.loginapp.model.User;
import com.zukron.loginapp.tools.Utility;
import com.zukron.loginapp.ui.viewmodel.MainViewModel;

import java.util.Objects;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "LoginFragment";
    private MainViewModel mainViewModel;
    private TextInputLayout inputUsername, inputPassword;
    private MaterialButton btnEnter, btnRegister;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // view model
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        inputUsername = view.findViewById(R.id.loginFrag_inputUsername);
        inputPassword = view.findViewById(R.id.loginFrag_inputPassword);
        btnEnter = view.findViewById(R.id.loginFrag_btnEnter);
        btnRegister = view.findViewById(R.id.loginFrag_btnRegisterHere);

        // button listener
        btnEnter.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        // check session
        User user = Utility.getUserSession(requireContext());
        if (user != null) {
            Bundle bundle = new Bundle();
            bundle.putString(DashboardFragment.USERNAME, user.getUsername());
            bundle.putString(DashboardFragment.PASSWORD, user.getPassword());

            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_dashboardFragment, bundle);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginFrag_btnEnter: {
                if (validate()) {
                    String username = Objects.requireNonNull(inputUsername.getEditText()).getText().toString().trim();
                    String password = Objects.requireNonNull(inputPassword.getEditText()).getText().toString().trim();

                    mainViewModel.get(username, password).observe(requireActivity(), user -> {
                        if (user == null) {
                            Toast.makeText(requireContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show();

                            // set session
                            Utility.setUserSession(requireContext(), user.getUsername(), user.getPassword());
                            Bundle bundle = new Bundle();
                            bundle.putString(DashboardFragment.USERNAME, user.getUsername());
                            bundle.putString(DashboardFragment.PASSWORD, user.getPassword());

                            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_dashboardFragment, bundle);
                        }
                    });
                }
                break;
            }
            case R.id.loginFrag_btnRegisterHere: {
                Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_registerFragment);
                break;
            }
        }
    }

    private boolean validate() {
        boolean valid = true;

        if (TextUtils.isEmpty(Objects.requireNonNull(inputUsername.getEditText()).getText())) {
            inputUsername.setError("Required field");
            valid = false;
        }

        if (TextUtils.isEmpty(Objects.requireNonNull(inputPassword.getEditText()).getText())) {
            inputPassword.setError("Required field");
            valid = false;
        }

        return valid;
    }
}