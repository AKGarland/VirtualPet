package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Congratulations, your pet has been born! Please input the desired name for your pet: ");
        String inputName = scanner.nextLine();
        Pet pet = new Pet(inputName);

        System.out.println("Your pet, " + pet.getName() + ", runs at you with a wide eyes and an expectant smile. Type \"help\" to explore your options.");
        takeOrder(pet);
    }

    public static void takeOrder(Pet pet) {
        String newOrder = scanner.nextLine().toLowerCase();

        switch(newOrder) {
            case "help":
                pet.help();
                break;
            case "status":
                pet.petStatus();
                break;
            case "feed":
                pet.feed();
                break;
            case "sleep":
                pet.sleep();
                break;
            case "shower":
                pet.shower();
                break;
            case "workout":
                pet.workout();
                break;
            case "drink":
                pet.drink();
                break;
            default:
                System.out.println("Oops! Type \"help\" to see the valid options.");
                break;
        }

        pet.dailyStatChange();
        pet.statusCheck();
        takeOrder(pet);
    }
}
