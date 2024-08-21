/*クライアントがSQLステートメントをサーバーに送信するために使用する文字セット*/
set names utf8;
/*MySQLで外部キー制約を適用しているテーブルにはDROP TABLEができない
 * 一時的に外部キー制約を無効にすることができる*/
set foreign_key_checks = 0;
/*DROP TABLE IF EXISTS でテーブルが存在すれば削除する*/
drop database if exists practice2;
/*もし存在しなければデータベースecsiteを作成*/
create database if not exists practice2;
use practice2;

/*DROP TABLE IF EXISTS でテーブルが存在すれば削除する*/
drop table if exists login_user_information;

/*テーブルを作成する
 *テーブルの中でただ一つのデータを特定する＝primary key
 *データベーステーブルのカラムに適用される制約の一つで、そのカラムに重複した値が入らないようにする制約＝unique
 *文字列格納＝varchar*/
create table login_user_information(
id int not null primary key auto_increment,
id int(100) unique,
login_pass varchar(16),
user_name varchar(50);