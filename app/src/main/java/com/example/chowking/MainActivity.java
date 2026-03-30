package com.example.chowking;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput;
    private Button loginButton;
    private TextView signupText, showPasswordText, subtitleText;
    private boolean isPasswordVisible = false;
    private String selectedRole = "Crew";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        emailInput = findViewById(R.id.mobile_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        signupText = findViewById(R.id.signup_text);
        showPasswordText = findViewById(R.id.show_password);
        subtitleText = findViewById(R.id.subtitle_text);

        // Display selected role
        selectedRole = getIntent().getStringExtra("ROLE");
        if (selectedRole != null) {
            subtitleText.setText("Login as " + selectedRole);
        } else {
            selectedRole = "Crew";
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to SignupActivity
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        showPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Hide password
            passwordInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
            showPasswordText.setText("Show");
            isPasswordVisible = false;
        } else {
            // Show password
            passwordInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            showPasswordText.setText("Hide");
            isPasswordVisible = true;
        }
        // Move cursor to the end
        passwordInput.setSelection(passwordInput.getText().length());
    }

    private void performLogin() {
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password is required");
            return;
        }

        // Hardcoded login logic
        if ((email.equals("user@example.com") && password.equals("password123")) ||
            (email.equals("ExampleCrew@test") && password.equals("qwerty123"))) {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
            
            // Navigate to DashboardActivity
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            intent.putExtra("ROLE", selectedRole);
            startActivity(intent);
            finish(); // Close login activity
        } else {
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }
    }
}