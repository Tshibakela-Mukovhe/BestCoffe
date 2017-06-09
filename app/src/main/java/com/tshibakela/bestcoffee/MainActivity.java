package com.tshibakela.bestcoffee;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.order;
import static android.R.attr.start;
import static com.tshibakela.bestcoffee.R.drawable.j;

import static com.tshibakela.bestcoffee.R.id.again;
import static com.tshibakela.bestcoffee.R.id.quant;


public class MainActivity extends AppCompatActivity {
    String details;
    private Button add, cancel, sub, rec, ord;

    private TextView disp, list, pr, tot;
    private EditText j1,amount, j2, j3, j4;

    public static int quantity0 = 0, quantity1=0, quantity2=0, quantity3=0, quantity4=0, quantity5=0;



    public static double total, price,price1, price2, price3, price4, change, quantum;

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


    /* I removed add and sub
     *add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = quantity + 1;
                String add = String.valueOf(quantity);
                disp.setText("" + quantity);
            }
        });


//for reducing the order number we use the following
        sub = (Button) findViewById(R.id.sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quantity == 1) {
                    return;
                }

                quantity = quantity - 1;
                // String sub=String.valueOf(quantity); this is not useful for case where we need positive numbers only
                disp.setText("" + quantity);
            }
        });
*/

//for order price after setting order numbers

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

                    quantity0 = Integer.parseInt(j1.getText().toString());  //This we use to convert to string #editText


                    price = (12.99 * quantity0);
                    //   String ord = String.valueOf(quantity);
                } else {

                    price = 0;
                    quantity0=0;

                }

                if (ch2.isChecked()) {

                    quantity1 = Integer.parseInt(j2.getText().toString());
                    price1 = (11 * quantity1);
                } else {

                    price1 = 0;
                    quantity1=0;
                }

                if (ch3.isChecked()) {
                    quantity2 = Integer.parseInt(j3.getText().toString());
                    price2 = (15.99 * quantity2);

                } else {
                    price2 = 0;
                    quantity2=0;
                }

                if (ch4.isChecked()) {
                    quantity3 = Integer.parseInt(j4.getText().toString());
                    price3 = 14.99 * quantity3;
                } else {
                    price3 = 0;
                    quantity3=0;
                }


                total = price + price1 + price2 + price3 + price4;
                quantum=Integer.parseInt(amount.getText().toString());
                change=quantum-total;

                pr.setText(String.valueOf("R" + total));


            }
        });

//For cancel button================================[It start here]===============================================
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i=new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);


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
                if (quantum>=total)
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

                else {

                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Main2Activity.class)

                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "You Have Submit Your Order For payments", Toast.LENGTH_SHORT).show();
                }


            }
        });



        //[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[      END      ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]

/////////////////////////////////////////////[End Here below is error done before achieving altimate goal]\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


    }




}













