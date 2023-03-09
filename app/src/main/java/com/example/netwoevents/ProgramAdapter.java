package com.example.netwoevents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ProgramAdapter extends ArrayAdapter<String> {

    Context context;
    int images[];
    String[] names;
    public ProgramAdapter (Context context, String [] names, int[] images){
        super(context,R.layout.list_view_layout, R.id.item_text,names);
        this.context = context;
        this.images = images;
        this.names = names;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View singleItem = convertView;
        ProgramViewHolder holder = null;
        if (singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.list_view_layout, parent, false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }
        else{
            holder = (ProgramViewHolder) singleItem.getTag();
        }
        holder.itemImage.setImageResource(images[position]);
        holder.names.setText(names[position]);
        return super.getView(position, convertView, parent);
    }
}
