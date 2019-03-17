package apibank.club.bot;

import lombok.extern.log4j.Log4j;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Log4j
public class BotResource extends TelegramLongPollingBot {

	private static final String TOKEN = "833516765:AAEqVBbecQ1gYgJb8TcfGxPrOSjrjdj_DB8";
	private static final String NAME = "RusicoBot";

	public BotResource(DefaultBotOptions options) {
		super(options);
	}

	@Override
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		log.info("received mesasge '" + message.getText() + "'. user id: "
				+ message.getChat().getId() + " "
				+ message.getChat().getFirstName() + " "
				+ message.getChat().getLastName());
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(message.getChatId());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText("OK! " + message.getText());
		sndMessage(sendMessage);

	}

	public void sndMessage(SendMessage messageToSend) {
		try {
			if (messageToSend != null) {
				Message execute = execute(messageToSend);// Call method to send the message
				log.info("Message sent " + execute.getText());
			}
		} catch (TelegramApiException e) {
			log.error("Error while sending message", e);
		}
	}

	@Override
	public String getBotUsername() {
		return NAME;
	}

	@Override
	public String getBotToken() {
		return TOKEN;
	}
}
