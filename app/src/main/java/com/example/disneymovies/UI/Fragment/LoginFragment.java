package com.example.disneymovies.UI.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.disneymovies.R;
import com.example.disneymovies.UI.HomeActivity;

import java.util.Objects;

public class LoginFragment extends Fragment {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        userNameEditText = view.findViewById(R.id.userName);
        passwordEditText = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndLogin();
            }
        });

        return view;
    }

    private void validateAndLogin() {
        String userName = userNameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            userNameEditText.setError("User Name is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return;
        }

        Toast.makeText(getActivity(), "Logging in...", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getActivity(), HomeActivity.class);
        userName = Objects.requireNonNull(userNameEditText.getText()).toString();
        intent.putExtra("UserName",userName);
        startActivity(intent);
    }
}
