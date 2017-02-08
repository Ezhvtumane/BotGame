package bot;

import bot.game.Game;
import bot.game.Player;

import java.io.BufferedReader;

public class GameInterface implements Observer {
    
    private BufferedReader reader;
    private String name;
    private int diff, num, d;
    private int counter=0;
    private MartianBot bot;
    private String message;
    private boolean isNameEnter=false
                    , isDiffEnter=false
                    , isNumEnter=false;
    private Game game = new Game();
    private Player player;
    
    public GameInterface(MartianBot bot) {
        this.bot = bot;
        //bot.registerObserver(this);
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public void update(String message) {
        handleUpdate(message);
    }
    
    public void handleUpdate(String message){
        if(!isNameEnter) 
            checkName(message);
        else if (!isDiffEnter)
            checkDifficulty(message);
        else if (!isNumEnter)
            checkNumber(message);
        else 
        {
        bot.sndMsg("Game ended!");
        bot.sndMsg("Your res:\n  name: " + name +"\n  number: " + game.getImaginedNumber()
                    + "\n  attempts: " + counter);
        isNameEnter = false;
        isDiffEnter = false;
        isNumEnter = false;
        counter=0;
        }

        
    }
    
    public void checkName(String message){
        if (!message.equals("")) {
            name = message;
            player = new Player(name);
            game.setPlayer(player);
            isNameEnter=true;
            bot.sndMsg(name);
        }
        //isNameEnter=false; // временная заглушка, чтобы бот отвечал на все сообщения, а не только на первое
    }
    
    public void checkDifficulty(String message){
        if(isInteger(message)){ d = Integer.parseInt(message);
            if(d == 1 || d == 2 || d == 3) {
                diff = d; 
                isDiffEnter=true;
                game.setDifficulty(diff);
                bot.sndMsg("Difficulty: " + game.getDifficulty());
                game.generateImaginedNumber();
                bot.sndMsg("Number: " + game.getImaginedNumber());
            }
            else bot.sndMsg("Need to enter a digit from 1 to 3");
        }
        else bot.sndMsg("It's not a number! Enter a digit!\nВведите сложность: ");
    }
    
    public void checkNumber(String message){
        if (isInteger(message))
        {
            switch (game.gamePlay(Integer.parseInt(message))) {
                case 0 : {
                    bot.sndMsg("You're win! "+game.getImaginedNumber()+"\nEnter any phrase...");
                    isNumEnter=true;
                    counter++;
                    break;
                    }
                case 1 : {bot.sndMsg("Я загадал меньше! Повторите попытку.");counter++;break;}
                case -1: {bot.sndMsg("Я загадал больше! Повторите попытку.");counter++;break;}
                default: bot.sndMsg("Something go wrong! switch in checkNumber");break;
            }
        }
        else bot.sndMsg("It's not a number! Enter a digit!");
         
    }
    
    
    public boolean isInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    
}