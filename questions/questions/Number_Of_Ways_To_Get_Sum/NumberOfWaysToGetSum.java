package questions.Number_Of_Ways_To_Get_Sum;

public class NumberOfWaysToGetSum {

    static int numberOfWaysToGetSum(int n,int k){
        int[][] arr = new int[k+1][n+1];

        for(int i=0;i<=n;i++){
            arr[0][i]=0;
            arr[1][i]= 1;
        }
        for(int i=0;i<=k;i++){
            arr[i][0]=1;
        }
        for(int i=2;i<=k;i++){
            for(int j=1;j<=n;j++){
                if(j>=i){
                arr[i][j]= arr[i][j-i]+ arr[i-1][j];
                }
                else{
                    arr[i][j] =arr[i-1][j];
                }
                //System.out.print(arr[i][j]+" ");
            }
           // System.out.println("");
        }

        return arr[k][n];
    }
    public static void main(String[] args) {
        System.out.println(numberOfWaysToGetSum(8,2));
        System.out.println(numberOfWaysToGetSum(5,3));
    }
}
