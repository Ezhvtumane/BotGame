package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MartianBot extends TelegramLongPollingBot {
    /*
     * 25.01.2017
     * Надо написать метод, который будет пробрасывать сообщения пользователя в main.
     * 
     * И наоборот.
     * 
     * Игра в main, в боте просто обработка команд.
     * 
     */
     @Override
    public void onUpdateReceived(Update update) {
         // We check if the update has a message and the message has text
    if (update.hasMessage() && update.getMessage().hasText()) {
        SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                .setChatId(update.getMessage().getChatId())
                .setText("You told: \"" + update.getMessage().getText()+"\"");
        SendMessage msgTel = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                //.setText(update.getMessage().getText());
                .setText("Your nickname is: "+update.getMessage().getFrom().getUserName());

        try {
            sendMessage(message); // Call method to send the message
            sendMessage(msgTel);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public String getBotUsername() {

        return "martian_bot";
    }

    @Override
    public String getBotToken() {
        
        return "170619718:AAHU66vGV8xLQ60qXgPKD0KO8ezLWBl7-gQ";
    }
}
