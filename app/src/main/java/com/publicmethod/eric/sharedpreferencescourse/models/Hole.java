package com.publicmethod.eric.sharedpreferencescourse.models;

/**
 * Created by Owner on 2016-02-12.
 */
public class Hole {

    private String mHoleLabel;
    private int mStrokeCount;

    public Hole(String label, int strokeCount) {

        mHoleLabel = label;
        mStrokeCount = strokeCount;

    }

    public String getHoleLabel() {
        return mHoleLabel;
    }

    public void setHoleLabel(String holeLabel) {
        mHoleLabel = holeLabel;
    }

    public int getStrokeCount() {
        return mStrokeCount;
    }

    public void setStrokeCount(int strokeCount) {
        mStrokeCount = strokeCount;
    }

}
