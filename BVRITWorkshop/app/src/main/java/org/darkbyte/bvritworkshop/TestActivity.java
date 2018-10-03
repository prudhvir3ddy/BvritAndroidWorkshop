package org.darkbyte.bvritworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TestActivity extends AppCompatActivity {
ImageView image1,image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        image1=(ImageView)findViewById(R.id.imag1);
        image2=(ImageView)findViewById(R.id.image2);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(TestActivity.this,Test2ctivity.class);
                i.putExtra("name","Goutham");
                i.putExtra("phone","9882550568");
                i.putExtra("email","asd@asd.cas");
                i.putExtra("bio","Test asd asdasd dsa");
                i.putExtra("bgcolor","#FFFF00");
                startActivity(i);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(TestActivity.this,Test2ctivity.class);
                i.putExtra("name","Srujan");
                i.putExtra("phone","sdfdfgc");
                i.putExtra("email","ffgc@cgcg.cas");
                i.putExtra("bio","hgcvghv");
                i.putExtra("bgcolor","#607D8B");
                startActivity(i);
            }
        });
    }
}
