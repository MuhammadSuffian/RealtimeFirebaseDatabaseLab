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
        DatabaseReference rf= FirebaseDatabase.getInstance().getReference("users");
        binding.btnGet.setOnClickListener(v->{
            String username=binding.tvEmail.getText().toString().trim();
            Query check=rf.orderByChild("username").equalTo(username);
            check.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String password=snapshot.child(username).child("password").getValue(String.class);
                        Toast.makeText(login.this, "password"+password,Toast.LENGTH_SHORT).show();
                        if(password.equals(password)){
                            Toast.makeText(login.this, "Logineeedd",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(login.this,"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });
    }
}