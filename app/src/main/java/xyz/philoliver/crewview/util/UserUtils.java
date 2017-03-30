package xyz.philoliver.crewview.util;

import android.support.annotation.NonNull;

import xyz.philoliver.crewview.model.Member;
import xyz.philoliver.crewview.model.Profile;

/**
 * Created by Phil on 3/29/17.
 */

public class UserUtils {

    public static boolean isActive(@NonNull Member user) {
        Profile profile = user.getProfile();

        return (profile != null && profile.getAlwaysActive() == Boolean.TRUE) || user.getPresence() == Member.Presence.ACTIVE;
    }

}
