package com.hackholyoke.skpatel.newlyfe;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class ChoiceActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private String[] mTestArray;
    private static final Random rgenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        Bundle bundle = getIntent().getExtras();
        int state = bundle.getInt("State");
        TextView textView = (TextView) findViewById(R.id.selectedText);
        String Workout = "Workout";
        String Deadline = "Deadline";
        String Lost = "Lost";
        if (state == 1) {
            textView.setText(Deadline);
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.deadlinespeech);
            Resources res = getResources();

            mTestArray = res.getStringArray(R.array.myArray);

            String q = mTestArray[rgenerator.nextInt(mTestArray.length)];

            TextView tv = (TextView) findViewById(R.id.Quote);
            tv.setText(q);


        } else if (state == 2) {
            textView.setText(Lost);
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lostspeech);
        } else if (state == 3) {
            textView.setText(Workout);
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.workoutspeech);
        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        mediaPlayer.start();

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Choice Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
        mediaPlayer.start();
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        mediaPlayer.stop();
        mediaPlayer.release();
        client.disconnect();
    }

    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}
