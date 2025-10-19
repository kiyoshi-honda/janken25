package oit.is.z9999.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {
  /**
   * Matchテーブルにある全てのuserのリストを返す．テーブルのフィールドとFruitsクラスのフィールドが同一であれば，個別にフィールド名を指定しなくとも自動的に変換してくれる
   *
   * @return 複数のMatchオブジェクトが格納されたArrayList
   */
  @Select("SELECT id, user1, user2, user1Hand, user2Hand FROM matches")
  ArrayList<Match> selectAllMatch();

  @Insert("INSERT INTO matches (user1, user2, user1Hand, user2Hand) VALUES (#{user1}, #{user2}, #{user1Hand}, #{user2Hand});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertMatch(Match match);
}
