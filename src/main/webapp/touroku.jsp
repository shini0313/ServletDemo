<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="ja">
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <link rel="stylesheet" href="static/css/comment.css">
    <link rel="stylesheet" href="static/css/default.css">
  
</head>

<body id="confirm">
    
    <input type="hidden" name="geGeneralTags" id="geServiceId" value="top">
    <input type="hidden" name="geGeneralTags" id="geRegistType" value="Insert">
    <input type="hidden" name="geGeneralTags" id="geRegistStep" value="registration:start">
    <input type="hidden" name="geGeneralTags" id="geErrorType" value="">
    
    <div align="center">
        
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
                <tr>
                    <td width="50%">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tbody>
                                <tr>
                                    <td valign="middle">
                                        <h1 style="margin:5px;padding:0"><a href="#"><img
                                                    src="static/img/logo.png"
                                                    alt="楽天" width="129" height="47" border="0"></a></h1>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>
        
        <table bgcolor="#bf0000" border="0" cellpadding="0" cellspacing="0" width="100%"
            style="display:block; margin-bottom:10px; height: 3px;">
            <tbody>
                <tr>
                    <!-- <td><img src="#" alt="" height="3" width="1"></td> -->
                </tr>
            </tbody>
        </table>
        

    </div>

    <noscript>
        <p class="noJS">
            JavaScriptが無効の為、一部のコンテンツをご利用いただけません。<br>JavaScriptの設定を有効にしてからご利用いただきますようお願いいたします。※JavaScriptの設定方法は<a
                href="#">楽天市場お問い合わせQ&A</a>をご覧ください。</p>
    </noscript>

    <div id="container">
        <form id="formLang1" name="formLang1" action="registfwdi" method="post">
            <input type="hidden" name="lang" value="">
            <input type="hidden" name="service_id" value="top">

        </form>


        <div id="contents">
            <h2 class="path">楽天会員登録</h2>
            <form name="Regist1Form" method="post" action="./test" autocomplete="off">
                <input type="hidden" name="service_id" value="top">


                <div id="step1" class="step">
                    <ol class="clear">
                        <li class="current">会員情報の入力</li>
                        <li>入力内容の確認</li>
                        <li>登録完了</li>
                    </ol>
                </div>

                <h3 class="circle">メールアドレス/ユーザーID/パスワード</h3>
                <table class="address" cellspacing="0" summary="memberInformation1">
                    <tbody>
                        <tr>
                            <th class="headRow" id="email,email2" scope="row"><span class="essential">必須</span>メールアドレス
                            </th>
                            <td>

                                <em>&lt;半角英数字&gt;</em><br>

                                <em>他の会員が登録済みのメールアドレスは登録できません。</em><br>
                                <input type="text" name="email" maxlength="100" size="35" value=""
                                    onchange="email2.value='';" class="text email" title=""
                                    style="color: rgb(153, 153, 153);">
                                <br>
                                <br>
                                <em class="em"><em class="em">確認のためもう一度入力してください（コピー・貼り付けはしないでください。）</em></em><br>
                                <input type="text" name="email2" maxlength="100" size="35" value="" class="text email2" title="" style="color: rgb(153, 153, 153);">
                                <br>
                                <br>
                            </td>
                            <td class="note help">
                                <a class="help"
                                    href="#"></a>
                            </td>
                        </tr>


                        <tr>
                            <th class="headRow" id="u" scope="row"><span class="essential">必須</span>ユーザID</th>
                            <td nowrap="">

                                <em>会員向けサービスにログインするときに使用します。</em><br>
                                <input type="radio" name="radio_mail" value="0" checked="checked">メールアドレスをユーザIDとして使用<br>
                                <br>
                                <input type="radio" name="radio_mail" value="1">メールアドレス以外をユーザIDとして使用<br>

                                <em>&lt;6文字以上・半角英数字&gt; 数字だけにすることはできません</em><br>
                                <div id="user"><input type="text" name="u" maxlength="100" size="50" value=""
                                        class="text userid" title="(例) rakuten1234" style="color: rgb(153, 153, 153);">
                                </div>

                            </td>
                            <td class="note">
                                <a class="help"
                                    href="#"></a>
                            </td>
                        </tr>




                        <tr>
                            <th class="headRow" id="p" scope="row"><span class="essential">必須</span>パスワード</th>
                            <td>
                                <em>&lt;6文字以上半角英数字&gt;</em><br>
                                <em>「ユーザID」と同じものは登録できません</em><br>
                                <em>第三者によるログインを防ぐために、できるだけ複雑なものを設定してください。</em><br>
                                <input type="password" name="p" maxlength="128" size="20" value=""
                                    
                                     id="p_id" title=""><br>


                                <div id="psm_box">
                                    <div class="psm_bar_style">
                                        <div id="psm_bar" style="width: 0%;" class="useless"></div>
                                    </div>
                                    <div id="psm_msg_length" style="display: none;"><img
                                            src="/com/img/id/psm_not_good.jpg" width="10" height="10"
                                            style="margin-right: 5px">パスワードは6文字以上で入力してください。</div>
                                    <div id="psm_msg_userP" style="display: none;"><img
                                            src="/com/img/id/psm_not_good.jpg" width="10" height="10"
                                            style="margin-right: 5px">ユーザIDと同じ文字をパスワードに指定することはできません。</div>
                                    <div id="psm_msg_astrix" style="display: none;"><img
                                            src="/com/img/id/psm_not_good.jpg" width="10" height="10"
                                            style="margin-right: 5px">パスワードにアスタリスク(*)のみを指定することはできません。</div>
                                    <div id="psm_msg_low" style="display: none;"><img src="/com/img/id/psm_good.jpg"
                                            width="10" height="10" style="margin-right: 5px">パスワード強度：低</div>
                                    <div id="psm_msg_lowmid" style="display: none;"><img src="/com/img/id/psm_good.jpg"
                                            width="10" height="10" style="margin-right: 5px">パスワード強度：中低</div>
                                    <div id="psm_msg_mid" style="display: none;"><img src="/com/img/id/psm_good.jpg"
                                            width="10" height="10" style="margin-right: 5px">パスワード強度：中</div>
                                    <div id="psm_msg_high" style="display: none;"><img src="/com/img/id/psm_good.jpg"
                                            width="10" height="10" style="margin-right: 5px">パスワード強度：高</div>
                                    <div id="psm_msg_none" style="display: block;"></div>
                                </div>
                                <br>
                            </td>
                            <td class="note">
                                <a class="help"
                                    href="#"></a>
                            </td>
                        </tr>
                        <input type="hidden" name="p_change" value="0" id="p_change_id">
                        <input type="hidden" name="previous_pm" value="0" id="previous_pm_id">





                    </tbody>
                </table>

                <h3 class="circle">お客様の基本情報</h3>
                <table class="address" cellspacing="0" summary="memberInformation1">
                    <tbody>
                        <tr>
                            <th class="headRow" id="lname,fname" scope="row"><span class="essential">必須</span>氏名</th>
                            <td>
                                <em>入力情報に誤りがあると、パスワード再設定が正しく行えない場合があります。</em><br>
                                <strong><em class="em">ご自身の氏名をお間違えないように登録してください。</em></strong><br>


                                （姓）
                                <input type="text" name="lname" maxlength="85" size="28" value="" class="text name"
                                    title="(例)楽天" style="color: rgb(153, 153, 153);">
                                （名）
                                <input type="text" name="fname" maxlength="85" size="28" value="" class="text name"
                                    title="(例)太郎" style="color: rgb(153, 153, 153);">
                                <br>



                            </td>
                            <td class="note">&nbsp;</td>
                        </tr>

                        <tr>
                            <th class="headRow" id="lname_kana,fname_kana" scope="row"><span
                                    class="essential">必須</span>氏名（フリガナ）</th>
                            <td>
                                <em>&lt;全角カタカナのみ&gt;</em><br>
                                （姓）
                                <input type="text" name="lname_kana" maxlength="85" size="28" value="" class="text name"
                                    title="(例)ラクテン" style="color: rgb(153, 153, 153);">
                                （名）
                                <input type="text" name="fname_kana" maxlength="85" size="28" value="" class="text name"
                                    title="(例)タロウ" style="color: rgb(153, 153, 153);">
                                <br>
                            </td>
                            <td class="note">&nbsp;</td>
                        </tr>
                    </tbody>
                </table>
                <input type="hidden" name="radio_ptype" value="1">
                <input type="hidden" name="other_ptype" value="自宅">
                <table style="display: none">
                    <tbody>
                        <tr style="display:none;">
                            <td>
                                <div id="challenger"><input name="cres" id="cres" type="hidden"
                                        value="66iKJYpWv2lU5ndw"></div>
                                <input type="hidden" name="cid" id="cid" value="">
                                <input type="hidden" name="cpid" id="cpid" value="">
                                <input type="hidden" name="ctid" id="ctid" value="">

                                <link rel="stylesheet"
                                    href="#"
                                    type="text/css" media="all">
                            </td>
                        </tr>




                    </tbody>
                </table>


                <p class="submitNote">
                    楽天会員への登録には、規約および<a target="_blank" href="#">個人情報保護方針</a>への同意が必要です。
                </p>
                
                <p class="submit">
                    <a href="kakunin.jsp">
                          <input type="submit" name="execMethod" value="同意して次へ" onclick="validateAndSubmit(event)">
                             <script>
                                 function validateAndSubmit(event) {
                                     event.preventDefault();

                                     var emailInput = document.querySelector("input[name='email']");
                                     var email2Input = document.querySelector("input[name='email2']");
                                     var userIDInput = document.querySelector("input[name='u']");
                                     var passwordInput = document.querySelector("input[name='p']");
                                     var lnameInput = document.querySelector("input[name='lname']");
                                     var fnameInput = document.querySelector("input[name='fname']");
                                     var lnameKanaInput = document.querySelector("input[name='lname_kana']");
                                     var fnameKanaInput = document.querySelector("input[name='fname_kana']");

                                     var email = emailInput.value.trim();
                                     var email2 = email2Input.value.trim();
                                     var userID = userIDInput.value.trim();
                                     var password = passwordInput.value.trim();
                                     var lname = lnameInput.value.trim();
                                     var fname = fnameInput.value.trim();
                                     var lnameKana = lnameKanaInput.value.trim();
                                     var fnameKana = fnameKanaInput.value.trim();
                                     var form = document.forms["Regist1Form"];
                                
                                     if (email === "" || email2 === "" || userID === "" || password === "" || lname === "" || fname === "" || lnameKana === "" || fnameKana === "") {
                                         alert("全ての項目は必須です");
                                         return;
                                     }

                                     var emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$/;
                                     if (!emailRegex.test(email)) {
                                         alert("正しいメールアドレスのフォーマットを入力してください");
                                         return;
                                     }

                                     if (email !== email2) {
                                         alert("メールアドレスが一致しません");
                                         return;
                                     }

                                     if (userID.length < 6) {
                                         alert("ユーザーIDの長さは6文字以上である必要があります");
                                         return;
                                     }
                                     var alphanumericRegex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]+$/;
                                     if (!alphanumericRegex.test(userID)) {
                                         alert("ユーザーIDはアルファベットと数字を少なくとも1つ含む必要があります");
                                         return;
                                     }

                                     if (password.length < 6) {
                                         alert("パスワードは6文字以上で入力してください");
                                         return;
                                     }

                                     var katakanaRegex = /^[\u30A0-\u30FF\s]+$/;
                                     if (!katakanaRegex.test(lnameKana) || !katakanaRegex.test(fnameKana)) {
                                         alert("氏名（フリガナ）は全角カタカナで入力してください");
                                         return;
                                     }
                                    
                                     document.forms["Regist1Form"].submit();
                                    
                                 }
                           </script>
                    </a>
                </p>
                
                
            </form>
        </div>
    </div>

    
</body>
</html>