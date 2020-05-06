public class Loader
{
    public static void main(String[] args)
    {
        //Кошка №1
        Cat murka = new Cat();
        System.out.println("Murka weight: " + murka.getWeight());
        System.out.println("Murka status: " + murka.getStatus());
        murka.meow();
        System.out.println("Murka weight: " + murka.getWeight());
        murka.meow();
        System.out.println("Murka weight: " + murka.getWeight());

        //Кошка №2
        Cat bars = new Cat();
        System.out.println("Bars weight: " + bars.getWeight());
        System.out.println("Bars status: " + bars.getStatus());
        bars.meow();
        System.out.println("Bars weight: " + bars.getWeight());
        bars.meow();
        System.out.println("Bars weight: " + bars.getWeight());

        //Кошка №3
        Cat scheila = new Cat();
        System.out.println("Scheila weight: " + scheila.getWeight());
        System.out.println("Scheila status: " + scheila.getStatus());
        while (scheila.getStatus() != "Dead") {
            scheila.meow();
        }
        System.out.println("Scheila weight: " + scheila.getWeight());
        System.out.println("Scheila status: " + scheila.getStatus());

        //Кошка №4
        Cat lily = new Cat();
        System.out.println("Lily weight: " + lily.getWeight());
        System.out.println("Lily status: " + lily.getStatus());
        lily.feed(500.0);
        System.out.println("Lily weight: " + lily.getWeight());
        System.out.println("Lily status: " + lily.getStatus());

        //Кошка №5
        Cat nory = new Cat();
        System.out.println("Nory weight: " + nory.getWeight());
        System.out.println("Nory status: " + nory.getStatus());
        nory.drink(nory.getWeight()/100);
        System.out.println("Nory drink--- ");
        System.out.println("Nory weight: " + nory.getWeight());
        System.out.println("Nory status: " + nory.getStatus());

        //Кошка №6
        Cat mouse = new Cat();
        System.out.println("Mouse weight: " + mouse.getWeight());
        System.out.println("Mouse status: " + mouse.getStatus());
        while (mouse.getStatus() != "Exploded")
        {
            mouse.feed(200.5);
        }
        mouse.food();
        System.out.println("Mouse weight: " + mouse.getWeight());
        System.out.println("Mouse status: " + mouse.getStatus());

        //Кошка №7
        Cat lucky = new Cat();
        System.out.println("Lucky weight: " + lucky.getWeight());
        System.out.println("Lucky status: " + lucky.getStatus());
        while (lucky.getStatus() != "Sleeping")
        {
            lucky.feed(11.8541);
            lucky.drink(22.7);
            System.out.println("Lucky drink--- ");
        }
        System.out.println("Lucky weight: " + lucky.getWeight());
        System.out.println("Lucky status: " + lucky.getStatus());

        //Кошка 8
        Cat sirius = new Cat();
        System.out.println("Sirius weight: " + sirius.getWeight());
        System.out.println("Sirius status: " + sirius.getStatus());
        sirius.food();
        sirius.feed(150.0);
        sirius.food();
        System.out.println("Sirius weight: " + sirius.getWeight());
        sirius.pee();
        sirius.pee();
        sirius.pee();
        sirius.pee();
        sirius.pee();
        System.out.println("Sirius weight: " + sirius.getWeight());
        sirius.food();
        sirius.feed(223.0);
        sirius.food();
        sirius.feed(111.0);
        System.out.println("Sirius weight: " + sirius.getWeight());
        System.out.println("Sirius status: " + sirius.getStatus());
        sirius.food();
    }
}
//Тест
