package com.diworksdev.practice2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//ユーザー登録機能

//Actionクラスでは、画面から送られてきたリクエストを取得する
//内部処理に応じてDAOやDTOクラスを呼び出し、最終的に次のJSPへ値を返すファイル

//struts2が持つActionSupportというクラスを継承
//（Actionクラスは基本的にこのクラスを継承）
//UserCreateConfirmAction（子クラス） extends（継承） ActionSupport（親クラス）
//すでにあるクラスとにたクラスを作る場合、元のクラスに必要な機能だけを追加する形で、新しいクラスを作ることを継承
//実際の処理を持たない、ちょっと変わったクラス=implements
//interfaceを使って型宣言を行うことができますが、メソッドの定義がないとプログラムは実行できないので、そこで使うのがimplements
/*Actionクラスにて、implements SessionAware を宣言（ActionSupport.SessionAware=インターフェース）
実装メソッドである setSession(Map session)にて、ActionのフィールドへHttpSessionのオブジェクトを格納する処理を実装する。this.session = session; でほぼ十分。
上記の手順で実装したフィールドを用意する
これにより、このActionクラスのsessionフィールドへ、Struts2が自動的にHttpSessionの内容をMapの型で格納します。*/
public class RegistConfirmAction extends ActionSupport implements SessionAware {

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

	// Map<String, Object>=キーを値にマッピングするオブジェクト。
	// マップには、同一のキーを複数登録できない。各キーは1つの値にしかマッピングできません。
	// このインタフェースは、インタフェースというよりむしろ完全に抽象クラスであったDictionaryクラスに代わるものです
	// 全てのクラス 変数 変数名
	public Map<String, Object> session;

	// このクラスのみ 変数 変数名
	// 初期値、
	private String errorMessage;

	// メソッド名は「execute」
	// 管理コマンド・メッセージをコマンド・サーバーに送信し、何らかの応答メッセージを待ちます
	public String execute() {

		// メソッドの戻り値 String result = success; を定義し、初期値としてseccessを代入
		String result = SUCCESS;

		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// loginUserIdと空文字・何も入ってない時の値が等しい場合、かつ、loginPasswordと空文字・何も入ってない時の値が等しい場合、かつ、userNameと空文字・何も入ってない時の値が等しい場合はelse文に行く！
		// ! aとbとcがtrueの場合処理は実行しない
		// && aとbとcが共にtrueの時に処理を実行する
		if (!(userFamily_name.equals("")) && !(userLast_name.equals("")) && !(userFamily_name_kana.equals(""))
				&& !(userLast_name_kana.equals("")) && !(userMail.equals("")) && !(userPassword.equals(""))
				&& !(userPrefecture.equals("")) && !(userAddress_1.equals("")) && !(userAddress_2.equals(""))) {

			// 空文字の部分に値が入っていたらsessionにそれぞれ記憶する
			session.put("userFamily_name", userFamily_name);
			session.put("userLast_name", userLast_name);
			session.put("userFamily_name_kana", userFamily_name_kana);
			session.put("userLast_name_kana", userLast_name_kana);
			session.put("userMail", userMail);
			session.put("userPassword", userPassword);
			session.put("userPrefecture", userPrefecture);
			session.put("userAddress_1", userAddress_1);
			session.put("userAddress_2", userAddress_2);

		} else {

			setErrorMessage("未入力の項目があります。");

			// elseの場合エラー
			result = ERROR;

		}
		// 空文字の部分に値が入っていたら処理を実行する、サクセス！userCreateConfirm.jsp画面に遷移する
		return result;

	}

	// 全てのクラス 変数 変数名(struts)//メソッド（操作）
	public String execute1() {

		// 初期値、購入ボタン押したらbuyItemConfirm.jspに遷移する
		String result = SUCCESS;

		session.put("userGender", userGender);
		session.put("userPostal_code", userPostal_code);
		session.put("userAuthority", userAuthority);

		// Integerクラスは、プリミティブ型intの値をオブジェクトにラップします。Integer型のオブジェクトには、型がintの単一フィールドが含まれます。
		// さらにこのクラスは、intをStringに、Stringをintに変換する各種メソッドや、intの処理時に役立つ定数およびメソッドも提供します。
		// 文字列の引数を解釈し、指定された基数 （数学的記数法の底）の整数値を返します
		// sessionの中のデータを取得してテキストで表す
		int intUserGender = Integer.parseInt(session.get("serGende").toString());
		int intUserPostal_code = Integer.parseInt(session.get("UserPostal_code").toString());
		int intUserAuthority = Integer.parseInt(session.get("UserAuthority").toString());

		String gender0;

		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// もしpayが1と等しい場合
		if (userGender == 0) {

			// paymentに現金払いを代入
			gender0 = "男性";

			// sessionに記憶
			session.put("userGender", gender0);

			// そうでない場合
		} else {

			// paymentにクレジットを代入
			gender0 = "女性";

			// sessionに記憶
			session.put("userGender", gender0);

		}

		String authority0;

		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// もしpayが1と等しい場合
		if (userAuthority == 0) {

			// paymentに現金払いを代入
			authority0 = "一般";

			// sessionに記憶
			session.put("userAuthority", authority0);

			// そうでない場合
		} else {

			// paymentにクレジットを代入
			authority0 = "管理者";

			// sessionに記憶
			session.put("userAuthority", authority0);

		}

		if (userPostal_code >= 0) {

			result = SUCCESS;

		} else {

			result = ERROR;
		}

		// 戻り値
		// 処理結果の内容を上記44行目のresultに渡す
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
/*
	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public int getUserGender() {
		return userGender;

	}
*/
	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setUserGender(int userGender) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.userGender = userGender;

	}
/*
	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public int getUserPostal_code() {
		return userPostal_code;

	}
*/
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
/*
	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public int getUserAuthority() {
		return userAuthority;

	}
*/
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

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったerrorMessageフィールドの値をuserCreateConfirm.jspに渡している
	public String getErrorMessage() {
		return errorMessage;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のerrorMessageフィールドに代入して格納
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;

	}

}
