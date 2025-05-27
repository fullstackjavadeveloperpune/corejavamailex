package com.fullstack;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailEx {

	public static void main(String[] args) throws AddressException, MessagingException {

		String fromEmail = "jadhavkiran2011@gmail.com";
		String toEmail = "fullstackjavadeveloperpune@gmail.com";
		String password = System.getProperty("EMAIL_PASS");

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);

		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
		message.setSubject("Congratulations!!!");
		message.setText("WELCOME TO FULL STACK JAVA DEVELOPER, PUNE");
		Transport.send(message);
		System.out.println("Mail Sent Successfully");

	}

}
