package com.example.ertugrul.tatltarifleri.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ertugrul.tatltarifleri.R;

public class TatliViewHolder extends RecyclerView.ViewHolder{
    public ImageView ivtatliresim;
    public TextView tvtaliad;

    public TatliViewHolder(View itemView) {
        super( itemView );
        ivtatliresim=itemView.findViewById( R.id.ivtatliresim );
        tvtaliad=itemView.findViewById( R.id.tvtatlisim );
    }
}
