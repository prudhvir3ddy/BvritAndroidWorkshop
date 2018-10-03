package org.bvrit.callingsample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt= (Button)findViewById(R.id.button);
        final EditText edt = (EditText)findViewById(R.id.editText);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = edt.getText().toString();

                Intent it =new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:"+s) );
                startActivity(it);
            }
        });
    }
}
