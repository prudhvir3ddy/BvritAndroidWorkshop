package org.darkbyte.bvritworkshop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

import static android.media.AudioManager.*;

public class MainActivity extends AppCompatActivity  implements
        TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;
    LinearLayout callbtn,smsbtn,emailbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callbtn=(LinearLayout)findViewById(R.id.call);
        smsbtn=(LinearLayout)findViewById(R.id.sms);
        emailbtn=(LinearLayout)findViewById(R.id.email);
        TextView text = (TextView) findViewById(R.id.education12th); // retrieve your text view
        text.setText(Html.fromHtml("12<sup>th</sup>"));

        TextView text2 = (TextView) findViewById(R.id.education10th); // retrieve your text view
        text2.setText(Html.fromHtml("10<sup>th</sup>"));


        ///calling code
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    String dial = "tel:" + "9882550568";
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));

            }
        });
        ///sms code



smsbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.SEND_SMS},
                        1);

            }
        }
        else{
           sendSms();
        }
        /*Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("sms_body", "default content");

        startActivity(sendIntent);*/
    }
});

        ///email code
emailbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
});

       ///Text to Speech Code
        tts = new TextToSpeech(this, this);
        txtText=(EditText)findViewById(R.id.editTextBio);

        btnSpeak=(Button)findViewById(R.id.readTxtButton);

        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });
    }



///sms code
public void sendSms(){
    SmsManager smsManager = SmsManager.getDefault();
    smsManager.sendTextMessage("9882550568", null, "Test message", null, null);
    Toast.makeText(getApplicationContext(),"Sent Message",Toast.LENGTH_SHORT).show();
}
@Override
public void onRequestPermissionsResult(int requestCode,String permissions[],
                                       int[] grantResults) {
    switch (requestCode) {
        case 1: {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
               sendSms();
            } else {
                Toast.makeText(getApplicationContext(),
                        "SMS faild, please try again.",
                        Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

}

    // Text to Speech Code
    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilisation Failed!");
        }

    }

    private void speakOut() {

        String text = txtText.getText().toString();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}