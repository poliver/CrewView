
package xyz.philoliver.crewview.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("team_id")
    @Expose
    private String teamId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("deleted")
    @Expose
    private Boolean deleted;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("real_name")
    @Expose
    private String realName;
    @SerializedName("tz")
    @Expose
    private Object tz;
    @SerializedName("tz_label")
    @Expose
    private String tzLabel;
    @SerializedName("tz_offset")
    @Expose
    private Long tzOffset;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("is_admin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("is_owner")
    @Expose
    private Boolean isOwner;
    @SerializedName("is_primary_owner")
    @Expose
    private Boolean isPrimaryOwner;
    @SerializedName("is_restricted")
    @Expose
    private Boolean isRestricted;
    @SerializedName("is_ultra_restricted")
    @Expose
    private Boolean isUltraRestricted;
    @SerializedName("is_bot")
    @Expose
    private Boolean isBot;
    @SerializedName("updated")
    @Expose
    private Long updated;
    @SerializedName("has_2fa")
    @Expose
    private Boolean has2fa;
    @SerializedName("presence")
    @Expose
    private Presence presence;

    public enum Presence {
        @SerializedName("active")
        ACTIVE,
        @SerializedName("away")
        AWAY
    }

    public final static Parcelable.Creator<Member> CREATOR = new Creator<Member>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Member createFromParcel(Parcel in) {
            Member instance = new Member();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.teamId = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.deleted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.status = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.color = ((String) in.readValue((String.class.getClassLoader())));
            instance.realName = ((String) in.readValue((String.class.getClassLoader())));
            instance.tz = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.tzLabel = ((String) in.readValue((String.class.getClassLoader())));
            instance.tzOffset = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.profile = ((Profile) in.readValue((Profile.class.getClassLoader())));
            instance.isAdmin = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.isOwner = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.isPrimaryOwner = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.isRestricted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.isUltraRestricted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.isBot = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.updated = ((Long) in.readValue((Long.class.getClassLoader())));
            instance.has2fa = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.presence = Presence.values()[in.readInt()];
            return instance;
        }

        public Member[] newArray(int size) {
            return (new Member[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Object getTz() {
        return tz;
    }

    public void setTz(Object tz) {
        this.tz = tz;
    }

    public String getTzLabel() {
        return tzLabel;
    }

    public void setTzLabel(String tzLabel) {
        this.tzLabel = tzLabel;
    }

    public Long getTzOffset() {
        return tzOffset;
    }

    public void setTzOffset(Long tzOffset) {
        this.tzOffset = tzOffset;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Boolean getIsPrimaryOwner() {
        return isPrimaryOwner;
    }

    public void setIsPrimaryOwner(Boolean isPrimaryOwner) {
        this.isPrimaryOwner = isPrimaryOwner;
    }

    public Boolean getIsRestricted() {
        return isRestricted;
    }

    public void setIsRestricted(Boolean isRestricted) {
        this.isRestricted = isRestricted;
    }

    public Boolean getIsUltraRestricted() {
        return isUltraRestricted;
    }

    public void setIsUltraRestricted(Boolean isUltraRestricted) {
        this.isUltraRestricted = isUltraRestricted;
    }

    public Boolean getIsBot() {
        return isBot;
    }

    public void setIsBot(Boolean isBot) {
        this.isBot = isBot;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Boolean getHas2fa() {
        return has2fa;
    }

    public void setHas2fa(Boolean has2fa) {
        this.has2fa = has2fa;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(teamId);
        dest.writeValue(name);
        dest.writeValue(deleted);
        dest.writeValue(status);
        dest.writeValue(color);
        dest.writeValue(realName);
        dest.writeValue(tz);
        dest.writeValue(tzLabel);
        dest.writeValue(tzOffset);
        dest.writeValue(profile);
        dest.writeValue(isAdmin);
        dest.writeValue(isOwner);
        dest.writeValue(isPrimaryOwner);
        dest.writeValue(isRestricted);
        dest.writeValue(isUltraRestricted);
        dest.writeValue(isBot);
        dest.writeValue(updated);
        dest.writeValue(has2fa);
        dest.writeValue(presence == null? Presence.AWAY.ordinal() : presence.ordinal());
    }

    public int describeContents() {
        return  0;
    }

}
