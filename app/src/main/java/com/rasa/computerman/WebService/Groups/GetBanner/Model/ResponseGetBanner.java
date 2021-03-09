
package com.rasa.computerman.WebService.Groups.GetBanner.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseGetBanner implements Serializable
{

    @SerializedName("Result")
    @Expose
    private Boolean result;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Extra")
    @Expose
    private List<Extra_getBannerGroups> extra = null;
    private final static long serialVersionUID = 6269624347035207759L;

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

    public List<Extra_getBannerGroups> getExtra() {
        return extra;
    }

    public void setExtra(List<Extra_getBannerGroups> extra) {
        this.extra = extra;
    }

}
