package com.example.lab_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private List<Item> items = new ArrayList();

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.header.setText(currentItem.getHeader());
        holder.description.setText(currentItem.getDescription());
        holder.number.setText(String.valueOf(currentItem.getNumber()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    static class ItemHolder extends RecyclerView.ViewHolder {
        private TextView number;
        private TextView header;
        private TextView description;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.number);
            header = itemView.findViewById(R.id.text_view_header);
            description = itemView.findViewById(R.id.text_view_description);
        }
    }

}
