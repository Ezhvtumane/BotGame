package bot;

public class GameInterface implements Observer{
    
    private BufferedReader reader;
    private String name;
    private MartianBot bot;
    
    public GameInterface(MartianBot bot) {
        this.bot = bot;
        bot.registerObserver(this);
    }
    
    public String getName(){
        return "";
    }
    
    @Override
    public String update(String message) {
        return message;
    }
}