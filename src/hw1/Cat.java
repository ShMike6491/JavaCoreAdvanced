package hw1;

public class Cat implements Exercising{
    private String name;
    private int strength;

    public Cat(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void jump(int height) {
        int remainder = strength - height;
        if (remainder >= 0) {
            strength = remainder;
            System.out.println(name + " has jumped over the wall");
            return;
        }

        strength = 0;
        System.out.println(name + " is tired");
    }

    @Override
    public void run(int length) {
        int remainder = strength - length;
        if (remainder >= 0) {
            strength = remainder;
            System.out.println(name + " has run the distance");
            return;
        }

        strength = 0;
        System.out.println(name + " is tired");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                '}';
    }
}
