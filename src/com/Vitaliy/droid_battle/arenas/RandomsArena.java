package com.Vitaliy.droid_battle.arenas;

import com.Vitaliy.droid_battle.models.Droid;
import com.Vitaliy.droid_battle.services.BattleWriter;

import java.util.ArrayList;
import java.util.Random;

public class RandomsArena extends BattleArena {

    public RandomsArena() {
        super();
    }

    @Override
    public String startBattle(ArrayList<Droid> droids) {
        BattleWriter log = new BattleWriter();
        super.setTeams(droids);
        int round = 1;
        Random random = new Random();
        boolean isFirstTeamTurn = random.nextBoolean();
        System.out.print(log.appendTeamsHeader(firstTeam, secondTeam));
        while (!firstTeam.isEmpty() && !secondTeam.isEmpty()) {
            Droid firstDroid = firstTeam.get(random.nextInt(firstTeam.size()));
            Droid secondDroid = secondTeam.get(random.nextInt(secondTeam.size()));
            System.out.print(log.appendRound(round++));
            if (isFirstTeamTurn) {
                System.out.print(log.appendString(" Droid %s damaged by %s with %.2f hit points.\n".formatted(secondDroid.getName(),
                        firstDroid.getName(), secondDroid.receiveDamage(((Math.random() / 2.0) - 0.25)
                                * firstDroid.getDamage() + firstDroid.shoot()))));
                if (secondDroid.isDead()) {
                    secondTeam.remove(secondDroid);
                }
            } else {
                System.out.print(log.appendString(" Droid %s damaged by %s with %.2f hit points.\n".formatted(firstDroid.getName(),
                        secondDroid.getName(), firstDroid.receiveDamage(((Math.random() / 2.0) - 0.25)
                                * secondDroid.getDamage() + secondDroid.shoot()))));
                if (firstDroid.isDead()) {
                    firstTeam.remove(firstDroid);
                }
            }
            isFirstTeamTurn = !isFirstTeamTurn;
            System.out.println(log.appendRoundResult(firstTeam, secondTeam));
        }
        if (firstTeam.isEmpty()) {
            System.out.println(log.appendResult("Second team won!!!"));
        } else {
            System.out.println(log.appendResult("First team won!!!"));
        }
        return log.toString();
    }
}
