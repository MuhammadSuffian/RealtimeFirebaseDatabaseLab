package com.example.realtimefirebasedatabaselab;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.realtimefirebasedatabaselab.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initlization();
    }
    void initlization(){
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Logic();
    }
    void Logic(){
        binding.btnSubmit.setOnClickListener(v->{
            if(binding.tvName.getText().toString().isEmpty()){
                binding.tvName.setError("Enter Name");
                binding.tvName.requestFocus();
            }
            else if(binding.tvEmail.getText().toString().isEmpty()){
                binding.tvEmail.setError("Enter Email");
                binding.tvName.requestFocus();
            }
           else if(binding.tvPass.getText().toString().isEmpty()){
                binding.tvName.setError("Enter Password");
                binding.tvName.requestFocus();
            }
            else if(binding.tvAge.getText().toString().isEmpty()){
                binding.tvEmail.setError("Enter age");
                binding.tvName.requestFocus();
            }
            else{

            }

        });
    }
}