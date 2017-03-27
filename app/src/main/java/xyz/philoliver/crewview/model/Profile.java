
package xyz.philoliver.crewview.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile implements Serializable
{

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("image_24")
    @Expose
    private String image24;
    @SerializedName("image_32")
    @Expose
    private String image32;
    @SerializedName("image_48")
    @Expose
    private String image48;
    @SerializedName("image_72")
    @Expose
    private String image72;
    @SerializedName("image_192")
    @Expose
    private String image192;
    @SerializedName("image_original")
    @Expose
    private String imageOriginal;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("skype")
    @Expose
    private String skype;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("avatar_hash")
    @Expose
    private String avatarHash;
    @SerializedName("real_name")
    @Expose
    private String realName;
    @SerializedName("real_name_normalized")
    @Expose
    private String realNameNormalized;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("image_512")
    @Expose
    private String image512;
    @SerializedName("always_active")
    @Expose
    private boolean alwaysActive;
    @SerializedName("fields")
    @Expose
    private Object fields;
    private final static long serialVersionUID = 7420908830177210663L;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage24() {
        return image24;
    }

    public void setImage24(String image24) {
        this.image24 = image24;
    }

    public String getImage32() {
        return image32;
    }

    public void setImage32(String image32) {
        this.image32 = image32;
    }

    public String getImage48() {
        return image48;
    }

    public void setImage48(String image48) {
        this.image48 = image48;
    }

    public String getImage72() {
        return image72;
    }

    public void setImage72(String image72) {
        this.image72 = image72;
    }

    public String getImage192() {
        return image192;
    }

    public void setImage192(String image192) {
        this.image192 = image192;
    }

    public String getImageOriginal() {
        return imageOriginal;
    }

    public void setImageOriginal(String imageOriginal) {
        this.imageOriginal = imageOriginal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarHash() {
        return avatarHash;
    }

    public void setAvatarHash(String avatarHash) {
        this.avatarHash = avatarHash;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealNameNormalized() {
        return realNameNormalized;
    }

    public void setRealNameNormalized(String realNameNormalized) {
        this.realNameNormalized = realNameNormalized;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage512() {
        return image512;
    }

    public void setImage512(String image512) {
        this.image512 = image512;
    }

    public boolean isAlwaysActive() {
        return alwaysActive;
    }

    public void setAlwaysActive(boolean alwaysActive) {
        this.alwaysActive = alwaysActive;
    }

    public Object getFields() {
        return fields;
    }

    public void setFields(Object fields) {
        this.fields = fields;
    }

}
