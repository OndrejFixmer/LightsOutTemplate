package cz.educanet.lights.out;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {
    int zpocitejTo = 0;
    boolean work = true;
    boolean[][] arr = new boolean[5][5];

    @Override
    public int getMoveCount() {
        return zpocitejTo;
    }

    @Override
    public boolean isGameOver() {
        int booleanPocitat = 0;
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (getGrid()[j][i]) {
                    booleanPocitat++;
                }
            }
        }
        if (booleanPocitat == 20) return true;
        return false;
    }

    @Override
    public boolean[][] getGrid() {
        Random rd = new Random();
        if (work) {
            for (int j = 0; j < arr.length; j++) {
                for (int i = 0; i < arr.length; i++) {

                    arr[j][i] = rd.nextBoolean();
                }

            }
            work = false;//chapete? protoze to nefunguje XDXDXDXD (update funguje)
        }
        return arr;
    }

    @Override
    public void makeMove(int x, int y) {
        arr[x][y] = !arr[x][y];

        if (x - 1 > -1) {
            arr[x - 1][y] = !arr[x - 1][y];
        }

        if (x + 1 < 5) {
            arr[x + 1][y] = !arr[x + 1][y];
        }

        if (y - 1 > -1) {
            arr[x][y - 1] = !arr[x][y - 1];
        }

        if (y + 1 < 5) {
            arr[x][y + 1] = !arr[x][y + 1];
        }

        System.out.println(x);
        System.out.println(y);
        zpocitejTo++;
    }
}