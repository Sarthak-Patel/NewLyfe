package com.hackholyoke.skpatel.newlyfe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Calendar;
import static com.google.android.gms.appindexing.AppIndex.*;

public class IntroActivity extends AppCompatActivity {
    public static Button button_test;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        /*
        ATTENTION: This was auto-generated to implement the App Indexing API.
        See https://g.co/AppIndexing/AndroidStudio for more information.
        */
        client = new GoogleApiClient.Builder(this).addApi(API).build();
        determineIntroStatus();
        OnClickButtonListener();
    }

    public void OnClickButtonListener() {
        button_test = (Button)findViewById(R.id.btnWorkout);
        button_test.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.hackholyoke.skpatel.newlyfe.ChoiceActivity");
                        intent.putExtra("State", 3);
                        startActivity(intent);
                    }
                }
        );

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void determineIntroStatus() {
        String morning = getString(R.string.morning);
        String afternoon = getString(R.string.afternoon);
        String evening = getString(R.string.evening);
        String night = getString(R.string.night);

        TextView textView = (TextView) findViewById(R.id.VariableTextView);
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        if (timeOfDay >= 0 && timeOfDay < 12) {
            textView.setText(morning);
        } else if (timeOfDay >= 12 && timeOfDay < 16) {
            textView.setText(afternoon);
        } else if (timeOfDay >= 16 && timeOfDay < 21) {
            textView.setText(evening);
        } else {
            textView.setText(night);
        }
    }

    public void playIntroMusic() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.introsong);
        mediaPlayer.start();
    }


    @Override
    public void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndexApi.start(client, getIndexApiAction());
        playIntroMusic();
    }

    @Override
    public void onStop() {
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndexApi.end(client, getIndexApiAction());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }
}
