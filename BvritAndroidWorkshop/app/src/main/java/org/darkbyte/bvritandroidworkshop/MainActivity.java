package org.darkbyte.bvritandroidworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

   // CREATE GLOBAL OBJECTS
    ImageView image1,image2,image3,image4,image5,image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       //LINK XML WITH JAVA FILE
        setContentView(R.layout.activity_main);



        //LINK VIEWS WITH OBJECTS
        image1=(ImageView)findViewById(R.id.image1);
        image2=(ImageView)findViewById(R.id.image2);
        image3=(ImageView)findViewById(R.id.image3);
        image4=(ImageView)findViewById(R.id.image4);
        image5=(ImageView)findViewById(R.id.image5);
        image6=(ImageView)findViewById(R.id.image6);


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this
                        ,DisplayActivity.class);
                i.putExtra("name","Person1");
                i.putExtra("phone","9882550568");
                i.putExtra("email","person1@darkbyte.in");
                i.putExtra("bio","This is the bio of the first person");
                i.putExtra("bgcolor","#388e3c");
                i.putExtra("photo",R.drawable.boyinoccent);
                startActivity(i);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("name","Person2");
                i.putExtra("phone","9999999999");
                i.putExtra("email","Person2@darkbyte.in");
                i.putExtra("bio","This is the bio of the Second person");
                i.putExtra("bgcolor","#c51162");
                i.putExtra("photo",R.drawable.girl);
                startActivity(i);
            }
        });


        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("name","Person3");
                i.putExtra("phone","9999999999");
                i.putExtra("email","Person3@darkbyte.in");
                i.putExtra("bio","This is the bio of the Third person");
                i.putExtra("bgcolor","#607D8B");
                i.putExtra("photo",R.drawable.boygeek);
                startActivity(i);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("name","Person4");
                i.putExtra("phone","8787878787");
                i.putExtra("email","Person4@cgcg.cas");
                i.putExtra("bio","This is the bio of the Fourth person");
                i.putExtra("bgcolor","#388e3c");
                i.putExtra("photo",R.drawable.boyinoccent);
                startActivity(i);
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("name","Person5");
                i.putExtra("phone","7777777777");
                i.putExtra("email","Person5@foodbee.in");
                i.putExtra("bio","This is the bio of the Second person");
                i.putExtra("bgcolor","#c51162");
                i.putExtra("photo",R.drawable.girl);
                startActivity(i);
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("name","Person6");
                i.putExtra("phone","8888888888");
                i.putExtra("email","person6@foodbee.in");
                i.putExtra("bio","This is the bio of the sixth person");
                i.putExtra("bgcolor","#607D8B");
                i.putExtra("photo",R.drawable.boygeek);
                startActivity(i);
            }
        });
    }



}
