package com.Vitaliy.droid_battle.services;

import com.Vitaliy.droid_battle.models.*;

public class DroidFactory {
    public Droid createDroid(int droidType, String name){
        switch (droidType){
            case 1:
                return new SoldierDroid(name);
            case 2:
                return new DamagerDroid(name);
            case 3:
                return new HeavyDroid(name);
            case 4:
                return new LightDroid(name);
            default:
                throw new IndexOutOfBoundsException("Droid type is incorrect");
        }

    }
}
