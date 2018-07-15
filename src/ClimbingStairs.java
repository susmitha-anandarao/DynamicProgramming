import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Compute the number of ways to climb stairs - Dynamic Programming way.
 */
public class ClimbingStairs {

    private static int waysToClimbStairs(final int numberOfStairs, final int numberOfBaseWays) {
        final int[] totalNumberOfWays = new int[numberOfStairs];

        totalNumberOfWays[0] = 1;
        totalNumberOfWays[1] = 1;

        for (int i = 2; i < numberOfStairs; i++) {
            totalNumberOfWays[i] = 0;
            for (int j = 1; j <= numberOfBaseWays && j <= i; j++) {
                totalNumberOfWays[i] += totalNumberOfWays[i - j];
            }
        }

        return totalNumberOfWays[numberOfStairs - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of stairs: ");
        int input = Integer.parseInt(br.readLine());
        System.out.print("Enter number of base ways: ");
        int baseWays = Integer.parseInt(br.readLine());
        if(baseWays > input){
            System.out.println("Number of ways should be less than or equal to number of stairs.");
            return;
        }
        System.out.println("Number of possible ways for " + input + " stairs = " + waysToClimbStairs(input + 1, baseWays));
    }
}
