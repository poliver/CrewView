package xyz.philoliver.crewview.ui.users;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.philoliver.crewview.R;
import xyz.philoliver.crewview.model.Member;
import xyz.philoliver.crewview.model.Profile;
import xyz.philoliver.crewview.ui.users.UserDetailsAdapter.UserDetail;
import xyz.philoliver.crewview.util.UserUtils;

import static android.view.View.GONE;

public class UserDetailsActivity extends CrewViewActivity {

    public static String USER_KEY = "user";
    public static String SYSTEM_BAR_COLOR_KEY = "systemBarColor";
    public static String TOOLBAR_COLOR_KEY = "toolbarColor";


    public static Intent getIntent(Context context, Member user) {
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(USER_KEY, user);

        return intent;
    }

    private Member user;

    @BindView(R.id.avatar)
    ImageView avatar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.username)
    TextView username;

    @BindView(R.id.status)
    ImageView status;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        if (!getIntent().hasExtra(USER_KEY)) {
            throw new IllegalArgumentException("User must be provided to UserDetailsActivity");
        }

        ButterKnife.bind(this);

        setupToolbar();

        user = getIntent().getExtras().getParcelable(USER_KEY);

        Glide.with(this)
                .load(user.getProfile().getImageOriginal())
                .dontAnimate()
                .centerCrop()
                .into(avatar);

        setupUserDetails();

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setupUserDetails() {
        List<UserDetail> details = new ArrayList<>();

        // Create a list of the details to show, if they exist
        if (getIntent().hasExtra(USER_KEY)) {
            name.setText(user.getRealName());

            String uname = user.getName();
            if (TextUtils.isEmpty(uname)) {
                username.setVisibility(GONE);
            } else {
                username.setText(getString(R.string.username, uname));
            }

            status.setActivated(UserUtils.isActive(user));

            Profile profile = user.getProfile();

            addDetail(profile.getTitle(), "Title", details);
            addDetail(user.getTz(), "Timezone", details);
            addDetail(profile.getEmail(), "Email", details);
            addDetail(profile.getPhone(), "Phone", details);

        }

        if (!details.isEmpty()) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(new UserDetailsAdapter(details));
        }
    }

    private void addDetail(String detail, String label, List<UserDetail> details) {
        if (!TextUtils.isEmpty(detail)) {
            details.add(new UserDetail(detail, label));
        }
    }

}
