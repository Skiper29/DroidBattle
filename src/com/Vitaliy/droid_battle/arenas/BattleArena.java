package com.Vitaliy.droid_battle.arenas;

import com.Vitaliy.droid_battle.models.Droid;

import java.util.*;

public abstract class BattleArena {
    protected ArrayList<Droid> firstTeam;
    protected ArrayList<Droid> secondTeam;

    public BattleArena() {
        firstTeam = new ArrayList<>();
        secondTeam = new ArrayList<>();
    }

    public abstract String startBattle(ArrayList<Droid> droids);

    protected void setTeams(ArrayList<Droid> droids) {
        Scanner input = new Scanner(System.in);
        ArrayList<Droid> copyDroid = new ArrayList<>(droids);
        while (!copyDroid.isEmpty()) {
            System.out.println(createdDroidsInfo(copyDroid));
            System.out.print(" Choose team (enter 1 or 2) or 0 to exit: ");
            int team = input.nextInt();
            input.nextLine();
            if (team == 0)
                break;
            System.out.print(" Enter droid number: ");
            int number = input.nextInt();
            input.nextLine();
            ArrayList<Droid> chosenTeam;
            chosenTeam = team == 1 ? firstTeam : secondTeam;
            try {
                chosenTeam.add(copyDroid.remove(number - 1));

            }catch (IndexOutOfBoundsException e){
                System.out.println(" Such droid doesn't exist.");
            }

        }
    }

    public String createdDroidsInfo(ArrayList<Droid> droids) {
        StringBuilder droidsInfo = new StringBuilder();
        droidsInfo.append("""
                ┌─────┬───────────────┬──────────┬──────────┬──────────┬──────────┬────────────────────┐
                │  №  │ Name          │ Type     │ Health   │ Damage   │ Reload   │ Skill              │
                ├─────┼───────────────┼──────────┼──────────┼──────────┼──────────┼────────────────────┤""").append('\n');
        int i = 1;
        for (Droid droid : droids) {
            droidsInfo.append("│%3d  │%-15s│%-10s│%-10.2f│%-10.2f│%5d     │%-20s│\n".formatted(i++, droid.getName()
                    , droid.getType(), droid.getHealth(), droid.getDamage(), droid.getReloadTime(), droid.getSkill()));
        }
        droidsInfo.append("└─────┴───────────────┴──────────┴──────────┴──────────┴──────────┴────────────────────┘");
        return droidsInfo.toString();
    }
}
/*
add droid
1
Skiper
 2
Adam
3
Davinki
4
Dok
0

play
 */
