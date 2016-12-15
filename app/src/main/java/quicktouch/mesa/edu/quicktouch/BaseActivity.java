package quicktouch.mesa.edu.quicktouch;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    Activity activity;
    SharedPreferences sharedPreferences;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setActivity(this);
        sharedPreferences = getSharedPreferences("Game", Context.MODE_PRIVATE);
    }

//    protected void saveToPref(int value) {
//        sharedPreferences.edit().putInt("currentScore", value).apply();
//    }
//
//    protected int getCurrentScore() {
//        return sharedPreferences.getInt("currentScore", 0);
//    }

    protected int getLastScore() {
        return sharedPreferences.getInt("lastScore", 0);
    }

    protected void savelastScore(int value) {
        sharedPreferences.edit().putInt("lastScore", value).apply();
    }
}
