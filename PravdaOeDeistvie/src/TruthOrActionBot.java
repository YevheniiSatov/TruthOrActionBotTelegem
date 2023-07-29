import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;
public class TruthOrActionBot extends TelegramLongPollingBot {
    private static final String BOT_USERNAME = "@pravda_deistvo_bot";
    private static final String BOT_TOKEN = "6320711387:AAFnN2xpJAEyQWmQwggbeebOUqxbaJlqzgY";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim();
            if ("/truth".equalsIgnoreCase(messageText)) {
                sendRandomQuestion(update.getMessage().getChatId());
            } else if ("/action".equalsIgnoreCase(messageText)) {
                sendRandomAction(update.getMessage().getChatId());
            } else {
                sendResponse(update.getMessage().getChatId(), "Для игры введите /truth или /action");
            }
        }
    }

    private void sendRandomQuestion(Long chatId) {
        int randomIndex = new Random().nextInt(TruthEnum.values().length);
        String question = TruthEnum.values()[randomIndex].getQuestion();
        sendResponse(chatId, question);
    }

    private void sendRandomAction(Long chatId) {
        int randomIndex = new Random().nextInt(ActionEnum.values().length);
        String action = ActionEnum.values()[randomIndex].getAction();
        sendResponse(chatId, action);
    }

    private void sendResponse(Long chatId, String response) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(response);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
