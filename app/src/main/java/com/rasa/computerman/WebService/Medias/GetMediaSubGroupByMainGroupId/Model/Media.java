
package com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Media implements Serializable
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
    @SerializedName("RegisterDate")
    @Expose
    private String registerDate;
    @SerializedName("DefaultLike")
    @Expose
    private Integer defaultLike;
    @SerializedName("DefaultVisit")
    @Expose
    private Integer defaultVisit;
    @SerializedName("Id")
    @Expose
    private Integer id;
    private final static long serialVersionUID = -5437463556569546619L;

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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
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

}
