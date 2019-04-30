package com.example.ertugrul.tatltarifleri.Activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.ertugrul.tatltarifleri.Database.DatabaseHelper;

import com.example.ertugrul.tatltarifleri.R;
import com.example.ertugrul.tatltarifleri.Model.Tatli;
import com.example.ertugrul.tatltarifleri.Adapter.TatliAdapter;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    RecyclerView recyclerView;
    TatliAdapter adapter;
    List<Tatli> tatliList=new ArrayList<>( );
    SearchView searchView;
    DatabaseHelper databaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        recyclerView=findViewById( R.id.recyclerview );


        try {
            databaseHelper = new DatabaseHelper(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tatliList = databaseHelper.getTatlilar();



        adapter=new TatliAdapter( tatliList,getApplicationContext() );
        recyclerView.setLayoutManager( new GridLayoutManager( getApplicationContext(),2 ) );
        recyclerView.setAdapter( adapter );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.main_menu,menu );

        MenuItem menuItem=menu.findItem( R.id.app_bar_search );
        searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(  this );
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        adapter.getFilter().filter(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}

