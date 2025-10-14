# じゃんけん認証・ログイン機能追加 実装計画（2025-10-14）

## 概要
- ルートパス（http://localhost:8080/）にアクセスした際にログインページを表示し、ログイン後にじゃんけんページへ遷移させる
- ユーザ名「yamada」、パスワード「tarou」でログインできるようにする
- Spring Securityを利用し、認証・認可を実装する

## 必要なファイル・関連ファイル
- janken/build.gradle（依存追加）
- janken/src/main/java/oit/is/z9999/kaizi/janken/security/SecurityConfig.java（新規作成）
- janken/src/main/java/oit/is/z9999/kaizi/janken/JankenController.java（既存）
- janken/src/main/resources/templates/janken.html（既存）
- janken/src/main/resources/static/index.html（不要なら削除）

## 実装タスク
1. `build.gradle` に `spring-boot-starter-security` を追加する
2. `security` ディレクトリを作成し、`SecurityConfig.java` を新規作成
   - インメモリユーザ（yamada/tarou）を設定
   - `/janken` へのアクセスは認証必須
   - ログイン画面は自動生成
3. コントローラやテンプレートは既存のままでOK
4. index.html の役割を確認し、不要なら削除
5. 実装後、ブラウザで http://localhost:8080/ にアクセスし、ログイン画面→認証後じゃんけん画面が表示されることを確認

## テスト・確認方法
- ログイン画面が表示されること
- ユーザ名「yamada」、パスワード「tarou」でログインできること
- ログイン後、じゃんけん画面（janken.html）が表示されること
- 認証なしで `/janken` にアクセスするとログイン画面にリダイレクトされること

## 優先順位
1. 依存追加・SecurityConfig作成
2. index.html の整理
3. 動作確認

## 参考ファイルパス
- janken/build.gradle
- janken/src/main/java/oit/is/z9999/kaizi/janken/security/SecurityConfig.java
- janken/src/main/java/oit/is/z9999/kaizi/janken/JankenController.java
- janken/src/main/resources/templates/janken.html
- janken/src/main/resources/static/index.html

---

この計画に従い、実装フェーズで作業を進めてください。
