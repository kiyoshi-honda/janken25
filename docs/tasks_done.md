# 完了した作業履歴

このファイルには、完了した作業計画の履歴を記録します。

## 作業履歴

### 2025-xx-xx: ドキュメント構造の初期セットアップ
- GitHub Copilot 指示書の作成
- ドキュメント構造の作成
- システム仕様書の初版作成

### 2025-10-07: じゃんけん（CPU対戦）基本機能一式実装
- JankenResultモデルクラスの作成
- JankenServiceクラスの作成（CPU手生成・勝敗判定ロジック）
- JankenControllerクラスの作成（画面遷移・結果表示）
- 画面テンプレート（janken.html, result.html）作成
- サービス・コントローラの単体テスト作成
- 画面イメージ・遷移図の作成
- ブランチ作成・コミット・プッシュ・プルリクエスト

### 2025-10-21: 認証・ログイン機能実装 (Spring Security)
- 概要: ルート(`/`)アクセスでログイン画面を表示し、ログイン後にじゃんけん画面へ遷移する認証機能を実装
- 実施内容:
  - `janken/build.gradle` に `spring-boot-starter-security` と `spring-security-test` を追加
  - `janken/src/main/java/oit/is/z9999/kaizi/janken/security/SecurityConfig.java` を作成
    - BCryptによる `PasswordEncoder` を定義
    - インメモリユーザ `yamada`（パスワード `tarou` をbcryptでハッシュ化）を登録
    - `/`, `/janken`, `/janken/result` を認証必須に設定
  - `janken/src/main/resources/templates/janken.html` にCSRFトークンを埋め込むhiddenフィールドを追加（Thymeleafで `th:action` を使用）
  - テスト `JankenControllerTests` を Spring Security に対応させ、認証ユーザとCSRFトークンを付与するよう修正
- 検証:
  - `./gradlew test` 実行済み。コントローラ・サービスのテストは全て成功（成功状態を確認）
  - ブラウザで `http://localhost:8080/` にアクセスし、ユーザ `yamada` / パスワード `tarou` でログイン後、じゃんけんをプレイできることを確認
- 影響ファイル一覧:
  - janken/build.gradle
  - janken/src/main/java/oit/is/z9999/kaizi/janken/security/SecurityConfig.java
  - janken/src/main/resources/templates/janken.html
  - janken/src/test/java/oit/is/z9999/kaizi/janken/JankenControllerTests.java
- 次の作業:
  1. 変更内容をコミット・プッシュする（まだリモートへはプッシュしていない場合）
  2. `docs/specs.md` と `docs/reports/done_2025-10-21_認証ログイン実装.md` を更新して仕様・完了報告を残す

---
*実装完了後、このファイルに完了した計画を追記します*
