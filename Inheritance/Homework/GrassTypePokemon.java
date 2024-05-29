/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;
/**
 * This is a Java program for Homework 9.
 * It represents a Grass type Pokemon, which is a specialized type of Pokemon.
 * Grass type Pokemon have specific rules for calculating damage based on the attacker's type.
 */
public class GrassTypePokemon extends Pokemon{

    /**
     * Creates a new GrassTypePokemon with the specified name, attack power, and health points.
     *
     * @param name   The name of the Grass type Pokemon.
     * @param attack The attack power of the Grass type Pokemon.
     * @param health The initial health points of the Grass type Pokemon.
     */
    public GrassTypePokemon(String name, int attack, int health) {
        super(name, attack, health);
        setType(Type.GRASS); // Set the type of this Pokemon to GRASS.
    }
    
    /**
     * Overrides the takeDamage method to apply specific damage calculations based on the attacker's type.
     *
     * @param attacker The Pokemon attacking this Grass type Pokemon.
     * @return The actual damage inflicted on this Grass type Pokemon after calculations.
     */
    @Override
    public int takeDamage(Pokemon attacker) {
        int damage;
        // Calculate damage based on the type of the attacker
        switch (attacker.getType()) {
            case NORMAL:
                damage = attacker.getAttack();
                break;
            case FIRE:
                damage = attacker.getAttack() * 2; // Grass type Pokemon takes double damage from Fire type attacks.
                break;
            case GRASS:
                damage = attacker.getAttack();
                break;
            case WATER:
                damage = attacker.getAttack() / 2; // Grass type Pokemon takes half damage from Water type attacks.
                break;
            default:
                damage = 0;
        }
        int actualDamage = super.takeDamage(attacker);
        return actualDamage;
    }
}
