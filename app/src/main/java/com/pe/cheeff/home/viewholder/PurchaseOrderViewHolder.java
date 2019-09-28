package com.pe.cheeff.home.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pe.cheeff.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class PurchaseOrderViewHolder extends GroupViewHolder {
    public TextView customerTextView;
    public TextView priceTextView;
    public ImageView arrowImageView;

    public PurchaseOrderViewHolder(View itemView) {
        super(itemView);
        customerTextView = itemView.findViewById(R.id.customer_text_view);
        priceTextView = itemView.findViewById(R.id.price_text_view);
        arrowImageView = itemView.findViewById(R.id.arrow_image_view);
    }

    @Override
    public void expand() {
        super.expand();
        arrowImageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
    }

    @Override
    public void collapse() {
        super.collapse();
        arrowImageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
    }

    public void setGroupName(ExpandableGroup groupName) {
        String[] string = groupName.getTitle().split("-");
        String nombres = string[0];
        String precio = string[1];
        String fechaRegistro = string[2];
        customerTextView.setText(nombres);
        priceTextView.setText("S/. "+precio);
    }
}
