package net.com.dev_web.mail;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.dev_module.model.User;

public class SendMailRegister extends MailConfig implements SendMailI {

	private static final Logger logger = Logger
			.getLogger(SendMailRegister.class);

	public void send(User user) {

		JavaMailSenderImpl config = prepareEmail();

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(user.getEmail());
		message.setSubject(SUBJECT);
		message.setText(createRegisterMsg(user));

		logger.info("Enviando email...");

		config.send(message);

		logger.info("Email enviado.");

	}

	private String createRegisterMsg(User user) {

		String msg = "Prezado(a) Sr(a). " + user.getUserName() + ",<br/> \n ";
		msg += "Agradeço o interesse em nossos serviços, sua conta foi criada com sucesso. Segue os dados cadastrais abaixo: <br/> \n ";
		msg += "Usuário: " + user.getUserName() + "\n";
		msg += "Senha: " + user.getPassword() + "\n"; ;
		msg += "Equipe Quatro Operações agradece pela confiança. ";

		return msg;
	}

}
