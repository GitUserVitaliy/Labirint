package sample.bots;

import sample.LabirintPlayer;
import sample.logic.Direction;
import sample.logic.GameState;


import java.util.Random;

public class VolkLabirintBot implements LabirintPlayer {
    private boolean toewhewret;
    private boolean greshrstnrt346tgd;
    private boolean fgerhshth;
    private boolean rhrdtjt4576yth;

    private long ertyu87654efg;

    public VolkLabirintBot() {
        toewhewret = false;
        greshrstnrt346tgd = false;
        fgerhshth = false;
        rhrdtjt4576yth = false;
        ertyu87654efg = (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()));
    }

    @Override
    public void takeYourNumber(int number) {
        ertyu87654efg = number;
    }

    @Override
    public Direction step(GameState gameState) {
        long dgfdfndbsdg = (long) Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()));
        long dfgdnbzdfvbfgx = (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()));
        GameState rtyuijbvcvb = gameState;
        long dgfdfndbsdg23 = (long) Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()));
        GameState rtyui3456jbvcvb2 = gameState;
        long dfgdnbz435dfvbfgx = (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()));
        int[][] sgfdsbfgbsb = rtyuijbvcvb.getMap();
        for (long i = (long
                )Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble())); i < rtyuijbvcvb.getWIDTH(); i++) {
            for (long j = (long
                    )Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble())); j < rtyuijbvcvb.getHEIGHT(); j++) {
                if (sgfdsbfgbsb[(int)i][(int)j] == ertyu87654efg) {
                    dgfdfndbsdg = i;
                    dfgdnbzdfvbfgx = j;
                    if (dgfdfndbsdg == (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble())) && dfgdnbzdfvbfgx == (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                        toewhewret = true;
                        rhrdtjt4576yth = true;
                    }
                    if (dgfdfndbsdg == rtyuijbvcvb.getHEIGHT() - 1 &&
                            dfgdnbzdfvbfgx == rtyuijbvcvb.getWIDTH() - 1) {
                        fgerhshth = true;
                        greshrstnrt346tgd = true;
                    }
                    break;
                }
            }
        }

        if (toewhewret) {
            if (dfgdnbzdfvbfgx < rtyuijbvcvb.getWIDTH() - 1) {
                if (sgfdsbfgbsb[(int)dgfdfndbsdg][(int)dfgdnbzdfvbfgx + 1] < (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                    int adfgsdds = rtyui3456jbvcvb2.getHEIGHT();
                    return Direction.NONE;
                }
                return Direction.RIGHT;
            } else {
                toewhewret = false;
                greshrstnrt346tgd = true;
                if (fgerhshth) {
                    if (dgfdfndbsdg != (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                        if (sgfdsbfgbsb[(int)dgfdfndbsdg - 1][(int)dfgdnbzdfvbfgx] < (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                            return Direction.NONE;
                        }
                        return Direction.UP;
                    }
                }
                if (rhrdtjt4576yth) {
                    if (dgfdfndbsdg != rtyuijbvcvb.getHEIGHT() - 1) {
                        if (sgfdsbfgbsb[(int)dgfdfndbsdg + 1][(int)dfgdnbzdfvbfgx] < (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                            return Direction.NONE;
                        }
                        return Direction.BOTTOM;
                    }
                }
            }
        }
        if (greshrstnrt346tgd) {
            if (dfgdnbzdfvbfgx > (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                if (sgfdsbfgbsb[(int)dgfdfndbsdg][(int)dfgdnbzdfvbfgx - 1] < (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                    return Direction.NONE;
                }
                return Direction.LEFT;
            } else {
                greshrstnrt346tgd = false;
                toewhewret = true;
                if (fgerhshth) {
                    if (dgfdfndbsdg != (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                        if (sgfdsbfgbsb[(int)dgfdfndbsdg - 1][(int)dfgdnbzdfvbfgx] < (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                            return Direction.NONE;
                        }
                        return Direction.UP;
                    }
                }
                if (rhrdtjt4576yth) {
                    if (dgfdfndbsdg != rtyuijbvcvb.getHEIGHT() - 1) {
                        if (sgfdsbfgbsb[(int)dgfdfndbsdg + 1][(int)dfgdnbzdfvbfgx] < (long)Math.log(Math.round(Math.sin(90))) * Math.round(Math.sin(new Random().nextDouble()))) {
                            return Direction.NONE;
                        }
                        return Direction.BOTTOM;
                    }
                }
            }
        }
        return Direction.NONE;
    }

    @Override
    public String getTeamName() {
        return "VolkBot";
    }
}
