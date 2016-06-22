package by.topolev.network.quartz;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.topolev.network.classes.MailUserNotSigninLong;
import by.topolev.network.dao.UserDao;
import by.topolev.network.domain.User;
import by.topolev.network.service.MailSenderService;
import by.topolev.network.service.UserService;

public class NotificationMsg4InactiveUserJob implements Job {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationMsg4InactiveUserJob.class);
	@Resource
	private UserService userService;

	@Resource
	private UserDao userDao;

	@Resource
	private MailSenderService mailSenderService;

	@Resource
	private MailUserNotSigninLong mail;

	private static final long MAX_TIME_IDENTITY_USER_NOT_SIGIN_LONG = 10 * 1000;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LOGGER.debug("START job SendMesageUnactiveUserJob");
		List<User> list = userDao.findUsersNotSigninMore(MAX_TIME_IDENTITY_USER_NOT_SIGIN_LONG);
		LOGGER.debug("Quantity User not sigin long: " + list.size());
		for (User user : list) {
			if (!user.isMarkNotificationInactive()) {
				LOGGER.debug("User not signin:" + user.getEmail());
				mail.setMailTo(user.getEmail());

				Map<String, String> map = new HashMap<>();
				SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
				map.put("firstName", user.getUsername());
				map.put("dataLastSignin", sm.format(user.getLastSignin()));
				mail.setData(map);

				LOGGER.debug("CONTENT MESSAGE:" + mail.getMailContent());

				mailSenderService.sendMail(mail);
				user.setMarkNotificationInactive(true);
				userService.updateUser(user);
			}
		}

	}

}
