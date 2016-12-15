package quicktouch.mesa.edu.quicktouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Winner extends AppCompatActivity implements View.OnClickListener{


    //NOT USING THIS WINNER.CLASS PAGE! DISREGARD!


    public Button buttonMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);


        buttonMenu=(Button) findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {

    }
}
