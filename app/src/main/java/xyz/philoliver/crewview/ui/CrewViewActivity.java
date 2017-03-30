package xyz.philoliver.crewview.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * A base Activity class whose only purpose currently is to add the Calligraphy wrapper.
 * Any future functionality common to all Activities would also go here.
 */
public abstract class CrewViewActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
