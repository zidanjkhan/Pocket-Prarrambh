package com.example.prarrambh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.prarrambh.databinding.ActivityList3Binding;
import com.example.prarrambh.databinding.Listadap1Binding;

import java.util.ArrayList;

public class list3 extends AppCompatActivity {

    String list1s[] = {"Aja Nachle!", "Show Your Glamour","Just Dance","Nukkad Natak","Gully Boy","Prarrambh Idol", "Standup Comedy","Mono Acting"};
    String list2s[] = {"(Group Dance)","(Fashion Show)","(Solo/Duet Dance)","(Street Play)","(Rapping)","(Singing)","",""};
    String list3s[] = {"500", "500","100", "100", "100","30", "50", "50"};
    int list4s[] = {R.drawable.l31,R.drawable.l32,R.drawable.l33,R.drawable.l34,R.drawable.l35,R.drawable.l36,R.drawable.l37,R.drawable.l38};
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);
        listview = findViewById(R.id.list3);

        ArrayList<eventData1> arrayList = new ArrayList<>();
        arrayList.add(new eventData1("Aja Nachle!", "30", "(Group Dance)",R.drawable.l31));
        arrayList.add(new eventData1("Show Your Glamour", "40", "(Fashion Show)",R.drawable.l32));
        arrayList.add(new eventData1("Just Dance", "100", "(Solo/Duet Dance)",R.drawable.l33));
        arrayList.add(new eventData1("Nukkad Natak", "30", "(Street Play)",R.drawable.l34));
        arrayList.add(new eventData1("Gully boy", "30", "(Rapping)",R.drawable.l35));
        arrayList.add(new eventData1("Prarrabh Idol", "30", "(Singing)",R.drawable.l36));
        arrayList.add(new eventData1("Standup Comedy", "30", "",R.drawable.l37));
        arrayList.add(new eventData1("Mono Acting", "30", "",R.drawable.l38));

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