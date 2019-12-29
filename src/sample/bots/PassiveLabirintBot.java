package sample.bots;

import sample.logic.Direction;
import sample.logic.GameState;
import sample.LabirintPlayer;

public class PassiveLabirintBot implements LabirintPlayer {

    private int mynumber;
    private int count = 0;

    @Override
    public void takeYourNumber(int number) {
        mynumber = number;
    }

    @Override
    public Direction step(GameState gameState) {
        return Direction.NONE;
    }


    @Override
    public String getTeamName() {
        return "PassiveBot";
    }
}
