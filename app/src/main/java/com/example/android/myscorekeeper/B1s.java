package com.example.android.myscorekeeper;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class B1s extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1s);
        Button ready = (Button) findViewById(R.id.button);
        final LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        final LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);
        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText teamName1 = (EditText) findViewById(R.id.team1Name);
                if( teamName1.getText().toString().trim().equals("")){
                    teamName1.setError( "Team name is required!" );
                }
                EditText teamName2 = (EditText) findViewById(R.id.team2Name);
                if( teamName2.getText().toString().trim().equals("")){
                    teamName2.setError( "Team name is required!" );
                }

                else{
                    final String name1 = teamName1.getText().toString();
                    final String name2 = teamName2.getText().toString();
                    Toast.makeText(view.getContext(),"SELECT THE TEAM TO SERVE FIRST",Toast.LENGTH_LONG).show();
                    layout2.setVisibility(View.VISIBLE);
                    TextView serve1 = (TextView) findViewById(R.id.serve1);
                    TextView serve2 = (TextView) findViewById(R.id.serve2);
                    serve1.setText(name1 +" to serve first");
                    serve2.setText(name2 +" to serve first");
                    serve1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(B1s.this,Match.class);
                            intent.putExtra("player1",name1);
                            intent.putExtra("player2",name2);
                            intent.putExtra("toss",true);
                            startActivity(intent);
                        }
                    });
                    serve2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(B1s.this,Match.class);
                            intent.putExtra("player1",name1);
                            intent.putExtra("player2",name2);
                            intent.putExtra("toss",false);
                            startActivity(intent);
                        }
                    });

                }
            }
        });

    }
}
