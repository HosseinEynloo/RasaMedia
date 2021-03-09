
package com.rasa.computerman.WebService.Medias.FinestBakh.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseFinestBakh implements Serializable
{

    @SerializedName("Result")
    @Expose
    private Boolean result;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Extra")
    @Expose
    private List<Extra_finestBakh> extra = null;
    private final static long serialVersionUID = 3406933491282100187L;

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

    public List<Extra_finestBakh> getExtra() {
        return extra;
    }

    public void setExtra(List<Extra_finestBakh> extra) {
        this.extra = extra;
    }

}
