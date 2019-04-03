package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game extends Board {

    public void newGame(Scanner in)
    {
        boolean b;
        boolean isCurrentX = false;
        do {
            isCurrentX = !isCurrentX;
            drawField();
            System.out.println("mark " + (isCurrentX ? "X" : "O"));
            int n = getNumber();
            field[n] = isCurrentX ? 1 : 2;
            b = !isGameOver(n);
            if (isDraw()){
                System.out.println("Draw");
                return;
            }
        } while (b);
        drawField();
        System.out.println();

        System.out.println("The winner is " + (isCurrentX ? "X" : "O") + "!");
    }

    static boolean isGameOver(int n){
        // 0 1 2
        // 3 4 5
        // 6 7 8
        //поиск совпадений по горизонтали
        int row = n-n%3; //номер строки - проверяем только её
        if (field[row]==field[row+1] &&
                field[row]==field[row+2]) return true;
        //поиск совпадений по вертикали
        int column = n%3; //номер столбца - проверяем только его
        if (field[column]==field[column+3])
            if (field[column]==field[column+6]) return true;
        //мы здесь, значит, первый поиск не положительного результата
        //если значение n находится на одной из граней - возвращаем false
        if (n%2!=0) return false;
        //проверяем принадлежит ли к левой диагонали значение
        if (n%4==0){
            //проверяем есть ли совпадения на левой диагонали
            if (field[0] == field[4] &&
                    field[0] == field[8]) return true;
            if (n!=4) return false;
        }
        return field[2] == field[4] &&
               field[2] == field[6];
    }
    static int getNumber(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n >= 0 && n < field.length && field[n]==0){
                    return n;
                }
                System.out.println("Choose free cell and enter its number");
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            } catch (IOException e) {
            }
        }
    }
    public static boolean isDraw() {
        for (int n : field) if (n==0) return false;
        return true;
    }
}
