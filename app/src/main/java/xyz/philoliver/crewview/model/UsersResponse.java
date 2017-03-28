
package xyz.philoliver.crewview.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsersResponse implements Parcelable
{

    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("members")
    @Expose
    private List<Member> members = null;
    @SerializedName("cache_ts")
    @Expose
    private Long cacheTs;
    public final static Parcelable.Creator<UsersResponse> CREATOR = new Creator<UsersResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UsersResponse createFromParcel(Parcel in) {
            UsersResponse instance = new UsersResponse();
            instance.ok = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(instance.members, (xyz.philoliver.crewview.model.Member.class.getClassLoader()));
            instance.cacheTs = ((Long) in.readValue((Long.class.getClassLoader())));
            return instance;
        }

        public UsersResponse[] newArray(int size) {
            return (new UsersResponse[size]);
        }

    }
    ;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Long getCacheTs() {
        return cacheTs;
    }

    public void setCacheTs(Long cacheTs) {
        this.cacheTs = cacheTs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ok);
        dest.writeList(members);
        dest.writeValue(cacheTs);
    }

    public int describeContents() {
        return  0;
    }

}
