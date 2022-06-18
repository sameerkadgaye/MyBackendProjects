/**
 * 
 */
package com.practice.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.practice.constants.Constants;
import com.practice.model.common.ApplicationException;

/**
 * @author SAMEER KADGAYE
 * @version 0.1
 * 
 *          Created Date : 07/10/2021
 * 
 *          Updated Date :
 * 
 *          Updated By :
 *
 */
public class AllUtils {

	static Logger logger = LoggerFactory.getLogger(AllUtils.class);

	public static String getSystemName() throws UnknownHostException, SocketException {
		logger.info("System Name ======>> " + InetAddress.getLocalHost().getHostName());
		return InetAddress.getLocalHost().getHostName();
	}

	public static String getIpAddress() throws UnknownHostException, SocketException {
		logger.info("Ip Address ======>> " + InetAddress.getLocalHost().getHostAddress());
		return InetAddress.getLocalHost().getHostAddress();
	}

	public static String getMacAddress() throws UnknownHostException, SocketException {
		NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
		byte[] mac = network.getHardwareAddress();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		logger.info("Mac Address ======>> " + sb.toString());
		return sb.toString();
	}

	public static String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		logger.info("Current Date ======>> " + formatter.format(date));

		return formatter.format(date).replaceAll("/", "-");
	}

	public static String getCurrentDateYyyyMmDd() throws ParseException {
		String formattedDate = null;
		SimpleDateFormat fromformat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = fromformat.format(new Date());
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formattedDate = myformat.format(fromformat.parse(strDate));
		logger.info("Current Date YYYY-MM-DD======>> " + formattedDate);
		return formattedDate;
	}

	public static String getFormattedDateTime(String stringDate) throws ParseException {
		String formattedDate = null;
		SimpleDateFormat fromformat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Date =========>> " + stringDate);
//		if (!stringDate.equals("null")) {
		formattedDate = myformat.format(fromformat.parse(stringDate));
//		}
		logger.info("Formatted Date ======>> " + formattedDate);
		return formattedDate;
	}

	public static Date getFormattedDate(String stringDate) throws ParseException {
		String formattedDate = null;
		Date d;
		SimpleDateFormat fromformat = new SimpleDateFormat("dd-MM-yyyy");
//		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Date =========>> " + fromformat);
//		if (!stringDate.equals("null")) {
//			formattedDate = myformat.format(fromformat.parse(stringDate));
//		}
		System.out.println("Date =========>> " + formattedDate);
		logger.info("Formatted Date ======>> " + formattedDate);
		d = fromformat.parse(stringDate);
		return d;
	}

	public static Date getFormatDate(String stringDate) throws ParseException {
		String formattedDate = null;
		Date d;
		SimpleDateFormat fromformat = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Date =========>> " + fromformat);
//		if (!stringDate.equals("null")) {
//			formattedDate = myformat.format(fromformat.parse(stringDate));
//		}
		System.out.println("Date =========>> " + formattedDate);
		logger.info("Formatted Date ======>> " + formattedDate);
		d = fromformat.parse(stringDate);
		return d;
	}

	public static Date getFormatDateTime(String stringDate) throws ParseException {
		String formattedDate = null;

		Date d;
		SimpleDateFormat fromformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println("Date =========>> " + stringDate);
//		if (!stringDate.equals("null")) {
//			formattedDate = myformat.format(fromformat.parse(stringDate));
//		}
		logger.info("Formatted Date ======>> " + formattedDate);
		d = fromformat.parse(stringDate);
		return d;
	}

	public static String getFormatSuccessJson(String json) {
		json = json.replace("=", ":");
		Map<String, Object> mainJsonList = new HashMap<String, Object>();
		String[] jsonSplit = json.split(",");
		for (int i = 0; i < jsonSplit.length; i++) {
			if (jsonSplit[i].indexOf("{") != -1) {
				String firstKey = jsonSplit[i].replace("{", "").split(":")[0].trim();
				String formatedFirstKey = "\"" + firstKey + "\"";

				String firstValue = jsonSplit[i].replace("{", "").split(":")[1].trim();
				String formatedFirstValue = "\"" + firstValue + "\"";
				mainJsonList.put(formatedFirstKey, formatedFirstValue);
			} else if (jsonSplit[i].indexOf("}") != -1) {
				String lastKey = jsonSplit[i].replace("}", "").split(":")[0].trim();
				String lastFormattedKey = "\"" + lastKey + "\"";

				String lastValue = jsonSplit[i].replace("}", "").split(":")[1].trim();
				String lastFormattedValue = "\"" + lastValue + "\"";
				mainJsonList.put(lastFormattedKey, lastFormattedValue);
			} else {
				String key = jsonSplit[i].split(":")[0].trim();
				String formattedKey = "\"" + key + "\"";

				String value = jsonSplit[i].split(":")[1].trim();
				String formattedValue = "\"" + value + "\"";
				mainJsonList.put(formattedKey, formattedValue);
			}
		}
		System.out.println(mainJsonList.toString().replace("=", ":"));
		return mainJsonList.toString().replace("=", ":");
	}

	public static String getFormatDocTypeJson(String docJson) {

		Map<String, Object> mainJsonList = new HashMap<String, Object>();

		docJson = docJson.replace("=", ":");
		String[] jsonSplit = docJson.split(",");
		for (int i = 0; i < jsonSplit.length; i++) {
			if (jsonSplit[i].indexOf("{") != -1 && i == 0) {
				String firstKey = jsonSplit[i].replace("{", "").split(":")[0].trim();
				String formatedFirstKey = "\"" + firstKey + "\"";

				String firstValue = jsonSplit[i].replace("{", "").split(":")[1].trim();
				String formatedFirstValue = "\"" + firstValue + "\"";
				mainJsonList.put(formatedFirstKey, formatedFirstValue);
			}

			if (jsonSplit[i].indexOf("{") != -1 && i == 1) {
				String secondKey = jsonSplit[i].replace("{", "").split(":")[0].trim();
				String formatedSecondKey = "\"" + secondKey + "\"";

				String secondValue = docJson.substring(docJson.indexOf("["), docJson.length() - 1);
				mainJsonList.put(formatedSecondKey, secondValue);
			}
		}
		System.out.println(mainJsonList.toString().replace("=", ":"));
		return mainJsonList.toString().replace("=", ":");
	}

	public static String getFormatReceiptJson(String receiptJson) {
		Map<String, Object> mainJsonList = new HashMap<String, Object>();

		receiptJson = receiptJson.replace("=", ":");
		// System.out.println("receiptJson====>>>"+receiptJson);
		String[] jsonSplit = receiptJson.split(",");
		System.out.println("jsonSplit====>>>" + jsonSplit);
		for (int i = 0; i < jsonSplit.length; i++) {
			if (jsonSplit[i].indexOf("{") != -1 && i == 0) {
				String firstKey = jsonSplit[i].replace("{", "").split(":")[0].trim();
				String formatedFirstKey = "\"" + firstKey + "\"";
				System.out.println("jsonSplit after for (i=0)====>>>" + jsonSplit[i]);
				String firstValue = jsonSplit[i].replace("{", "").split(":")[1].trim();
				String formatedFirstValue = "\"" + firstValue + "\"";
				mainJsonList.put(formatedFirstKey, formatedFirstValue);
			}

			if (i == 1) {
				String firstKey = jsonSplit[i].replace("{", "").split(":")[0].trim();
				String formatedFirstKey = "\"" + firstKey + "\"";
				System.out.println("jsonSplit after for (i=1)====>>>" + jsonSplit[i]);
				String firstValue = jsonSplit[i].replace("{", "").split(":")[1].trim();
				String formatedFirstValue = "\"" + firstValue + "\"";
				mainJsonList.put(formatedFirstKey, formatedFirstValue);
			}

			if (jsonSplit[i].indexOf("{") != -1 && i == 2) {
				String secondKey = jsonSplit[i].replace("{", "").split(":")[0].trim();
				String formatedSecondKey = "\"" + secondKey + "\"";
				System.out.println("jsonSplit after for (i=2)====>>>" + jsonSplit[i]);
				String secondValue = receiptJson.substring(receiptJson.indexOf("["), receiptJson.length() - 1);
				mainJsonList.put(formatedSecondKey, secondValue);
			}
		}
		System.out.println("mainJsonList====>>>" + mainJsonList.toString().replace("=", ":"));
		return mainJsonList.toString().replace("=", ":");
	}

//	String toStr = result.toString();
//	String finalJson = "[" + toStr.substring(1, toStr.length() - 1) + "]";
//	JSONDeserializer<Object> deserializer = new JSONDeserializer<Object>();
//	Object deserialize = deserializer.deserialize(finalJson);
//
//	System.out.println("DB Response After ExecuteFunction " + functionName + "====>>> " + deserialize);

//	public static void main(String[] args) throws ParseException, UnknownHostException, SocketException {
//		System.out.println(getCurrentDateYyyyMmDd());
//
//		String ip = getIpAddress();
//		String mac = getMacAddress();
//
//		System.out.println("Ip : " + ip + "    Mac : " + mac);
//	}

	/*-------------------- Send OTP on mail start --------------------*/
	public static String sendEmailOtp(String email) throws ApplicationException {
		System.out.println("email " + email);
		String subject = "Account Approve";
		String text = "Dear Customer your Deposit case has been approved with your deposit amount XYZ. ";
//		String text = "Dear User, \n\n Your One Time Password (OTP) for complete your process is :: " +emailOtp + "\n\n Please Do not share with anyone.\n\n Disclaimer: You have received this mail because you are registered user of MIS Software.\n\n This is a system generated E-mail, Please don't reply to this Mail.!";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("vgiplerp4@gmail.com", "Vgipl@123");// sender username and password
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vgiplerp4@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);

			System.out.println("Email Sent.......");
			return "Success";

		
		} catch (MessagingException e) {
//			throw new RuntimeException(e);
			System.out.println("Messaging Exception ");
			throw new ApplicationException(Constants.ErrorCode, Constants.EmailAddressWrong);
		}
	}
	/*-------------------- Send OTP on mail end --------------------*/

//	 ***************************** Send OTP and Message in mobile No ****************************** 
	public static String sendSmsOtp(String mobNo, String otp) {
		try {
			String message = "Please use " + otp + " as your otp to login - VKSML.";
			// String message ="Dear,प्रल्हाद तुळशिराम साबळे Form No-1234 Serve No -786
			// Reg.Date-31-DEC-2021Area -1.5 Verity -कोसि-६७१ Hangam -पुर्व हंगामी your Cane
			// Registration Successfully.KATSSSK LTD EDPM ";
			// String message = "Hi, Your Self Collect Address for Order id 125 from 789
			// vide Tracking no 785 is: 785. Kindly collect the parcel within 24 hours else
			// it may get returned to the seller. Team Shipyaari.";
			String newmsg = URLEncoder.encode(message, "UTF-8");
			// String peId = "1001177560891875992";
			// String tempId = "1007073339335808053";

			// URL url = new
			// URL("http://smsjust.com/sms/user/urlsms.php?username=vksml&pass=vksml123&senderid=VKSMLL&message="+newmsg+"&dest_mobileno="+mobNo+"&msgtype=TXT&response=Y");
			// URL url = new
			// URL("http://49.50.67.32/smsapi/httpapi.jsp?username=SAMSSK03&password=SAMSSK123&from=KATSSK&to="+mobNo+"&text="+newmsg+"&pe_id=1701159194613433864&template_id=1207160896843395865");
			URL url = new URL(
					"http://smsjust.com/sms/user/urlsms.php?username=vksml&pass=vksml123&senderid=VKSMLL&message="
							+ newmsg + "&dest_mobileno=" + mobNo
							+ "&msgtype=TXT&response=Y&dlttempid=1707163151391930117");
			// URL url = new
			// URL("https://app.indiasms.com/sendsms/sendsms.php?username=VNLSSSSK&password=abc123&type=text&sender=LSSSSK&mobile="+mobNo+"&message="+newmsg+"&type=TEXT&tempid="+tempId+"&peid="+peId);
			// String encodedURL=java.net.URLEncoder.encode(url,"UTF-8");
			System.out.println("message=============" + newmsg);
			System.out.println("URL is============" + url);
			// Send datax
			// HttpURLConnection conn = (HttpURLConnection) new
			// URL("https://api.textlocal.in/send/?").openConnection();
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			System.out.println("Succeeded to connect [" + url.toString() + "]");
			// String data = mobNo + message ;

			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setDefaultUseCaches(false);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.connect();
			// conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			// conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			System.out.println("Message API Response----------------" + stringBuffer.toString());
			rd.close();

			// return stringBuffer.toString();
			return "Success";
			/*
			 * if(stringBuffer.toString() == "Y") { return "Success"; }else { return
			 * "Failed"; }
			 */

		} catch (Exception e) {
			System.out.println("Error SMS " + e);
			return "Error " + e;
		}

	}

//	 ***************************** Send OTP and Message in mobile No End ******************************
	
	public static String sendEmail(String subject, String text, String email) {
		System.out.println("email " + email);
		//String subject = "OTP";
		//String text = "Dear ABC your Deposit case has been approved with your deposit amount XYZ. ";
//		String text = "Dear User, \n\n Your One Time Password (OTP) for complete your process is :: " +emailOtp + "\n\n Please Do not share with anyone.\n\n Disclaimer: You have received this mail because you are registered user of MIS Software.\n\n This is a system generated E-mail, Please don't reply to this Mail.!";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("vgiplerp4@gmail.com", "Vgipl@123");// sender username and password
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vgiplerp4@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);

			System.out.println("Email Sent.......");
			return "Success";

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
