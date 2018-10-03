package org.bvrit.speakoutbio;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements TextToSpeech.OnInitListener {

    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts=new TextToSpeech(this,this);

        final EditText edt = (EditText)
                findViewById(R.id.editText);
        final TextView tv = (TextView)
                findViewById(R.id.textView);

        Button btn= (Button)findViewById(R.id.button);
        

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = edt.getText().toString();
                tts.speak(s,
                        TextToSpeech.QUEUE_FLUSH,
                        null);

                tv.setText(s);

            }
        });

    }

    @Override
    public void onInit(int i) {

    }
}
