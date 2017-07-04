package com.tshibakela.bestcoffee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.tshibakela.bestcoffee.MainActivity.quantum;

public class Main2Activity extends AppCompatActivity {
    private TextView list, changes, r1, r2, r3, r4, r5, pr;
    private Button rec, again;
    private EditText j1, j2, j3, j4, amount;

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
        if (quantum < MainActivity.total) {

            changes.setText("You cannot purchase you money is not enough!!!");
        } else {
            changes.setText(String.valueOf("Toatal Cost R" + MainActivity.total + "\n Purchase Amount R " + quantum + "\n Your Change is R " + MainActivity.change));
            r5.setText("Thank You!! You can order again!!!!!");
        }


//==================================For Ordering again || ====|| Main Menu==================

        again= (Button) findViewById(R.id.again);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Main2Activity.this);
                alertDialogBuilder.setMessage("Do you want to order Again?");
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        onResume();
                    }
                });

                alertDialogBuilder.setNeutralButton("Go back For exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();


                    }
                });


                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.quantum = 0;
                        MainActivity.quantity0 = 0;
                        MainActivity.quantity1 = 0;
                        MainActivity.quantity2 = 0;
                        MainActivity.quantity3 = 0;
                        MainActivity.quantity4 = 0;
                        MainActivity.total = 0;
                        MainActivity.price3 = 0;
                        MainActivity.price = 0;
                        MainActivity.price2 = 0;
                        MainActivity.price4 = 0;
                        MainActivity.price1 = 0;

                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


                // Intent i= new Intent(Main2Activity.this,MainActivity.class);
                //  startActivity(i);



            }
        });








    }




}
