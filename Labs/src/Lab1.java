import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
Числа в порядке убывания частоты встречаемости чисел.
 */
public class Lab1 {
    Lab1(){
        int[] inputData;
        inputData = getInputData();
        if(inputData.length!= 0) {
            ArrayList<Integer> result = getNumbersByFrequencyOfOccurrence(inputData);
            printToConsole(result);
        }

    }
    private int[] getInputData(){
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.print("Write n: ");
        if(scan.hasNextInt()) {
            n = scan.nextInt();
        }else {
            n = 4;
        }
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            if(scan.hasNextInt()){
                list[i] = (scan.nextInt());
            }else{
                scan.next();
                list[i]=-1;
            }
        }
        return list;
    }
    private ArrayList<Integer> getNumbersByFrequencyOfOccurrence(int[] data) {
        int[][] nums = new int[data.length][2];
        countTheNumberOfAppearances(nums,data);
        sortNumsInCount(nums);
        zeroCopies(nums);
        ArrayList<Integer> result = new ArrayList();
        fillListWithData(result,nums);
        return result;
    }
    private void countTheNumberOfAppearances(int [][] nums, int[] data){
        for(int i=0;i<data.length;i++){
            nums[i][0]=data[i];
            nums[i][1]=0;
            for(int j=0;j<data.length;j++){
                if(data[i] == data[j]){
                    nums[i][1]++;
                }
            }
        }
    }
    private void sortNumsInCount(int[][] nums){
        Arrays.sort(nums, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });
    }
    private void zeroCopies(int[][] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i][0]==nums[j][0]){
                    nums[j][1]=-1;
                }
            }
        }
    }
    private void fillListWithData(ArrayList<Integer> result,int[][] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i][1]!=-1){
                result.add(nums[i][0]);
            }
        }
    }
    void printToConsole(ArrayList<Integer> result){
        System.out.println(result);
    }

    public static void main(String []args){
        new Lab1();
    }
}
