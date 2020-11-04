package hw1;

public class Treadmill extends Obstacle{
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public void overcome(Exercising participant) {
        participant.run(length);
    }
}
