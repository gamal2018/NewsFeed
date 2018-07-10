package com.example.hamza.NewsFeedApp;

public class Article {
    // @param Title of Article
    private String mTitle;
    // @param the name of the section
    private String mSectionName;
    // @param the name of the author
    private String mAuthorName;
    //@param date published
    private String mDate;
    private String mUrl;

    public Article(String Title, String SectionName, String AuthorName, String Date, String url) {
        mTitle = Title;
        mSectionName = SectionName;
        mAuthorName = AuthorName;
        mDate = Date;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getAuthorName() {
        return mAuthorName;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
