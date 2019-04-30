package com.example.ertugrul.tatltarifleri.Activity;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Button;

import com.example.ertugrul.tatltarifleri.Adapter.RecyclerviewMultiplyAdapter;
import com.example.ertugrul.tatltarifleri.Model.Tatli;

import com.example.ertugrul.tatltarifleri.Model.TatliDetay;
import com.example.ertugrul.tatltarifleri.Model.TatliDetayMalzeme;
import com.example.ertugrul.tatltarifleri.Model.TatliDetayYapılıs;
import com.example.ertugrul.tatltarifleri.R;


import java.util.ArrayList;
import java.util.List;

public class TatliDetayActivity extends AppCompatActivity {
    RecyclerView recyclerView1;


    private LinearLayoutManager linearLayoutManager;
    private List<Object> lists;
    private RecyclerviewMultiplyAdapter recyclerviewMultiplyAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tatli_detay );
        this.getSupportActionBar().setDisplayHomeAsUpEnabled( true );//Toolbar'a geri butonu eklenmesi

        recyclerView1=findViewById( R.id.recyclerview1 );
        Tatli tatli=(Tatli) getIntent().getSerializableExtra( "tatli" );



        linearLayoutManager=new LinearLayoutManager( this );
        recyclerView1.setLayoutManager( linearLayoutManager );
        recyclerView1.setHasFixedSize( true );


        init();




    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected( item );
    }
    private void init(){
        lists=new ArrayList<>(  );
        recyclerviewMultiplyAdapter=new RecyclerviewMultiplyAdapter( TatliDetayActivity.this );
        recyclerView1.setAdapter( recyclerviewMultiplyAdapter );

        lists.add( new TatliDetay( "","") );
        lists.add( new TatliDetayMalzeme( ""));
        lists.add( new TatliDetayYapılıs( "") );

        recyclerviewMultiplyAdapter.setLists( lists );
        recyclerviewMultiplyAdapter.notifyDataSetChanged();
    }
}
