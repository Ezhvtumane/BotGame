package bot.game;

public class Player {

    private String     nickName;
    private final int  ID;
    private static int idCounter = 1;

    public Player(String nickName) {
        this.nickName = nickName;
        this.ID = idCounter;
        idCounter++;
    }

    public String getNickName() {
        return nickName;
    }

    public int getID() {
        return ID;
    }

    int getIdCounter() {
        return idCounter;
    }

}
