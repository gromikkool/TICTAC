package com.company;

import com.company.Board;
import com.company.Game;

import java.util.Scanner;

public class Menu {
    Scanner in;
    Information inf = new Information();

    int choiceInput() {
        inf.yourChoiceInformer();
        int yourChoice = in.nextInt();
        while (!(yourChoice >= 1 && yourChoice <= 3)) {
            inf.invalidInputInMenu();
            yourChoice = in.nextInt();
        }
        return yourChoice;
    }
        public void startProgram ()
        {
            int yourChoice;
            in = new Scanner(System.in);
            do {
                inf.menuInform();
                yourChoice = choiceInput();
                switch (yourChoice) {
                    case 1: {
                        Game game = new Game();
                        game.newGame(in);
                        break;
                    }
                    case 2: {
                        inf.resultsInform();
                        break;
                    }
                    case 3: {
                        System.exit(0);
                    }
                }
            }
            while (yourChoice != 2);
        }
    }

