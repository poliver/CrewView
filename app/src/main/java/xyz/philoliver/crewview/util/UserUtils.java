package xyz.philoliver.crewview.util;

import android.support.annotation.NonNull;

import xyz.philoliver.crewview.model.User;
import xyz.philoliver.crewview.model.Profile;

/**
 * Created by Phil on 3/29/17.
 */

public class UserUtils {

    public static boolean isActive(@NonNull User user) {
        Profile profile = user.getProfile();

        return (profile != null && profile.getAlwaysActive() == Boolean.TRUE) || user.getPresence() == User.Presence.ACTIVE;
    }

}
