package xyz.philoliver.crewview.ui.users;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.philoliver.crewview.R;

/**
 * Created by Phil on 3/26/17.
 * <p>
 * I'm using this adapter to list out the User details, because they are optional in the server response.
 * This way, I can add only details present in the response, and the RecyclerView will take care of things
 * like ItemAnimations and ItemDecorations (divider lines)
 */

public class UserDetailsAdapter extends Adapter<UserDetailsAdapter.DetailViewHolder> {

    private List<UserDetail> details;

    public UserDetailsAdapter(List<UserDetail> details) {
        this.details = details;
        setHasStableIds(true);
    }

    @Override
    public DetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_detail_row, parent, false);
        return new DetailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailViewHolder holder, int position) {
        holder.bind(details.get(position));
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.detail)
        TextView detail;

        @BindView(R.id.label)
        TextView label;


        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(UserDetail details) {
            detail.setText(details.getDetail());
            label.setText(details.getLabel());
        }

    }

    public static class UserDetail {

        private String detail;
        private String label;

        public UserDetail(@NonNull String detail, @NonNull String label) {
            this.detail = detail;
            this.label = label;
        }

        public String getDetail() {
            return detail;
        }

        public String getLabel() {
            return label;
        }

    }

}