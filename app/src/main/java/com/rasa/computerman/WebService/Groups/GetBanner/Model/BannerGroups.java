
package com.rasa.computerman.WebService.Groups.GetBanner.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannerGroups implements Serializable
{

    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("ParameterType")
    @Expose
    private String parameterType;
    @SerializedName("Type")
    @Expose
    private String type;
    private final static long serialVersionUID = 8287430732188326951L;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
