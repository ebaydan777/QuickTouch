package quicktouch.mesa.edu.quicktouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loser extends AppCompatActivity implements View.OnClickListener {

    public Button buttonMenu;


    //NOT USING THIS LOSER.CLASS PAGE! DISREGARD!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loser);

        buttonMenu=(Button) findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }
}
