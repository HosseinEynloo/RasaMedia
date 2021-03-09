
package com.rasa.computerman.WebService.Medias.SuggestBakh.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSuggestBakh implements Serializable
{

    @SerializedName("Result")
    @Expose
    private Boolean result;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Extra")
    @Expose
    private List<Extra_suggestBakh> extra = null;
    private final static long serialVersionUID = 8581855502494462157L;

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

    public List<Extra_suggestBakh> getExtra() {
        return extra;
    }

    public void setExtra(List<Extra_suggestBakh> extra) {
        this.extra = extra;
    }

}
