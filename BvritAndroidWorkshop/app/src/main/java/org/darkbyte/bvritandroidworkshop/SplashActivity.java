package org.darkbyte.bvritandroidworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           Toast t=   Toast.makeText(getApplicationContext(),"Hello u clicked me",Toast.LENGTH_SHORT);
t.show();

                //code to move to next screen
                Intent i =new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
