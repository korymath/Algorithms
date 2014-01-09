import java.util.ArrayList;
import java.util.Arrays;


public class subsets {

    public static ArrayList<ArrayList<Integer>> generateSubsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (S.length == 0) {
            return result;
        }

        Arrays.sort(S);
        for (int i = 0; i < S.length + 1; i++) {
            ArrayList<Integer> intermediate = new ArrayList<Integer>();
            getSubset(S, intermediate, result, i, 0);
        }

        return result;
    }

    private static void getSubset(int[] S, ArrayList<Integer> intermedaite, ArrayList<ArrayList<Integer>> result, int targetSize, int offsetInSet) {
        if (intermedaite.size() == targetSize) {
            result.add(new ArrayList<Integer>(intermedaite));
            return;
        }

        for (int i = offsetInSet; i < S.length; i++) {
            intermedaite.add(S[i]);
            getSubset(S, intermedaite, result, targetSize, i + 1);
            intermedaite.remove(intermedaite.size() - 1);
        }
    }

    public static void main(String[] args) {
        generateSubsets(new int[] { 0 });
        generateSubsets(new int[] { 1, 2, 3, 4 });
    }
}