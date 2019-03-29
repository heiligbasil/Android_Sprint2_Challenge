package com.lambdaschool.sprint2_challenge;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewGroup parentLayout;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.constraint_layout_parent);
            imageView = itemView.findViewById(R.id.image_view_icon);
            textView = itemView.findViewById(R.id.text_view_name);
        }
    }

    private ArrayList<ShoppingItem> itemList;
    private Context context;

    public ShoppingListAdapter(ArrayList<ShoppingItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.shopping_list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ShoppingItem item = itemList.get(i);
        viewHolder.imageView.setImageResource(item.getShoppingItemResource());
        viewHolder.textView.setText(item.getShoppingItemName());
/*        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            viewHolder.parentLayout.setBackgroundColor(context.getColor(R.color.colorPrimary));
        else
            viewHolder.parentLayout.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));*/
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}