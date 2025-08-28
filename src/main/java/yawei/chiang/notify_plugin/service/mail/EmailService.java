package yawei.chiang.notify_plugin.service.mail;

public interface EmailService {

  boolean sendMail(String to, String subject, String content);

  boolean sendHtmlMail(String to, String subject, String content);
}
