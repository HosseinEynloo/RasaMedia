
package com.rasa.computerman.WebService.Medias.Like.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params implements Serializable
{

    @SerializedName("MediaId")
    @Expose
    private Integer mediaId;
    @SerializedName("IsLike")
    @Expose
    private Boolean isLike;
    @SerializedName("DeviceId")
    @Expose
    private String deviceId;
    private final static long serialVersionUID = 3970073774767314326L;

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
