
package com.rasa.computerman.WebService.Medias.GetMedia.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group implements Serializable
{

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Url")
    @Expose
    private String url;
    @SerializedName("DefaultLike")
    @Expose
    private Integer defaultLike;
    @SerializedName("DefaultVisit")
    @Expose
    private Integer defaultVisit;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("RegisterDate")
    @Expose
    private String registerDate;
    @SerializedName("isFree")
    @Expose
    private Boolean isFree;
    @SerializedName("isMarked")
    @Expose
    private Boolean isMarked;
    @SerializedName("isLiked")
    @Expose
    private Boolean isLiked;
    @SerializedName("Groups")
    @Expose
    private Object groups;
    private final static long serialVersionUID = -4267170291428804882L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDefaultLike() {
        return defaultLike;
    }

    public void setDefaultLike(Integer defaultLike) {
        this.defaultLike = defaultLike;
    }

    public Integer getDefaultVisit() {
        return defaultVisit;
    }

    public void setDefaultVisit(Integer defaultVisit) {
        this.defaultVisit = defaultVisit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Boolean getIsMarked() {
        return isMarked;
    }

    public void setIsMarked(Boolean isMarked) {
        this.isMarked = isMarked;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

    public Object getGroups() {
        return groups;
    }

    public void setGroups(Object groups) {
        this.groups = groups;
    }

}
