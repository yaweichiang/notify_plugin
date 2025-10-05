package yawei.chiang.notify_plugin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HealthService {
  @Value("${spring.application.name}")
  private String appName;
  
  public String getAppName() {
    return appName;
  }

}
