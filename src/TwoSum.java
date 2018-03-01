import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> argsMap = new HashMap();

        for (int index = 0; index < nums.length; index ++) {
            argsMap.put(nums[index], index);
        }

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (argsMap.containsKey(difference) && argsMap.get(difference) != i) {
                return new int[]{i, argsMap.get(difference)};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] a = {1,3,4};
        System.out.println(Arrays.toString(twoSum(a, 5)));
    }
}

/**
 * 遇到的问题：
 * 向下转型
 * 基础类型变量数组不能直接使用asList方法，asList的参数必须是对象！
 */
