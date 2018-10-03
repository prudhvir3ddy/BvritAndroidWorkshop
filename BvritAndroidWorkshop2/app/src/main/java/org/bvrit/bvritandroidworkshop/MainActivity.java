package org.bvrit.bvritandroidworkshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView im = (ImageView)findViewById(R.id.imageView);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),
                        "Hello BVRIT ",
                        Toast.LENGTH_SHORT)
                        .show();
                Intent it = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(it);


            }
        });
    }
}
