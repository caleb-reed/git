public class Pokemon
{
    //Initializing variables
    private String species;
    private int attack;
    private int defense;
    private int speed;

    //Initial constructor
    public Pokemon(String name)
    {
        species = name;
        attack = species.length() * 4 + 2;
        defense = species.length() * 2 + 7;
        speed = species.length() * 3 + 5;
    }

    //Getter/Setter methods for Attack/Defense/Speed
    public int getAttack()
    {
        return attack;
    }
    public void setAttack(int newAttack)
    {
        attack = newAttack;
    }
    public int getDefense()
    {
        return defense;
    }
    public void setDefense(int newDefense)
    {
        defense = newDefense;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
    public String getSpecies()
    {
        return species;
    }
    public void setSpecies(String newSpecies)
    {
        species = newSpecies;
    }

    //Evolve Method
    public void evolve()
    {
        speed = speed * 2;
        attack = attack * 3;
        defense = defense * 5;
    }

}
