package xyz.philoliver.crewview.util;

import android.support.annotation.NonNull;

import xyz.philoliver.crewview.model.User;
import xyz.philoliver.crewview.model.Profile;

/**
 * Created by Phil on 3/29/17.
 */

public class UserUtils {

    /**
     *
     * @param user the user whose status will be checked
     * @return true if the user presence is active or it's always active (i.e. a bot)
     */
    public static boolean isActive(@NonNull User user) {
        Profile profile = user.getProfile();

        return (profile != null && profile.getAlwaysActive() == Boolean.TRUE) || user.getPresence() == User.Presence.ACTIVE;
    }

}
