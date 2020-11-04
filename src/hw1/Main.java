package hw1;

public class Main {
    public static void main(String[] args) {
        Exercising[] participants = {
             new Cat("Tom", 30),
             new Robot("Bender", 1000),
             new Human("John", 420),
             new Human("Ben", 350),
             new Cat("Garfield", 45),
        };
        Obstacle[] obstacles = {
                new Wall (1),
                new Treadmill(15),
                new Wall(5),
                new Treadmill(30),
                new Wall(10),
                new Treadmill(50),
        };

        for(Obstacle a : obstacles) {
            for(Exercising b : participants) {
                if(b.getStrength() <= 0) {
                    continue;
                }
                a.overcome(b);
                System.out.println(b.toString());
            }
            System.out.println("");
        }

    }
}
