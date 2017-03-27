
package xyz.philoliver.crewview.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member implements Serializable
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
    private boolean deleted;
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
    private long tzOffset;
    @SerializedName("profile")
    @Expose
    private Profile profile;
    @SerializedName("is_admin")
    @Expose
    private boolean isAdmin;
    @SerializedName("is_owner")
    @Expose
    private boolean isOwner;
    @SerializedName("is_primary_owner")
    @Expose
    private boolean isPrimaryOwner;
    @SerializedName("is_restricted")
    @Expose
    private boolean isRestricted;
    @SerializedName("is_ultra_restricted")
    @Expose
    private boolean isUltraRestricted;
    @SerializedName("is_bot")
    @Expose
    private boolean isBot;
    @SerializedName("updated")
    @Expose
    private long updated;
    @SerializedName("has_2fa")
    @Expose
    private boolean has2fa;
    private final static long serialVersionUID = -3598479459267190375L;

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
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

    public long getTzOffset() {
        return tzOffset;
    }

    public void setTzOffset(long tzOffset) {
        this.tzOffset = tzOffset;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    public boolean isIsPrimaryOwner() {
        return isPrimaryOwner;
    }

    public void setIsPrimaryOwner(boolean isPrimaryOwner) {
        this.isPrimaryOwner = isPrimaryOwner;
    }

    public boolean isIsRestricted() {
        return isRestricted;
    }

    public void setIsRestricted(boolean isRestricted) {
        this.isRestricted = isRestricted;
    }

    public boolean isIsUltraRestricted() {
        return isUltraRestricted;
    }

    public void setIsUltraRestricted(boolean isUltraRestricted) {
        this.isUltraRestricted = isUltraRestricted;
    }

    public boolean isIsBot() {
        return isBot;
    }

    public void setIsBot(boolean isBot) {
        this.isBot = isBot;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public boolean isHas2fa() {
        return has2fa;
    }

    public void setHas2fa(boolean has2fa) {
        this.has2fa = has2fa;
    }

}
