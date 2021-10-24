package com.Vitaliy.droid_battle.models;

public class SoldierDroid extends Droid {
    private static final double HEALTH = 2000;
    private static final double DAMAGE = 250;
    private static final int RELOAD_TIME = 3;

    public SoldierDroid(String name){
        super(name, HEALTH, DAMAGE, RELOAD_TIME);
    }

    @Override
    public String getType() {
        return "Soldier";
    }

    @Override
    public String getSkill() { return "-"; }

    @Override
    public void repair() {
        this.health = HEALTH;
    }
}
