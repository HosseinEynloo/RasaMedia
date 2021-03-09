
package com.rasa.computerman.WebService.ContactUs.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params implements Serializable
{

    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("Description")
    @Expose
    private String description;
    private final static long serialVersionUID = -8900564770882437664L;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
