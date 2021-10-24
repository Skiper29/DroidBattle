package com.Vitaliy.droid_battle.models;

import java.time.LocalTime;

public abstract class Droid {
    private final String name;
    protected double health;


    protected double damage;
    protected int reloadTime;
    protected LocalTime lastReload;

    public Droid(String name, double health, double damage, int reloadTime) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.reloadTime = reloadTime;
        this.lastReload = LocalTime.now();
    }

    public String getName() {
        return name;
    }

    public double getDamage() { return damage; }

    public double getHealth() {
        return health;
    }

    public int getReloadTime() { return reloadTime; }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }

    public boolean isDead() {
        return (health <= 0);
    }

    public abstract String getType();

    public abstract String getSkill();

    public abstract void repair();

    public double shoot() {
        if (!isReloaded()) {
            try {
                int i = 1;
                while(!LocalTime.now().isAfter(lastReload.plusSeconds(reloadTime))) {
                    System.out.printf("%s reloading - %ds%n\n", this.name,i++);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        lastReload = LocalTime.now();
        return damage;
    }

    public boolean isReloaded() {
        return LocalTime.now().isAfter(lastReload.plusSeconds(reloadTime));
    }

    public double receiveDamage(double hit) {
        this.health -= hit;
        return hit;
    }
}
