package com.house.renting;

/**
 * Created by zeting
 * Date 2019-08-26.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    ImageView portrait;
    TextView name;
    TextView desc;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        desc = (TextView) itemView.findViewById(R.id.desc);
        portrait = (ImageView) itemView.findViewById(R.id.portrait);
    }


    public void bindView(final User user) {
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(itemView, user.getDesc(), Snackbar.LENGTH_LONG).setAction("确定", null).show();
//            }
//        });
        name.setText(user.getName());
        desc.setText(user.getDesc());
        portrait.setImageResource(user.getPortrait());
    }
}