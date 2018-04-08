package com.maxxitsolution.a1networkspte.ModelClass;

import java.io.Serializable;

/**
 * Created by TOSHIBA on 1/30/2018.
 */

public class VOIP  implements Serializable {

    private String mCode;
    private String mDestination;
    private String mCountry;
    private String mPremium;
    private String mSilver;
    private String mSpecial;

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmDestination() {
        return mDestination;
    }

    public void setmDestination(String mDestination) {
        this.mDestination = mDestination;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmPremium() {
        return mPremium;
    }

    public void setmPremium(String mPremium) {
        this.mPremium = mPremium;
    }

    public String getmSilver() {
        return mSilver;
    }

    public void setmSilver(String mSilver) {
        this.mSilver = mSilver;
    }

    public String getmSpecial() {
        return mSpecial;
    }

    public void setmSpecial(String mSpecial) {
        this.mSpecial = mSpecial;
    }
}
