package yawei.chiang.notify_plugin.service.mail;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

  @Resource
  private JavaMailSender mailSender;
  Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);


  @Override
  public boolean sendMail(String to, String subject, String content) {
    boolean result = false;
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);
    try {
      mailSender.send(message);
      result = true;
    } catch (Exception e) {
      logger.error("send mail error. to:{},subject:{} ", to, subject, e);
    }
    return result;
  }

  @Override
  public boolean sendHtmlMail(String to, String subject, String content) {
    boolean result = false;
    try {
      // 實現 HTML 郵件發送
      result = true;
    } catch (Exception e) {
      logger.error("send html mail error.", e);
    }
    return result;
  }
}
