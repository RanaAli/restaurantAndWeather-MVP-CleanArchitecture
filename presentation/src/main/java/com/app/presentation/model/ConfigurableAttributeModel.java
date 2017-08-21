package com.app.presentation.model;

import java.util.List;

public class ConfigurableAttributeModel {

  private String code;
  private List<OptionModel> options = null;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<OptionModel> getOptions() {
    return options;
  }

  public void setOptions(List<OptionModel> options) {
    this.options = options;
  }
}
