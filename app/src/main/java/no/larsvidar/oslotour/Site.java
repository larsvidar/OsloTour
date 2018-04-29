package no.larsvidar.oslotour;

public class Site {
    private String mTitle;
    private int mImageId;
    private String mDescription;

    public Site(String title, int imageId, String description) {
        mTitle = title;
        mImageId = imageId;
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getImageId() {
        return mImageId;
    }

    public String getmDescription() {
        return mDescription;
    }
}
