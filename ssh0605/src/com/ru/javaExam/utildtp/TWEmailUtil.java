package com.ru.javaExam.utildtp;

import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 邮件发送工具类. <br>
 * 使用方法： <br>
 * 1、获取实例 <br>
 * TWEmailUtil emailUtil = TWEmailUtil.getInstance("mail.topwalk.com", 25, "user@topwalk.com", "user", "password"); <br>
 * TWEmailUtil emailUtil = TWEmailUtil.getInstance("user@topwalk.com", "user", "password"); <br>
 * TWEmailUtil emailUtil = TWEmailUtil.getInstance("配置文件地址"); <br>
 * 配置文件格式：<br>
 * emailserver=邮件服务器地址<br>
 * emailport=服务端口<br>
 * emailaddress=发送人邮箱地址<br>
 * emailuser=发送人用户名<br>
 * emailpwd=发送人密码<br>
 * 2、发送邮件 <br>
 * boolean flag = emailUtil.sendMail("subject主题", "content内容", mailTo收件人地址列表); <br>
 * boolean flag = emailUtil.sendMail("subject主题", "content内容", mailTo收件人地址列表, enclosure附件地址列表); <br>
 * 3、判断邮件发送结果，成功/失败，失败原因 <br>
 * if(flag == true){ <br>
 * System.out.println("邮件发送成功！"); <br>
 * } else { <br>
 * System.out.println("邮件发送失败！失败原因：" + emailUtil.getErrMsg()); <br>
 * }
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * -----------------------------------------------------------------------------
 * <p>
 * 
 */
public class TWEmailUtil {

	private String errMsg;
	private String from;
	private String user;
	private String password;

	private static  Session session;

	private static final String TOP_MAIL_HOST = "mail.topwalk.com";
	private static final int TOP_MAIL_PORT = 25;

	/**
	 * 私有构造方法
	 * 
	 * @param props
	 *            邮件发送服务器配置文件
	 * @param from
	 *            发送人邮箱地址
	 * @param user
	 *            发送人用户名
	 * @param password
	 *            发送人密码
	 */
	private TWEmailUtil(Properties props, String from, String user,
			String password) {
		session = Session.getDefaultInstance(props, null);
		this.setFrom(from);
		this.setUser(user);
		this.setPassword(password);
	}

	/**
	 * 获取邮件发送工具类实例
	 * 
	 * @param host
	 *            邮件服务器地址
	 * @param port
	 *            服务端口
	 * @param from
	 *            发送人邮箱地址
	 * @param user
	 *            发送人用户名
	 * @param password
	 *            发送人密码
	 * @return 邮件工具类对象
	 */
	public static TWEmailUtil getInstance(String host, int port, String from,
			String user, String password) {
		if ((null == host || host.trim().equals(""))
				|| (null == from || from.trim().equals(""))
				|| (null == user || user.trim().equals(""))
				|| (null == password || password.trim().equals(""))) {
			return null;
		}
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.transport.protoco1", "smtp");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		return new TWEmailUtil(props, from, user, password);
	}

	/**
	 * 获取邮件发送工具类实例
	 * 
	 * @param from
	 *            发送人邮箱地址
	 * @param user
	 *            发送人用户名
	 * @param password
	 *            发送人密码
	 * @return 邮件工具类对象
	 */
	public static TWEmailUtil getInstance(String from, String user,
			String password) {
		return getInstance(TOP_MAIL_HOST, TOP_MAIL_PORT, from, user, password);
	}

	/**
	 * 获取邮件发送工具类实例，通过配置文件初始化
	 * 
	 * @param configFile
	 *            配置文件路径<br>
	 *            文件格式：<br>
	 *            host=邮箱服务器地址（可以为空，缺省值mail.topwalk.com） <br>
	 *            port=服务端口（可以为空，缺省值25） <br>
	 *            from=发送人邮箱地址 <br>
	 *            user=发送人邮箱用户名 <br>
	 *            password=发送人邮箱密码 <br>
	 * @return
	 */
	public static TWEmailUtil getInstance(String configFile) {
		Properties props = new Properties();
		try {
			InputStream is = new FileInputStream(configFile);
			props.load(is);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		String host = (String) props.get("emailserver");
		if (null == host) {
			host = TOP_MAIL_HOST;
		}
		String portStr = (String) props.get("emailport");
		int port = (null == portStr) ? TOP_MAIL_PORT : Integer
				.parseInt(portStr);
		String from = (String) props.get("emailaddress");
		String user = (String) props.get("emailuser");
		String password = (String) props.get("emailpwd");
		return getInstance(host, port, from, user, password);
	}

    Logger log = Logger.getLogger(TWEmailUtil.class);
	/**
	 * 邮件发送基础方法（私有方法）
	 * 
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param mailTo
	 *            收件人地址列表
	 * @param mailCc
	 *            抄送人地址列表
	 * @param enclosure
	 *            附件地址列表
	 * @return 返回发送结果
	 * @throws javax.mail.MessagingException
	 * @throws javax.mail.internet.AddressException
	 */
	private boolean sendMailBase(String subject, String content,
			List<String> mailTo, List<String> mailCc, String[] enclosure) throws AddressException, MessagingException {
		log.debug("发送邮件开始");
        if (null == mailTo || mailTo.size() == 0) {
			this.setErrMsg("收件人地址列表不能为空"); 
			return false;
		}
		if (null == this.getSession()) {
			this.setErrMsg("邮件服务器初始化失败");
			return false;
		}

        log.debug("发送邮件2");
		Message msg = new MimeMessage(this.getSession());
			// 设置发件人邮件地址
			msg.setFrom(new InternetAddress(this.getFrom()));

			// 循环加入收件人和抄送人地址
			for (String to : mailTo) {
				if (null == to || to.trim().equals("")) {
					break;
				}
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to));// 添加收件人地址
			}
			if (null != mailCc && mailCc.size() > 0) {
				for (String cc : mailCc) {
					if (cc == null || cc.trim().equals("")) {
						break;
					}
					msg.addRecipient(Message.RecipientType.CC,
							new InternetAddress(cc));// 添加抄送人地址
				}
			}

			// 设置邮件主题
			msg.setSubject(subject);

			// 设置邮件内容
			Multipart part = new MimeMultipart();
			BodyPart body = new MimeBodyPart();
			body.setContent(content, "text/html;charset=UTF-8");
			part.addBodyPart(body);
			if (null != enclosure && enclosure.length > 0) { // 如果有附件，循环添加附加
				for (String element : enclosure) {
					String fileName = element.substring(
							element.indexOf("//") + 1, element.length());
					BASE64Encoder base64 = new BASE64Encoder();
					String gbkName = base64.encode(fileName.getBytes()); // 获取转码后的文件名
					body = new MimeBodyPart();
					FileDataSource source = new FileDataSource(element);
					body.setDataHandler(new DataHandler(source));
					body.setFileName("=?gbk?B?" + gbkName + "?=");
					part.addBodyPart(body);// 添加附件
				}
			}
			msg.setContent(part);

            log.debug("发送邮件2");
			Transport transport = this.getSession().getTransport("smtp");
				// 登录邮箱服务器
            log.debug("发送邮件 user = " + this.getUser() + "  password = " + this.getPassword());
		    //transport.connect(this.getUser(), this.getPassword());
            log.debug("发送邮件  -登陆成功");
			// 发送邮件
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
            log.debug("发送邮件结束");
		return true;
	}

	/**
	 * 发送邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param mailTo
	 *            收件人地址列表
	 * @return 返回发送结果
	 * @throws javax.mail.MessagingException
	 * @throws javax.mail.internet.AddressException
	 */
	public boolean sendMail(String subject, String content, List<String> mailTo) throws AddressException, MessagingException {
		return sendMailBase(subject, content, mailTo, null, null);
	}

	/**
	 * 发送邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * @param mailTo
	 *            收件人地址列表
	 * @param enclosure
	 *            附件地址列表
	 * @return 返回发送结果
	 * @throws javax.mail.MessagingException
	 * @throws javax.mail.internet.AddressException
	 */
	public boolean sendMail(String subject, String content,
			List<String> mailTo, String[] enclosure) throws AddressException, MessagingException {
		return sendMailBase(subject, content, mailTo, null, enclosure);
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public static void main(String[] args) {

		TWEmailUtil emailUtil = TWEmailUtil.getInstance("mail.topwalk.com", 25,
				"hejk@topwalk.com", "hejk@topwalk.com", "hejiakuo**1");
//		TWEmailUtil emailUtil = TWEmailUtil.getInstance("luocw@topwalk.com",
//				"luocw", "******");
		//TWEmailUtil emailUtil = TWEmailUtil.getInstance("/home/luocw/alarmbasicconf.properties");

		List<String> mailTo = new ArrayList<String>();
		mailTo.add("734596703@qq.com");
		mailTo.add("hejiakuo@163.com");

		String[] enclosure = { "/home/luocw/enclosure.txt",
				"/home/luocw/附件.txt", "/home/luocw/程序.txt" };

//		boolean flag = emailUtil.sendMail("测试邮件发送基础类-主题", "测试邮件发送基础类-内容",
//				mailTo, enclosure);

//		boolean flag = emailUtil.sendMail("测试邮件发送基础类-主题", "测试邮件发送基础类-内容",
////				mailTo);
//		if (flag == true) {
//			System.out.println("邮件发送成功！");
//		} else {
//			System.out.println("邮件发送失败！失败原因：" + emailUtil.getErrMsg());
//		}

	}

}
