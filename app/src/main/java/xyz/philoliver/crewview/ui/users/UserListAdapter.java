package xyz.philoliver.crewview.ui.users;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import xyz.philoliver.crewview.R;
import xyz.philoliver.crewview.model.Member;
import xyz.philoliver.crewview.model.Profile;
import xyz.philoliver.crewview.ui.users.details.UserDetailsActivity;
import xyz.philoliver.crewview.util.UserUtils;

/**
 * Created by Phil on 3/26/17.
 */

public class UserListAdapter extends Adapter<UserListAdapter.UserViewHolder> {

    private List<Member> users;

    public UserListAdapter(List<Member> users) {
        this.users = users;
        setHasStableIds(true);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_row, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.avatar)
        ImageView avatar;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.status)
        ImageView status;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Member user) {
            Context context = itemView.getContext();
            Resources resources = context.getResources();
            Profile profile = user.getProfile();

            ViewCompat.setTransitionName(avatar, context.getString(R.string.avatar_transition));

            int size = resources.getDimensionPixelSize(R.dimen.avatar_size);
            //TODO: image not present?
            Glide.with(context)
                    .load(profile.getImage72())
                    .override(size, size)
                    //.centerCrop()
                    .bitmapTransform(new RoundedCornersTransformation(context, resources.getDimensionPixelSize(R.dimen.avatar_corner_radius), 0))
                    //.crossFade()
                    .into(avatar);

            name.setText(user.getRealName());
            status.setActivated(UserUtils.isActive(user));

            itemView.setOnClickListener(view -> {
                Intent intent = UserDetailsActivity.getIntent(context, user);

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        (Activity) context,
                        avatar,
                        ViewCompat.getTransitionName(avatar));

                context.startActivity(intent, options.toBundle());
            });
        }

    }

}