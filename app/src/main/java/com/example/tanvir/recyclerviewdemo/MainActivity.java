package com.example.tanvir.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    MyAdapter myAdapter;


    int[] images = {R.drawable.australia,R.drawable.bangladesh,R.drawable.bhutan,
            R.drawable.canada,R.drawable.china,R.drawable.denmark,
            R.drawable.england,R.drawable.finland,R.drawable.ghana_flag,
            R.drawable.india,R.drawable.japan,R.drawable.pakistan};

    String[] title, desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewId);

        title =getResources().getStringArray(R.array.country_Names);
        desc =getResources().getStringArray(R.array.country_desc);

        myAdapter = new MyAdapter(this,title,desc,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"onitem click : "+position,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"onitem long click : "+position,Toast.LENGTH_SHORT).show();

            }
        });

    }

}
