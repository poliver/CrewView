package xyz.philoliver.crewview.network;



import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import xyz.philoliver.crewview.model.UsersResponse;

/**
 * Created by Phil on 3/26/17.
 */

public interface SlackService {

    @GET("methods/users.list")
    Observable<UsersResponse> getUsers(@Query("presence") boolean presence);

}
