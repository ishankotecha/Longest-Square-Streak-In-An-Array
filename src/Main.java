import java.io.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] array = {4,2,16};
        System.out.println(longestSquareStreak(array));
    }
    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
        }

        int longestStreak = -1;

        for(int num : nums)
        {
            int root = (int) Math.sqrt(num);
            if(root * root != num || !set.contains(root))
            {
                int length = 1;
                long current = num;

                while(true)
                {
                    long next = current * current;
                    if(next > 100000 || !set.contains((int)next))
                    {
                        break;
                    }
                    current = next;
                    length++;
                }

                if(length > 1)
                {
                    longestStreak = Math.max(longestStreak, length);
                }
            }
        }
        return longestStreak;
    }
}
