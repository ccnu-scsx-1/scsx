package com.ccnu.scsx.model;

/**
 * Created by Joban on 2017/1/13.
 */
public class ContactFeed {

  private String id;
  private String feedbackId;
  private ScsxFeedBack feedBack;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFeedbackId() {
    return feedbackId;
  }

  public void setFeedbackId(String feedbackId) {
    this.feedbackId = feedbackId;
  }

  public ScsxFeedBack getFeedBack() {
    return feedBack;
  }

  public void setFeedBack(ScsxFeedBack feedBack) {
    this.feedBack = feedBack;
  }
}
