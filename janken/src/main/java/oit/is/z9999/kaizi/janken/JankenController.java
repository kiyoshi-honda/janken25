package oit.is.z9999.kaizi.janken;

import oit.is.z9999.kaizi.janken.model.JankenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @Autowired
  private JankenService jankenService;

  /**
   * じゃんけん選択画面
   */
  @GetMapping("/janken")
  public String showJankenForm() {
    return "janken";
  }

  /**
   * じゃんけん結果表示
   */
  @PostMapping("/janken/result")
  public String playJanken(@RequestParam("userHand") String userHand, Model model) {
    JankenResult result = jankenService.play(userHand);
    model.addAttribute("result", result);
    return "result";
  }
}
