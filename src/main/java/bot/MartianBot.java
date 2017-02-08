package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.*;
import java.util.List;

public class MartianBot extends TelegramLongPollingBot implements Observable  {

    private List<Observer> observers;
    private String msg;
    private String botName;
    private String botToken;
    private FileReader reader;
    private BufferedReader bufferedReader;
    private boolean isGameStart;


    public MartianBot() {
        File f = new File("creds");

        try{
            reader = new FileReader(f);
            bufferedReader = new BufferedReader(reader);
            botName = bufferedReader.readLine();
            botToken = bufferedReader.readLine();
            bufferedReader.close();
            reader.close();
        }
        catch (FileNotFoundException ex) {
            try{bufferedReader.close();
            reader.close();} catch (IOException exx){};
            System.out.println("File not found ex.");
            System.out.println(ex.getMessage());}
        catch (IOException ex) {
            try{bufferedReader.close();
            reader.close();} catch (IOException exx){};
            System.out.println("Can't read a file.");
            System.out.println(ex.getMessage());
        }
        
    }

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
    
    public void handleUpdate(Update update){
        if (update.hasMessage() && update.getMessage().hasText()){
            if (update.getMessage().getText().equals("Start the game!") && !isGameStart)
                //Начинаем игру
            else if (isGameStart) //Продолжаем игру
            else // дефолтный ввод
                }
            
    }

    @Override
    public String getBotUsername() {

        return botName;
    }

    @Override
    public String getBotToken() {
        
        return botToken;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(Observer o) {
        for(Observer observer: observers) observer.update(msg);
    }
}
