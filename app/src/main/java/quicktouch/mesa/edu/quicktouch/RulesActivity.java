package quicktouch.mesa.edu.quicktouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        try{
            Music.player.stop();
            Music.player.release();
            Music.playMusic(getApplicationContext(),R.raw.introbg);
            Music.player.start();
        }catch(Exception e){

        }

    }
}
