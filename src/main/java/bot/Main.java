package bot;

import bot.game.Player;

/*
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
*/
public class Main {
     public static void main(String[] args) {

    /*    ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MartianBot());
            System.out.println("Bot started!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }*/
   
    Player pl1 = new Player("1");
    Player pl2 = new Player("2");
    Player pl3 = new Player("3");
    Player pl4 = new Player("4");
    
    System.out.println(
        pl1.getNickName() + " : " + pl1.getID() + "; " + 
        pl2.getNickName() + " : " + pl2.getID() + "; " + 
        pl3.getNickName() + " : " + pl3.getID() + "; " + 
        pl4.getNickName() + " : " + pl4.getID() + "; " );
    }

}
