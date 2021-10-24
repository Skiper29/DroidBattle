package com.Vitaliy.droid_battle.services;

import com.Vitaliy.droid_battle.arenas.BattleArena;
import com.Vitaliy.droid_battle.arenas.RandomsArena;
import com.Vitaliy.droid_battle.arenas.SimpleArena;


public class ArenaFactory {
    public BattleArena createArena(int type){
        switch (type){
            case 1:
                return new SimpleArena();
            case 2:
                return new RandomsArena();
            default:
                throw new IndexOutOfBoundsException("Arena type is incorrect");
        }
    }
}
