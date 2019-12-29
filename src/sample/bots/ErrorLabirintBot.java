package sample.bots;

import sample.LabirintPlayer;
import sample.logic.Direction;
import sample.logic.GameState;

public class ErrorLabirintBot implements LabirintPlayer {
    private int mynumber;
    private int count = 0;

    @Override
    public void takeYourNumber(int number) {
        mynumber = number;
        System.out.println(mynumber);
    }
    Boolean t = true;
    @Override
    public Direction step(GameState gameState) {
        int posX = 0, posY = 0;
        int[][] map = gameState.getMap();
        for (int i = 0; i < gameState.getHEIGHT(); i++) {
            for (int j = 0; j < gameState.getWIDTH(); j++) {
                if (map[i][j] == mynumber) {
                    posX = j;
                    posY = i;
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }

        for (int i = 0; i < gameState.getHEIGHT(); i++) {
            for (int j = 0; j < gameState.getWIDTH(); j++) {
                if (map[i][j] == -2) {
                    posX = j;
                    posY = i;
                    System.out.println(i + " " + j);
                    break;
                }
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                map[posX][posY] = -2;
                map[i][j]=0;
            }
        }

        map[5][5]=9;
        map[5][6] = mynumber;
        if(t == true){
            t = false;
            return Direction.LEFT;
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                map[posX][posY] = -2;
                map[i][j]=-1;
            }
        }
        return Direction.NONE;
        }

    @Override
    public String getTeamName() {
        return "a";
    }
}

//ErrorLabirintBot