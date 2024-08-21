<!-- このファイルが通常のHTMLファイルではなく、JSPであることを示している -->
<!-- strutsタグ（下の補足参照）を使用する際に記述します。ここでは”s”としてタグを使用 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- ユーザー登録機能 -->
<!DOCTYPE html>
<html>
    <head>
    <!-- 実務で必要になる、検索エンジンに引っかかりやすくなる、どういうコード入力すればより便利になるか -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <meta http-equiv="Content-Script-Type" content="text/javascript" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <title>UserCreateConfirm画面</title>

        <style type="text/css">

/*  TAG LAYOUT  */

body {
    margin: 0;
    padding: 200px;
    line-height: 1.6;
    letter-spacing: 1px;
    font-family: Verdana, Helvetica, sans-serif;
    font-size: 20px;
    color: #333;
    background: #fff;
}

body input {
    border: 1px solid #333;
}

table {
    text-align: center;
    margin: 0 auto;
}

/*  ID LAYOUT  */

#top {
    width: 100%;
    margin-left: 0px;
}

#header {
    width: 100%;
}

#main {
    width: 100%;
    text-align: center;
    border-right: 1px solid #333;
    border-left: 1px solid #333;
}

#main h3 {
    width: 100%;
    text-align: left;
    margin-left: 100px;
}

#main p {
    width: 100%;
    font-size: 20px;
    text-align: center;
    border-top: 1px solid #333;
    border-bottom: 1px solid #333;
    padding-top: 10px;
    padding-bottom: 10px;
}

#main a {
    width: 1000px;
    border: 1px solid #333;
    color: #333;
    padding: 10px;
}

        </style>
    </head>
    <body>
        <div id="header">
            <div id="pr"></div>
        </div>
        <h1>アカウント登録確認画面</h1>
        <div id="main">
            <div id="top">
                <p>ナビゲーションバー</p>
                <h3>アカウント登録確認画面</h3>
            </div>
            <div>
                <table>
                    <s:form action="UserCreateCompleteAction">
                        <tr id="box">
                            <td>
                                <label>名前（姓）</label>
                            </td>
                            <td>
                                <s:property value="UserName1" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>名前（名）</label>
                            </td>
                            <td>
                                <s:property value="UserUnderName1" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>カナ（姓）</label>
                            </td>
                            <td>
                                <s:property value="UserName2" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>カナ（名）</label>
                            </td>
                            <td>
                                <s:property value="UserUnderName2" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>メールアドレス</label>
                            </td>
                            <td>
                                <s:property value="UserMail" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>パスワード</label>
                            </td>
                            <td>
                                <s:property value="UserPassword" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>性別</label>
                            </td>
                            <td>
                                <s:property value="" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>郵便番号</label>
                            </td>
                            <td>
                                <s:property value="PostCode" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>住所（都道府県）</label>
                            </td>
                            <td>
                                <s:property value="Prefectures" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>住所（市区町村）</label>
                            </td>
                            <td>
                                <s:property value="Municipalities" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>住所（番地）</label>
                            </td>
                            <td>
                                <s:property value="StreetAddress" escape="false" />
                            </td>
                        </tr>
                        <tr id="box">
                            <td>
                                <label>アカウント権限</label>
                            </td>
                            <td>
                                <s:property value="UserAuthority" escape="false" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <a href='<s:url action="UserCreateConfirmAction" />'>前に戻る</a>
                                <input type="button" value="前に戻る" onclick="submitAction('UserCreateConfirmAction')" />
                                <a href='<s:url action="UserCreateCompleteAction" />'>登録する</a>
                                <input type="button" value="登録する" onclick="submitAction('UserCreateCompleteAction')" />
                            </td>
                        </tr>
                    </s:form>
                </table>
            </div>
            <p>フッター</p>
        </div>
        <div id="footer">
            <div id="pr"></div>
        </div>
    </body>
</html>