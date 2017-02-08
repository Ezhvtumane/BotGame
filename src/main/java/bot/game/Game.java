package bot.game;

public class Game {

    private Player player;
    private int    difficulty;
    private int    imaginedNumber;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getImaginedNumber() {
        return imaginedNumber;
    }

    public Game generateImaginedNumber(/*int difficulty*/) {//генерируем псевдослучайное число

        if (difficulty == 1)
            this.imaginedNumber = (int)(Math.random() * 10);
        else {
            if (difficulty == 2)
                this.imaginedNumber = (int)(Math.random() * 100);
            else
                this.imaginedNumber = (int)(Math.random() * 1000);
        }
        
        return this;
    }

    public int gamePlay(int playerNumber) { // прошло число проверку или нет, и соответствующий вывод
    
    if(playerNumber == this.imaginedNumber) // простой тип, сравниваем ==
        return 0;
        else {
            if(playerNumber > this.imaginedNumber) return 1;
            else return -1;
        }

    }

}
