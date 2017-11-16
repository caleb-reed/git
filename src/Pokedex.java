import java.util.*;
public class Pokedex
{
    //Initializing ArrayList of pokemon objects and array of Pokemon Names as string array
    private Pokemon[] pokemons;
    private List<String> pokeNames;

    //Pokedex constructor sets up pokemons array and pokeNames arraylist
    public Pokedex(int numberPokemon)
    {
        pokeNames = new ArrayList<>();
        pokemons = new Pokemon[numberPokemon];
    }

    public String[] listPokemon()
    {
        //Printing out pokenames list
        for(int i = 0; i < pokeNames.size(); i++)
        {
            System.out.println((i + 1) + ". " + pokeNames.get(i));
        }

        //Returning an array of pokemon names
        return pokeNames.toArray(new String[pokeNames.size()]);
    }

    public boolean addPokemon(String species)
    {
        boolean canAdd = true;
        Pokemon newPokemon = new Pokemon(species);
        //Testing For Duplicity
        for(int i = 0; i < pokemons.length; i++)
        {
            //If pokemon being added is already in pokemons
            if (pokemons[i] != null && pokemons[i].getSpecies().equalsIgnoreCase(species))
                {
                    System.out.println("Duplicate");
                    canAdd = false;
                    break;
                }
        }

        //If size of namePokemon list equals the size of pokemons array
        if(pokeNames.size() == pokemons.length && canAdd)
        {
            System.out.println("Max");
            canAdd = false;
        }

        //If canAdd is still true after checking for duplicity/maximum, adds pokemon to first empty space in pokemon array and adds species to pokeNames list
        if(canAdd)
        {
            for(int i = 0; i < pokemons.length; i++)
            {
                if (pokemons[i] == null)
                {
                    pokemons[i] = newPokemon;
                    pokeNames.add(species);
                    break;
                }
            }

        }

        return canAdd;

    }

    public int[] checkStats(String species)
    {
        int[] stats = new int[3];           //Initializing stats array to return to main

        //For loop to iterate through pokemon array and check if given species is in array
        for(int i = 0; i < pokemons.length; i++)
        {
            //To avoid nullpointerexceptions and checking if pokemon at index i's species is same as provided species, ignoring case
            if (pokemons[i] != null && pokemons[i].getSpecies().equalsIgnoreCase(species))
            {
                stats[0] = pokemons[i].getAttack();
                stats[1] = pokemons[i].getDefense();
                stats[2] = pokemons[i].getSpeed();
                System.out.println("\nThe stats for " + species + " are:");
                System.out.println("Attack: " + stats[0]);
                System.out.println("Defense: " + stats[1]);
                System.out.println("Speed: " + stats[2]);
                break;
            }
            //If for loop iterates through whole array and does not find pokeName matching given String
            else if (i == pokemons.length - 1)
                System.out.println("Missing");
        }

        return stats;

    }

    public void sortPokedex()
    {
        //Double for-loop to compare two pokemon objects's species simultaneously, and reorder them based on alphabetical order
        for(int i = 0; i < pokeNames.size(); i++)
        {
            for(int j = i + 1; j < pokeNames.size(); j++)
            {

                if(pokeNames.get(i).compareTo(pokeNames.get(j)) > 0)           //If first argument is greater than second argument (higher alphabetical order), returns value > 0. Source: docs.oracle.com/javase/7/docs/api/java/util/Comparator.html
                {
                    //switches indexes in pokeNames arraylist
                    String temp = pokeNames.get(i);
                    pokeNames.set(i, pokeNames.get(j));
                    pokeNames.set(j, temp);

                }
            }

        }

    }

    public boolean evolvePokemon(String species)
    {
        boolean canEvolve = true;
        //For loop to iterate through pokemon array and check if given species is in array
        for(int i = 0; i < pokemons.length; i++)
        {
         //To avoid nullpointerexceptions and checking if pokemon at index i's species is same as provided species, ignoring case
            if(pokemons[i] != null && pokemons[i].getSpecies().equalsIgnoreCase(species))
            {
                pokemons[i].evolve();
                System.out.println(species + " has evolved!");
                break;
            }
         //Else, if entire i has reached its final iteration and above condition still has not been met, pokemon must not be in array.
            else if(i == pokemons.length - 1)
         {
             System.out.println("Missing");
         }
        }
        return canEvolve;

    }
}
