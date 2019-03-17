package apibank.club.bot;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Log4j
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	private static boolean proxy = true;
	private static String proxyHost = "149.56.27.45";
	private static int proxyPort = 1080;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		log.info("Initialize Api Context...");
		ApiContextInitializer.init();
		log.info("Done!");

		log.info("Instantiate Telegram Bots API...");
		TelegramBotsApi botsApi = null;
		botsApi = new TelegramBotsApi();
		log.info("Done!");

		log.info("Register our bot...");
		try {
			DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
			if (proxy) {
				botOptions.setProxyHost(proxyHost);
				botOptions.setProxyPort(proxyPort);
				botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
			}
			botsApi.registerBot(new BotResource(botOptions));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		log.info("Done!");
		log.info("All done!");
	}
}
