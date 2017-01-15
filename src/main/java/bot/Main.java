package bot;

import bot.game.Game;
import bot.game.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
*/
public class Main {
     public static void main(String[] args) throws Exception { //убрать проброс

    /*    ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MartianBot());
            System.out.println("Bot started!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }*/
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите имя: ");
    String playerName = reader.readLine();

    System.out.print("Введите сложность: ");
    int difficulty = Integer.parseInt(reader.readLine());
    int playerNumber;
    int resultOfGame;
    Player player = new Player(playerName);

    Game game = new Game();
    game.setDifficulty(difficulty);
    game.setPlayer(player);
    game.generateImaginedNumber();

    while(true)
    {
        System.out.print("Введите число: ");
        playerNumber = Integer.parseInt(reader.readLine());
        resultOfGame = game.gamePlay(playerNumber);
        if(resultOfGame)
    };

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
