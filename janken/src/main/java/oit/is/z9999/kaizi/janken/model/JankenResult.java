package oit.is.z9999.kaizi.janken.model;

public class JankenResult {
  private String userHand;
  private String cpuHand;
  private String result;

  public JankenResult(String userHand, String cpuHand, String result) {
    this.userHand = userHand;
    this.cpuHand = cpuHand;
    this.result = result;
  }

  public String getUserHand() {
    return userHand;
  }

  public void setUserHand(String userHand) {
    this.userHand = userHand;
  }

  public String getCpuHand() {
    return cpuHand;
  }

  public void setCpuHand(String cpuHand) {
    this.cpuHand = cpuHand;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }
}
