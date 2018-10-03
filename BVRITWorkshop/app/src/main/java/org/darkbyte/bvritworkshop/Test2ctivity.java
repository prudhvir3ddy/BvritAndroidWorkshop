package org.darkbyte.bvritworkshop;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Test2ctivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
String name,email,bio,phone,color;
Button biobtn,changebackground;
    private TextToSpeech tts;
TextView nametxt,emailtxt,phonetxt,biotxt;
int j=0;
RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2ctivity);
        rl = (RelativeLayout) findViewById(R.id.rllayout);
        nametxt = (TextView) findViewById(R.id.name);
        biobtn = (Button) findViewById(R.id.biobutton);
        emailtxt = (TextView) findViewById(R.id.email);
        phonetxt = (TextView) findViewById(R.id.phone);
        biotxt = (TextView) findViewById(R.id.biotxt);
        changebackground = (Button) findViewById(R.id.Changebackground);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        bio = i.getStringExtra("bio");
        phone = i.getStringExtra("phone");
        color = i.getStringExtra("bgcolor");
        nametxt.setText(name);
        emailtxt.setText(email);
        phonetxt.setText(phone);
        biotxt.setText(bio);
        int c = Color.parseColor(color);
        rl.setBackgroundColor(c);
        phonetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("9882550568", null, "Test message", null, null);
                Toast.makeText(getApplicationContext(), "Sent Message", Toast.LENGTH_SHORT).show();

            }
        });

        tts = new TextToSpeech(this, this);
        tts.setLanguage(Locale.GERMAN);

        //   btnSpeak=(Button)findViewById(R.id.readTxtButton);

        biobtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                speakOut();
            }

        });


        final int[] array = new int[]{R.drawable.cp,R.drawable.spidey,R.drawable.ironman};
        changebackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                 rl.setBackgroundResource(array[j]);
                j++;
                if (j == 3) {
                    j = 0;
                }
            }
        });
    }
    @Override
    public void onInit(int status) {

    }


    private void speakOut() {
        tts.speak(bio, TextToSpeech.QUEUE_FLUSH, null);
    }

}
