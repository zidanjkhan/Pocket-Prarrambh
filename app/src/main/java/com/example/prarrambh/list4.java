package com.example.prarrambh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.prarrambh.databinding.ActivityList4Binding;
import com.example.prarrambh.databinding.Listadap1Binding;
import java.util.ArrayList;

public class list4 extends AppCompatActivity {


    String list1s[] = {"Wazir-E-Aazam","Battle for Queen","Mind Hiss","Ek Pal Ki Jeet","Unlock the Mystery","Three Legged Race","Ball in the Box","Football","HU-TU-TU","Volley Ball","100 Meter Race","Standing Jump","Dawat-E-Ishq","Sack Race","Counter Strike","Kho-Kho","Tug of War","PUBG/Free Fire"};
    String list2s[] = {"(Chess)","(Carrom)","(Snakes & Ladders)","(Minute to Win It)","(Treasure Hunt)","","(Box Cricket)","[Only Boys]","[Only Boys]","[Only Boys]","[Only Boys]","","(Dare to Eat)","","","[Only Boys]","[Atleast One Girl]","[SOLO]"};
    String list3s[] = {"30","30","50","40","100","30","600","500","300","200","30","30","50","30","50","300","100","50"};
    int list4s[] = {R.drawable.l41,R.drawable.l42,R.drawable.l43,R.drawable.l44,R.drawable.l45,R.drawable.l46,R.drawable.l47,R.drawable.l48,R.drawable.l49,R.drawable.l410,R.drawable.l411,R.drawable.l412,R.drawable.l413,R.drawable.l414,R.drawable.l415,R.drawable.l416,R.drawable.l417,R.drawable.l418};
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list4);
        listview = findViewById(R.id.listview4);

        ArrayList<eventData1> arrayList = new ArrayList<>();
        arrayList.add(new eventData1("Wazir-E-Aazam", "30", "(Chess)",R.drawable.l41));
        arrayList.add(new eventData1("Battle for Queen", "30", "(Carrom)",R.drawable.l42));
        arrayList.add(new eventData1("Mind Hiss", "50", "(Snake & Ladders)",R.drawable.l43));
        arrayList.add(new eventData1("Ek Pal Ki Jeet", "40", "(Minute to Win It)",R.drawable.l44));
        arrayList.add(new eventData1("Unlock the Mystery", "100", "(Treasure Hunt)",R.drawable.l45));
        arrayList.add(new eventData1("Three Legged Race", "30", "",R.drawable.l46));
        arrayList.add(new eventData1("Ball in the Box", "600", "(Box Cricket)",R.drawable.l47));
        arrayList.add(new eventData1("Football", "500", "[Only Boys]",R.drawable.l48));
        arrayList.add(new eventData1("HU-TU-TU", "300", "[Only Boys]",R.drawable.l49));
        arrayList.add(new eventData1("Volley Ball", "200", "[Only Boys]",R.drawable.l410));
        arrayList.add(new eventData1("100 Meter Race", "30", "[Only Boys]",R.drawable.l411));
        arrayList.add(new eventData1("Standing Jump", "30", "",R.drawable.l412));
        arrayList.add(new eventData1("Dawat-E-Ishq", "50", "(Dare To Eat)",R.drawable.l413));
        arrayList.add(new eventData1("Sack Race", "30", "",R.drawable.l414));
        arrayList.add(new eventData1("Counter Strike", "50", "",R.drawable.l415));
        arrayList.add(new eventData1("Kho-Kho", "300", "[Only Boys]",R.drawable.l416));
        arrayList.add(new eventData1("Tug Of War", "100", "[Atleast One Girl]",R.drawable.l417));
        arrayList.add(new eventData1("PUBG/Free fire", "50", "[Solo]",R.drawable.l418));

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