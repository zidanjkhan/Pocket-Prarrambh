package com.example.prarrambh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.prarrambh.databinding.ActivityList2Binding;
import com.example.prarrambh.databinding.ActivityList4Binding;

import java.util.ArrayList;

public class list2 extends AppCompatActivity {


    String list1s[] = {"Nail ki Kala","Hair Beauty","Glamour Bride","Magical Faces","Trash can Novelties","Khushrang Heena","Go Fireless!","Rang-De-Zameen", "Let's Lit up!", "Paint Your Shirt","Canvas For Change","Click-a-Flick!","Artistic Greetings"};
    String list2s[] = {"(Nail Art)","(Hair dress up)","(Bridal Makeup)","(Face Painting)","(Best out of waste)","(Mehendi)","(Cooking With Fire)","(Rangoli)","(Diya Decoration)","(T-Shirt Painting)","(Poster Making)","(Photography)","()"};
    String list3s[] = {"30", "40","100", "30", "30","30", "30", "30", "30","30","30","50","30"};
    int list4s[] = {R.drawable.l21,R.drawable.l22,R.drawable.l23,R.drawable.l24,R.drawable.l25,R.drawable.l26,R.drawable.l27,R.drawable.l28,R.drawable.l29,R.drawable.l210,R.drawable.l211,R.drawable.l212,R.drawable.l213};
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        listview = findViewById(R.id.list2v);

        ArrayList<eventData1> arrayList = new ArrayList<>();
        arrayList.add(new eventData1("Nail ki Kala", "30", "(Nail Art)",R.drawable.l21));
        arrayList.add(new eventData1("Hair Beauty", "40", "(Hair dress up)",R.drawable.l22));
        arrayList.add(new eventData1("Glamour Bride", "100", "(Bridal Makeup)",R.drawable.l23));
        arrayList.add(new eventData1("Magical Faces", "30", "(Face Painting)",R.drawable.l24));
        arrayList.add(new eventData1("Trash can Novelties", "30", "(Best out of waste)",R.drawable.l25));
        arrayList.add(new eventData1("Khushrang Heena", "30", "(Mehendi)",R.drawable.l26));
        arrayList.add(new eventData1("Go Fireless!", "30", "(Cooking With Fire)",R.drawable.l27));
        arrayList.add(new eventData1("Rang-De-Zameen", "30", "(Rangoli)",R.drawable.l28));
        arrayList.add(new eventData1("Let's Lit up!", "30", "(Diya Decoration)",R.drawable.l29));
        arrayList.add(new eventData1("Paint Your Shirt", "30", "(T-Shirt Painting)",R.drawable.l210));
        arrayList.add(new eventData1("Canvas For Change", "30", "(Poster Making)",R.drawable.l211));
        arrayList.add(new eventData1("Click-a-Flick!", "50", "(Photography)",R.drawable.l212));
        arrayList.add(new eventData1("Artistic Greetings", "30", "",R.drawable.l213));

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