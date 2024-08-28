package com.diworksdev.practice2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.practice2.dao.RegistCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

//ユーザー登録機能

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//LoginAciton（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
//実際の処理を持たない、ちょっと変わったクラス=implements
//interfaceを使って型宣言を行うことができますが、メソッドの定義がないとプログラムは実行できないので、そこで使うのがimplements
/*Actionクラスにて、implements SessionAware を宣言（ActionSupport.SessionAware=インターフェース）
実装メソッドである setSession(Map session)にて、ActionのフィールドへHttpSessionのオブジェクトを格納する処理を実装する。this.session = session; でほぼ十分。
上記の手順で実装したフィールドを用意する
これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。*/

public class RegistCompleteAction extends ActionSupport implements SessionAware {

	// Map<String, Object>=キーを値にマッピングするオブジェクト。
	// マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
	// このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	// 全てのクラス 変数 変数名
	public Map<String, Object> session;

	// ②userCreateCompleteDAOのインスタンス化（コピーして代入）
	private RegistCompleteDAO RegistCompleteDAO = new RegistCompleteDAO();

	// 全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
	public String execute() throws SQLException {

		// DAOを経由して入力された内容をDBに登録します。
		// DAOのcreateUserに記憶しているid,pass,nameを取得してテキストで表す文字列を返す
		RegistCompleteDAO.regist(session.get("userFamily_name").toString(), session.get("userLast_name").toString(),
				session.get("userFamily_name_kana").toString(), session.get("userLast_name_kana").toString(),
				session.get("userMail").toString(), session.get("userPassword").toString(), session.get("userGender").toString(),
				session.get("userPostal_code").toString(), session.get("userPrefecture").toString(),
				session.get("userAddress_1").toString(), session.get("userAddress_2").toString(),
				session.get("userAuthority").toString());

		// 変数・文字列 result=SUCCESS
		// userCreateComplete.jspに遷移する
		String result = SUCCESS;

		// 戻り値
		// resultに入った値の処理結果をstrutsが取得してuserCreateComplete.jspに遷移する
		return result;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
