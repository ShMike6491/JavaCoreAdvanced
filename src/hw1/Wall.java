package hw1;

public class Wall extends Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Exercising participant) {
        participant.jump(height * 2);
    }
}
