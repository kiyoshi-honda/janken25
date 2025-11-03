package oit.is.z9999.kaizi.janken;

import oit.is.z9999.kaizi.janken.model.JankenResult;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class JankenService {
  private static final String[] HANDS = { "グー", "チョキ", "パー" };

  /**
   * CPUの手を乱数で生成
   */
  public String generateCpuHand() {
    Random rand = new Random();
    int idx = rand.nextInt(HANDS.length);
    return HANDS[idx];
  }

  /**
   * 勝敗判定ロジック
   * 
   * @param userHand ユーザの手
   * @param cpuHand  CPUの手
   * @return 勝敗結果（"勝ち"、"負け"、"あいこ"）
   */
  public String judge(String userHand, String cpuHand) {
    if (userHand.equals(cpuHand)) {
      return "あいこ";
    }
    if ((userHand.equals("グー") && cpuHand.equals("チョキ")) ||
        (userHand.equals("チョキ") && cpuHand.equals("パー")) ||
        (userHand.equals("パー") && cpuHand.equals("グー"))) {
      return "勝ち";
    }
    return "負け";
  }

  /**
   * じゃんけん結果生成
   */
  public JankenResult play(String userHand) {
    String cpuHand = generateCpuHand();
    String result = judge(userHand, cpuHand);
    return new JankenResult(userHand, cpuHand, result);
  }
}
