package ejercicios;

import java.util.HashMap;
import java.util.Map;

public class ejercicio001 {
    static void main() {
        int[] nums = {1, 3, 2, 3, 4, 3, 2, 1 ,1, 3, 6};

        Map<Integer, Integer> conteo = new HashMap<>();

        for(int n : nums){
            conteo.put(n, conteo.getOrDefault(n,0)+1);
        }

        int maxNum = nums[0];
        int maxCount = 0;

        for(Map.Entry<Integer, Integer> entry : conteo.entrySet()){
            if(entry.getValue()>maxCount){
                maxCount = entry.getValue();
                maxNum = entry.getKey();
            }
        }

        System.out.println(maxNum);
        System.out.println(maxCount);
    }
}
