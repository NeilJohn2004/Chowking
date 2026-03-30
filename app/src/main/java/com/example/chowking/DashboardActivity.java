package com.example.chowking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TextView roleDisplay = findViewById(R.id.role_display);
        Button btnPunch = findViewById(R.id.btn_punch_in_out);
        Button btnSchedule = findViewById(R.id.btn_schedule);
        Button btnLogout = findViewById(R.id.btn_logout);

        String role = getIntent().getStringExtra("ROLE");
        if (role != null) {
            roleDisplay.setText("Role: " + role);
        }

        btnPunch.setOnClickListener(v -> Toast.makeText(DashboardActivity.this, "Scanning...", Toast.LENGTH_SHORT).show());

        btnSchedule.setOnClickListener(v -> Toast.makeText(DashboardActivity.this, "Opening Schedule...", Toast.LENGTH_SHORT).show());

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, LandingActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}