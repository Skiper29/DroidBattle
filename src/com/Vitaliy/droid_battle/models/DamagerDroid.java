package com.Vitaliy.droid_battle.models;

public class DamagerDroid extends Droid {
    private static final int NUM_OF_GUNS = 2;
    private static final double HEALTH = 1500;
    private static final double DAMAGE = 200;
    private static final int RELOAD_TIME = 3;

    public DamagerDroid(String name) {
        super(name, HEALTH, DAMAGE, RELOAD_TIME);
    }


    @Override
    public String getType() {
        return "Damager";
    }

    @Override
    public String getSkill() { return "Double guns"; }

    @Override
    public void repair() {
        this.health = HEALTH;
    }

    @Override
    public double shoot() {
        if(Math.random() > 0.75)
            return super.shoot() * NUM_OF_GUNS;
        return super.shoot();
    }

}
