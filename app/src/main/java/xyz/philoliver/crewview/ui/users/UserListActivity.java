package xyz.philoliver.crewview.ui.users;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.philoliver.crewview.CrewViewApplication;
import xyz.philoliver.crewview.R;
import xyz.philoliver.crewview.model.UsersResponse;
import xyz.philoliver.crewview.network.SlackService;

public class UserListActivity extends CrewViewActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    SlackService slackService;

    Subscription usersSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CrewViewApplication.getNetworkComponent(this).inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        usersSubscription = slackService.getUsers(true)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(UsersResponse::getMembers)
                .subscribe(users -> {
                    recyclerView.setAdapter(new UserListAdapter(users));
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (usersSubscription != null) {
            usersSubscription.unsubscribe();
        }
    }

}
