package task1;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов в массиве: ");
        int n = scanner.nextInt();
        System.out.println("Укажите длину интервала: ");
        int m = scanner.nextInt();
        int[] array = new int[n];

        for(int i = 0; i<n; i++){
            array[i] = i +1;
        }
//         System.out.println(Arrays.toString(array));

        int way = 0;
        System.out.print("Путь: ");
        do{
            System.out.print(array[way]);
            way = (way + m - 1) % n;
        }while (way != 0);



    }

}
