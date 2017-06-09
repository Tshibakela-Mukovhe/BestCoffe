package com.tshibakela.bestcoffee;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.M;
import static com.tshibakela.bestcoffee.MainActivity.price1;
import static com.tshibakela.bestcoffee.MainActivity.price2;
import static com.tshibakela.bestcoffee.MainActivity.price3;
import static com.tshibakela.bestcoffee.MainActivity.price4;
import static com.tshibakela.bestcoffee.MainActivity.total;
import static com.tshibakela.bestcoffee.R.id.ch1;
import static com.tshibakela.bestcoffee.R.id.r1;
import static com.tshibakela.bestcoffee.R.id.r2;

public class Main2Activity extends AppCompatActivity {
    private TextView list,changes, r1, r2, r3, r4, r5;
    private Button rec, again;
    public int quantity0, quantity1, quantity2, quantity3, quantity4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        list = (TextView) findViewById(R.id.list);
        r1 = (TextView) findViewById(R.id.r1);
        r2= (TextView) findViewById(R.id.r2);
        r3= (TextView) findViewById(R.id.r3);
        r4= (TextView) findViewById(R.id.r4);
        r5= (TextView) findViewById(R.id.r5);
        changes= (TextView) findViewById(R.id.changes);

//====================================For the Receipt===================


        if (MainActivity.quantity0==0){
            list.setVisibility(View.INVISIBLE);
        }else {
            list.setVisibility(View.VISIBLE);
            list.setText(String.valueOf("You have ordered " + MainActivity.quantity0 + "with Sugar" + "\n Cost " + "R" + MainActivity.price));
        }

        if (MainActivity.quantity1==0){
            r1.setVisibility(View.INVISIBLE);
        }
        else {
            r1.setVisibility(View.VISIBLE);

            r1.setText(String.valueOf("you have ordered " + MainActivity.quantity1 + " with No Sugar" + "\n" + "Cost R" + MainActivity.price1));
        }

        if (MainActivity.quantity2==0){
            r2.setVisibility(View.INVISIBLE);
        }else {
            r2.setVisibility(View.VISIBLE);
            r2.setText(String.valueOf("You have ordered " + MainActivity.quantity2 + " Hot Tea" + "\n" + "R" + MainActivity.price2));

            }

            if(MainActivity.quantity3==0){
                r3.setVisibility(View.INVISIBLE);
            }
            else {
                r3.setVisibility(View.VISIBLE);

                r3.setText(String.valueOf(" You have ordered " + MainActivity.quantity3 + " Warm Tea" + "\n" + "R" + MainActivity.price3));
            }

            if (MainActivity.quantity4==0){
                r4.setVisibility(View.INVISIBLE);
            }
            else {
                r4.setVisibility(View.VISIBLE);

                r4.setText(String.valueOf("You have ordered " + MainActivity.quantity4 + "\n" + "R" + MainActivity.price4));
            }
        if (MainActivity.change < MainActivity.total){

            changes.setText("You cannot purchase you money is not enough!!!");
        } else {
            changes.setText(String.valueOf("Toatal Cost R" + MainActivity.total + "\n Purchase Amount R " + MainActivity.quantum + "\n Your Change is R " + MainActivity.change));
            r5.setText("Thank You!! You can order again!!!!!");
        }


//==================================For Ordering again || ====|| Main Menu==================

        again= (Button) findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i);



            }
        });








    }




}
