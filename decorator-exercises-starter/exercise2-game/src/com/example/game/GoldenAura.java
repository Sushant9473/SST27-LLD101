package com.example.game;

public class GoldenAura extends CharacterDecorator {
    private final String auraSprite = "golden.png";
    private final int speedBuff = 2;
    private final int damageBuff = 5;

    public GoldenAura(Character wrapped) {
        super(wrapped);
    }

    @Override
    public void move() {
        System.out.println("[Golden Aura] Moving at speed " + getSpeed() + " with sprite " + getSprite());
    }

    @Override
    public void attack() {
        System.out.println("[Golden Aura] Attacking with damage " + getDamage() + " using sprite " + getSprite());
    }

    @Override
    public int getSpeed() {
        return wrapped.getSpeed() + speedBuff;
    }

    @Override
    public int getDamage() {
        return wrapped.getDamage() + damageBuff;
    }

    @Override
    public String getSprite() {
        return auraSprite;
    }
}
