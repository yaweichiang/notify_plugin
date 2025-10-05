package yawei.chiang.notify_plugin.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yawei.chiang.notify_plugin.service.HealthService;

@RestController
@RequestMapping("/api/notify/health")
public class HealthController {
  @Resource
  private HealthService healthService;
  @GetMapping("/checkInfo")
  public String test() {
    return healthService.getAppName();
  }
}
