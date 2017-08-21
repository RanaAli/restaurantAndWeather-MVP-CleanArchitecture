package com.app.domain.model;

import java.util.List;

public class ConfigurableAttribute {

  private String code;
  private List<Option> options = null;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<Option> getOptions() {
    return options;
  }

  public void setOptions(List<Option> options) {
    this.options = options;
  }
}
