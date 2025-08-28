package yawei.chiang.notify_plugin.service.line;

public interface LineService {

  boolean sendLineMessage(String userId, String message);

  boolean broadcastMessage(String message);

  boolean sendMessage2Developer(String message);

}
