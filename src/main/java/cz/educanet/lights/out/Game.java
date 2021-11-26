package cz.educanet.lights.out;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {
    int count = 0;
    boolean ano = true;
    boolean[][] arr = new boolean[5][5];

    @Override
    public int getMoveCount() {
        return count;
    }

    @Override
    public boolean isGameOver() {
        int boolCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (getGrid()[i][j]) {
                    boolCount++;
                }
            }
        }
        if (boolCount == 25) return true;
        return false;
    }

    @Override
    public boolean[][] getGrid() {
        Random rd = new Random();
        if (ano) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = rd.nextBoolean();
                }
            }
            ano = false;
        }
        return arr;
    }



    @Override
    public void makeMove(int x, int y) {
        arr[x][y] = !arr[x][y];

        if (x + 1 < 5){
            arr[x + 1][y] = !arr[x + 1][y];
        }
        if (x - 1 > -1){
            arr[x - 1][y] = !arr[x - 1][y];
        }
        if (y + 1 <5) {
            arr[x][y + 1] = !arr[x][y + 1];
        }
        if (y - 1 >-1){
            arr[x][y - 1] = !arr[x][y - 1];
        }

        System.out.println(x);
        System.out.println(y);
        count++;
    }
}
