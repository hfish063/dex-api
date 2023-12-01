package com.hfish.dev.dexapi.model.pokemon;

import com.hfish.dev.dexapi.util.ApiResource;

/**
 * @author haydenfish
 * @version 11.24.2023
 */

public class Stats implements ApiResource {
    private int hp;
    private int attack;
    private int defense;
    private int spatk;
    private int spdef;
    private int speed;
    private int total;
    public final static String resourceUrl = "https://pokemondb.net/pokedex/all";

    public Stats(int hp, int attack, int defense, int spatk, int spdef, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spatk = spatk;
        this.spdef = spdef;
        this.speed = speed;
        this.total = hp + attack + defense + spatk + spdef + speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpatk() {
        return spatk;
    }

    public void setSpatk(int spatk) {
        this.spatk = spatk;
    }

    public int getSpdef() {
        return spdef;
    }

    public void setSpdef(int spdef) {
        this.spdef = spdef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", spatk=" + spatk +
                ", spdef=" + spdef +
                ", speed=" + speed +
                ", total=" + total +
                '}';
    }

    @Override
    public String getResourceUrl() {
        return resourceUrl;
    }
}
