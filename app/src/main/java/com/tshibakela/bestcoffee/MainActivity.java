package com.tshibakela.bestcoffee;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static Button exit, cancel, rec, ord;
    public static TextView pr;
    public static EditText j1, amount, j2, j3, j4;
    public static int quantity0 = 0;
    public static int quantity1 = 0;
    public static int quantity2 = 0;
    public static int quantity3 = 0;
    public static int quantity4 = 0;
    public static int quantity5 = 0;
    public static int quantum = 0;
    public static double total, price, price1, price2, price3, price4, change;
    String details;
    private CheckBox ch1, ch2, ch3, ch4;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//for adding orders of coffee
       // disp = (TextView) findViewById(R.id.disp);
       // add = (Button) findViewById(R.id.add);
        j1 = (EditText) findViewById(R.id.j1);
        j2 = (EditText) findViewById(R.id.j2);
        j3 = (EditText) findViewById(R.id.j3);
        j4 = (EditText) findViewById(R.id.j4);




//for order price after setting order numbers
        exit = (Button) findViewById(R.id.exit);
        ord = (Button) findViewById(R.id.ord);
        pr = (TextView) findViewById(R.id.pr);
        amount= (EditText) findViewById(R.id.amount);
        ch1 = (CheckBox) findViewById(R.id.ch1);
        ch2 = (CheckBox) findViewById(R.id.ch2);
        ch3 = (CheckBox) findViewById(R.id.ch3);
        ch4 = (CheckBox) findViewById(R.id.ch4);

        ord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// for Sugar tea...................................
                if (ch1.isChecked()) {

                    if (j1.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Invalid Order!!!", Toast.LENGTH_SHORT).show();
                    } else {


                        quantity0 = Integer.parseInt(j1.getText().toString());  //This we use to convert to string #editText


                        price = (12.99 * quantity0);

                    }
                    //   String ord = String.valueOf(quantity);
                } else {

                    price = 0;
                    quantity0=0;

                }

                if (ch2.isChecked()) {

                    if (j2.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Invalid Order!!", Toast.LENGTH_SHORT).show();
                    } else {


                    quantity1 = Integer.parseInt(j2.getText().toString());
                    price1 = (11 * quantity1);
                    }
                } else {

                    price1 = 0;
                    quantity1=0;
                }

                if (ch3.isChecked()) {

                    if (j3.getText().toString().equals("")) {

                        Toast.makeText(MainActivity.this, "Invalid Order!", Toast.LENGTH_SHORT).show();

                    } else {
                    quantity2 = Integer.parseInt(j3.getText().toString());
                    price2 = (15.99 * quantity2);

                    }
                } else {
                    price2 = 0;
                    quantity2=0;
                }

                if (ch4.isChecked()) {

                    if (j4.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "invalid Order", Toast.LENGTH_SHORT).show();
                    } else {
                    quantity3 = Integer.parseInt(j4.getText().toString());
                        price3 = 14.99 * quantity3;
                    }
                } else {
                    price3 = 0;
                    quantity3=0;


                }

                if (quantum == 0) {

                    Toast.makeText(MainActivity.this, "Enter Amount For Purchase Not less than Cost ", Toast.LENGTH_SHORT).show();


                } /**else
                 {
                 Toast.makeText(MainActivity.this,"You have Enterd Amount!!", Toast.LENGTH_SHORT).show();
                 }**/

                if (amount.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "You have entered invalid Amount", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "You have Enterd Amount!!", Toast.LENGTH_SHORT).show();
                    quantum = Integer.parseInt(amount.getText().toString());
                }


                total = price + price1 + price2 + price3 + price4;

                change=quantum-total;

                pr.setText(String.valueOf("R" + total));


            }
        });

//For cancel button================================[It start here]===============================================
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                price3 = price1 = price = price2 = price4 = price4 = quantum = 0;
                quantity0 = quantity1 = quantity2 = quantity3 = quantity4 = quantity5 = 0;
                total = 0;

                pr.setText(String.valueOf("R" + total));
                amount.setText(String.valueOf(quantum));
                j1.setText(String.valueOf(quantity0));
                j2.setText(String.valueOf(quantity1));
                j3.setText(String.valueOf(quantity2));
                j4.setText(String.valueOf(quantity3));




               // disp.setText("You have cancelled ");
                // pr.setText(String.valueOf("R"+total));

            }
        });


        //======================[for Next Page For Receipts]======================================

        rec = (Button) findViewById(R.id.rec);
        rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//-------------------------------------------------Here is for Popo dialog-----------------------------

                if (total >= quantum)
                {

                    AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Check Your Order ");
                    alertDialogBuilder.setPositiveButton("Try!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog , int which) {
                            Toast.makeText(MainActivity.this,"You Clicked Try", Toast.LENGTH_LONG).show();


                        }
                    });






                    AlertDialog alertDialog=alertDialogBuilder.create();
                    alertDialog.show();





                }
//===================================For valid price and amount not less than cost price==========================
                else {


                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertDialogBuilder.setMessage("Do you want to Purchase?");
                    alertDialogBuilder.setNegativeButton("Procede", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            Intent i = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(i);
                        }
                    });
                    alertDialogBuilder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });


                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();


                    Toast.makeText(MainActivity.this, "You Have Submit Your Order For payments", Toast.LENGTH_SHORT).show();
                }
            }


        });


//===========================For exit=============================================

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Do you want to Exit?");
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        onResume();
                    }
                });
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        //[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[      END      ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]

/////////////////////////////////////////////[End Here below is error done before achieving altimate goal]\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    }




}













