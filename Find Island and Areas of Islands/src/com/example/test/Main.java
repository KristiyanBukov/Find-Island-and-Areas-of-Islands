package com.example.test;

import java.sql.Time;

public class Main {

    public static void main(String[] args) {

        int[][] dashboard = {
                {0, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 0}
        };

        System.out.println(findIsland(dashboard));
        System.out.println(loop(dashboard));
    }

    public static int findIsland(int [] [] dashboard) {
         int islandCount = 0;

         for (int i = 0; i < dashboard.length; i++) {
             for (int j = 0; j < dashboard.length; j++) {
                 boolean island = true;

                 if (dashboard[i][j] == 1) {

                     if (j + 1 < dashboard[i].length) {

                         if (dashboard[i][j] == dashboard[i][j + 1]) {
                             island = false;
                         }
                     }


                     if (j != 0) {
                         if (dashboard[i][j] == dashboard[i][j - 1]) {
                             island = false;
                         }
                     }


                     if (i + 1 < dashboard.length) {
                         if (dashboard[i][j] == dashboard[i + 1][j]) {
                             island = false;
                         }
                     }

                     if (i != 0) {
                         if (dashboard[i][j] == dashboard[i - 1][j]) {
                             island = false;
                         }
                     }

                     if (island) {
                         islandCount++;
                     }
                 }
             }
         }
         return islandCount;
    }

    public static boolean findArea(int [] [] dashboard, int i, int j) {
        boolean area = false;

        // j must be less tha dashboard [i] (outofbound)
        if (j +1 < dashboard[i].length) {
            // checking next position == 1 if is equal set this position index to 2

            if (dashboard [i] [j +1] == 1) {
                dashboard[i][j] = 2;
                findArea(dashboard, i, j + 1);
                area = true;
            }
        }

        if (j != 0) {
            if (dashboard[i] [j -1] == 2 ) {
                dashboard[i][j] = 2;
                findArea(dashboard, i, j -1);
            }
            if (dashboard [i] [j-1] == 1) {
                dashboard[i][j - 1] = 2;
                findArea(dashboard, i, j - 1);
            }
        }

        if (i + 1 < dashboard.length) {
            if (dashboard [i + 1] [j] == 1) {
                dashboard[i] [j] = 2;
                findArea(dashboard, i +1, j);
                area = true;
            }
        }

        if (i != 0) {
            if(dashboard[i-1] [j] ==2) {
                dashboard[i][j] = 2;
                findArea(dashboard, i -1, j);
            }
            if(dashboard[i-1] [j] ==1) {
                dashboard[i][j] = 2;
                findArea(dashboard, i -1, j);
            }

        }
        return area;
    }

    public static int loop(int [][] dashboard) {

        int counter = 0;
        for (int i = 0; i < dashboard.length; i++) {
            for (int j = 0; j < dashboard.length; j++) {
                if (dashboard [i][j] == 1) {
                    if (findArea(dashboard, i,j)){
                        counter ++;
                    }
                }
            }
        }
        return counter;
    }


}
