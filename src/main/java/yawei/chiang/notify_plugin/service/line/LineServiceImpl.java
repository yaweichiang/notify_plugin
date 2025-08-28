package yawei.chiang.notify_plugin.service.line;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Broadcast;
import com.linecorp.bot.model.PushMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import jakarta.annotation.Resource;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LineServiceImpl implements LineService {

  @Resource
  private LineMessagingClient lineMessagingClient;
  @Value("${line.userId}")
  private String developerUserId;

  Logger logger = LoggerFactory.getLogger(LineServiceImpl.class);

  @Override
  public boolean sendLineMessage(String userId, String message) {
    boolean result = false;
    try {
      if (userId == null || userId.isEmpty()) {
        throw new Exception("userId is null or empty");
      }
      TextMessage textMessage = new TextMessage(message);
      lineMessagingClient.pushMessage(new PushMessage(userId, textMessage));
      result = true;
    } catch (Exception e) {
      logger.error("sendLineMessage error: " + e.getMessage());
    }
    return result;

  }

  @Override
  public boolean broadcastMessage(String message) {
    boolean result = false;
    try {
      // 建立文字訊息
      TextMessage textMessage = new TextMessage(message);

      // 廣播給所有追蹤您官方帳號的使用者
      BotApiResponse response = lineMessagingClient.broadcast(
          new Broadcast(Collections.singletonList(textMessage))
      ).get();
      result = true;
    } catch (Exception e) {
      logger.error("broadcastMessage error: " + e.getMessage());
    }
    return result;
  }

  @Override
  public boolean sendMessage2Developer(String message) {
    boolean result = sendLineMessage(developerUserId, message);
    return result;

  }
}
