package com.ccnu.scsx.model;

public class ScsxFeedBack {

  private String id;

  private String infoId;

  private Boolean result;

  private String title;

  private String content;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getInfoId() {
    return infoId;
  }

  public void setInfoId(String infoId) {
    this.infoId = infoId == null ? null : infoId.trim();
  }

  public Boolean getResult() {
    return result;
  }

  public void setResult(Boolean result) {
    this.result = result;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title == null ? null : title.trim();
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }

  public static ScsxFeedBack build(String feedbackId, String infoId, String title, String content,
      boolean result) {
    ScsxFeedBack feedBack = new ScsxFeedBack();
    feedBack.setId(feedbackId);
    feedBack.setInfoId(infoId);
    feedBack.setTitle(title);
    feedBack.setContent(content);
    feedBack.setResult(result);
    return feedBack;
  }

}