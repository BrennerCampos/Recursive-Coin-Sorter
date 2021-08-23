import java.util.Scanner;



public class CoinSorter
{

    static int done = 0;


    public static void coinSorter(int targetValue, int valueSoFar,  int quartersLeft, int dimesLeft, int nickelsLeft, int penniesLeft,  int quartersSpent, int dimesSpent, int nickelsSpent, int penniesSpent) {

        // BASE CASES:

        if (done < 0)       // way of checking if we are done getting an answer
        {
            return;
        }

        if (quartersLeft+dimesLeft+nickelsLeft+penniesLeft == 0)        // if we are out of coins, print valueSoFar instead and quit
        {
            System.out.println(valueSoFar+" cents = " +quartersSpent+ " quarters, " +dimesSpent+ " dimes, " +nickelsSpent+ " nickels, "+penniesSpent+ " pennies");
            done -= 1;   // to mark that we're done reaching our goal
            return;
        }

        if (valueSoFar == targetValue)   // if we have exactly hit our targetValue, print what we have and return;
        {
            System.out.println(targetValue+" cents = " +quartersSpent+ " quarters, " +dimesSpent+ " dimes, " +nickelsSpent+ " nickels, "+penniesSpent+ " pennies");
            done -= 1;   // to mark that we're done reaching our goal
            return;
        }


        if (valueSoFar > targetValue)   // if you go over the target amount
        {
            return;
        }


        // RECURSIVE CASES:   ----> ----> <-----


        // QUARTERS -----------------------------------------------------------------------------------------------
        if ((quartersLeft > 0) &&              // if you have quarters  AND
                ((valueSoFar + 25) <= targetValue))     // if you can still add the quarter's worth to the value and not go over the top
        {
                //valueSoFar += 25;       //add quarter to our value so far
                //  quartersLeft -=1;       // minus 1 of that coin left
                // quartersSpent +=1;      // plus 1 of that coin spent

                coinSorter(targetValue, valueSoFar + 25, quartersLeft - 1, dimesLeft, nickelsLeft, penniesLeft, quartersSpent + 1, dimesSpent, nickelsSpent, penniesSpent);
        }



        // DIMES -----------------------------------------------------------------------------------------------
        if ((dimesLeft > 0) &&              // if you have dimes  AND
                ((valueSoFar + 10) <= targetValue))     // if you can still add the dime's worth to the value and not go over the top
        {
                coinSorter(targetValue, valueSoFar + 10, quartersLeft, dimesLeft - 1, nickelsLeft, penniesLeft, quartersSpent, dimesSpent + 1, nickelsSpent, penniesSpent);
        }




        // NICKELS -----------------------------------------------------------------------------------------------
        if ((nickelsLeft > 0) &&              // if you have dimes  AND
                ((valueSoFar + 5) <= targetValue))     // if you can still add the dime's worth to the value and not go over the top
        {
                coinSorter(targetValue, valueSoFar + 5, quartersLeft, dimesLeft, nickelsLeft - 1, penniesLeft, quartersSpent, dimesSpent, nickelsSpent + 1, penniesSpent);
        }



        // PENNIES ------------------------------------------------------------------------------------------------
        if ((penniesLeft > 0) &&              // if you have dimes  AND
                ((valueSoFar + 1) <= targetValue))     // if you can still add the dime's worth to the value and not go over the top
        {
                coinSorter(targetValue, valueSoFar + 1, quartersLeft, dimesLeft, nickelsLeft, penniesLeft - 1, quartersSpent, dimesSpent, nickelsSpent, penniesSpent + 1);
        }



    }



    public static void main (String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int targetValue = sc.nextInt();


        int quartersLeft = sc.nextInt();
        int dimesLeft = sc.nextInt();
        int nickelsLeft = sc.nextInt();
        int penniesLeft = sc.nextInt();


        int valueSoFar = 0;
        int quartersSpent = 0;
        int dimesSpent = 0;
        int nickelsSpent = 0;
        int penniesSpent = 0;


      coinSorter(targetValue, valueSoFar, quartersLeft, dimesLeft, nickelsLeft, penniesLeft, quartersSpent, dimesSpent, nickelsSpent, penniesSpent);


    }


}


/*

63 3 2 5 3
63 1 2 1 1
108 4 4 4 4
1080 75 7 8 6

 */