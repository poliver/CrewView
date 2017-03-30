package xyz.philoliver.crewview.ui.users.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.philoliver.crewview.R;
import xyz.philoliver.crewview.model.User;
import xyz.philoliver.crewview.model.Profile;
import xyz.philoliver.crewview.ui.CrewViewActivity;
import xyz.philoliver.crewview.util.DeviceUtils;
import xyz.philoliver.crewview.util.UserUtils;

import static android.view.View.GONE;

/**
 * The Activity which displays details about the User
 */
public class UserDetailsActivity extends CrewViewActivity {

    public static final String USER_KEY = "user";

    /**
     * Factory method to create the Intent to start this Activity
     *
     * @param context
     * @param user the User whose details will be displayed
     * @return the Intent to start this Activity
     */
    public static Intent getIntent(Context context, @NonNull User user) {
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(USER_KEY, user);

        return intent;
    }

    private User user;

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

        supportPostponeEnterTransition();

        if (!getIntent().hasExtra(USER_KEY)) {
            throw new IllegalArgumentException("User must be provided to UserDetailsActivity");
        }

        ButterKnife.bind(this);

        setupToolbar();

        user = getIntent().getExtras().getParcelable(USER_KEY);

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
        List<UserDetailsAdapter.UserDetail> details = new ArrayList<>();

        // Set this programmatically, since the XML attribute is not supported on API 16
        ViewCompat.setTransitionName(avatar, getString(R.string.avatar_transition));

        // The backdrop is full bleed
        int size = DeviceUtils.screenWidth(this);
        Glide.with(this)
                .load(user.getProfile().getImageOriginal())
                .override(size, size) // Keep aspect ratio square (same as user list screen), so transition looks fluid
                .placeholder(R.drawable.slack)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        // So app doesn't get deadlocked
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        // Now that the avatar image is loaded, proceed with the shared element transition
                        supportStartPostponedEnterTransition();
                        return false;
                    }
                })
                .dontAnimate()
                .into(avatar);

        name.setText(user.getRealName());

        String uname = user.getName();
        if (TextUtils.isEmpty(uname)) {
            username.setVisibility(GONE);
        } else {
            username.setText(getString(R.string.username, uname));
        }

        status.setActivated(UserUtils.isActive(user));

        Profile profile = user.getProfile();

        // Create a list of the details to show, if they exist
        addDetail(profile.getTitle(), "Title", details);

        String timeZone = user.getTz();
        if (TextUtils.isEmpty(timeZone)) {
            timeZone = user.getTzLabel();
        }

        addDetail(timeZone, getString(R.string.timezone), details);
        addDetail(profile.getEmail(), getString(R.string.email), details);
        addDetail(profile.getPhone(), getString(R.string.phone), details);

        if (!details.isEmpty()) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(new UserDetailsAdapter(details));
        }
    }

    /**
     * Repeat logic to add a User detail to the provided list
     *
     * @param detail
     * @param label
     * @param details
     */
    private void addDetail(String detail, String label, List<UserDetailsAdapter.UserDetail> details) {
        if (!TextUtils.isEmpty(detail)) {
            details.add(new UserDetailsAdapter.UserDetail(detail, label));
        }
    }

    /**
     * Overrides the default behavior of a home press to be the same as pressing the device back button.
     *
     * @param item the menu item that was selected
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
