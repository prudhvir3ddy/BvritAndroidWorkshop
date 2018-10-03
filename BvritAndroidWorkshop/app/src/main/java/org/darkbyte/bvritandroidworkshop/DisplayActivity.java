package org.darkbyte.bvritandroidworkshop;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DisplayActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {


    String name, email, bio, phone, color;



    int photo;
    Button biobtn, changebackground;
    private TextToSpeech tts;
    TextView nametxt, emailtxt, phonetxt, biotxt,smstxt;
    ImageView profile;
    int j = 0;
    LinearLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        rl = (LinearLayout) findViewById(R.id.rllayout);
        nametxt = (TextView) findViewById(R.id.name);
        emailtxt = (TextView) findViewById(R.id.email);
        phonetxt = (TextView) findViewById(R.id.call);
        smstxt=(TextView)findViewById(R.id.sms);
        biotxt = (TextView) findViewById(R.id.biotxt);
        changebackground = (Button) findViewById(R.id.Changebackground);
        biobtn = (Button) findViewById(R.id.biobutton);
        profile=(ImageView)findViewById(R.id.profile);





        Intent i = getIntent();
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        bio = i.getStringExtra("bio");
        phone = i.getStringExtra("phone");
        color = i.getStringExtra("bgcolor");
        photo=i.getIntExtra("photo",R.drawable.boyinoccent);


        nametxt.setText(name);
        emailtxt.setText(email);
        phonetxt.setText(phone);
        biotxt.setText(bio);
        profile.setImageResource(photo);
     /*   //code for default background
        int c = Color.parseColor(color);
        rl.setBackgroundColor(c);
*/

        //code for call
        phonetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dial = "tel:" + "9882550568";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        });



        //code for sms
        smstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phone,
                        null, "Test message",
                        null, null);
                Toast.makeText(getApplicationContext(),
                        "Sent Message",
                        Toast.LENGTH_SHORT).show();

            }
        });













    ///code for text to speech
        tts = new TextToSpeech(this, this);
        tts.setLanguage(Locale.US);

        biobtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                tts.speak(bio,

                        TextToSpeech.QUEUE_FLUSH, null);
            }

        });

///code to change background
        final int[] array = new int[]{R.drawable.cp, R.drawable.spidey, R.drawable.ironman};
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


}