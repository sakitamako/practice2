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
	private String family_name;
	private String last_name;
	private String family_name_kana;
	private String last_name_kana;
	private String mail;
	private String password;
	private int gender;
	private int postal_code;
	private String prefecture;
	private String address_1;
	private String address_2;
	private int authority;

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
		if (!(family_name.equals("")) && !(last_name.equals("")) && !(family_name_kana.equals(""))
				&& !(last_name_kana.equals("")) && !(mail.equals("")) && !(password.equals("")) && !(gender == 0)
				&& !(postal_code == 0) && !(prefecture.equals("")) && !(address_1.equals(""))
				&& !(address_2.equals("")) && !(authority == 0)) {

			// 空文字の部分に値が入っていたらsessionにそれぞれ記憶する
			session.put("family_name", family_name);
			session.put("last_name", last_name);
			session.put("family_name_kana", family_name_kana);
			session.put("last_name_kana", last_name_kana);
			session.put("mail", mail);
			session.put("password", password);
			session.put("gender", gender);
			session.put("postal_code", postal_code);
			session.put("prefecture", prefecture);
			session.put("address_1", address_1);
			session.put("address_2", address_2);
			session.put("authority", authority);

		} else {

			setErrorMessage("未入力の項目があります。");

			// elseの場合エラー
			result = ERROR;

		}

		// Integerクラスは、プリミティブ型intの値をオブジェクトにラップします。Integer型のオブジェクトには、型がintの単一フィールドが含まれます。
		// さらにこのクラスは、intをStringに、Stringをintに変換する各種メソッドや、intの処理時に役立つ定数およびメソッドも提供します。
		// 文字列の引数を解釈し、指定された基数 （数学的記数法の底）の整数値を返します
		// sessionの中のデータを取得してテキストで表す
		String gender0;

		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// もしpayが1と等しい場合
		if (gender == 0) {

			// paymentに現金払いを代入
			gender0 = "男性";

			// sessionに記憶
			session.put("gender", gender0);

			// そうでない場合
		} else {

			// paymentにクレジットを代入
			gender0 = "女性";

			// sessionに記憶
			session.put("gender", gender0);

		}

		// Integerクラスは、プリミティブ型intの値をオブジェクトにラップします。Integer型のオブジェクトには、型がintの単一フィールドが含まれます。
		// さらにこのクラスは、intをStringに、Stringをintに変換する各種メソッドや、intの処理時に役立つ定数およびメソッドも提供します。
		// 文字列の引数を解釈し、指定された基数 （数学的記数法の底）の整数値を返します
		// sessionの中のデータを取得してテキストで表す
		String authority0;

		// int型などのプリミティブ型で２つの値が等しいか比較する場合は”==”演算子で比較しますがString型などの参照型の場合はequalsメソッドで比較する
		// もしpayが1と等しい場合
		if (authority == 0) {

			// paymentに現金払いを代入
			authority0 = "一般";

			// sessionに記憶
			session.put("authority", authority0);

			// そうでない場合
		} else {

			// paymentにクレジットを代入
			authority0 = "管理者";

			// sessionに記憶
			session.put("authority", authority0);

		}

		//戻り値
		//処理結果の内容を上記44行目のresultに渡す
		return result;

	}

	// ・getterは「フィールド値を返却する事だけ」
	// ・setterは「値を更新する事だけ」

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public String getFamily_name() {
		return family_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setFamily_name(String family_name) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.family_name = family_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public String getLast_name() {
		return last_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setLast_name(String last_name) {
		this.last_name = last_name;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public String getFamily_name_kana() {
		return family_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public String getLast_name_kana() {
		return last_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setLast_name_kana(String last_name_kana) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.last_name_kana = last_name_kana;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public String getMail() {
		return mail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setMail(String mail) {
		this.mail = mail;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public String getPassword() {
		return password;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setPassword(String password) {
		this.password = password;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public int getGender() {
		return gender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setGender(int gender) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.gender = gender;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public int getPostal_code() {
		return postal_code;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public String getPrefecture() {
		return prefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取った、loginUserIdフィールドの値をuserCreateConfirm.jspに渡している
	public String getAddress_1() {
		return address_1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のsessionフィールドに代入して格納
	public void setAddress_1(String address_1) {

		// thisという変数を経由して、自分自身のインスタンスのメソッドを呼び出す
		this.address_1 = address_1;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったloginPasswordフィールドの値をuserCreateConfirm.jspに渡している
	public String getAddress_2() {
		return address_2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のloginPasswordフィールドに代入して格納
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// userCreate.jspの値として受け取ったuserNameフィールドの値をuserCreateConfirm.jspに渡している
	public int getAuthority() {
		return authority;

	}

	// フィールド変数に対応したgetterとsetterを定義
	// 全てのクラスのsetの値を自身のuserNameフィールドに代入して格納
	public void setAuthority(int authority) {
		this.authority = authority;

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
