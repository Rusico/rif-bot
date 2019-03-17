package apibank.club.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Bot extends TelegramLongPollingBot {
  private static Logger logger = LoggerFactory.getLogger(Bot.class);

  private String token = "833516765:AAEqVBbecQ1gYgJb8TcfGxPrOSjrjdj_DB8";

  public Bot(DefaultBotOptions options) {
    super(options);
  }

  public void onUpdateReceived(Update update) {
    try {
      logger.debug("TRY GET MESSAGE");
      if(update.hasMessage() && update.getMessage().hasText()) {
        Message inMessage = update.getMessage();

        logger.debug("TAKE MESSAGE "+inMessage.getText());

        SendMessage outMessage = new SendMessage();
        outMessage.setChatId(inMessage.getChatId());
        outMessage.setText(inMessage.getText());
        execute(outMessage);

        logger.debug("SENT MESSAGE "+inMessage.getText());
      }else logger.debug("NOT ANOTH MESSAGE");
    } catch (TelegramApiException e) {
      logger.error(e.getMessage(), e);
    }
  }

  public String getBotUsername() {
    return "RusicoBot";
  }

  public String getBotToken() {
    return token;
  }
}
