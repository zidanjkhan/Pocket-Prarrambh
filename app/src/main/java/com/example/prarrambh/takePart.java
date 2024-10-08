package com.example.prarrambh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prarrambh.databinding.ActivityTakePartBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.UUID;

public class takePart extends AppCompatActivity {
    TextView name,price;
    ImageView img;
    Button PayBtn;
    private String id, prname, uname, ucontact, ucollege, rupees;
ActivityTakePartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
        int GOOGLE_PAY_REQUEST_CODE = 123;

        super.onCreate(savedInstanceState);
        binding = ActivityTakePartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        name = findViewById(R.id.prn1);
        price = findViewById(R.id.prr1);
        img = findViewById(R.id.imageView3);

        name.setText(getIntent().getExtras().getString("name"));
        price.setText(getIntent().getExtras().getString("price"));
        img.setImageResource(getIntent().getExtras().getInt("img",R.drawable.l48));


        binding.paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prname = binding.prn1.getText().toString();
                uname = binding.uname.getText().toString();
                ucollege = binding.ucollege.getText().toString();
                ucontact = binding.ucontact.getText().toString();
                rupees = binding.prr1.getText().toString();
                addData();
                Toast.makeText(takePart.this, "Data Stored", Toast.LENGTH_SHORT).show();
                Uri uri =
                        new Uri.Builder()
                                .scheme("upi")
                                .authority("pay")
                                .appendQueryParameter("pa", "khanzidansam@okhdfcbank")
                                .appendQueryParameter("pn", "Zidan")
//                                .appendQueryParameter("mc", "1234")
//                                .appendQueryParameter("tr", "")
                                .appendQueryParameter("tn", "test transaction note")
                                .appendQueryParameter("am", rupees)
                                .appendQueryParameter("cu", "INR")
//                                .appendQueryParameter("url", "https://test.merchant.website")
                                .build();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setPackage(GOOGLE_PAY_PACKAGE_NAME);
                startActivityForResult(intent, GOOGLE_PAY_REQUEST_CODE);
            }
        });
    }
    private void addData() {
        id= UUID.randomUUID().toString();
        eventData1 eventData1=new eventData1(prname,uname,ucontact,ucollege,rupees,id,true);
        FirebaseFirestore.getInstance()
                .collection("Entry")
                .document(id)
                .set(eventData1);
    }

}