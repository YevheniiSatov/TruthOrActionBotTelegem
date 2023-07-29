/*
@autor Yevhenii Shatov
@dDate 29.07.2023
@github https://github.com/YevheniiSatov
 */

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TruthOrActionBot());
            System.out.println("Truth or Action Bot is up and running!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
