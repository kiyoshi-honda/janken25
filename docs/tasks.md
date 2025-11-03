# じゃんけんゲーム開始画面のルートパス表示 実装計画（2025-10-09）

## 概要
- じゃんけんゲームを `localhost:8080/` にアクセスしたら開始できるようにする

## 必要なファイル・関連ファイル
- janken/src/main/java/oit/is/z9999/kaizi/JankenController.java（新規作成または既存コントローラに追加）
- janken/src/main/resources/templates/janken.html（表示画面）
- janken/src/main/resources/static/index.html（不要なら削除またはリネーム）

## 実装タスク
1. コントローラクラス JankenController を janken/src/main/java/oit/is/z9999/kaizi/ に作成し、@GetMapping("/") で janken.html を返すメソッドを追加する
2. 既存の index.html の役割を確認し、不要なら削除またはリネームする
3. 必要に応じて janken.html の内容を確認・修正する
4. サンプル（reference/springboot_samples/）のコントローラ実装を参考にする
5. 実装後、localhost:8080/ にアクセスして janken.html が表示されることを確認する

## テスト・確認方法
- ブラウザで localhost:8080/ にアクセスし、じゃんけん画面が表示されること
- 既存の index.html が不要な場合、削除後も問題なく動作すること

## 優先順位
1. コントローラの新規作成・修正
2. index.html の整理
3. 動作確認

## 参考ファイルパス
- janken/src/main/java/oit/is/z9999/kaizi/JankenController.java
- janken/src/main/resources/templates/janken.html
- janken/src/main/resources/static/index.html
- reference/springboot_samples/src/main/java/oit/is/

---

この計画に従い、実装フェーズで作業を進めてください。
