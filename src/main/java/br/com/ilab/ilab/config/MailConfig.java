package br.com.ilab.ilab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("email CLIENTE");
		message.setTo(para);
		message.setSubject(assunto);
		message.setText("NOME DA EMPRESA: \n"  + texto + "\n\n SLOGAN DA EMPRESA PARA APARECER CORPO DO EMAIL");
		javaMailSender.send(message);
		
	}

}
