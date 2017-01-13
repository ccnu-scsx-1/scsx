package com.ccnu.scsx.vo;

import com.ccnu.scsx.model.ContactFeed;

/**
 * Created by Joban on 2017/1/13.
 */
public class FeedList {

  private String feedBackId;

  private boolean result;

  private String infoId;

  private String title;

  public String getFeedBackId() {
    return feedBackId;
  }

  public void setFeedBackId(String feedBackId) {
    this.feedBackId = feedBackId;
  }

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public String getInfoId() {
    return infoId;
  }

  public void setInfoId(String infoId) {
    this.infoId = infoId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public static FeedList build(ContactFeed contactFeed) {
    FeedList feedList = new FeedList();
    feedList.setFeedBackId(contactFeed.getFeedbackId());
    feedList.setResult(contactFeed.getFeedBack().getResult());
    feedList.setInfoId(contactFeed.getFeedBack().getInfoId());
    return feedList;
  }

}
