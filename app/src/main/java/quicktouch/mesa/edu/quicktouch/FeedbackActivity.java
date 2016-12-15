package quicktouch.mesa.edu.quicktouch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        try{
            Music.player.stop();
            Music.player.release();
            Music.playMusic(getApplicationContext(),R.raw.introbg);
            Music.player.start();
        }catch(Exception e){

        }

        final EditText name = (EditText) findViewById(R.id.editTextName);
        final EditText addy = (EditText) findViewById(R.id.editTextEmail);

        final EditText questions = (EditText) findViewById(R.id.editTextFeedback);

        Button email = (Button) findViewById(R.id.buttonSend);
        email.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View v){
                //TODO Auto-generated method stub
                Intent email = new Intent(Intent.ACTION_SEND);


                email.setType("plain/text");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{addy.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, "JPs App");
                email.putExtra(Intent.EXTRA_TEXT,
                        "name:"+name.getText().toString()+'\n'+"address:"+addy.getText().toString()+'\n'+"phone:"+'\n'+'\n'+questions.getText().toString()+'\n'+'\n');


                startActivity(Intent.createChooser(email, "Send mail..."));
            }
        });

    }
}