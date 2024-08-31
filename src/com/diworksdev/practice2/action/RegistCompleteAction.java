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

	// フィールド変数
	// JSPから受け取る値
	// ※必ずJSPでの定義と同じ名前にする
	private String userFamily_name;
	private String userLast_name;
	private String userFamily_name_kana;
	private String userLast_name_kana;
	private String userMail;
	private String userPassword;
	private int userGender;
	private int userPostal_code;
	private String userPrefecture;
	private String userAddress_1;
	private String userAddress_2;
	private int userAuthority;

	//Map<String, Object>=キーを値にマッピングするオブジェクト。
	//マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
    //このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	//全てのクラス 変数 変数名
	private Map<String,Object> session;


	//②userCreateCompleteDAOのインスタンス化
	RegistCompleteDAO userCreateCompleteDAO = new RegistCompleteDAO();

	//全てのクラス 変数 変数名(struts) throws=例外を意図的に起こすことが出来る処理のこと。
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

	// ・getterは「フィールド値を返却する事だけ」
	// ・setterは「値を更新する事だけ」

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserFamily_name() {
		return userFamily_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setUserFamily_name(String userFamily_name) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.userFamily_name = userFamily_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserLast_name() {
		return userLast_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setUserLast_name(String userLast_name) {
		this.userLast_name = userLast_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserFamily_name_kana() {
		return userFamily_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setUserFamily_name_kana(String userFamily_name_kana) {
		this.userFamily_name_kana = userFamily_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserLast_name_kana() {
		return userLast_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setUserLast_name_kana(String userLast_name_kana) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.userLast_name_kana = userLast_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserMail() {
		return userMail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setUserMail(String userMail) {
		this.userMail = userMail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserPassword() {
		return userPassword;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public int getUserGender() {
		return userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setUserGender(int userGender) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.userGender = userGender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public int getUserPostal_code() {
		return userPostal_code;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setUserPostal_code(int userPostal_code) {
		this.userPostal_code = userPostal_code;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserPrefecture() {
		return userPrefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setUserPrefecture(String userPrefecture) {
		this.userPrefecture = userPrefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserAddress_1() {
		return userAddress_1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setUserAddress_1(String userAddress_1) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.userAddress_1 = userAddress_1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public String getUserAddress_2() {
		return userAddress_2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setUserAddress_2(String userAddress_2) {
		this.userAddress_2 = userAddress_2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public int getUserAuthority() {
		return userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setUserAuthority(int userAuthority) {
		this.userAuthority = userAuthority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}

