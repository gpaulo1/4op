package net.com.dev_web.mail;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;

abstract class MailConfig {

	protected static final String HOST = "smtp.gmail.com";
	protected static final Integer PORT = 587;
	protected static final String USERNAME = "4opsystem@gmail.com";
	protected static final String PASSWORD = "159000paulo";
	protected static final String SUBJECT = "Quatro Operações - Sistema de Controle Financeiro";

	private String message;
	private String to;
	private String subject;

	protected JavaMailSenderImpl prepareEmail() {

		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setHost(HOST);
		mail.setPort(PORT);
		mail.setUsername(USERNAME);
		mail.setPassword(PASSWORD);

		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");

		mail.setJavaMailProperties(properties);

		return mail;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
