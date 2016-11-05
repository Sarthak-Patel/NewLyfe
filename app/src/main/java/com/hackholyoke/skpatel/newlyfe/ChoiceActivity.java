package com.hackholyoke.skpatel.newlyfe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity {

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
        if(state == 1) {
            textView.setText(Workout);
        }
        else if(state == 2) {
            textView.setText(Lost);
        }
        else if (state == 3) {
            textView.setText(Workout);
        }
    }

}
