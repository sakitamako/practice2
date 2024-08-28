package com.diworksdev.practice2.dto;

//ログイン認証機能
//DTOクラスは、DAOがDBから取得した値をActionへ戻す時、値を格納するのに利用されるファイル

public class RegistConfirmDTO {

	//テーブルから取得するデータに対応したフィールド変数を宣言
	//このクラス・変数・変数名
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

}