package com.zukron.loginapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.zukron.loginapp.R;
import com.zukron.loginapp.tools.Utility;
import com.zukron.loginapp.ui.viewmodel.MainViewModel;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "DashboardFragment";
    public static final String USERNAME = "bundle_username";
    public static final String PASSWORD = "bundle_password";
    private MainViewModel mainViewModel;
    private TextView tvFullName, tvEmail, tvUsername;
    private MaterialButton btnLogout;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // view model
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // init text view and button
        tvEmail = view.findViewById(R.id.dashboardFrag_tvEmail);
        tvFullName = view.findViewById(R.id.dashboardFrag_tvFullName);
        tvUsername = view.findViewById(R.id.dashboardFrag_tvUsername);
        btnLogout = view.findViewById(R.id.dashboardFrag_btnLogout);
        btnLogout.setOnClickListener(this);

        // get user
        if (getArguments() != null) {
            String username = getArguments().getString(USERNAME, null);
            String password = getArguments().getString(PASSWORD, null);

            if (username != null && password != null) {
                mainViewModel.getByHashPassword(username, password).observe(requireActivity(), user -> {
                    tvFullName.setText(user.getFullName());
                    tvUsername.setText(user.getUsername());
                    tvEmail.setText(user.getEmail());
                });
            }
        }
    }

    @Override
    public void onClick(View view) {
        Utility.clearUserSession(requireContext());

        Navigation.findNavController(requireView()).navigate(R.id.action_dashboardFragment_to_loginFragment);
    }
}