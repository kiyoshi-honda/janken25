package oit.is.z9999.kaizi.janken.model;

public class Janken {
  String hand;
  String cpuHand;
  String kekka;

  public Janken(String hand, String cpuHand) {
    this.hand = hand;
    this.cpuHand = cpuHand;
    makeGame(hand, cpuHand);

  }

  public void makeGame(String hand, String cpuHand) {
    if (hand.equals("Gu") && cpuHand.equals("Gu") || hand.equals("Choki") && cpuHand.equals("Choki")
        || hand.equals("Pa") && cpuHand.equals("Pa")) {
      this.kekka = "Draw";
    } else if (hand.equals("Gu") && cpuHand.equals("Choki") || hand.equals("Choki") && cpuHand.equals("Pa")
        || hand.equals("Pa") && cpuHand.equals("Gu")) {
      this.kekka = "You Win!";
    } else if (hand.equals("Gu") && cpuHand.equals("Pa") || hand.equals("Choki") && cpuHand.equals("Gu")
        || hand.equals("Pa") && cpuHand.equals("Choki")) {
      this.kekka = "CPU Win!";
    }

  }

  public String getKekka() {
    return kekka;
  }

  public String getCpuHand() {
    return cpuHand;
  }
}
