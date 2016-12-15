package quicktouch.mesa.edu.quicktouch;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Music extends AppCompatActivity {

    static MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static void playMusic(Context context, int musicID){
        player = MediaPlayer.create(context, musicID);
        player.start();
        player.setLooping(true);
    }
    public static void playMusicMenu(Context context, int musicID){
        player = MediaPlayer.create(context, musicID);
        player.start();
    }

}
