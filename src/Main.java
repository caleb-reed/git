import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        //Declaring Variables/Scanner
        int numPokemon = 0;
        int menuChoice = 0;
        boolean isUsing = true;
        Scanner input = new Scanner(System.in);

        //Opening Program Statements
        System.out.println("Welcome to your new PokeDex!");
        System.out.print("How many Pokemon are in your region: ");

        //Error Handling for numPokemon
        boolean isError = true;
        while(isError)
        {
            try
            {
                numPokemon = input.nextInt();
                isError = false;
            }
            catch(InputMismatchException f)
            {
                System.out.println("\nThat is not a valid choice. Try again.");
                System.out.print("\nHow many Pokemon are in your region: ");
                input.nextLine();
            }

        }

        //Initializing Pokedex
        Pokedex pokedex = new Pokedex(numPokemon);
        System.out.println("\nYour new Pokedex can hold " + numPokemon + " Pokemon. Let's start using it!");

        //Main Program/Menu
        while(isUsing)
        {
            menuChoice = 0;
            //Error Handling
            while(menuChoice < 1 || menuChoice > 6)
            {
                //Menu
                System.out.println("\n1. List Pokemon");
                System.out.println("2. Add Pokemon");
                System.out.println("3. Check a Pokemon's Stats");
                System.out.println("4. Evolve Pokemon");
                System.out.println("5. Sort Pokemon");
                System.out.println("6. Exit\n");
                System.out.print("What would you like to do? ");

                try
                {
                    menuChoice = input.nextInt();
                    if(menuChoice < 1 || menuChoice > 6)
                        System.out.println("\nThat is not a valid choice. Try Again.");
                }
                catch(InputMismatchException uSuck)
                {
                    System.out.println("\nThat is not a valid choice. Try Again.");
                    input.nextLine();
                }
            }

            switch (menuChoice)
            {
                //List all pokemon species in the pokedex
                case 1:
                    pokedex.listPokemon();
                    break;

                //Adds a pokemon to pokedex
                case 2:
                    System.out.print("\nPlease enter the Pokemon's species: ");
                    String pokeName = input.next();
                    pokedex.addPokemon(pokeName);
                    break;

                //Checks stats of a certain pokemon
                case 3:
                    System.out.print("\nPlease enter the Pokemon of interest: ");
                    pokeName = input.next();
                    pokedex.checkStats(pokeName);
                    break;

                //Evolves a certain pokemon
                case 4:
                    System.out.print("\nPlease enter the Pokemon of interest: ");
                    pokeName = input.next();
                    pokedex.evolvePokemon(pokeName);
                    break;

                //Sorts pokemon in alphabetical order
                case 5:
                    pokedex.sortPokedex();
                    break;

                //Exits program
                case 6:
                    isUsing = false;
                    return;
            }

        }


    }
}
