package com.example.me.diceroller;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.*;

import java.util.*;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner selectDie;
    TextView selectedDie, d4Text, d6Text, d8Text, d10Text, d12Text, d20Text, d100Text;
    Button rollDie;
    int d4Roll, d6Roll, d8Roll, d10Roll, d12Roll, d20Roll, d100Roll, moveX, moveY;
//    TranslateAnimation diceRoll;
    RotateAnimation diceRotate;
//    AnimationSet roll = new AnimationSet(false);

    Random r = new Random();

    public static final String[] dice = {"d4", "d6", "d8", "d10", "d12", "d20", "d100"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up widgets
        selectDie = (Spinner) findViewById(R.id.selectDie);
        selectedDie = (TextView) findViewById(R.id.selectedDie);
        d4Text = (TextView) findViewById(R.id.d4Text);
        d6Text = (TextView) findViewById(R.id.d6Text);
        d8Text = (TextView) findViewById(R.id.d8Text);
        d10Text = (TextView) findViewById(R.id.d10Text);
        d12Text = (TextView) findViewById(R.id.d12Text);
        d20Text = (TextView) findViewById(R.id.d20Text);
        d100Text = (TextView) findViewById(R.id.d100Text);
        rollDie = (Button) findViewById(R.id.roll);

        //Setting up animation
        diceRotate = new RotateAnimation(0, 360, 200, 200);
        diceRotate.setDuration(500);
        diceRotate.setFillAfter(false);
//        roll.addAnimation(diceRotate);

//        diceRoll = new TranslateAnimation(0, 0, 500, 500, 0, 0, 500, 500);
//        diceRoll.setDuration(500);
//        diceRoll.setFillAfter(false);
//        roll.addAnimation(diceRoll);

        //Filling in spinner
        final ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < dice.length; i++) {
            list.add(dice[i]);
        }

        final ArrayAdapter <String> myAdapter = new ArrayAdapter <> (this, android.R.layout.simple_list_item_1, list);
        selectDie.setAdapter(myAdapter);

        selectDie.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Set all to invisible after each selection so none are overlapping
        d4Text.setVisibility(View.INVISIBLE);
        d6Text.setVisibility(View.INVISIBLE);
        d8Text.setVisibility(View.INVISIBLE);
        d10Text.setVisibility(View.INVISIBLE);
        d12Text.setVisibility(View.INVISIBLE);
        d20Text.setVisibility(View.INVISIBLE);
        d100Text.setVisibility(View.INVISIBLE);

        selectedDie.setText("Selected Die: " + dice[i]);

        //Setting selected die to visible
        switch (selectDie.getSelectedItemPosition()){
            case 0:
                d4Text.setVisibility(View.VISIBLE);
                break;
            case 1:
                d6Text.setVisibility(View.VISIBLE);
                break;
            case 2:
                d8Text.setVisibility(View.VISIBLE);
                break;
            case 3:
                d10Text.setVisibility(View.VISIBLE);
                break;
            case 4:
                d12Text.setVisibility(View.VISIBLE);
                break;
            case 5:
                d20Text.setVisibility(View.VISIBLE);
                break;
            case 6:
                d100Text.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void rollDie(View view) {

        //Movement of dice and generating random numbers for rolls
        switch (selectDie.getSelectedItemPosition()){
            case 0:
                d4Roll = r.nextInt(5 - 1) + 1;
                d4Text.setText("" + d4Roll);
                rotate(d4Text);
                break;
            case 1:
                d6Roll = r.nextInt(7 - 1) + 1;
                d6Text.setText("" + d6Roll);
                rotate(d6Text);
                break;
            case 2:
                d8Roll = r.nextInt(9 - 1) + 1;
                d8Text.setText("" + d8Roll);
                rotate(d8Text);
                break;
            case 3:
                d10Roll = r.nextInt(10 - 0);
                d10Text.setText("" + d10Roll);
                rotate(d10Text);
                break;
            case 4:
                d12Roll = r.nextInt(13 - 1) + 1;
                d12Text.setText("" + d12Roll);
                rotate(d12Text);
                break;
            case 5:
                d20Roll = r.nextInt(21 - 1) + 1;
                d20Text.setText("" + d20Roll);
                rotate(d20Text);
                break;
            case 6:
                d100Roll = r.nextInt(100 - 0);
                d100Text.setText("" + d100Roll);
                rotate(d100Text);

                //Setting a zero to double zero for somewhat accuracy
                if (d100Roll == 0){
                    d100Text.setText("00");
                }
                break;
            default:
                break;
        }
    }

    //Method for rotating die
    public void rotate (TextView die){
        die.startAnimation(diceRotate);
    }


}
