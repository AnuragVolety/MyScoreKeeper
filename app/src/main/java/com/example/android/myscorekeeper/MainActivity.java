package com.example.android.myscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout baddy = (LinearLayout) findViewById(R.id.baddy);
        final LinearLayout table = (LinearLayout) findViewById(R.id.table);
        final LinearLayout lawn = (LinearLayout) findViewById(R.id.lawn);
        final LinearLayout volley = (LinearLayout) findViewById(R.id.volley);
        //Badminton--------------
        TextView badminton = (TextView) findViewById(R.id.badminton);
        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(baddy.getVisibility()==View.GONE){
                    Toast.makeText(view.getContext(),"Badminton: Select Game Type",Toast.LENGTH_SHORT).show();
                    baddy.setVisibility(View.VISIBLE);
                    table.setVisibility(View.GONE);
                    lawn.setVisibility(View.GONE);
                    volley.setVisibility(View.GONE);
                    TextView b1s = (TextView) findViewById(R.id.b1s);
                    b1s.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(view.getContext(),"Play Badminton Single Player Single Set",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,B1s.class);
                            startActivity(intent);
                        }
                    });
                }
                else {
                    baddy.setVisibility(View.GONE);
                }
            }
        });

        //Table Tennis--------------
        TextView tableTennis = (TextView) findViewById(R.id.tableTennis);
        tableTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(table.getVisibility()==View.GONE){
                    Toast.makeText(view.getContext(),"Table Tennis: Select Game Type",Toast.LENGTH_SHORT).show();
                    table.setVisibility(View.VISIBLE);
                    lawn.setVisibility(View.GONE);
                    volley.setVisibility(View.GONE);
                    baddy.setVisibility(View.GONE);
                }
                else {
                    table.setVisibility(View.GONE);
                }
            }
        });

        //Lawn Tennis--------------
        TextView lawnTennis = (TextView) findViewById(R.id.lawnTennis);
        lawnTennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lawn.getVisibility()==View.GONE){
                    Toast.makeText(view.getContext(),"Lawn Tennis: Select Game Type",Toast.LENGTH_SHORT).show();
                    lawn.setVisibility(View.VISIBLE);
                    volley.setVisibility(View.GONE);
                    baddy.setVisibility(View.GONE);
                    table.setVisibility(View.GONE);
                }
                else {
                    lawn.setVisibility(View.GONE);
                }
            }
        });

        //Volleyball--------------
        TextView volleyball = (TextView) findViewById(R.id.volleyball);
        volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(volley.getVisibility()==View.GONE){
                    Toast.makeText(view.getContext(),"Volleyball:Select Game Type",Toast.LENGTH_SHORT).show();
                    volley.setVisibility(View.VISIBLE);
                    baddy.setVisibility(View.GONE);
                    table.setVisibility(View.GONE);
                    lawn.setVisibility(View.GONE);
                }
                else {
                    volley.setVisibility(View.GONE);
                }
            }
        });
    }
}
