/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

/**
 * This is a Java program for Homework 9.
 * It represents an arena where Pokemon battles take place.
 */
public class Arena {

    /**
     * Simulates a battle between two Pokemon until one of them is knocked out.
     *
     * @param pokemon1 The first Pokemon participating in the battle.
     * @param pokemon2 The second Pokemon participating in the battle.
     */
    public void battle(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.println("Battle Start!");
        System.out.println("Pokemon 1: " + pokemon1);
        System.out.println("Pokemon 2: " + pokemon2);
        System.out.println("---------------");

        // Continue battle until one of the Pokemon is knocked out
        while (pokemon1.isConscious() && pokemon2.isConscious()) {
            // Pokemon 1 attacks Pokemon 2
            int damageToPokemon1 = pokemon1.takeDamage(pokemon2);
            System.out.println(pokemon2.getName() + " attacks " + pokemon1.getName() + " for " + damageToPokemon1 +
                    " damage. " + pokemon1.getName() + " remaining health: " + pokemon1.getHealth());

            // Check if Pokemon 2 is knocked out
            if (!pokemon2.isConscious()) {
                System.out.println(pokemon2.getName() + " is knocked out!");
                break;
            }

            // Pokemon 2 attacks Pokemon 1
            int damageToPokemon2 = pokemon2.takeDamage(pokemon1);
            System.out.println(pokemon1.getName() + " attacks " + pokemon2.getName() + " for " + damageToPokemon2 +
                    " damage. " + pokemon2.getName() + " remaining health: " + pokemon2.getHealth());

            // Check if Pokemon 1 is knocked out
            if (!pokemon1.isConscious()) {
                System.out.println(pokemon1.getName() + " is knocked out!");
                break;
            }

            System.out.println("---------------");
        }

        System.out.println("Battle End!");
    }

    /**
     * Main method demonstrating the usage of the Arena class to simulate a Pokemon battle.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Example usage of Arena class
        FireTypePokemon charmander = new FireTypePokemon("Charmander", 10, 50);
        GrassTypePokemon bulbasaur = new GrassTypePokemon("Bulbasaur", 8, 55);

        Arena arena = new Arena();
        arena.battle(charmander, bulbasaur);
    }
}
