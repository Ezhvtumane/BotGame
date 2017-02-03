package bot;

import bot.Observer;

/**
 * Created by Goshan on 03.02.2017.
 */
public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver(Observer o);
}
