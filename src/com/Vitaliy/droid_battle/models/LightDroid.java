package com.Vitaliy.droid_battle.models;

public class LightDroid extends Droid {

    //private static final double Repair_Reload = 3;
    private static final double HEALTH = 500;
    private static final double DAMAGE = 50;
    private static final int RELOAD_TIME = 1;

    public LightDroid(String name) {
        super(name, HEALTH, DAMAGE, RELOAD_TIME);
    }

    @Override
    public String getType() {
        return "Light";
    }

    @Override
    public String getSkill() { return "Regenerate health"; }

    @Override
    public void repair() {
        this.health = HEALTH;
    }

    @Override
    public double shoot()
    {
        if(Math.random() < 0.5){
            health += Math.random() * 100;
        }
        return super.shoot();
    }
}
