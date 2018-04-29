package com.myschool.livedatademo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myschool.livedatademo.R;
import com.myschool.livedatademo.database.BorrowerModel;

import java.util.List;

/**
 * Created by dilip on 20/2/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<BorrowerModel> list;
    private View.OnLongClickListener longClickListener;


    public RecyclerViewAdapter(List<BorrowerModel> list, View.OnLongClickListener longClickListener) {
        this.list = list;
        this.longClickListener = longClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setAllData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void addItems(List<BorrowerModel> models){
        this.list = models;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mName,mItem,mDate;

        public MyViewHolder(View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mItem = itemView.findViewById(R.id.item);
            mDate = itemView.findViewById(R.id.date);

        }

        public void setAllData(BorrowerModel model){
            mName.setText(model.getPersonName());
            mItem.setText(model.getItemName());
            mDate.setText(model.getBorrowDate());

            itemView.setTag(model);
            itemView.setOnLongClickListener(longClickListener);

        }
    }
}
