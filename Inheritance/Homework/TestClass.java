/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.util.Random;
import java.util.Scanner;

/**
 * This is a Java program for Homework 9.
 * This class simulates Pokémon battles based on randomly generated Pokémon attributes.
 */
public class TestClass {
    
    /**
     * Main method to start the program and simulate Pokémon battles.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Arena arena = new Arena();

        while (true) {
            // Generate random Pokemon attributes
            Pokemon.Type randomType1 = Pokemon.Type.values()[random.nextInt(Pokemon.Type.values().length)];
            Pokemon.Type randomType2 = Pokemon.Type.values()[random.nextInt(Pokemon.Type.values().length)];
            int randomAttack1 = random.nextInt(51) + 50; // Random attack value between 50 to 100
            int randomAttack2 = random.nextInt(51) + 50; // Random attack value between 50 to 100
            int randomHealth1 = random.nextInt(501) + 500; // Random health value between 500 to 1000
            int randomHealth2 = random.nextInt(501) + 500; // Random health value between 500 to 1000

            // Create random Pokemon based on generated attributes
            Pokemon pokemon1 = createRandomPokemon(randomType1, randomAttack1, randomHealth1);
            Pokemon pokemon2 = createRandomPokemon(randomType2, randomAttack2, randomHealth2);

            // Battle the Pokemon
            arena.battle(pokemon1, pokemon2);

            // Ask the user if they want to watch another battle
            System.out.print("Do you want to watch another battle? (yes/no): ");
            String input = scanner.next().toLowerCase();
            if (!input.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for watching Pokémon battles!");
    }

    /**
     * Helper method to create a random Pokemon based on type, attack, and health.
     *
     * @param type   The type of the Pokemon to be created.
     * @param attack The attack power of the Pokemon.
     * @param health The health points of the Pokemon.
     * @return A randomly generated Pokemon object with the specified attributes.
     */
    private static Pokemon createRandomPokemon(Pokemon.Type type, int attack, int health) {
        switch (type) {
            case FIRE:
                return new FireTypePokemon("Fire Pokemon", attack, health);
            case GRASS:
                return new GrassTypePokemon("Grass Pokemon", attack, health);
            case WATER:
                return new WaterTypePokemon("Water Pokemon", attack, health);
            default:
                return new Pokemon("Normal Pokemon", attack, health);
        }
    }
}
