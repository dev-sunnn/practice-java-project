-- DB切り替え
\c practice_db;

-- テーブルを削除
DROP TABLE IF EXISTS "todo_list";

-- todo_list テーブル作成
CREATE TABLE "todo_list" (
    "id" serial PRIMARY KEY,
    "title" VARCHAR( 100 ),
    "detail" VARCHAR( 2000 ),
    "update_date" TIMESTAMP,
    "create_date" TIMESTAMP
);

