public class towerOfHanoi {

    static int moveCount = 0;

    // Moves n disks from 'source' to 'destination', using 'auxiliary' as spare.
    // Core idea: move top (n-1) disks out of the way, move the biggest disk directly,
    // then move the (n-1) disks on top of it.
    static void solve(int n, char source, char destination, char auxiliary) {
        if (n == 0) {
            return; // base case: nothing to move
        }

        solve(n - 1, source, auxiliary, destination);

        moveCount++;
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        solve(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int numberOfDisks = 4;
        System.out.println("Solving Tower of Hanoi for " + numberOfDisks + " disks:");
        solve(numberOfDisks, 'A', 'C', 'B');

        System.out.println("\nTotal moves: " + moveCount);
        System.out.println("Minimum possible moves (2^n - 1): " + (int) (Math.pow(2, numberOfDisks) - 1));
    }
}
