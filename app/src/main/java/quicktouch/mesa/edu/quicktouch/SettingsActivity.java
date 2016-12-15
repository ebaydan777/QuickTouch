package quicktouch.mesa.edu.quicktouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    public Button buttonOn, buttonOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);

        try{
            Music.player.stop();
            Music.player.release();
            Music.playMusic(getApplicationContext(),R.raw.introbg);
            Music.player.start();
        }catch(Exception e){

        }
        buttonOn = (Button) findViewById(R.id.buttonOn);
        buttonOn.setOnClickListener(this);
        buttonOff = (Button) findViewById(R.id.buttonOff);
        buttonOff.setOnClickListener(this);

    }

        @Override
        public void onClick(View v) {


            switch (v.getId()){
                case R.id.buttonOff:
                    try{
                        Music.player.pause();
                    }catch (Exception e){

                    }

                    break;
                case R.id.buttonOn:
                    try{
                        Music.player.start();
                    }catch (Exception e){

                    }

                    break;
            }
    }
}
