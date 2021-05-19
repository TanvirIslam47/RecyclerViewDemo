package com.example.tanvir.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tanvir on 3/26/2020.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private static ClickListener clickListener;
    Context context;
    String[] title, desc;
    int[] images;

    public MyAdapter(Context context, String[] title, String[] desc, int[] images) {

        this.context = context;
        this.title = title;
        this.desc = desc;
        this.images = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.titleTextView.setText(title[position]);
        holder.dexcTextView.setText(desc[position]);
        holder.flagImageView.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {

        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView titleTextView, dexcTextView;
        ImageView flagImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextViewId);
            dexcTextView = itemView.findViewById(R.id.descTextViewId);
            flagImageView = itemView.findViewById(R.id.imageviewId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);

        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAdapterPosition(),view);
            return false;
        }
    }

    public interface ClickListener{

        void onItemClick(int position, View view);
        void onItemLongClick(int position, View view);
    }

    public void setOnItemClickListener(ClickListener clickListener)
    {
        MyAdapter.clickListener = clickListener;
    }
}
