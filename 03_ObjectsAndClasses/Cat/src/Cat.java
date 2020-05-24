public class Cat
{
    private double originWeight;
    private double weight;
    private double weightFood;
    private double minWeight;
    private double maxWeight;
    private static int count;
    private static boolean catAlive;
    public static final int CAT_QTY_EYES = 2;
    public static final int CAT_MIN_WEIGHT = 1200;
    public static final int CAT_MAX_WEIGHT = 7500;

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
            if(catAlive)
            {
                weight = weight - 1;
                System.out.println("Meow");
            }
            else
            {
                System.out.println("Мертвые кошки не мяукают");
            }

        if (weight < minWeight && catAlive)
            {
                count--;
                catAlive = false;
            }
    }

    public void feed(Double amount)
    {
        if(catAlive) {
            weight = weight + amount;
            weightFood = weightFood + amount;
            System.out.println("Feed: " + amount);
        }
        else
        {
            System.out.println("Мертвые кошки не едят");
        }
        if (weight > maxWeight && catAlive)
            {
            catAlive = false;
            count--;
            }
    }

    public void weightFood()
    {
        System.out.println("Eating food: " + weightFood);
    }

    public void pee()
    {
            if (catAlive)
            {
                weight = weight - 17.83;
                System.out.println("Pee-pee");
            }
            else
            {
                System.out.println("Мертвые кошки не ходят в туалет");
            }
        if (weight < minWeight && catAlive)
            {
            count--;
            catAlive = false;
            }
    }

    public void drink(Double amount)
    {
        if(catAlive)
        {
            weight = weight + amount;
        }
        else
        {
            System.out.println("Мёртвые кошки не пьют");
        }
        if (weight > maxWeight && catAlive)
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