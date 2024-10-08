package com.example.prarrambh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class list1 extends AppCompatActivity {


    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);
        listview = findViewById(R.id.list1v);
        String list1s[] = {"Bollywood Ka Boss","Manthan Vicharan Ka","Spill the Ink","Kalam ke Swar","Buddy Meter","Logos","Typing Master","Zabane Baya", "Business Wits", "Act od Speaking"};
        String list2s[] = {"(Bollywood Quiz)","(Debate)","(Essay Writing)","(Poetry Writing)","(Friend-O-Meter)","(Memory Game)","(Typing Speed)","(Sher-O-Shayri)","(Business Quiz)","(Elocution)"};
        String list3s[] = {"30", "30","30", "30", "40","30", "40", "30", "30","30"};
        int list4s[] = {R.drawable.l11,R.drawable.l12,R.drawable.l13,R.drawable.l14,R.drawable.l15,R.drawable.l16,R.drawable.l17,R.drawable.l18,R.drawable.l19,R.drawable.l110};

        ArrayList<eventData1> arrayList = new ArrayList<>();
        arrayList.add(new eventData1("Bollywood ka Boss", "30", "(Bollywood Quiz)",R.drawable.l11));
        arrayList.add(new eventData1("Manthan Vicharan Ka", "30", "(Debate)",R.drawable.l12));
        arrayList.add(new eventData1("Spill the Ink", "30", "(Essay Writing)",R.drawable.l13));
        arrayList.add(new eventData1("Kalam ke Swar", "30", "(Poetry Writing)",R.drawable.l14));
        arrayList.add(new eventData1("Buddy Meter", "40", "(Friend-O-Meter)",R.drawable.l15));
        arrayList.add(new eventData1("Logos", "30", "(Memory Game)",R.drawable.l16));
        arrayList.add(new eventData1("Typing Master", "40", "(Typing Speed)",R.drawable.l17));
        arrayList.add(new eventData1("Zabane Baya", "30", "(Sher-O-Shayri)",R.drawable.l18));
        arrayList.add(new eventData1("Business Wits", "30", "(Business Quiz)",R.drawable.l19));
        arrayList.add(new eventData1("Act od Speaking", "30", "(Elocution)",R.drawable.l110));

        eventAdapter eventAdapter = new eventAdapter(this,R.layout.listadap1,arrayList);
        listview.setAdapter(eventAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), takePart.class);
                intent.putExtra("name",list1s[i]);
                intent.putExtra("price",list3s[i]);
                intent.putExtra("img",list4s[i]);
                startActivity(intent);
                listview.setSelector(R.color.black);
            }
        });



}}