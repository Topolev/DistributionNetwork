package by.topolev.network.service;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import by.topolev.network.classes.Mail;
@Service
public class MailSenderServiceImpl implements MailSenderService{
	private final static Logger LOGGER = LoggerFactory.getLogger(MailSenderServiceImpl.class);
	@Autowired
	private MailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;
	
	private Map<String, String> data;
	
	@Override
	public boolean sendMail(Mail mail){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getMailFrom());
		message.setTo(mail.getMailTo());
		message.setSubject(mail.getMailSubject());
		message.setText(mail.getMailContent());
		try{
			mailSender.send(message);
			return true;
		} catch (MailException ex){
			LOGGER.debug("The sending message is failed", ex);
			LOGGER.info("The sending message is failed");
			return false;
		}
	}
	
}
