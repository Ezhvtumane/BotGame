package bot;

import bot.game.Game;
import bot.game.Player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.BotSession;
import org.telegram.telegrambots.generics.LongPollingBot;

public class Main implements Observer{

    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception { //убрать проброс

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            LongPollingBot bot = new MartianBot()/*.registerObserver(this)*/;
            botsApi.registerBot(bot);
            System.out.println("Bot started!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        


    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите имя: ");
    String playerName = reader.readLine();
    //String playerName = Main.

    System.out.print("Введите сложность: "); //надо число от 1 до 3!
    
    int difficulty=0;
    boolean isNum=false;
    String str_difficulty;

    do {
        str_difficulty = reader.readLine();
        if(isInteger(str_difficulty)) {
            int d = Integer.parseInt(str_difficulty);
            if(d == 1 || d == 2 || d == 3) {
                difficulty = Integer.parseInt(str_difficulty); isNum=true;}
            else System.out.println("Need to enter a digit from 1 to 3");
        }
        else System.out.print("It's not a number! Enter a digit!\nВведите сложность: ");

    } while(!isInteger(str_difficulty) || !isNum);


    int playerNumber;
    int resultOfGame=2; // подумать что сделать с инициализацией
    Player player = new Player(playerName);

    Game game = new Game();
    game.setDifficulty(difficulty);
    game.setPlayer(player);
    game.generateImaginedNumber();
    System.out.println(game.getImaginedNumber());
    while(resultOfGame != 0)
    {
        System.out.print("Введите целое число: ");
        playerNumber = Integer.parseInt(reader.readLine());
        resultOfGame = game.gamePlay(playerNumber);
        if(resultOfGame == -1) System.out.println("Я загадал больше! Повторите попытку.");
        else if(resultOfGame == 1) System.out.println("Я загадал меньше! Повторите попытку.");
    }

         System.out.println("You're win! "+ game.getImaginedNumber());

/*
    Player pl1 = new Player("1");
    Player pl2 = new Player("2");
    Player pl3 = new Player("3");
    Player pl4 = new Player("4");

    System.out.println(
        pl1.getNickName() + " : " + pl1.getID() + "; " + 
        pl2.getNickName() + " : " + pl2.getID() + "; " + 
        pl3.getNickName() + " : " + pl3.getID() + "; " + 
        pl4.getNickName() + " : " + pl4.getID() + "; " );
        */
    }


    @Override
    public String update(String message) {
        return message;
    }
}
