package task1;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args){

//        Scanner scanner = new Scanner(System.in);                 // ввод с клавиатуры
//        System.out.println("Введите количество элементов в массиве: ");
//        int n = scanner.nextInt();
//        System.out.println("Укажите длину интервала: ");
//        int m = scanner.nextInt();


        int[] yInt = new int[2]; //массив из командной строки       //ввод арументов в

        for(int i=0; i< args.length; i++){
//            System.out.println(args[i]);
            String y = args[i];
             yInt[i] = Integer.parseInt(y);
        }
//        System.out.println(Arrays.toString(yInt));
        int n = yInt[0];
        int m = yInt[1];

        int[] array = new int[n];

        for(int i = 0; i<n; i++){
            array[i] = i +1;
        }
//         System.out.println(Arrays.toString(array));

        int way = 0;
        System.out.print("Way: ");
        do{
            System.out.print(array[way]);
            way = (way + m - 1) % n;
        }while (way != 0);



    }

}
