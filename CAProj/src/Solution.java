import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>();
        int bobScore = 0;
        int aliceScore = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < b.get(i))
                bobScore++;
            else if (b.get(i) < a.get(i))
                aliceScore++;
        }
        res.add(bobScore);
        res.add(aliceScore);
        return res;
    }


    static String catAndMouse(int x, int y, int z) {
        int firstCatToMouse = Math.abs(x-z);
        int secondCatToMouse = Math.abs(y - z);
        if (firstCatToMouse > secondCatToMouse)
            return "Cat B";
        else if (secondCatToMouse > firstCatToMouse)
            return "Cat A";
        else
            return "Mouse C";
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        // Write your code here
        int sum = 0;
        for (int i = 0 ; i < bill.size() ; i++){
            sum += bill.get(i);
        }
        sum -= bill.get(k);
        sum /= 2;
        if (sum == b){
            System.out.println("Bon Appetit");
        }
        else{
            System.out.println(Math.abs(b-sum));
        }
    }

    public static int equal2(List<Integer> arr){
        return helper(arr, 0);
    }
    public static int helper(List<Integer> arr , int currentTrials){
        Collections.sort(arr);
        if (currentTrials > 10000)
            return currentTrials;
        if (isAllSame(arr))
            return currentTrials;
        List<Integer> arr1 = addAll(1 , arr);
        List<Integer> arr2 = addAll(2 , arr);
        List<Integer> arr5 = addAll(5 , arr);
        int c1 = helper(arr1 , currentTrials+1);
        int c2 = helper(arr2 , currentTrials + 1);
        int c3 = helper(arr5 , currentTrials + 1);
        return Math.min(Math.min(c1 , c2) , c3);
    }

    public static int equal(List<Integer> arr) {
        int min = Collections.min(arr);
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0 ; i < 3 ; i++){
            int sum = 0;
            for (int j = 0 ; j < arr.size() ; j++){
                int remSteps = arr.get(j) - (min - i);
                if (remSteps == 0)
                    continue;
                int stepsBy5 = remSteps / 5;
                remSteps %= 5;
                int stepsBy2 = remSteps / 2;
                remSteps %= 2;
                int stepsBy1 = remSteps / 1;
                sum += stepsBy5 + stepsBy2 + stepsBy1;
            }
            if (i == 0)
                n1 = sum;
            if (i == 1)
                n2 = sum;
            if (i==2)
                n3 = sum;
        }
        return Math.min(n1 , Math.min(n2,n3));

    }
    public static void aa(){
        String a = "41241234324";
        Hashtable<Integer , Integer> table = new Hashtable<>();
        if (table.containsKey(3)){
            PriorityQueue<Integer> tt = new PriorityQueue<>();

        }
        BigInteger b = BigInteger.valueOf(15 * 40);
    }

    public static int minArr(List<Integer> arr){
        int smallest = arr.get(0);
        for (int i = 1 ; i < arr.size() ; i++){
            if (arr.get(i) < smallest)
                smallest = arr.get(i);
        }
        return smallest;
    }
    public static int maxArr(List<Integer> arr){
        int largest = arr.get(0);
        for (int i = 1 ; i < arr.size() ; i++){
            if (arr.get(i) > largest)
                largest = arr.get(i);
        }
        return largest;
    }
    public static int getMaxIndex(List<Integer> arr){
            int largest = 0;
            for (int i = 1 ; i < arr.size() ; i++){
                if (arr.get(i) > arr.get(largest))
                    largest = i;
            }
            return largest;
    }
    public static List<Integer> addAll(int toAdd , List<Integer> arr){
        List<Integer> l = new ArrayList<>();
        for (int i = 0 ;i < arr.size() - 1 ; i++)
            l.add(arr.get(i) + toAdd);
        l.add(arr.get(arr.size() - 1));
        return l;
    }
    public static boolean isAllSame(List<Integer> arr){
        return arr.get(0) == arr.get(arr.size() - 1);
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();
        r1.add(2);
        r1.add(2);
        r1.add(3);
        r1.add(7);
        int res = Result.equal(r1);
        System.out.println(canConstruct("aa" , "aab"));

        int[] a = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(a));
        Hashtable<Integer , Integer> a = new Hashtable<>();
        a.cl

    }
    public static int removeDuplicates(int[] nums) {
        int max = Integer.MAX_VALUE;
        boolean haveD = false;
        boolean next = false;
        int k = 1;
        for (int i = 1 ; i < nums.length ; i++){
            if(nums[i] == nums[i-1]){
                if(haveD){
                    if (i != nums.length-1 && nums[i+1] == nums[i])
                        next = true;
                    nums[i] = max;
                }
                else{
                    haveD = true;
                    k++;
                }
            }
            else{
                if (next){
                    if (i != nums.length-1 && nums[i+1] == nums[i])
                        next = true;
                    else
                        next = false;
                    nums[i] = max;
                    continue;
                }
                haveD = false;
                k++;
            }
        }

        int swaps = nums.length - k;
        for (int i = 0 ; i < swaps ; i++){
            for (int j = 0 ; j < nums.length-1-i ; j++){
                if (nums[j] == max){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for (int i = 0 ; i < k ; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
        return k;

    }

    public static boolean isUgly(int n) {
        if (n == -2147483648)
            return false;
        n = Math.abs(n);
        if (n<=1)
            return true;
        if (n < 7)
            return true;
        for (int i = 7 ; i < n ; i++){
            if (n%i == 0 && isPrime(i))
                return false;
        }
        return true;
    }

    public static boolean isPrime(int n){
        for (int i = 2 ; i < n ; i++){
            if (n%i == 0)
                return false;
        }
        return true;
    }

    public static void rotate(int[][] matrix){ // i == y , j == x
        int n = matrix.length - 1;
        for (int i = 0 ; i < matrix.length ; i++){
            for (int j = 0 ; j < matrix[i].length ; j++){
                if (j < i || n-i < i || n-j < i){
                    continue;
                }
                if ((j==i && n-i < j) || (n-i == i && n-j < j) || (n-j == i && i < j))
                    continue;
                int firstPlace = matrix[i][j]; // x = j , y = i
                int secondPlace = matrix[j][n-i]; // x = n-i , y = j
                int thirdPlace = matrix[n-i][n-j]; // x = n-j , y = n-i
                int fourthPlace = matrix[n-j][i]; // x = i , y = n-j
                matrix[j][n-i] = firstPlace;
                matrix[n-i][n-j] = secondPlace;
                matrix[n-j][i] = thirdPlace;
                matrix[i][j] = fourthPlace;
            }
        }
    }
    public static void spiral(int n){
        int[][] matrix = new int[n][n];
        int maxI = n-1;
        boolean hor = true;
        int j = 0;
        int i = 0;
        boolean horInc = true;
        boolean verInc = true;
        System.out.println(matrix[0][0]);
        for (int curr = 1 ; curr <= (n*n) ; curr++){
            if (hor){
                matrix[i][j] = curr;
                if (j == maxI || (j == 0 && i!=0) || (horInc && matrix[i][j+1] != 0) || (!horInc && matrix[i][j-1] != 0)) {
                    hor = false;
                    if (i != 0 && matrix[i-1][j] == 0) {
                        i--;
                        verInc = false;
                    }
                    else {
                        i++;
                        verInc = true;
                    }
                    continue;
                }
                if (!horInc)
                    j--;
                else
                    j++;
            }
            else{
                matrix[i][j] = curr;
                if (i == maxI || i == 0 || (verInc && matrix[i+1][j] != 0) || (!verInc && matrix[i-1][j] != 0)) {
                    hor = true;
                    if (j != 0 && matrix[i][j-1] == 0) {
                        j--;
                        horInc = false;
                    }
                    else {
                        j++;
                        horInc = true;
                    }
                    continue;
                }
                if (!verInc)
                    i--;
                else
                    i++;

            }
        }
        for (i = 0 ; i < matrix.length ; i++) {
            for (j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        Hashtable<Character, Integer> ransom = new Hashtable<>();
        for (int i = 0 ; i < magazine.length() ; i++){
            if (ransom.containsKey(magazine.charAt(i))){
                ransom.put(magazine.charAt(i) , ransom.get(magazine.charAt(i)) + 1);
            }
            else
                ransom.put(magazine.charAt(i) , 1);
        }
        for (int i = 0 ; i < ransomNote.length() ; i++){
            if (!ransom.containsKey(ransomNote.charAt(i)) || ransom.get(ransomNote.charAt(i)) == 0)
                return false;
            ransom.put(ransomNote.charAt(i) , ransom.get(ransomNote.charAt(i)) - 1);

        }
        return true;

    }
}
