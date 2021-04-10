import java.util.Scanner;
import java.util.InputMismatchException;
/*
  Вычислить определитель матрицы
 */
public class Lab2 {
    Lab2(){
        try {
            double[][] matrix;
            matrix = getInputData();
            double result = getDeterminant(matrix);
            System.out.println("result = " + result);
        }catch(InputMismatchException e){
            System.out.println("Incorrect data " +e);
        }
    }
    private double[][] getInputData() throws InputMismatchException{
        double [][] result = null;
        Scanner scan = new Scanner(System.in);
        System.out.print("Write n: ");
        int n = scan.nextInt();
        if(n>=1){
            result = new double[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    result[i][j] = scan.nextDouble();
                }
            }
        }
        else throw new InputMismatchException("n<1");
        return result;
    }
    private double getDeterminant(double [][] matrix){
        double result=0;
        int n=matrix.length;
        if(matrix.length==1){
            return matrix[0][0];
        }
        else {
            for (int i = 0; i < n; i++) {
                double[][] subMatrix = new double[n-1][n-1];
                boolean wasSkippingRow = false;
                for(int k = 0;k<n;k++){
                    for(int l=1;l<n;l++){
                        if(wasSkippingRow) {
                            subMatrix[k - 1][l - 1] = matrix[k][l];
                        }
                        else
                            if(k!=i)
                                subMatrix[k][l-1] = matrix[k][l];
                            else
                                wasSkippingRow = true;
                        if(k==i) break;
                    }
                }
                result += Math.pow(-1,i+0)* matrix[i][0]*getDeterminant(subMatrix);
            }
            return result;
        }
    }





    public static void main(String [] args){
        new Lab2();
    }
}
