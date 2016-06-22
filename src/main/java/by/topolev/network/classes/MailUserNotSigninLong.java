package by.topolev.network.classes;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MailUserNotSigninLong extends MailVelocity {

	@Resource(name = "velocityEngine")
	protected VelocityEngine velocityEngine;

	private static final Logger LOGGER = LoggerFactory.getLogger(MailVelocity.class);

	protected String mailFrom = "i.topolev.vladimir@mail.ru";

	protected String mailSubject = "Distribution Network";

	protected String nameTemplate = "templateUserNotSigninLong.vm";

	@Override
	public String getMailContent() {

		StringWriter stringWriter = new StringWriter();
		try {
			Template template = velocityEngine.getTemplate("./emails/" + nameTemplate);
			VelocityContext velocityContext = new VelocityContext();
			if (data != null) {
				for (Map.Entry<String, String> entry : data.entrySet()) {
					LOGGER.debug("key: " + entry.getKey() + " value: " + entry.getValue());
					velocityContext.put(entry.getKey(), entry.getValue());
				}
			}
			template.merge(velocityContext, stringWriter);
		} catch (ResourceNotFoundException ex) {
			LOGGER.debug("Problem with create emplatemessage", ex);
		}
		return stringWriter.toString();
	}

}
