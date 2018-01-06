# java_chat_curriculum
Websocketを利用したJavaカリキュラム用chatアプリです。

## websocketを利用したチャットアプリの要望
- 過去の課題の理解チェックを兼ねた機能開発
- ユーザの登録機能/編集機能
- ユーザの検索機能
- (仮)ルームの作成機能/編集機能
- (仮)ルームの検索機能
- 新規の課題・ハードルとして設定
- websocketを利用した双方向のチャット機能
- (仮)チャットルーム毎の会話可能な仕組み
- データの永続化等
- 投稿はユーザーのみ

# DB設計
## messages table
| Column   | Type   | Options                        |
| -------- | ------ | ------------------------------ |
| user_id  | Long   | null: false, foreign_key: true |
| group_id | Long   | null: false, foreign_key: true |
| body     | String |                                |

## users table
| Column        | Type    | Options                        |
| ------------- | ------- | ------------------------------ |
| email         | String  | null: false, unique: true      |
| password      | String  | null: false                    |
| name          | String  | null: false, unique: true      |
| profile_photo | String  |                                |


## groups table
| Column | Type   | Options                   |
| ------ | ------ | ------------------------- |
| name   | String | null: false, unique: true |


## group_users table
| Column   | Type | Options                        |
| -------- | ---- | ------------------------------ |
| user_id  | Long | null: false, foreign_key: true |
| group_id | Long | null: false, foreign_key: true |
