package oit.is.z9999.kaizi.janken;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JankenServiceTests {
  private final JankenService service = new JankenService();

  @Test
  void testJudgeDraw() {
    assertEquals("あいこ", service.judge("グー", "グー"));
    assertEquals("あいこ", service.judge("チョキ", "チョキ"));
    assertEquals("あいこ", service.judge("パー", "パー"));
  }

  @Test
  void testJudgeWin() {
    assertEquals("勝ち", service.judge("グー", "チョキ"));
    assertEquals("勝ち", service.judge("チョキ", "パー"));
    assertEquals("勝ち", service.judge("パー", "グー"));
  }

  @Test
  void testJudgeLose() {
    assertEquals("負け", service.judge("グー", "パー"));
    assertEquals("負け", service.judge("チョキ", "グー"));
    assertEquals("負け", service.judge("パー", "チョキ"));
  }
}
