package apibank.club.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class BotApplication {

  public static void main(String[] args) {
    SpringApplication.run(BotApplication.class, args);
    ApiContextInitializer.init();

    TelegramBotsApi botsApi = new TelegramBotsApi();
    try {
      DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
      botOptions.setProxyHost("149.56.27.45");
      botOptions.setProxyPort(1080);
      botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
      botsApi.registerBot(new Bot(botOptions));
    } catch (TelegramApiRequestException e) {
      e.printStackTrace();
    }
  }
}