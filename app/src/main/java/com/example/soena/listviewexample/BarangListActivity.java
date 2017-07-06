package com.example.soena.listviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import dataaccess.DataProvider;
import models.Barang;

public class BarangListActivity extends AppCompatActivity {
    private ListView barangListView;
    private List<Barang> listBarang = DataProvider.barangList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        BarangListAdapter adapter = new BarangListAdapter(this, R.layout.list_item, listBarang);
        barangListView = (ListView) findViewById(R.id.barangListView);
        barangListView.setAdapter(adapter);

        barangListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(BarangListActivity.this, DetailBarangActivity.class);
                Barang currBarang = listBarang.get(position);
                i.putExtra("barangId", currBarang.getBarangId());
                startActivity(i);
            }
        });
    }

}
