package xyz.philoliver.crewview.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import xyz.philoliver.crewview.CrewViewApplication;
import xyz.philoliver.crewview.R;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CrewViewApplication.getNetworkComponent(this).inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
    }
}
