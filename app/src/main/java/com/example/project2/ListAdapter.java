package com.example.project2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemText;
        private ImageView mItemImage;



        public ListViewHolder(View itemView){

        super(itemView);
        mItemText = (TextView) itemView.findViewById(R.id.itemText);
        mItemImage = (ImageView) itemView.findViewById(R.id.itemImage);
        itemView.setOnClickListener(this);



        }


        public void bindView(int position){

            mItemText.setText(datafile.title[position]);
            mItemImage.setImageResource(datafile.picturePath[position]);
        }



        public void onClick(View view){


        }
    }
}
