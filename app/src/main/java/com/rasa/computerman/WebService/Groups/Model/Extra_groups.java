
package com.rasa.computerman.WebService.Groups.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extra_groups implements Serializable
{

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Id")
    @Expose
    private Integer id;
    private final static long serialVersionUID = 3823623528995534683L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
