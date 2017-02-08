package bot;

import java.io.BufferedReader;

public class GameInterface implements Observer {
    
    private BufferedReader reader;
    private String name;
    private int diff, num;
    private MartianBot bot;
    private String message;
    private boolean isNameEnter=false
                    , isDiffEnter=false
                    , isNumEnter=false;
    
    public GameInterface(MartianBot bot) {
        this.bot = bot;
        //bot.registerObserver(this);
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public void update(String message) {
        this.message = message;
        handleUpdate();
    }
    
    public void handleUpdate(){
        if(!isNameEnter) 
            checkName();
        else if (!isDiffEnter)
            checkDifficulty();
        else if (!isNumEnter)
            checkNumber();
        
    }
    
    public void checkName(){
        if (!this.message.equals("")) {
            this.name = this.message;
            isNameEnter=true;
            bot.sndMsg(this.name);
        }
        isNameEnter=false; // временная заглушка, чтобы бот отвечал на все сообщения, а не только на первое
    }
    
    public void checkDifficulty(){
        
    }
    
    public void checkNumber(){
        
    }
    
}