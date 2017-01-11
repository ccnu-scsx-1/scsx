package com.ccnu.scsx.model;

public class ScsxFeedContact {

  private String id;

  private String userId;

  private String feedbackId;

  private int role;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId == null ? null : userId.trim();
  }

  public String getFeedbackId() {
    return feedbackId;
  }

  public void setFeedbackId(String feedbackId) {
    this.feedbackId = feedbackId == null ? null : feedbackId.trim();
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

  public static ScsxFeedContact build(String id, String feedbackId, String userId, int role) {
    ScsxFeedContact feedContact = new ScsxFeedContact();
    feedContact.setId(id);
    feedContact.setFeedbackId(feedbackId);
    feedContact.setUserId(userId);
    feedContact.setRole(role);
    return feedContact;
  }

}