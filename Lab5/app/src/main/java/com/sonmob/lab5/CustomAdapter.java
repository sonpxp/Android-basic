package com.sonmob.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Product> {
    private Context context;
    private int resource;
    private List<Product> objects;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        //thiet lap view
        if (convertView == null) { //truong hop chua co view ,thiet lap view
            convertView = inflater.inflate(R.layout.item_listview, null);
            holder.tvImage = convertView.findViewById(R.id.tvImage);
            holder.tvName = convertView.findViewById(R.id.tvName);
            holder.tvPrice = convertView.findViewById(R.id.tvPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //khoi tao gia tri cho view
        Product product = objects.get(position);
        holder.tvImage.setText(product.getId());
        //set color
        holder.tvImage.setBackgroundColor(product.getImage());
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText(String.valueOf(product.getPrice()));
        return convertView;
    }

    // dinh nghia view holder
    public class ViewHolder {
        TextView tvImage, tvName, tvPrice;
    }

}
