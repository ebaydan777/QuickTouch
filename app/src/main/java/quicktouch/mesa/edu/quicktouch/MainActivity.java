package quicktouch.mesa.edu.quicktouch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public  Button buttonSettings, buttonFeedback , buttonPlay, buttonRules;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Music.playMusic(this, R.raw.introbg);


        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(this);
        buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(this);
        buttonFeedback = (Button) findViewById(R.id.buttonFeedback);
        buttonFeedback.setOnClickListener(this);
        buttonRules = (Button) findViewById(R.id.buttonRules);
        buttonRules.setOnClickListener(this);
        animation =  AnimationUtils.loadAnimation(this, R.anim.wooble);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){

            case R.id.buttonSettings:
                try{
                    Music.player.stop();
                    Music.player.release();
                    Music.playMusic(getApplicationContext(),R.raw.menuselection);
                }catch (Exception e){

                }

                Intent intentt = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intentt);
                break;
            case R.id.buttonFeedback:
                try{
                    Music.player.stop();
                    Music.player.release();
                }catch (Exception e){

                }
                Music.playMusicMenu(getApplicationContext(),R.raw.menuselection);
                intent = new Intent(this, FeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonRules:
                try{
                    Music.player.stop();
                    Music.player.release();
                }catch (Exception e){

                }
                Music.playMusicMenu(getApplicationContext(),R.raw.menuselection);
                intent = new Intent(this, RulesActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonPlay:
                buttonPlay.startAnimation(animation);
                startGame();
                break;
        }
    }


    private void startGame() {
        try{
            Music.player.stop();
            Music.player.release();
        }catch (Exception e){

        }
        Music.playMusicMenu(this, R.raw.playbutton);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        },1500);

    }

}
