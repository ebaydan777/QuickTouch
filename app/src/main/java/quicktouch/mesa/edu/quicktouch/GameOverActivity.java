package quicktouch.mesa.edu.quicktouch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameOverActivity extends BaseActivity
	{

		private ViewHolder mHolder;

		@Override
		public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				getSupportActionBar().hide();
				setContentView(R.layout.activity_game_over);

				mHolder = new ViewHolder();
				int score = getIntent().getExtras().getInt(getString(R.string.score_key));

				if (score > getLastScore() || getLastScore() == 0)
					{
						mHolder.abc.setText("Highest Score " + score);
						//mHolder.winLose.setBackgroundResource(R.drawable.prize);
						savelastScore(score);
					}
				else
					{
						//mHolder.winLose.setBackgroundResource(R.drawable.nuke);
						mHolder.abc.setText("Your Score: " + score + "\n" + "Highest Score is " + getLastScore());
						mHolder.winLose.setVisibility(View.INVISIBLE);

					}

				mHolder.again.setOnClickListener(new View.OnClickListener()
					{
						@Override
						public void onClick(View view)
							{
								startActivity(new Intent(getActivity(), GameActivity.class));
								finish();
							}
					});

				mHolder.mainMenu.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View view)
					{
						try{
							Music.player.stop();
							Music.player.release();
						}catch (Exception e){

						}
						startActivity(new Intent(getActivity(), MainActivity.class));
						finish();
					}
				});
			}

		private class ViewHolder
			{
				private Button again;

				private TextView abc;

				private ImageButton winLose;
				private Button mainMenu;

				public ViewHolder()
					{
						again = (Button) findViewById(R.id.again);
						abc = (TextView) findViewById(R.id.mHolder);
						winLose = (ImageButton) findViewById(R.id.winLose);
						mainMenu = (Button) findViewById(R.id.mainMenu);
					}
			}

	}
