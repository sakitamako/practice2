package com.diworksdev.practice2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.practice2.dto.RegistConfirmDTO;
import com.diworksdev.practice2.util.DBConnector;

//ログイン認証機能

//DAOクラスでは、Actionから送られてきた情報を使ってDBへ問い合わせを行うファイル
//問い合わせて取得した値をDTOクラスに格納するファイル
public class RegistConfirmDAO {

	//②DBConnectorのインスタンス化
	//DBへの接続準備、DBと会話するためのコード、これでログインできる
	//Connectionは特定のデータベースとの接続
	private DBConnector dbConnector = new DBConnector();

	//③getConnectionの呼び出し（DBと接続する）
	private Connection connection = dbConnector.getConnection();

	//BuyItemDTOインスタンス化
	//DTOと会話するためのコード
	private RegistConfirmDTO registConfirmDTO = new RegistConfirmDTO();

	//①クラス、メソッドの定義
	//DTO型を最後に呼び出し元に渡すので、DTO型を戻り値にしたメソッドを作る
	//Actionクラスの値を引数として受け取る、初期値の時点では空
	public RegistConfirmDTO getRegistConfirmInfo() {

		//商品情報をすべて取得するSQL文を書く
		//④sql文を書く
		//SELECT item_info_transactionのデータを抽出する
		String sql = "SELECT family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, "
				+ "postal_code, prefecture, address_1, address_2, authority FROM login_user_transaction";

		//try.catchはjavaの例外処理のための構文
		try {

			//tryの中にはエラーが発生しそうな処理を書く
			//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			//⑥sql文の?に入れる値をsetする
			ResultSet resultSet = preparedStatement.executeQuery();

			//もしsqlから取得したデータが存在していれば下に一行ずらすこと
			//データが存在していれば戻り値を true で返す。存在しなければ falseで返す
			if (resultSet.next()) {

				//DBから取得した情報をDTOクラスに格納
				//もしresultsetに入っている値が存在していればDTOに格納する
				registConfirmDTO.setUserFamily_name(resultSet.getString("family_name"));
				registConfirmDTO.setUserLast_name(resultSet.getString("last_name"));
				registConfirmDTO.setUserFamily_name_kana(resultSet.getString("family_name_kana"));
				registConfirmDTO.setUserLast_name_kana(resultSet.getString("last_name_kana"));
				registConfirmDTO.setUserMail(resultSet.getString("mail"));
				registConfirmDTO.setUserPassword(resultSet.getString("password"));
				registConfirmDTO.setUserGender(resultSet.getInt("gender"));
				registConfirmDTO.setUserPostal_code(resultSet.getInt("postal_code"));
				registConfirmDTO.setUserPrefecture(resultSet.getString("prefecture"));
				registConfirmDTO.setUserAddress_1(resultSet.getString("address_1"));
				registConfirmDTO.setUserAddress_2(resultSet.getString("address_2"));
				registConfirmDTO.setUserAuthority(resultSet.getInt("authority"));

			}

		//処理中にSQL関連のエラーが発生した際に実行する処理
		//tryの中でエラーが発生した場合、catchが受け取り
		//例外がスローされる原因となったエラーまたは動作の説明を返す
		} catch(Exception e) {
			e.printStackTrace();

		}

		//ActionクラスにDTOクラスを返す
		return registConfirmDTO;

	}

}

