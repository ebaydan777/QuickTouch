package quicktouch.mesa.edu.quicktouch;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class GameActivity extends BaseActivity implements View.OnClickListener
{
    ViewHolder mHolder;
    private GameCountDown timer;
    private int interval = 1000;
    private int totalTime = 1000 * 3;
    Random random = new Random();
    int randomNumber;

    private TextView[] buttons = new TextView[9];

    private int score = 0;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
        try{
            Music.player.stop();
            Music.player.release();
        }catch (Exception e){

        }
        Music.playMusic(getApplicationContext(),R.raw.mainbgmusic);

        mHolder = new ViewHolder();
        buttons[0] = mHolder.btnOne;
        buttons[1] = mHolder.btnTwo;
        buttons[2] = mHolder.btnThree;
        buttons[3] = mHolder.btnFour;
        buttons[4] = mHolder.btnFive;
        buttons[5] = mHolder.btnSix;
        buttons[6] = mHolder.btnSeven;
        buttons[7] = mHolder.btnEight;
        buttons[8] = mHolder.btnNine;

        mHolder.btnStart.setOnClickListener(this);
        mHolder.btnOne.setOnClickListener(this);
        mHolder.btnTwo.setOnClickListener(this);
        mHolder.btnThree.setOnClickListener(this);
        mHolder.btnFour.setOnClickListener(this);
        mHolder.btnFive.setOnClickListener(this);
        mHolder.btnSix.setOnClickListener(this);
        mHolder.btnSeven.setOnClickListener(this);
        mHolder.btnEight.setOnClickListener(this);
        mHolder.btnNine.setOnClickListener(this);

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (timer != null)
        {
            timer.cancel();
        }
    }

    private class GameCountDown extends CountDownTimer
    {

        public GameCountDown( long millisInFuture, long countDownInterval )
        {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millis)
        {
            showRemainingTime(millis);
        }

        @Override
        public void onFinish()
        {
            startActivity();
        }
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {

            case R.id.btnStart:

                mHolder.btnStart.setVisibility(View.INVISIBLE);
                timer = new GameCountDown(totalTime, interval);
                timer.start();
                mHolder.tvRemainingTime.setVisibility(View.VISIBLE);
                mHolder.tvRemainingTime.setText("");
                showRandomNumbers();

                break;

            case R.id.btnOne:
                compareNumber(1);
                break;
            case R.id.btnTwo:
                compareNumber(2);
                break;
            case R.id.btnThree:
                compareNumber(3);
                break;
            case R.id.btnFour:
                compareNumber(4);
                break;
            case R.id.btnFive:
                compareNumber(5);
                break;
            case R.id.btnSix:
                compareNumber(6);
                break;
            case R.id.btnSeven:
                compareNumber(7);
                break;
            case R.id.btnEight:
                compareNumber(8);
                break;
            case R.id.btnNine:
                compareNumber(9);
                break;

        }
    }

    class ViewHolder
    {

        private TextView tvRemainingTime;
        private TextView btnOne;
        private TextView btnTwo;
        private TextView btnThree;
        private TextView btnFour;
        private TextView btnFive;
        private TextView btnSix;
        private TextView btnSeven;
        private TextView btnEight;
        private TextView btnNine;
        private TextView btnStart;
        private TextView tvTotalScore;

        public ViewHolder()
        {

            tvTotalScore = (TextView) findViewById(R.id.tvTotalScore);

            tvRemainingTime = (TextView) findViewById(R.id.tvRemainingTime);
            btnOne = (TextView) findViewById(R.id.btnOne);
            btnTwo = (TextView) findViewById(R.id.btnTwo);
            btnThree = (TextView) findViewById(R.id.btnThree);
            btnFour = (TextView) findViewById(R.id.btnFour);
            btnFive = (TextView) findViewById(R.id.btnFive);
            btnSix = (TextView) findViewById(R.id.btnSix);
            btnSeven = (TextView) findViewById(R.id.btnSeven);
            btnEight = (TextView) findViewById(R.id.btnEight);
            btnNine = (TextView) findViewById(R.id.btnNine);
            btnStart = (TextView) findViewById(R.id.btnStart);
        }

    }

    private void showRandomNumbers()
    {
        showRemainingTime(totalTime);
        randomNumber = random.nextInt(buttons.length) + 1;
        Log.e("Random #", randomNumber + "");

        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i].setBackgroundResource(R.drawable.button_bg);
        }

        for (int i = 0; i < buttons.length; i++)
        {
            if (randomNumber == i + 1)
            {
                buttons[i].setBackgroundResource(R.drawable.btn_bg_hightlight);
            }
        }
    }

    private void compareNumber(int button)
    {
        Log.e("OnClick", button + "");
        if (timer == null)
        {
            Toast.makeText(getActivity(), "Please Start First", Toast.LENGTH_LONG).show();
            return;
        }
        if (randomNumber == button)
        {
            // isMatch = true;
            restartTimer();
            score = score + 1;
            mHolder.tvTotalScore.setVisibility(View.VISIBLE);
            mHolder.tvTotalScore.setText("Score " + score);
        }
        else
        {
            startActivity();
            timer.cancel();
        }
    }

    private void restartTimer()
    {
        timer.cancel();
        timer = new GameCountDown(totalTime, interval);
        timer.start();
        showRandomNumbers();
        mHolder.tvRemainingTime.setVisibility(View.VISIBLE);
        mHolder.tvRemainingTime.setText("");
    }

    private void showRemainingTime(long millis)
    {
        String remainingTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), // The change is in this line
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

        mHolder.tvRemainingTime.setText(remainingTime);
    }

    private void startActivity()
    {
        if (score > getLastScore())
        {

        }
        Intent intent = new Intent(getActivity(), GameOverActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.score_key), score);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
