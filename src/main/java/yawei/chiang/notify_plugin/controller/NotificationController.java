package yawei.chiang.notify_plugin.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yawei.chiang.notify_plugin.model.EmailRequest;
import yawei.chiang.notify_plugin.service.mail.EmailService;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

  @Resource
  private EmailService emailService;

  @PostMapping("/email")
  public void sendEmail(@RequestBody EmailRequest request) {
    emailService.sendMail(request.getTo(), request.getSubject(), request.getContent());
  }

  @GetMapping("/test")
  public void test() {
    System.out.println("test");
//    emailService.sendMail(request.getTo(), request.getSubject(), request.getContent());
  }
}

