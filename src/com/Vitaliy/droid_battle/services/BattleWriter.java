package com.Vitaliy.droid_battle.services;

import com.Vitaliy.droid_battle.models.Droid;

import java.util.ArrayList;

public class BattleWriter {
    private final StringBuffer buffer;

    public BattleWriter() {
        buffer = new StringBuffer();
    }

    public String appendTeamsHeader(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        StringBuilder header = new StringBuilder();
        header.append("┌────────────────────────────────────────┬────────────────────────────────────────┐").append('\n');
        header.append("│ First team                             │ Second team                            │").append('\n');
        header.append("├───────────────┬─────────────┬──────────┼───────────────┬─────────────┬──────────┤").append('\n');
        header.append(appendTeamsInfo(firstTeam, secondTeam));
        header.append("└───────────────┴─────────────┴──────────┴───────────────┴─────────────┴──────────┘").append("\n\n\n");
        buffer.append(header);
        return header.toString();
    }

    public String appendTeamsInfo(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam) {
        StringBuilder info = new StringBuilder();
        int firstSize = firstTeam.size();
        int secondSize = secondTeam.size();
        int size = Math.max(firstTeam.size(), secondTeam.size());
        for (int i = 0; i < size; i++) {
            if (firstSize <= i) {
                info.append("│               │             │          │");
            } else {
                Droid droid = firstTeam.get(i);
                info.append("│%-15s│%-13s│%-10.2f│".formatted(droid.getName(), droid.getType(), droid.getHealth()));
            }
            if (secondSize <= i) {
                info.append("               │             │          │").append('\n');
            } else {
                Droid droid = secondTeam.get(i);
                info.append("%-15s│%-13s│%-10.2f│".formatted(droid.getName(), droid.getType(), droid.getHealth())).append('\n');
            }
        }
        return info.toString();
    }

    public String appendString(String message) {
        buffer.append(message);
        return message;
    }

    public String appendRound(int i) {
        String round = "                 ROUND %d\n".formatted(i);
        buffer.append(round);
        return round;
    }

    public String appendRoundResult(ArrayList<Droid> firstTeam, ArrayList<Droid> secondTeam){
        StringBuilder roundResult = new StringBuilder();
        roundResult.append("┌───────────────┬─────────────┬──────────┬───────────────┬─────────────┬──────────┐").append('\n');
        roundResult.append(appendTeamsInfo(firstTeam,secondTeam));
        roundResult.append("└───────────────┴─────────────┴──────────┴───────────────┴─────────────┴──────────┘").append("\n\n\n");
        buffer.append(roundResult);
        return roundResult.toString();
    }

    public String appendResult(String result){
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("╭╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╮").append('\n');
        resultBuilder.append("╽ %-38s ╿\n".formatted(result));
        resultBuilder.append("╰╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╼╯").append("\n\n");
        buffer.append(resultBuilder);
        return resultBuilder.toString();
    }

    @Override
    public String toString(){
        return buffer.toString();
    }

}
