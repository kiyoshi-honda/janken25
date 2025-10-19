package oit.is.z9999.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  /**
   * idを引数にしてDBを対象にSELECT文を実行し，SELECT文の結果をUserオブジェクトに格納して返すメソッド．
   *
   * @param id がメソッドの引数．@Selectの引数に記述するSELECT文に#{id}と記述することで利用できる．
   * @return DBから取り出した値をUserオブジェクトに格納して返す．
   */
  @Select("SELECT id, name FROM users WHERE id = #{id}")
  User select(int id);

  @Select("SELECT id, name FROM users WHERE name = #{name}")
  User selectByName(String name);

  /**
   * userテーブルにある全てのuserのリストを返す．テーブルのフィールドとFruitsクラスのフィールドが同一であれば，個別にフィールド名を指定しなくとも自動的に変換してくれる
   *
   * @return 複数のUserオブジェクトが格納されたArrayList
   */
  @Select("SELECT id, name FROM users")
  ArrayList<User> selectAllUser();

}
