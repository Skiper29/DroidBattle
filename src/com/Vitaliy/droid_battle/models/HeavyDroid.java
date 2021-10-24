package com.Vitaliy.droid_battle.models;


public class HeavyDroid extends Droid {
    private double armorStrength;
    private static final double ARMOR_HIT_FACTOR = 0.7;
    private static final double HEALTH = 3000;
    private static final double DAMAGE = 100;
    private static final int RELOAD_TIME = 2;

    public HeavyDroid(String name) {
        super(name, HEALTH, DAMAGE, RELOAD_TIME);
        armorStrength = 600;
    }


    @Override
    public String getType() {
        return "Heavy";
    }

    @Override
    public String getSkill() { return "600 points of armor"; }

    @Override
    public void repair() {
        this.health = HEALTH;
    }

    @Override
    public double receiveDamage(double hit) {
        if (armorStrength > 0) {
            hit = hit * ARMOR_HIT_FACTOR;
            armorStrength -= hit;
        }
        return super.receiveDamage(hit);
    }
}
