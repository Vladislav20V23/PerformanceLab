package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Task4 {


    public static void main(String[] args) throws FileNotFoundException {


        Scanner scannerSystem = new Scanner(System.in);
        System.out.println("Укажите расположение файла c массивом целых чисел:  ");
        String argumentOne = scannerSystem.nextLine();
//   C:\Users\Владислав\IdeaProjects\PerformanceLab\src\main\java\task4\nums.txt


        Scanner scanner = new Scanner(new File(argumentOne));

        List<Long> array = new ArrayList<>();

        while (scanner.hasNextLong()){
            array.add(scanner.nextLong());
        }

        Long[] nums = array.stream()
                .toArray(Long[]::new);;


//        System.out.println(Arrays.toString(nums));

        long min = Collections.min(Arrays.stream(nums).sorted().collect(Collectors.toList()));
        long max = Collections.max(Arrays.stream(nums).sorted().collect(Collectors.toList()));

        double average = 0;
        if (nums.length > 0) {
            double sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
            }
            average = sum / nums.length;
        }

        long averageInt = Math.round(average);      //к нему приводим

//        System.out.println(min);
//        System.out.println(max);
//        System.out.println(average);
//        System.out.println(averageInt + "!!!!");



        int y = 0;
        for(long x : nums){
            while (x != averageInt){
                y++;
                if (x < averageInt){
                    x++;
                } else {
                    x--;
                }
            }
        }
        System.out.println("y = " + y);





    }

}
