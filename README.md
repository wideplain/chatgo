# ChatGo
![トップページ](https://i.gyazo.com/2ecdb0294b30641fe12d3e475c9e60dd.png)
Websocketを利用したJavaカリキュラム用chatアプリです。

## websocketを利用したチャットアプリ
- レスポンシブデザイン
- ユーザの登録機能/編集機能
- ルームの検索機能
- 新規の課題・ハードルとして設定
- websocketを利用した双方向のチャット機能
- チャットルーム毎の会話可能な仕組み
- データの永続化等
- 投稿はユーザーのみ
- トースト型通知

# DB設計
## messages table
| Column   | Type   | Options                        |
| -------- | ------ | ------------------------------ |
| user_id  | Long   | null: false, foreign_key: true |
| room_id  | Long   | null: false, foreign_key: true |
| body     | String |                                |

## users table
| Column        | Type    | Options                        |
| ------------- | ------- | ------------------------------ |
| email         | String  | null: false, unique: true      |
| password      | String  | null: false                    |
| username      | String  | null: false, unique: true      |
| profile_photo | String  |                                |


## rooms table
| Column | Type   | Options                   |
| ------ | ------ | ------------------------- |
| name   | String | null: false, unique: true |


## group_users table
| Column   | Type | Options                        |
| -------- | ---- | ------------------------------ |
| user_id  | Long | null: false, foreign_key: true |
| room_id  | Long | null: false, foreign_key: true |
