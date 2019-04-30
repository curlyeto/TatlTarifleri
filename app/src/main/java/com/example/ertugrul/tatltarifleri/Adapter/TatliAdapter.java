package com.example.ertugrul.tatltarifleri.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ertugrul.tatltarifleri.Model.Tatli;
import com.example.ertugrul.tatltarifleri.R;
import com.example.ertugrul.tatltarifleri.Holder.TatliViewHolder;
import com.example.ertugrul.tatltarifleri.Activity.TatliDetayActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TatliAdapter extends RecyclerView.Adapter<TatliViewHolder> implements Filterable{
    private List<Tatli> tatliList;
    private Context context;
    private List<Tatli> tatliListFiltered;//filtreleme özelligi için yeni arraylist

    public TatliAdapter() {}

    public TatliAdapter(List<Tatli> tatliList,Context context){
        this.context=context;
        this.tatliList=tatliList;
        this.tatliListFiltered=tatliList;
    }

    @NonNull
    @Override
    public TatliViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate( R.layout.tatli_satir ,null);

        return new TatliViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull TatliViewHolder holder, final int position) {
        holder.tvtaliad.setText( tatliListFiltered.get( position ).getTatliadi() );
        Glide.with(holder.itemView.getContext()).load( tatliListFiltered.get( position ).getTatliresim()).into(holder.ivtatliresim);
        //Picasso.get().load(tatliListFiltered.get( position ).getTatliresim()).into(holder.ivtatliresim);
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recyclerview satıra tıklama olayı
                Intent intent=new Intent( v.getContext(), TatliDetayActivity.class );
                intent.putExtra( "tatli",tatliListFiltered.get( position ));
                intent.putExtra( "resim",tatliListFiltered.get( position ).getTatliresim());
                intent.putExtra( "tatliad",tatliListFiltered.get( position ).getTatliadi());
                intent.putExtra( "malzeme",tatliListFiltered.get( position ).getMalzeme());
                intent.putExtra( "yapilis",tatliListFiltered.get( position ).getYapilis());
                v.getContext().startActivity( intent );
            }
        } );

    }


    @Override
    public int getItemCount() {
        return tatliListFiltered.size();
    }

   @Override
    public Filter getFilter() {

        return new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String query=constraint.toString();

                List<Tatli> filtered=new ArrayList<>(  );

                if (query.isEmpty()){
                    filtered=tatliList;
                }else {
                    for (Tatli t:tatliList){
                        if (t.getTatliadi().toLowerCase().contains( query.toLowerCase())){
                            filtered.add( t );
                        }
                    }
                }
                FilterResults results=new FilterResults();
                results.count=filtered.size();
                results.values=filtered;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                tatliListFiltered=(ArrayList<Tatli>) results.values;
                notifyDataSetChanged();
            }
        };
    }
    public void updateList(List<Tatli> lstItem) {
        tatliList.clear();
        tatliList.addAll(lstItem);
        this.notifyDataSetChanged();
    }
}
