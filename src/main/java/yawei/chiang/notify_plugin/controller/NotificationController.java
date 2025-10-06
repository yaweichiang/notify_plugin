package yawei.chiang.notify_plugin.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yawei.chiang.notify_plugin.model.EmailRequest;
import yawei.chiang.notify_plugin.model.LineRequest;
import yawei.chiang.notify_plugin.service.line.LineService;
import yawei.chiang.notify_plugin.service.line.LineServiceImpl;
import yawei.chiang.notify_plugin.service.mail.EmailService;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

  @Resource
  private EmailService emailService;
  @Resource
  private LineService lineService;
  @Autowired
  private LineServiceImpl lineServiceImpl;

  /**
   * 發送email
   * @param request
   */
  @PostMapping("/mail")
  public void sendEmail(@RequestBody EmailRequest request) {
    emailService.sendMail(request.getTo(), request.getSubject(), request.getContent());
  }

  /**
   * 發送訊息給指定 line user
   * @param request
   */
  @PostMapping("/line/message")
  public void sendLineMsg(@RequestBody LineRequest request) {
    lineService.sendLineMessage(request.getUserId(), request.getMessage());
  }

  /**
   * 發送群發訊息給 NotifyHub 訂閱者
   * @param request
   */
  @PostMapping("/line/broadcast")
  public void sendBroadcast(@RequestBody LineRequest request) {
    lineService.broadcastMessage(request.getMessage());
  }
}

