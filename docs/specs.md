# システム仕様書

## プロジェクト概要

**プロジェクト名**: janken25  
**バージョン**: 0.0.1-SNAPSHOT  
**説明**: Spring Boot を使用したじゃんけんゲームアプリケーション

## 技術スタック

### バックエンド
- **フレームワーク**: Spring Boot 3.5.6
- **言語**: Java 21
- **ビルドツール**: Gradle 8.14.3
- **データベース**: H2 Database（インメモリ）
- **ORM**: MyBatis 3.0.5

### フロントエンド
- **テンプレートエンジン**: Thymeleaf
- **静的リソース**: HTML, CSS, JavaScript

### 開発環境
- **パッケージ構造**: `oit.is.z9999.kaizi.janken`
- **テストフレームワーク**: JUnit 5, Spring Boot Test

## 現在の実装状況

### 実装済み機能

#### 1. Spring Boot アプリケーション起動
- **クラス**: `JankenApplication.java`
- **場所**: `janken/src/main/java/oit/is/z9999/kaizi/janken/`
- **説明**: Spring Boot アプリケーションのエントリーポイント

#### 2. 静的コンテンツ配信
- **ファイル**: `index.html`
- **場所**: `janken/src/main/resources/static/`
- **内容**: "Hello GitHub Flow!" を表示するシンプルなHTMLページ
- **URL**: `http://localhost:8080/index.html` または `http://localhost:8080/`

#### 3. テスト環境
- **テストクラス**: `JankenApplicationTests.java`
- **場所**: `janken/src/test/java/oit/is/z9999/kaizi/janken/`
- **説明**: Spring Boot コンテキストが正常にロードされることを確認する基本的なテスト

## プロジェクト構成

```
janken25/
├── .github/
│   └── copilot-instructions.md    # GitHub Copilot 指示書
├── docs/
│   ├── reports/                   # 調査レポート格納ディレクトリ
│   ├── schema.md                  # データベーススキーマ定義
│   ├── specs.md                   # システム仕様書（本ファイル）
│   ├── requirements.md            # 要件定義書
│   ├── tasks.md                   # 現在の作業計画
│   └── tasks_done.md              # 完了した作業履歴
└── janken/
    ├── build.gradle               # Gradle ビルド設定
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── oit/is/z9999/kaizi/janken/
    │   │   │       └── JankenApplication.java
    │   │   └── resources/
    │   │       └── static/
    │   │           └── index.html
    │   └── test/
    │       └── java/
    │           └── oit/is/z9999/kaizi/janken/
    │               └── JankenApplicationTests.java
    └── ...
```

## ビルドとデプロイ

### ビルド方法
```bash
cd janken
./gradlew build
```

### アプリケーション起動
```bash
cd janken
./gradlew bootRun
```

### テスト実行
```bash
cd janken
./gradlew test
```

## 今後の拡張予定

現在は基本的なSpring Bootアプリケーションの骨組みのみが実装されています。
今後、以下のような機能を実装予定です：

- じゃんけんゲームのロジック実装
- ユーザー管理機能
- ゲーム履歴の保存と表示
- Webインターフェースの充実
- データベースを使用した永続化

## 更新履歴

| 日付 | バージョン | 更新内容 |
|------|-----------|---------|
| 2025-xx-xx | 0.0.1-SNAPSHOT | 初版作成。Spring Boot基本構成を記載 |
