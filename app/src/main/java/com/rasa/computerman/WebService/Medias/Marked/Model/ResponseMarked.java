
package com.rasa.computerman.WebService.Medias.Marked.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseMarked implements Serializable
{

    @SerializedName("Result")
    @Expose
    private Boolean result;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Extra")
    @Expose
    private List<ExtraMarker> extra = null;
    private final static long serialVersionUID = 7490965045543731145L;

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

    public List<ExtraMarker> getExtra() {
        return extra;
    }

    public void setExtra(List<ExtraMarker> extra) {
        this.extra = extra;
    }

}
