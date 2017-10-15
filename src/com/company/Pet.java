package com.company;

public class Pet {
    private String name;
    private int ageYears;
    private int ageDays;
    private double energy;
    private double hunger;
    private double cleanliness;
    private double restlessness;
    private double ennui;

    public Pet(String name) {
        this.name = name;
        this.ageYears = 0;
        this.ageDays = 0;
        this.energy = 50;
        this.hunger = 75;
        this.cleanliness = 75;
        this.restlessness = 50;
        this.ennui = 50;
    }

    public String getName() {
        return name;
    }

    public void ageUp(){
        ageDays++;
        if ((ageDays/7)>ageYears){
            ageYears = ageDays/7;
        }
    }

    public void dailyStatChange() {
        this.cleanliness-=5;
        this.hunger+=5;
        this.energy-=5;
        this.restlessness++;
        this.ennui++;
        this.ageUp();
    }

    public void statusCheck() {
        if (this.hunger >= 100) {
            System.out.println(name + "'s hunger level reached capacity, your pet has perished!");
            System.exit(0);
        } else if (this.energy <= 0) {
            System.out.println(name + " has fallen asleep from exhaustion!");
            dailyStatChange();
            dailyStatChange();
            dailyStatChange();
            this.energy = 50;
        } else if (this.cleanliness <= 0) {
            System.out.println(name + " has ran away in shame of their uncleanliness!");
            System.exit(0);
        } else if (this.restlessness >= 100) {
            System.out.println(name + " has ran away out of sheer restlessness.");
            System.exit(0);
        } else if (this.ennui >= 100) {
            System.out.println(name + " is no longer responsive and appears lost in their own world where they may or may not exist, and if they do, then why?");
            System.exit(0);
        }
    }

    public void petStatus() {
        System.out.println(name + " is " + ageYears + " years old.");
        System.out.println("Hunger level: " + hunger);
        System.out.println("Energy level: " + energy);
        System.out.println("Cleanliness level: " + cleanliness);
        System.out.println("Restlessness level: " + restlessness);
        System.out.println("Ennui level: " + ennui);
    }

    public void help() {
        System.out.println("Hello. Your pet " + name + "has various needs and its up to you to ensure they're met!");

        System.out.println("Your pet's hunger will increase with each turn unless you feed it using the \"feed\" command.");
        System.out.println("Don't let it reach 100 or your pet with perish!\n");

        System.out.println("Your pet's energy level will decrease each turn unless you use the \"sleep\" command.");
        System.out.println("There are various other commands that can affect your pet's energy level in different ways.\nFeel free to experiment with these effects!");
        System.out.println("The energy level reaching 0 will cause your pet to fall asleep for several turns which could jeopardise your pet's other needs!\n");

        System.out.println("Your pet's cleanliness will decline as time goes on. Use the \"shower\" command to keep your pet clean.");
        System.out.println("Your pet will run away if this reaches 0!\n");

        System.out.println("Your pet's restlessness level will increase with each turn. Use the \"workout\" command to ease this.");
        System.out.println("Your pet will run away if this reaches 100!\n");

        System.out.println("Your pet's ennui level will increase most terms. Use the \"drink\" command to reverse this, but be careful!");
        System.out.println("Your pet will become unresponsive if this reaches 100!\n");
    }

    public void feed() {
        if(this.hunger>=20) {
            this.hunger -= 20;
            if(ennui>1) {
                this.ennui--;
            }
            System.out.println(name + " has been fed.");
        } else {
            System.out.println(name + " shakes their head and turns up their nose at their food. It would appear they're not hungry.");
            this.restlessness++;
        }
    }

    public void sleep() {
        if(this.energy<=50) {
            this.energy += 50;
            this.ennui += 5;
            this.cleanliness -= 10;
            this.restlessness += 5;
            System.out.println(name + " has now rested.");
        } else {
            System.out.println(name + " bounces on the bed playfully. It would appear they're not tired enough to sleep.");
            this.restlessness++;
        }
    }

    public void shower() {
        if(this.cleanliness <= 50) {
            this.cleanliness += 50;
            System.out.println(name + " feels much cleaner now!");
        } else {
            this.cleanliness = 100;
            this.restlessness+=5;
            this.ennui+=5;
            System.out.println(name + " reluctantly showered and is now completely clean.");
        }
    }

    public void workout() {
        if(restlessness>=30) {
            this.restlessness -= 30;
            System.out.println(name + "'s pent up energy has been spent wisely.");
        } else {
            System.out.println(name + " would rather do something else.");
        }
    }

    public void drink() {
        if(ennui>=40){
            this.ennui-=40;
        } else {
            this.ennui = 0;
        }
        this.restlessness+=10;
        System.out.println(name + " is feeling much better about existence, somehow.");

    }
}
