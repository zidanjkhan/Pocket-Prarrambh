package com.example.prarrambh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listAdap extends BaseAdapter {
    Context context;
    String arr[];
    int img2[];
    LayoutInflater inflator;
    public listAdap(Context ctx, String []arr,int[]img2){
        this.context = ctx;
        this.arr=arr;
        this.img2=img2;
        inflator = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        convertView = inflator.inflate(R.layout.listadap,null);
        TextView txtview= (TextView) convertView.findViewById(R.id.listAd);
        ImageView imgview1 = (ImageView) convertView.findViewById(R.id.imageView1);
        txtview.setText(arr[i]);
        imgview1.setImageResource(img2[i]);
        return convertView;
    }
}

//    public listAdap(@NonNull Context context, int resource, @NonNull String[] arr, int[] img, int[] img2) {
//        super(context, resource, arr, img, img2);
//        this.arr = arr;
//        this.img = img;
//        this.img2 = img2;
//    }
//
//    @Nullable
//    @Override
//    public Object getItem(int position) {
//        return arr[position];
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        convertView = LayoutInflater.from(getContext()).inflate(R.layout.listadap, parent, false);
//        TextView t = convertView.findViewById(R.id.listAd);
//        ImageView img = convertView.findViewById(R.id.imageView);
//        ImageView img2 = convertView.findViewById(R.id.imageView1);
//        t.setText(getItem(position).toString());
//        return convertView;
//    }
//}
