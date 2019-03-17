package apibank.club.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class BotApplication {

  private static boolean proxy = true;
  private static String proxyHost = "149.56.27.45";
  private static int proxyPort = 1080;

  public static void main(String[] args) {
    ApiContextInitializer.init();
    SpringApplication.run(BotApplication.class, args);

    try {
      TelegramBotsApi botsApi = new TelegramBotsApi(/*
              "src/main/resources/ssl/bot.jks",
              "janjakrusso",
              "https://rif-bot.herokuapp.com",
              "https://rif-bot.herokuapp.com"*/);

      DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
      if(proxy) {
        botOptions.setProxyHost(proxyHost);
        botOptions.setProxyPort(proxyPort);
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
      }
      botsApi.registerBot(new Bot(botOptions));
    } catch (TelegramApiRequestException e) {
      e.printStackTrace();
    }
  }
}