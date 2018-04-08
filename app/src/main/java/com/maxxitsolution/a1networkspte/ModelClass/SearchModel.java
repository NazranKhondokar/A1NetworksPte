package com.maxxitsolution.a1networkspte.ModelClass;

import java.io.Serializable;

/**
 * Created by TOSHIBA on 3/7/2018.
 */

public class SearchModel implements Serializable{

    private String locationName;
    private String dialCode;
    private String price;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDialCode() {
        return dialCode;
    }

    public void setDialCode(String dialCode) {
        this.dialCode = dialCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
