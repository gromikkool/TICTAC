package com.company;

public class Board {
    static int [] field = {0,0,0,
            0,0,0,
            0,0,0};
    static void clearField()
    {
        Arrays.fill(field, 0);
    }
    static void drawField(){
        System.out.println("     |     |     ");
        for (int i = 0; i < field.length; i++) {
            if (i!=0){
                if (i%3==0) {
                    System.out.println();
                    System.out.println("_____|_____|_____");
                    System.out.println("     |     |     ");
                }
                else
                    System.out.print("|");
            }

            if (field[i]==0) System.out.print("  " + i + "  ");
            if (field[i]==1) System.out.print("  X  ");
            if (field[i]==2) System.out.print("  O  ");
        }
        System.out.println();
        System.out.println("     |     |     ");
    }

}
