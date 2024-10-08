package com.example.prarrambh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class listadap1 extends ArrayAdapter<eventData1> {
    public listadap1(Context context, ArrayList<eventData1> eventData1ArrayList){
        super(context,R.layout.listadap1,eventData1ArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        eventData1 event = getItem(position);
        if (view==null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.listadap1,parent,false);
        }
        TextView txt = view.findViewById(R.id.txt);
        TextView txt1 = view.findViewById(R.id.txt1);
        TextView txt2 = view.findViewById(R.id.txt2);
        ImageView img = view.findViewById(R.id.img);

        txt.setText(event.getPrn());
        txt1.setText(event.getSubprn());
        txt2.setText(event.getPrrs());
        img.setImageResource(event.getImg());

        return super.getView(position, view, parent);
    }
}
