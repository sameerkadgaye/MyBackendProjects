/**
 * 
 */
package com.email.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

/**
 * @author sameer
 *
 */
@Service
public class EmailService {

	/**
	 * 
	 */
	public EmailService() {
	}

	public boolean sendEmail(String subject, String message, String to) {
		boolean f = false;

		String from = "sameer.iceico@gmail.com";
		to = "kadgayesameer@gmail.com";

		// This is responsible to send email...
		// private static void sendEmail(String message, String subject, String to,
		// String from) {

		// Variable for G-Mail
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("Properties" + properties);

		// Setting Host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: To get Session Object....(Anonymous Class used below)
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sameer.iceico@gmail.com", "Mysrksam@123");
			}

		});
		session.setDebug(true);

		// Step 2: Compose The Message [Text, Muti-media, Pdf.. ]
		MimeMessage m = new MimeMessage(session);

		try {
			// from email
			m.setFrom(from);

			// Adding Recipient to message.
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Adding Subject To Message.
			m.setSubject(subject);

			// Adding text to Message
			m.setText(message);

			// send

			// step 3 : send the message using Transport class
			Transport.send(m);

			System.out.println("Finally Mail Sent Successfully......");
			f = true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return f;
	}

	// }

}
