package xyz.philoliver.crewview.ui.users;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import xyz.philoliver.crewview.R;
import xyz.philoliver.crewview.model.Member;
import xyz.philoliver.crewview.model.Profile;
import xyz.philoliver.crewview.ui.users.UserDetailsAdapter.UserDetail;

public class UserDetailsActivity extends CrewViewActivity {

    public static String USER_KEY = "user";

    private Member user;

    @BindView(R.id.avatar)
    ImageView avatar;

    public static Intent getIntent(Context context, Member user) {
        Intent intent = new Intent(context, UserDetailsActivity.class);
        intent.putExtra(USER_KEY, user);

        return intent;
    }

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

        user = getIntent().getExtras().getParcelable(USER_KEY);

        Glide.with(this)
                .load(user.getProfile().getImageOriginal())
                .centerCrop()
                .into(avatar);

        setupUserDetails();

    }

    public void setupUserDetails() {
        List<UserDetail> details = new ArrayList<>();

        // Create a list of the details to show, if they exist
        if (getIntent().hasExtra(USER_KEY)) {
            Profile profile = user.getProfile();

            String email = profile.getEmail();
            if (!TextUtils.isEmpty(email)) {
                details.add(new UserDetail(email, "Email"));
            }

            details.add(new UserDetail("YOOO", "yooo"));
        }

        if (!details.isEmpty()) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(new UserDetailsAdapter(details));
        }
    }

}
