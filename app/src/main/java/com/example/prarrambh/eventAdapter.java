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

public class eventAdapter extends ArrayAdapter<eventData1> {
    private Context mContext;
    private int mResource;
    public eventAdapter(@NonNull Context context, int resource, @NonNull ArrayList<eventData1> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource= resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView txt = convertView.findViewById(R.id.txt);
        TextView txt1 = convertView.findViewById(R.id.txt1);
        TextView txt2 = convertView.findViewById(R.id.txt2);
        ImageView img = convertView.findViewById(R.id.img);

        txt.setText(getItem(position).getPrn());
        txt1.setText(getItem(position).getPrrs());
        txt2.setText(getItem(position).getSubprn());
        img.setImageResource(getItem(position).getImg());

        return convertView;
    }
}
