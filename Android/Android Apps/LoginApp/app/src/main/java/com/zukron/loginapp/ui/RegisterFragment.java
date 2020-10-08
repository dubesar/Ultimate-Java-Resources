package com.zukron.loginapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.zukron.loginapp.R;
import com.zukron.loginapp.model.User;
import com.zukron.loginapp.ui.viewmodel.MainViewModel;

import org.threeten.bp.LocalDate;

import java.util.Objects;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private TextInputLayout inputFullName, inputUsername, inputEmail, inputPassword, inputConfirmPassword;
    private MaterialButton btnEnter, btnLogin;
    private MainViewModel mainViewModel;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // view model
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        inputFullName = view.findViewById(R.id.registerFrag_inputFullName);
        inputUsername = view.findViewById(R.id.registerFrag_inputUsername);
        inputEmail = view.findViewById(R.id.registerFrag_inputEmail);
        inputPassword = view.findViewById(R.id.registerFrag_inputPassword);
        inputConfirmPassword = view.findViewById(R.id.registerFrag_inputConfirmPassword);
        btnEnter = view.findViewById(R.id.registerFrag_btnEnter);
        btnLogin = view.findViewById(R.id.registerFrag_btnLoginHere);

        // button listener
        btnEnter.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerFrag_btnEnter: {
                if (validate()) {
                    String fullName = Objects.requireNonNull(inputFullName.getEditText()).getText().toString().trim();
                    String username = Objects.requireNonNull(inputUsername.getEditText()).getText().toString().trim();
                    String email = Objects.requireNonNull(inputEmail.getEditText()).getText().toString().trim();
                    String password = Objects.requireNonNull(inputPassword.getEditText()).getText().toString().trim();

                    AndroidThreeTen.init(requireContext());
                    User user = new User(
                            username, fullName, email, password, LocalDate.now().toString()
                    );
                    mainViewModel.insert(user).observe(requireActivity(), aBoolean -> {
                        if (aBoolean) {
                            Toast.makeText(requireContext(), "Success register", Toast.LENGTH_SHORT).show();
                            Navigation.findNavController(requireView()).navigate(R.id.action_registerFragment_to_loginFragment);
                        }
                    });
                }
                break;
            }
            case R.id.registerFrag_btnLoginHere: {
                Navigation.findNavController(requireView()).navigate(R.id.action_registerFragment_to_loginFragment);
                break;
            }
        }
    }

    private boolean validate() {
        boolean valid = true;

        if (TextUtils.isEmpty(Objects.requireNonNull(inputFullName.getEditText()).getText())) {
            valid = false;
            inputFullName.setError("Required field");
        }

        if (TextUtils.isEmpty(Objects.requireNonNull(inputUsername.getEditText()).getText())) {
            valid = false;
            inputUsername.setError("Required field");
        }

        if (TextUtils.isEmpty(Objects.requireNonNull(inputEmail.getEditText()).getText())) {
            valid = false;
            inputEmail.setError("Required field");
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.getEditText().getText()).matches()) {
                valid = false;
                inputEmail.setError("Wrong format");
            }
        }

        if (TextUtils.isEmpty(Objects.requireNonNull(inputPassword.getEditText()).getText())) {
            valid = false;
            inputPassword.setError("Required field");
        }

        if (TextUtils.isEmpty(Objects.requireNonNull(inputConfirmPassword.getEditText()).getText())) {
            valid = false;
            inputConfirmPassword.setError("Required field");
        } else {
            String password = inputPassword.getEditText().getText().toString().trim();
            String confirmPassword = inputConfirmPassword.getEditText().getText().toString().trim();

            if (!password.equals(confirmPassword)) {
                valid = false;
                inputPassword.setError("Must be same");
                inputConfirmPassword.setError("Must be same");
            }
        }

        return valid;
    }
}