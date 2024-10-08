package com.example.prarrambh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.prarrambh.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        videoView = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.intr));
        videoView.start();
        videoView.start();
        videoView.start();

        binding.signupPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Signup.class));
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.sUsername.getText().toString();
                String password = binding.sPassword.getText().toString();
                login(email,password);
            }
        });


    }

    private void login(String email, String password) {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("In Process");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email.trim(), password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        progressDialog.cancel();
                        Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this,MainActivity.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.cancel();
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            startActivity(new Intent(Login.this,MainActivity.class));
        }
    }
}