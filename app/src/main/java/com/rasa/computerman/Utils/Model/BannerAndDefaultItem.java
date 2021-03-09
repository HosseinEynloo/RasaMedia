package com.rasa.computerman.Utils.Model;

import com.rasa.computerman.WebService.Groups.GetBanner.Model.Extra_getBannerGroups;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.Extra_getMediaSubGroup;

public class BannerAndDefaultItem {


    private Extra_getBannerGroups banners;
    private Extra_getMediaSubGroup mediaList;



    public Extra_getBannerGroups getBanners() {
        return banners;
    }

    public void setBanners(Extra_getBannerGroups banners) {
        this.banners = banners;
    }

    public Extra_getMediaSubGroup getMediaList() {
        return mediaList;
    }

    public void setMediaList(Extra_getMediaSubGroup mediaList) {
        this.mediaList = mediaList;
    }
}
