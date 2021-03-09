
package com.rasa.computerman.WebService.Medias.GetMedia.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGetMedia implements Serializable
{

    @SerializedName("Result")
    @Expose
    private Boolean result;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Extra")
    @Expose
    private List<Extra_getMedia> extra = null;
    private final static long serialVersionUID = 6490746463414809733L;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Extra_getMedia> getExtra() {
        return extra;
    }

    public void setExtra(List<Extra_getMedia> extra) {
        this.extra = extra;
    }

}
