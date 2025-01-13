package com.example.realtimefirebasedatabaselab;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.realtimefirebasedatabaselab.databinding.ActivityLoginBinding;
import com.example.realtimefirebasedatabaselab.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initlization();
    }
    void initlization(){
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnGet.setOnClickListener(v->{
            LoginToFirebaseRealtime();
        });
    }
    void LoginToFirebaseRealtime() {
        String email = binding.tvEmail.getText().toString();
        String pass = binding.tvPass.getText().toString();
        if (email.isEmpty() || pass.isEmpty()) {
            Snackbar.make(binding.getRoot(), "Please enter all fields", Snackbar.LENGTH_SHORT).show();
            return;
        }
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference rf = db.getReference("Users");
        rf.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean found = false;
                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    user minni = userSnapshot.getValue(user.class);
                    if (minni != null && minni.getEmail().equals(email) && minni.getPass().equals(pass)) {
                        found = true;
                        Snackbar.make(binding.getRoot(), "Login successful! Welcome " + minni.getName(), Snackbar.LENGTH_SHORT).show();
                        binding.tvName.setText(minni.getName());
                        binding.tvAge.setText(minni.getAge());
                        binding.tvPhone.setText(minni.getPhone());
                        break;
                    }
                }
                if (!found) {
                    Snackbar.make(binding.getRoot(), "Invalid email or password", Snackbar.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Snackbar.make(binding.getRoot(), "Error: " + error.getMessage(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}