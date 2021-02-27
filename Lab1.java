import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lab1 {
    Lab1(){
        int[] inputData;
        try{
            inputData = getInputData();
            if(inputData.length!= 0) {
                int[] result = getNumbersByFrequencyOfOccurrence(inputData);
                System.out.print(result[0]);
                for(int i=1;i<result.length;i++)
                    if(result[i-1] != result[i]) System.out.print(" "+result[i]);
            }

        }catch(java.util.InputMismatchException e){
            System.out.println("Incorrect data");
        }
    }
    private int[] getInputData() throws java.util.InputMismatchException{
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.print("Write n: ");
        n = scan.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = (scan.nextInt());
        }
        return list;
    }
    private int[] getNumbersByFrequencyOfOccurrence(int[] data) {
        int[][] nums = new int[data.length][2];
        for(int i=0;i<data.length;i++){
            nums[i][0]=data[i];
            nums[i][1]=0;
            for(int j=0;j<data.length;j++){
                if(data[i] == data[j]){
                    nums[i][1]++;
                }
            }
        }

        Arrays.sort(nums, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });

        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i] = nums[i][0];
        }

        return result;
    }

    public static void main(String []args){
        new Lab1();
    }
}
