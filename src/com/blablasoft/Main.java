package com.blablasoft;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        menu.addEntry(new MenuEntry("Input sentence") {
            @Override
            public void run() {
                System.out.println("Input sentence for correction: ");
                String input = sc.nextLine();
                String newSentence = input;
                System.out.println("Input index for change: ");
                input = sc.nextLine();
                int chIndex = Integer.valueOf(input);
                if (chIndex <= 0) chIndex = 1;
                System.out.println("Input char for change: ");
                input = sc.nextLine();
                char chSymbol = input.charAt(0);
                Sentence sentence = new Sentence(newSentence);
                System.out.println("In:  " + sentence.getValue());
                System.out.println("Words count: " + sentence.Lengtht() + ", symbol at pos. " + chIndex + " changed to " + chSymbol);
                sentence.processChanges(chIndex, chSymbol);
                System.out.println("Out: " + sentence.getValue());
            }
        });

        menu.addEntry(new MenuEntry("Read sentence from txt file") {
            @Override
            public void run() {
                System.out.println("Reading lines from file...");
                TxtFile txtfile = new TxtFile("test.txt");
                String newSentence = txtfile.getRndString();
                System.out.println("Input index for change: ");
                String input = sc.nextLine();
                int chIndex = Integer.valueOf(input);
                if (chIndex <= 0) chIndex = 1;
                System.out.println("Input char for change: ");
                input = sc.nextLine();
                char chSymbol = input.charAt(0);
                Sentence sentence = new Sentence(newSentence);
                System.out.println("In:  " + sentence.getValue());
                System.out.println("Words count: " + sentence.Lengtht() + ", symbol at pos. " + chIndex + " changed to " + chSymbol);
                sentence.processChanges(chIndex, chSymbol);
                System.out.println("Out: " + sentence.getValue());

            }
        });

        menu.addEntry(new MenuEntry("Autogenerate sentence") {
            @Override
            public void run() {
                System.out.println("Generating...");
                String newSentence = "";
                RndWord rndword = new RndWord();
                int wordCount = rndword.randomInt(10);
                for (int i=1; i <= wordCount; i++) {
                    if (i != wordCount) newSentence += rndword.randomString(rndword.randomInt(10)) + " ";
                    else newSentence += rndword.randomString(rndword.randomInt(10));
                }
                int chIndex = rndword.randomInt(5);
                char chSymbol = rndword.randomString(1).charAt(0);
                Sentence sentence = new Sentence(newSentence);
                System.out.println("In:  " + sentence.getValue());
                System.out.println("Words count: " + sentence.Lengtht() + ", symbol at pos. " + chIndex + " changed to " + chSymbol);
                sentence.processChanges(chIndex, chSymbol);
                System.out.println("Out: " + sentence.getValue());

            }
        });

        menu.run();
    }
}