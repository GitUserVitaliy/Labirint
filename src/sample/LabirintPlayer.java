package sample;

import sample.logic.Direction;
import sample.logic.GameState;

public interface LabirintPlayer {

    //may be -1 or -2
    void takeYourNumber(int number);

    Direction step(GameState gameState);

    String getTeamName();
}
