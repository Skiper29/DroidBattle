package com.Vitaliy.droid_battle.services;

import com.Vitaliy.droid_battle.arenas.BattleArena;
import com.Vitaliy.droid_battle.models.Droid;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationController {
    private final ArrayList<Droid> droids;
    private final Scanner scanner = new Scanner(System.in);
    private final String FILE = "DroidBattle.txt";


    public ApplicationController() {
        droids = new ArrayList<>();
    }

    public void start() {
        System.out.println("\n\n\t\tWelcome to the Droid Battles game!!!\n");
        while (true) {
            System.out.println("\n\n");
            System.out.println("""
                    Enter command
                     play - to start new game
                     watch - to reload previous game.
                     add - to create new droid
                     exit - to exit the game""");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    createDroids();
                    break;
                case "play":
                    startPlay();
                    break;
                case "watch":
                    loadLastBattle();
                    break;
                case "exit":
                    return;
                default:
                    throw new RuntimeException("The command doesn't exist.");

            }
            System.out.print("Enter any key to continue ");
            scanner.nextLine();
        }
    }

    private void loadLastBattle() {
        try {
            System.out.println(Files.readString(Paths.get(FILE)));
        } catch (IOException e) {
            System.out.println("File not exist");
        }
    }

    private void startPlay() {
        ArenaFactory factory = new ArenaFactory();
        System.out.println("""
                Choose battle arena to start fight
                1 - simple arena
                2 - arena with random damage""");
        int arenaNumber = scanner.nextInt();
        scanner.nextLine();
        BattleArena arena = factory.createArena(arenaNumber);
        String battle = arena.startBattle(droids);
        droids.forEach(Droid::repair);
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE),32 * 1024);
            bufferedWriter.write(battle);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("File not exist.");
        }

    }

    protected void createDroids() {
        DroidFactory droidFactory = new DroidFactory();
        System.out.println(droidsInfo());
        while (true) {
            System.out.print(" Choose droid type (1-4) or 0 to exit: ");
            int type = scanner.nextInt();
            scanner.nextLine();
            if (type == 0)
                break;
            System.out.print(" Enter droid name: ");
            String name = scanner.nextLine();
            droids.add(droidFactory.createDroid(type, name));
        }
    }

    private String droidsInfo() {
        return """
                ┌──────────┬──────────┬──────────┬──────────┬────────────────────┐
                │ Type     │ Health   │ Damage   │ Reload   │ Skill              │
                ├──────────┼──────────┼──────────┼──────────┼────────────────────┤
                │ Soldier  │ 2000     │ 250      │ 3        │ -                  │
                ├──────────┼──────────┼──────────┼──────────┼────────────────────┤
                │ Light    │ 500      │ 50       │ 1        │ Regenerate health  │
                ├──────────┼──────────┼──────────┼──────────┼────────────────────┤
                │ Damager  │ 1500     │ 200      │ 3        │ Double gun         │
                ├──────────┼──────────┼──────────┼──────────┼────────────────────┤
                │ Heavy    │ 3000     │ 100      │ 2        │ 600 points of armor│
                └──────────┴──────────┴──────────┴──────────┴────────────────────┘
                """;
    }

}
