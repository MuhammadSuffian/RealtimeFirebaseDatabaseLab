package com.example.realtimefirebasedatabaselab;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.realtimefirebasedatabaselab.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

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
                binding.tvEmail.requestFocus();
            }
           else if(binding.tvPass.getText().toString().isEmpty()){
                binding.tvPass.setError("Enter Password");
                binding.tvPass.requestFocus();
            }
            else if(binding.tvAge.getText().toString().isEmpty()){
                binding.tvAge.setError("Enter age");
                binding.tvAge.requestFocus();
            }
            else if(binding.tvPhone.getText().toString().isEmpty()){
                binding.tvPhone.setError("Enter Phone Number");
                binding.tvPhone.requestFocus();
            }
            else{
                AddDataToFireBaseRealtime();
            }
        });
    }
    void AddDataToFireBaseRealtime(){
        String name=binding.tvName.getText().toString();
        String email=binding.tvEmail.getText().toString();
        String pass=binding.tvPass.getText().toString();
        String age=binding.tvAge.getText().toString();
        String phone=binding.tvPhone.getText().toString();
        Map<String,Object> user=new HashMap<>();
        user.put("name",name);
        user.put("email",email);
        user.put("pass",pass);
        user.put("age",age);
        user.put("phone",phone);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference rf=db.getReference("Users");
        rf.push().setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            binding.tvName.setText("");
                            binding.tvEmail.setText("");
                            binding.tvPass.setText("");
                            binding.tvAge.setText("");
                            Snackbar.make(binding.getRoot(),"Mubarak! Your are logined",Snackbar.LENGTH_SHORT).show();
                        }
                        else{
                            Snackbar.make(binding.getRoot(),"Something went wrong",Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}