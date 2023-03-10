package com.example.netwoevents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter <MyCustomRecyclerViewAdapter.ViewHolder>{
        private final LayoutInflater inflater;
        private final List<Item> items;
        MyCustomRecyclerViewAdapter(Context context, List<Item> items) {
            this.items = items;
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public MyCustomRecyclerViewAdapter.ViewHolder
        onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.list_view_layout, parent, false);
            return new ViewHolder(view);
        }
        @Override
        public void
        onBindViewHolder(MyCustomRecyclerViewAdapter.ViewHolder
                                 holder, int position) {
            Item item = items.get(position);
            holder.textView.setText(item.getText());
            holder.imageView.setImageResource(item.getImage());
        }
        @Override
        public int getItemCount() {
            return items.size();
        }
        public static class ViewHolder extends
                RecyclerView.ViewHolder {
            final TextView textView;
            final ImageView imageView;
            ViewHolder(View view){
                super(view);
                textView = view.findViewById(R.id.item_text);
                imageView = view.findViewById(R.id.item_image);
            }
        }
}


