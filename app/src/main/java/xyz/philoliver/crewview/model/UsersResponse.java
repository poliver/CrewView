
package xyz.philoliver.crewview.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersResponse implements Serializable
{

    @SerializedName("ok")
    @Expose
    private boolean ok;
    @SerializedName("members")
    @Expose
    private List<Member> members = null;
    @SerializedName("cache_ts")
    @Expose
    private long cacheTs;
    private final static long serialVersionUID = -8549329281924826022L;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public long getCacheTs() {
        return cacheTs;
    }

    public void setCacheTs(long cacheTs) {
        this.cacheTs = cacheTs;
    }

}
