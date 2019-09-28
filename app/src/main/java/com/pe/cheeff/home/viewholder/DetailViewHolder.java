package com.pe.cheeff.home.viewholder;

import android.view.View;
import android.widget.TextView;

import com.pe.cheeff.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class DetailViewHolder extends ChildViewHolder {
    public TextView textView;

    public DetailViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.tv_child_item);
    }

    public void setChildText(String name){
        textView.setText(name);
    }
}
