package xyz.philoliver.crewview.ui.users;

import android.content.Context;
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
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import xyz.philoliver.crewview.R;
import xyz.philoliver.crewview.model.Member;
import xyz.philoliver.crewview.model.Profile;

/**
 * Created by Phil on 3/26/17.
 */

public class UserListAdapter extends Adapter<UserListAdapter.UserViewHolder> {

    private List<Member> users;

    public UserListAdapter(List<Member> users) {
        this.users = users;
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
            Profile profile = user.getProfile();

            Glide.with(context)
                    .load(profile.getImage72())
                    .centerCrop()
                    .bitmapTransform(new CropCircleTransformation(context))
                    .crossFade()
                    .into(avatar);

            name.setText(user.getRealName());
            status.setActivated(profile.getAlwaysActive() == Boolean.TRUE || user.getPresence() == Member.Presence.ACTIVE);
        }

    }

}