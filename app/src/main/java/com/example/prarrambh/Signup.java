package com.example.prarrambh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prarrambh.databinding.SignupBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;

public class Signup extends AppCompatActivity {
    TextView login;
    SignupBinding binding;
    String id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this, Login.class));
            }
        });

        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.sName.getText().toString();
                String college = binding.sClg.getText().toString();
                String contact = binding.sContact.getText().toString();
                String email = binding.sUsername.getText().toString();
                String password = binding.sPassword.getText().toString();
                addData(name,college,contact,email,password);
                createAccount(name,college,contact,email,password);
                startActivity(new Intent(Signup.this, Login.class));
            }
        });

    }

    private void addData(String name, String college,String contact,String email,String password) {
        id= UUID.randomUUID().toString();
        users users=new users(name,college,contact,email,password);
        FirebaseFirestore.getInstance()
                .collection("Users")
                .document(id)
                .set(users);
    }
    private void createAccount(String name, String college,String contact, String email, String password) {
        FirebaseAuth fAuth=FirebaseAuth.getInstance();
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Creating");
        progressDialog.setMessage("Account");
        progressDialog.show();
        fAuth.createUserWithEmailAndPassword(email.trim(),password.trim())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        UserProfileChangeRequest profileChangeRequest=new UserProfileChangeRequest.Builder()
                                .setDisplayName(name).build();
                        FirebaseAuth.getInstance().getCurrentUser().updateProfile(profileChangeRequest);
                        progressDialog.cancel();
                        Toast.makeText(Signup.this, "Account Created", Toast.LENGTH_SHORT).show();
                        binding.sName.setText("");
                        binding.sClg.setText("");
                        binding.sContact.setText("");
                        binding.sUsername.setText("");
                        binding.sPassword.setText("");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.cancel();
                        Toast.makeText(Signup.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}