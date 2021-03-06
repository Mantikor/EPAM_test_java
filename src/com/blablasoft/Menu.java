package com.blablasoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final String MENU_PATTERN = "%s - %s\n";
    private List<MenuEntry> entries = new ArrayList<MenuEntry>();
    private boolean isExit = false;

    public Menu() {
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                isExit = true;
            }
        });
    }

    public void run() {
        while (!isExit) {
            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = reader.readLine();
                int choice = Integer.parseInt(line);
                MenuEntry entry = entries.get(choice);
                entry.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Menu addEntry(MenuEntry entry) {
        int index = entries.size();
        entries.add(index, entry);
        return this;
    }

    private void printMenu() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\nCase from:\n");
        for (int i = 1; i < entries.size(); i++) {
            MenuEntry entry = entries.get(i);
            String entryFormatted = String.format(MENU_PATTERN, (i), entry.getTitle());
            buffer.append(entryFormatted);
        }
        MenuEntry entry = entries.get(0);
        String entryFormatted = String.format(MENU_PATTERN, (0), entry.getTitle());
        buffer.append(entryFormatted);
        System.out.print(buffer.toString());
    }
}