package oit.is.z9999.kaizi.janken.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Entry {

  ArrayList<String> users = new ArrayList<>();

  public void addUser(String name) {
    this.users.add(name);
  }

  public ArrayList<String> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<String> users) {
    this.users = users;
  }
}
