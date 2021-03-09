
package com.rasa.computerman.WebService.Banner.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extra implements Serializable
{

    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("ParameterType")
    @Expose
    private Object parameterType;
    @SerializedName("Type")
    @Expose
    private String type;
    private final static long serialVersionUID = 1768764014919654240L;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getParameterType() {
        return parameterType;
    }

    public void setParameterType(Object parameterType) {
        this.parameterType = parameterType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
