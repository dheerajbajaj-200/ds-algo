package questions.GenerateCombinationsBalancedParanthesis;


/*
* Write a function to generate all possible n pairs of balanced parentheses.
Examples:

Input: n=1
Output: {}
Explantaion: This the only sequence of balanced
parenthesis formed using 1 pair of balanced parenthesis.

Input : n=2
Output:
{}{}
{{}}
Explantaion: This the only two sequences of balanced
parenthesis formed using 2 pair of balanced parenthesis.
*
*
* */
public class BalancedParanthesisCombinations {



    static void printParanthesis(String str,int open,int close,int n){
        // n pairs completed -> print the sequence
        if(close==n){
            System.out.println(str);
            return;
        }

        if(open<n){
          printParanthesis(str+"{",open+1,close,n);
        }
        if(open>close){
            printParanthesis(str+"}",open,close+1,n);
        }

    }
    static void printBalancedParanthesis(int n){

        if(n>0){
            printParanthesis("",0,0,n);
        }
    }
// length of string -> 2n
    // valid combination at any given point the number of ( should not be lesser than )

    // ((())) // (()()) // ()()()  -> (())() -> ()(())
          //3   // 2     // 1        // 2     // 2

    public static void main(String[] args) {
        int n= 3;
        printBalancedParanthesis(n);
    }

}
