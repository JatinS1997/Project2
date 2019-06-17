package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter {

    Context context;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((ListViewHolder) viewHolder).bindView(i);
        ((ListViewHolder) viewHolder).constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name","Jatin");
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return datafile.title.length;
    }



    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemText;
        private ImageView mItemImage;
        ConstraintLayout constraintLayout;



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
