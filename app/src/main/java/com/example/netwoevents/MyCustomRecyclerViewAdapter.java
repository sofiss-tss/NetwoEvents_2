package com.example.netwoevents;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter <MyCustomRecyclerViewAdapter.ViewHolder>{
        private final LayoutInflater inflater;
        private final List<Item> items;
        public static Context context;
        private static final String TAG = "List_2";

        MyCustomRecyclerViewAdapter(Context context, List<Item> items) {
            this.items = items;
            this.inflater = LayoutInflater.from(context);
            this.context = context;
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

                
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String value = (String) textView .getText();
                        Toast.makeText(context, value +"!",
                                Toast.LENGTH_SHORT).show();
                        Log.i(TAG, value);

                    }
                });
            }
        }


}


