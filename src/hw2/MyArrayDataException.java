package hw2;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException() {
    }

    public MyArrayDataException(int i, int j) {
        super("Error occurred at the position of: " + i + ", " + j + "\n A number must be used as an argument");
    }
}
