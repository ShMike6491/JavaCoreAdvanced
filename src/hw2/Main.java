package hw2;

public class Main {
    public static void main(String[] args) {
        String[][] myArray = {
                {"2", "1", "4", "5"},
                {"4", "3", "6", "9"},
                {"5", "5", "lol", "7"},
                {"4", "1", "8", "6"}
        };
        int answer = 0;

        try {
            answer = sumArray(myArray, 4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
        System.out.println(answer);
    }

    public static int sumArray (String[][] array, int num) throws MyArraySizeException, MyArrayDataException {
        int arrSize = array.length;
        int sum = 0;

        if (arrSize != num) {
            throw new MyArraySizeException(num);
        }
        for (String[] x : array ) {
            if(x.length != num) {throw new MyArraySizeException(num);}
        }

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                if (!isInteger(array[i][j])) { throw new MyArrayDataException(i, j); }

                sum += Integer.parseInt(array[i][j]);
            }
        }

        return sum;
    }

    public static boolean isInteger (String s) {
        try {
           Integer.parseInt(s);
           return true;
        } catch (Exception e) {
            return false;
        }
    }
}
