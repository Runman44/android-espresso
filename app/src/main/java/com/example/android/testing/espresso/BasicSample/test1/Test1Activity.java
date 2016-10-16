package com.example.android.testing.espresso.BasicSample.test1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.testing.espresso.BasicSample.R;

/**
 * A simple {@link Activity} that shows a message.
 */
public class Test1Activity extends Activity {

    public final static String KEY_EXTRA_MESSAGE =
            "com.example.android.testing.espresso.basicsample.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_text);

        // Get the message from the Intent.
        Intent intent = getIntent();
        String message = intent.getStringExtra(KEY_EXTRA_MESSAGE);

        // Show message.
        ((TextView) findViewById(R.id.show_text_view_one)).setText(message);
        ((TextView) findViewById(R.id.show_text_view_two)).setText(message);
    }

    /**
     * Creates an {@link Intent} for {@link Test1Activity} with the message to be displayed.
     *
     * @param context the {@link Context} where the {@link Intent} will be used
     * @param message a {@link String} with text to be displayed
     * @return an {@link Intent} used to start {@link Test1Activity}
     */
    public static Intent newStartIntent(Context context, String message) {
        Intent newIntent = new Intent(context, Test1Activity.class);
        newIntent.putExtra(KEY_EXTRA_MESSAGE, message);
        return newIntent;
    }
}