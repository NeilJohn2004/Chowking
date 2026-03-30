package com.example.chowking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        Button btnManager = findViewById(R.id.btn_manager);
        Button btnTeamLeader = findViewById(R.id.btn_team_leader);
        Button btnCrew = findViewById(R.id.btn_crew);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String role = "";
                int id = v.getId();
                if (id == R.id.btn_manager) {
                    role = "Manager";
                } else if (id == R.id.btn_team_leader) {
                    role = "Team Leader";
                } else if (id == R.id.btn_crew) {
                    role = "Crew";
                }

                Intent intent = new Intent(LandingActivity.this, MainActivity.class);
                intent.putExtra("ROLE", role);
                startActivity(intent);
            }
        };

        btnManager.setOnClickListener(listener);
        btnTeamLeader.setOnClickListener(listener);
        btnCrew.setOnClickListener(listener);
    }
}