/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * This is a Java program for Homework 9.
 * It represents a Pokemon with a name, type, attack power, and health points.
 */
public class Pokemon {
    private String name;
    private Type type;
    private int attack;
    private int health;

    /**
     * Enumeration representing different types of Pokemon.
     */
    public enum Type {
        NORMAL, FIRE, GRASS, WATER
    }

    //Constructor

    /**
     * Constructor to create a Pokemon object with the specified name, attack power, and health points.
     *
     * @param name   The name of the Pokemon.
     * @param attack The attack power of the Pokemon.
     * @param health The initial health points of the Pokemon.
     */
    public Pokemon(String name, int attack, int health){
        this.name = name;
        this.type = Type.NORMAL; // Default type is NORMAL.
        this.attack = attack;
        this.health = health;
    }

    //Accessors and Mutators

    /**
     * Gets the name of the Pokemon.
     *
     * @return The name of the Pokemon.
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the type of the Pokemon.
     *
     * @return The type of the Pokemon.
     */
    public Type getType(){
        return type;
    }

    /**
     * Sets the type of the Pokemon.
     *
     * @param type The type to be set for the Pokemon.
     */
    public void setType(Type type){
        this.type = type;
    }

    /**
     * Gets the attack power of the Pokemon.
     *
     * @return The attack power of the Pokemon.
     */
    public int getAttack(){
        return attack;
    }

    // Method to deduct health when attacked by another Pokémon

    /**
     * Deducts health points when the Pokemon is attacked by another Pokemon.
     *
     * @param attacker The Pokemon attacking this Pokemon.
     * @return The damage points inflicted on this Pokemon.
     */
    public int takeDamage(Pokemon attacker) {
        int damage = attacker.getAttack();
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        return damage;
    }

    /**
     * Gets the current health points of the Pokemon.
     *
     * @return The current health points of the Pokemon.
     */
    public int getHealth(){
        return health;
    }
    
    // Check if the Pokémon is conscious

    /**
     * Checks if the Pokemon is conscious (has positive health points).
     *
     * @return True if the Pokemon is conscious, false otherwise.
     */
    public boolean isConscious() {
        return health > 0;
    }

    // toString method to represent the Pokemon's information as a string

    /**
     * Represents the Pokemon's information as a string.
     *
     * @return A string representation of the Pokemon.
     */
    @Override
    public String toString() {
        return "Pokemon{name='" + name + "', type=" + type + ", attack=" + attack + ", health=" + health + '}';
    }
}
