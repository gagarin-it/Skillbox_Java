public class Cat
{
    private double originWeight;
    private double weight;
    private double weightFood;
    private double minWeight;
    private double maxWeight;
    private static int count;
    private static boolean catAlive;


    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;
        catAlive = true;
    }

    public void meow()
    {
            weight = weight - 1;
            System.out.println("Meow");
            if (weight < minWeight)
            {
                count--;
            }
    }

    public void feed(Double amount)
    {
//        if(catAlive) {
            weight = weight + amount;
            weightFood = weightFood + amount;
            System.out.println("Feed: " + amount);
//        }
//        else
//        {
//            System.out.println("Кошка умерла,кормить нельзя");
//            count++;
//        }
        if (weight > maxWeight)
            {
//            catAlive = false;
            count--;
            }
    }

    public void weightFood()
    {
        System.out.println("Eating food: " + weightFood);
    }

    public void pee()
    {
            weight = weight - 17.83;
            System.out.println("Pee-pee");
            if (weight < minWeight)
            {
            count--;
            }
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        if (weight > maxWeight)
        {
            count--;
            catAlive = false;
        }
    }

    public Double getWeight()
    {
        return weight;
    }
    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
    public static int getCount()
    {
        return count;
    }
}