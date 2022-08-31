package email;

import java.util.Date;

import org.apache.commons.mail.SimpleEmail;

public class Email {

	/**
	 * 仮メールを送信するメゾット
	 * @param ユーザーname,email,age,address,eventName
	 * @return 
	 */
	public boolean kariyoyaku(String name, String email, int age, String address, String eventName, String confirmationNum, Date eventDate) {
		
		try {
		SimpleEmail sEmail = new SimpleEmail();
		// メールサーバのアドレス
		sEmail.setHostName("");
		// 送信元メールアドレス
			sEmail.setFrom("@gmail.com", "イベント事務局", "ISO-2022-JP");
		// 受信者メールアドレス
		sEmail.addTo(email, name, "ISO-2022-JP");
		// 事務局側メール受け取り
		sEmail.addBcc("@gmail.com", "イベント事務局", "ISO-2022-JP");
		// メッセージ文字コード
		sEmail.setCharset("ISO-2022-JP");
		// 件名と本文
		sEmail.setSubject("仮イベント予約");
		sEmail.setMsg("予約は完了しておりません。\n"
					+ "下記URLより予約が完了します。\n"
					+ "URL"+ "http://localhost:8080/event-reserve/emailRegister"
					+ "予約内容\n"
					+ "予約番号:"+ confirmationNum + "\n"
					+ "氏名:"+ name+ "\n"
					+ "年齢:"+ age+ "\n"
					+ "住所:"+ address+ "\n"
					+ "予約イベント:"+ eventName+ "\n"
					+ "イベント日程:"+ eventDate);
		// 送信
		sEmail.send();
		return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		return false;
		}
		
	}
	
		
	/**
	 * 本メールを送信するメゾット
	 * @param ユーザーemail
	 * @return confirmationNum name
	 */
	public String honyoyaku(String name, String email, int age, String address, String eventName, String confirmationNum, Date eventDate) {
		try {
			SimpleEmail sEmail = new SimpleEmail();
			// メールサーバのアドレス
			sEmail.setHostName("");
			// 送信元メールアドレス
				sEmail.setFrom("@gmail.com", "イベント事務局", "ISO-2022-JP");
			// 受信者メールアドレス
			sEmail.addTo(email, name, "ISO-2022-JP");
			// 事務局側メール受け取り
			sEmail.addBcc("@gmail.com", "イベント事務局", "ISO-2022-JP");
			// メッセージ文字コード
			sEmail.setCharset("ISO-2022-JP");
			// 件名と本文
			sEmail.setSubject("イベント予約");
			sEmail.setMsg("予約が完了しました。\n"
						+ "下記URLより予約をご確認ください。\n"
						+ "URL"+ "http://localhost:8080/event-reserve/reserveConfirmation"
						+ "予約内容\n"
						+ "予約番号:"+ confirmationNum + "\n"
						+ "氏名:"+ name+ "\n"
						+ "年齢:"+ age+ "\n"
						+ "住所:"+ address+ "\n"
						+ "予約イベント:"+ eventName+ "\n"
						+ "イベント日程:"+ eventDate);
			// 送信
			sEmail.send();
			
			} catch (Exception e) {
				// 
				e.printStackTrace();
			}
		//TODO returnで予約番号と名前を返して、サーブレットで自動入力
			return confirmationNum + name;
}
	
}
