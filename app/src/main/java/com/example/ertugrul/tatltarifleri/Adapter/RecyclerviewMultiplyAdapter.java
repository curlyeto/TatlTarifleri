package com.example.ertugrul.tatltarifleri.Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ertugrul.tatltarifleri.Activity.TatliDetayActivity;
import com.example.ertugrul.tatltarifleri.Model.Tatli;
import com.example.ertugrul.tatltarifleri.Model.TatliDetay;
import com.example.ertugrul.tatltarifleri.Model.TatliDetayMalzeme;
import com.example.ertugrul.tatltarifleri.Model.TatliDetayYapılıs;
import com.example.ertugrul.tatltarifleri.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewMultiplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static int RESIM=1,MALZEME=2,YAPILIS=3;
    private List<Object> lists=new ArrayList<>(  );
    private Context context;

    //private TatliAdapter1 tatliAdapter=new TatliAdapter1(  );

    public RecyclerviewMultiplyAdapter(Context context){
        this.context=context;
    }
    public void setLists(List<Object> lists){
        this.lists=lists;
    }

    @Override
    public int getItemViewType(int position) {
        if (lists.get( position ) instanceof TatliDetay){
            return RESIM;
        }else if (lists.get( position ) instanceof TatliDetayMalzeme){
            return MALZEME;
        }else if (lists.get( position ) instanceof TatliDetayYapılıs){
            return YAPILIS;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout=0;
        RecyclerView.ViewHolder viewHolder;

        switch (viewType){
            case RESIM:
               layout= R.layout.tatli_detay_resim;
                View resim= LayoutInflater.from( parent.getContext() ).inflate( layout,parent,false );
                viewHolder=new ResimViewHolder(resim);
                break;
            case MALZEME:
              layout=R.layout.tatli_detay_malzeme;
                View malzeme= LayoutInflater.from( parent.getContext() ).inflate( layout,parent,false );
                viewHolder=new MalzemeViewHolder(malzeme);
                break;

            case YAPILIS:
                layout=R.layout.tatli_detay_yapilis;
                View yapilis= LayoutInflater.from( parent.getContext() ).inflate( layout,parent,false );
                viewHolder=new YapilisViewHolder(yapilis);
                break;
            default:
                viewHolder=null;
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType=holder.getItemViewType();

        switch (viewType){
            case RESIM:
                TatliDetay tatliDetay=(TatliDetay)lists.get(position);
                ((ResimViewHolder)holder).showResimDetails(tatliDetay);

                break;
            case MALZEME:
                TatliDetayMalzeme tatliDetayMalzeme=(TatliDetayMalzeme) lists.get(position);
                ((MalzemeViewHolder)holder).showMalzemeDetails(tatliDetayMalzeme);
                break;
            case YAPILIS:
                TatliDetayYapılıs tatliDetayYapılıs=(TatliDetayYapılıs) lists.get(position);
                ((YapilisViewHolder)holder).showYapilisDetails(tatliDetayYapılıs);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    public class  ResimViewHolder extends RecyclerView.ViewHolder {


        ImageView ivdetayresim;
        TextView tvdetayresimad;

        public ResimViewHolder(View itemvView){
            super(itemvView);

            ivdetayresim=itemvView.findViewById( R.id.ivdetayresim );
            tvdetayresimad=itemvView.findViewById( R.id.tvdetayresimad );

        }

        public void showResimDetails(TatliDetay tatliDetay1 ){
            //nesnelerin aksiyonları

            Bundle bundle=new Bundle(  );
            bundle=((TatliDetayActivity)context).getIntent().getExtras();
            String resim=bundle.getString( "resim" );
            String ad=bundle.getString( "tatliad" );

            Glide.with(context).load(resim).into( ivdetayresim );
            Glide.with(context).load(resim).into( ivdetayresim );
            tvdetayresimad.setText( ad );

        }
    }
    public class  MalzemeViewHolder extends RecyclerView.ViewHolder {
        TextView tvmalzeme,textView;

        public MalzemeViewHolder(View itemvView){
            super(itemvView);
            tvmalzeme=itemvView.findViewById( R.id.tvmalzeme );
            textView=itemvView.findViewById( R.id.tvmalzemebaslik );
        }

        public void showMalzemeDetails(TatliDetayMalzeme tatliDetayMalzeme){
            Bundle bundle=new Bundle(  );
            bundle=((TatliDetayActivity)context).getIntent().getExtras();
            String malzeme=bundle.getString( "malzeme" );
            tvmalzeme.setText(  malzeme);

        }

    }
    public class  YapilisViewHolder extends RecyclerView.ViewHolder {
        TextView tvyapilis,tvyapilisbaslik;

        public YapilisViewHolder(View itemvView){
            super(itemvView);
            tvyapilis=itemvView.findViewById( R.id.tvyapilis );
            tvyapilisbaslik=itemvView.findViewById( R.id.tvyapilisbaslik );
        }

        public void showYapilisDetails(TatliDetayYapılıs tatliDetayYapılıs){
            Bundle bundle=new Bundle(  );
            bundle=((TatliDetayActivity)context).getIntent().getExtras();
            String yapilis=bundle.getString( "yapilis" );
            tvyapilis.setText(  yapilis);

        }

    }





}
