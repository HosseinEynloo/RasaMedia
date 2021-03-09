
package com.rasa.computerman.WebService.Groups.GetBanner.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Extra_getBannerGroups implements Serializable
{

    @SerializedName("Title")
    @Expose
    private Object title;
    @SerializedName("Banners")
    @Expose
    private List<BannerGroups> banners = null;
    private final static long serialVersionUID = 4095061333147804960L;

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public List<BannerGroups> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerGroups> banners) {
        this.banners = banners;
    }

}
