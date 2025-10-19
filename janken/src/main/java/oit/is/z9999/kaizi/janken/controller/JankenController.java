package oit.is.z9999.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z9999.kaizi.janken.model.Janken;
import oit.is.z9999.kaizi.janken.model.Match;
import oit.is.z9999.kaizi.janken.model.MatchMapper;
import oit.is.z9999.kaizi.janken.model.User;
import oit.is.z9999.kaizi.janken.model.UserMapper;
import oit.is.z9999.kaizi.janken.model.Entry;

@Controller
public class JankenController {
  @Autowired
  private Entry entry;
  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;

  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    ArrayList<User> users = userMapper.selectAllUser();
    ArrayList<Match> matches = matchMapper.selectAllMatch();
    this.entry.addUser(loginUser);
    model.addAttribute("yourName", loginUser);
    model.addAttribute("users", users);
    model.addAttribute("matches", matches);
    return "janken.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam Integer id, ModelMap model, Principal prin) {
    String loginUserName = prin.getName(); // ログインユーザ情報
    User loginUser = userMapper.selectByName(loginUserName);
    User target = userMapper.select(id);
    model.addAttribute("loginUser", loginUser);
    model.addAttribute("target", target);
    return "match.html";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam Integer id, @RequestParam String hand, ModelMap model, Principal prin) {
    String loginUserName = prin.getName(); // ログインユーザ情報
    User loginUser = userMapper.selectByName(loginUserName);
    User target = userMapper.select(id);
    String yourHand = hand;
    String cpuHand = "Gu";
    Janken janken = new Janken(yourHand, cpuHand);

    model.addAttribute("loginUser", loginUser);
    model.addAttribute("target", target);

    model.addAttribute("yourHand", yourHand);
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("kekka", janken.getKekka());

    Match addMatch = new Match(loginUser.getId(), id, yourHand, cpuHand);

    matchMapper.insertMatch(addMatch);
    return "match.html";
  }

  @PostMapping("/janken")
  public String janknepost(@RequestParam String name, ModelMap model) {
    model.addAttribute("yourName", name);
    return "janken.html";
  }

  @GetMapping("/jankengame")
  public String lec02(@RequestParam String hand, ModelMap model) {
    String yourHand = hand;
    String cpuHand = "Gu";
    Janken janken = new Janken(yourHand, cpuHand);
    model.addAttribute("yourHand", yourHand);
    model.addAttribute("cpuHand", janken.getCpuHand());
    model.addAttribute("kekka", janken.getKekka());
    return "janken.html";

  }
}
