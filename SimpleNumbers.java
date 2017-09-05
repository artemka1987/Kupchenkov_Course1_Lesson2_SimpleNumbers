package Kupchenkov_Course1_Lesson2_SimpleNumbers;

import java.util.Arrays;

/**
 * Created by Artemka on 04.09.2017.
 */
public class SimpleNumbers {

    public static void main(String[] args) {

        //Решето Эратосфена
        System.out.println(Arrays.toString(sieveEratosthenes(10000)));

        // Полный перебор
        for (int i = 0; i < 10000; i++){
            int divider = 0;
            for (int j = 1; j <= i; j++){
                if (i % j == 0){
                    divider++;
                    if (divider > 2){
                        j = i;
                    }
                }
            }
            if (divider == 2){
                System.out.print(i + " ");
            }
        }



    }



    // Метод реализующий алгоритм Решето Эратосфена
    public static int[] sieveEratosthenes(int arraySize){
        int[] array = new int[arraySize];
        for (int i = 2; i < array.length; i++){
            array[i] = i;
        }
        int p = 2;
        do {
            for (int i = 2 * p; i < array.length; i += p) {
                array[i] = 0;
            }
            for (int i = p + 1; i < array.length; i++) {
                if (array[i] != 0) {
                    p = i;
                    i = array.length ;
                }
            }
        }while (p * p < array.length);

        int newArraySize = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > 0){
                newArraySize++;
            }
        }

        int newArrayIndex = 0;
        int[] newArray = new int[newArraySize];
        for (int i = 0; i < array.length; i++){
            if (array[i] > 0){
                newArray[newArrayIndex] = array[i];
                newArrayIndex++;
            }
        }

        return newArray;
    }

}
