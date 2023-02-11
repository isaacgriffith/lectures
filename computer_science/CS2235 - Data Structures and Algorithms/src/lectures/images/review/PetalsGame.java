
/**
 * Write a description of class PetalsGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PetalsGame
{
    private int [] dice = new int [6];
    int total = 0;

    public void rollDice()
    {
        for(int i = 0; i < dice.length; i++)
        {
            dice[i] = 1 + (int) (Math.random() * 6);
        }
    }
    
    public void printDice()
    {
        System.out.printf("You rolled the following: ");
        for(int i = 0; i < dice.length; i++)
        {
            System.out.printf("%d", dice[i]);
            if(i < 5)
            {
                System.out.printf(",");
            }
            else
            {
                System.out.printf("%n");
            }
        }
    }
    
    public void calculateAllPetals()
    {
        

        for(int i = 0; i < dice.length; i++)
        {
            switch (dice[i])
            {
                case 1:
                   
                    break;
                case 2:
                    
                    break;
                case 3:
                    total += 2;
                    break;
                case 4:
                    
                    break;
                case 5:
                    total += 4;
                    break;
            }
            
            
        }
        
        System.out.printf("The number of petals around the rose is %d%n", total);    
    }
    
    public int getallPetals()
    {
        return total;
    }  
}
