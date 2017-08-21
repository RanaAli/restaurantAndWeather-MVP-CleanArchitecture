package com.app.domain.model;

/**
 * Created by RanaAli on 8/21/17.
 */

public class Media {

  private Integer position;
  private String mediaType;
  private String src;
  private Object videoUrl;

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public Object getVideoUrl() {
    return videoUrl;
  }

  public void setVideoUrl(Object videoUrl) {
    this.videoUrl = videoUrl;
  }
}
