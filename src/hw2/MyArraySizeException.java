package hw2;

public class MyArraySizeException extends IllegalAccessException{
    public MyArraySizeException() {
    }

    public MyArraySizeException(int number) {
        super("Can not use an array larger than: " + number);
    }
}
