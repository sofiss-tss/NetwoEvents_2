package com.example.netwoevents;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {
    ImageView itemImage;
    TextView names;

    public ProgramViewHolder(View v) {
        itemImage = v.findViewById(R.id.item_image);
        names = v.findViewById(R.id.item_text);

    }

}
