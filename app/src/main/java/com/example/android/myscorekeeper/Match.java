package com.example.android.myscorekeeper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Match extends AppCompatActivity {
    int score1 = 0;
    int score2 = 0;
    int dscore = 0;
    boolean last=true;
    boolean deuce=false;
    int limit = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        TextView team_name1 = (TextView) findViewById(R.id.team_name1);
        TextView team_name2 = (TextView) findViewById(R.id.team_name2);
        LinearLayout sheet1 = (LinearLayout) findViewById(R.id.sheet1);
        LinearLayout sheet2 = (LinearLayout) findViewById(R.id.sheet2);
        team_name1.setText(getIntent().getExtras().getString("player1"));
        team_name2.setText(getIntent().getExtras().getString("player2"));


        if(getIntent().getExtras().getBoolean("toss"))
        {
            Toast.makeText(this,getIntent().getExtras().getString("player1")+" will start the game.",Toast.LENGTH_LONG).show();
            sheet1.setBackgroundColor(Color.parseColor("#99cc00"));
        }
        else {
            Toast.makeText(this, getIntent().getExtras().getString("player2") + " will start the game.", Toast.LENGTH_LONG).show();
            sheet2.setBackgroundColor(Color.parseColor("#99cc00"));
        }
    }
    public void inc1(View view){
        LinearLayout sheet1 = (LinearLayout) findViewById(R.id.sheet1);
        sheet1.setBackgroundColor(Color.parseColor("#99cc00"));
        LinearLayout sheet2 = (LinearLayout) findViewById(R.id.sheet2);
        sheet2.setBackgroundColor(Color.parseColor("#669900"));
        TextView point1 = (TextView) findViewById(R.id.score1);
        score1+=1;
        if(!deuce)
        {
            point1.setText("" + score1);
            if(score1==limit && score2<=limit-2)
            {
                Toast.makeText(view.getContext(),getIntent().getExtras().getString("player1")+ " wins",Toast.LENGTH_LONG).show();
                score1=0;
                score2 = 0;
                limit=21;
                //Intent to next page after winning
            }
            else if(score1==limit-1 && score2<=limit-2)
            {
                Toast.makeText(view.getContext(),"Game Point to " + getIntent().getExtras().getString("player1"),Toast.LENGTH_LONG).show();
            }
            else if(score1==limit && score2==limit-1){
                limit+=1;
            }
            else if(score1==score2 && score1>=limit-1){
                deuce = true;
                Toast.makeText(view.getContext(),"Deuce",Toast.LENGTH_SHORT).show();
            }}
        else{
            dscore += 1;
            switch (dscore){
                case 0:
                    Toast.makeText(view.getContext(),"Deuce",Toast.LENGTH_SHORT).show();
                    point1.setText("D");
                    break;
                case 1:
                    Toast.makeText(view.getContext(),"Game Point to " + getIntent().getExtras().getString("player1"),Toast.LENGTH_LONG).show();
                    point1.setText("Ad");
                    break;
                case 2:
                    Toast.makeText(view.getContext(),getIntent().getExtras().getString("player1")+ " wins",Toast.LENGTH_LONG).show();
                    score1=0;
                    score2=0;
                    limit=21;
                    //Intent to next page after winning
            }
        }
        last = true;
    }
    public void inc2(View view){
        LinearLayout sheet2 = (LinearLayout) findViewById(R.id.sheet2);
        sheet2.setBackgroundColor(Color.parseColor("#99cc00"));
        LinearLayout sheet1 = (LinearLayout) findViewById(R.id.sheet1);
        sheet1.setBackgroundColor(Color.parseColor("#669900"));
        TextView point2 = (TextView) findViewById(R.id.score2);
        score2+=1;
        if(!deuce)
        {
            point2.setText("" + score2);
            if(score2==limit && score1<=limit-2)
            {
                Toast.makeText(view.getContext(),getIntent().getExtras().getString("player2")+ " wins",Toast.LENGTH_LONG).show();
                score1 = 0;
                score2=0;
                limit=21;
                //Intent to next page after winning
            }
            else if(score2==limit-1 && score1<=limit-2)
            {
                Toast.makeText(view.getContext(),"Game Point to " + getIntent().getExtras().getString("player2"),Toast.LENGTH_LONG).show();
            }
            else if(score2==limit && score1==limit-1){
                limit+=1;
            }
            else if(score1==score2 && score2>=limit-1){
                deuce = true;
                Toast.makeText(view.getContext(),"Deuce",Toast.LENGTH_SHORT).show();
            }}
        else{
            dscore -= 1;
            switch (dscore){
                case 0:
                    Toast.makeText(view.getContext(),"Deuce",Toast.LENGTH_SHORT).show();
                    point2.setText("D");
                    break;
                case -1:
                    Toast.makeText(view.getContext(),"Game Point to " + getIntent().getExtras().getString("player2"),Toast.LENGTH_LONG).show();
                    point2.setText("Ad");
                    break;
                case -2:
                    Toast.makeText(view.getContext(),getIntent().getExtras().getString("player2")+ " wins",Toast.LENGTH_LONG).show();
                    score1=0;
                    limit=21;
                    score2=0;
                    //Intent to next page after winning
            }
        }
        last = false;
    }
}
