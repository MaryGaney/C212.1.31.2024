import java.util.Scanner;

public class IterationDemo {
    /**
     * returns the number of years it will take to double the given amount
     * @param amount
     * @return number of years
     */
    public static int doubleInvestment(double amount){
        final double RATE = 0.05;
        final double TARGET = 2 * amount;
        double balance = amount;
        int years = 0;

        //while balance is not doubled
        while(balance <= TARGET){
            //update the balance
            balance += balance * RATE;
            //increment the number of years
            years++;
        }
        return years;
    }

    /**
     * returns the number of years it will take to double the given amount
     * @param amount
     * @return number of years
     */
    public static int doubleInvestment2(int amount){
        final double RATE = 0.05;
        final double TARGET = 2 * amount;
        //double balance = amount
        int years = 0;

        //fori and tab
        //initialize, test, update, increment/output
        for (double balance = amount; balance <= TARGET; balance += balance * RATE){
            years++;
        }

        return years;
    }

    /**
     * retursn the balance at the end of the given amount of years using for loop
     * @param n
     * @param amount
     * @return balance
     */
    public static double balanceAfterNYears(int n, double amount){
        final double RATE = 0.05;
        final double TARGET = 2 * amount;
        double balance = amount;
        int years = 0;

        //fori and tab
        for (int i = 0; i < n; i++) {
            balance += balance * RATE;
        }
        return balance;
    }

    public static void averageSalary(){ //void since not taking any param
        Scanner in = new Scanner(System.in);
        //prompt the user for input
        System.out.println("enter salaries: -1 to quit");
        double salary = 0;
        double sum = 0;
        double avg = 0;
        double counter = 0;

        salary = in.nextDouble();
        while(salary !=-1){

            //compute the sum
            sum += salary;
            //increment the counter
            counter++;
            //take input from the user  -> do this last to prevent -1 in the calculations
            salary = in.nextDouble();

        }

        //compute average
        if(counter>0){
            avg = sum/counter;
        }
        System.out.println("Avg salary " + avg); //ex: 10,20,30,-1 avg = 20.0
    }

    public static void maxSalary(){//void since not taking any param
        Scanner in = new Scanner(System.in);
        //prompt the user for input
        System.out.println("enter salaries: -1 to quit");
        double salary; //initialize before using in while loop

        salary = in.nextDouble(); //take input before loop to prevent count increasing in calculator
        double max = salary;
        while (salary != -1) {

            //if the current value of salary is greater than max
            //assign this value to max
            if(salary > max){
                max = salary;
            }
            //take the next input
            salary = in.nextDouble();
        }
        System.out.println("Max salary = " + max); //ex: 10,20,30,-1 max -> 30
    }
    public static void powerOfX(int x, int n){
        for(int i = 1; i <= x; i++){
            for(int j = 1; j <=n; j++){
                System.out.println(Math.pow(i,j) + " ");//row/horizontally display
            }
            System.out.println(); //break each j into columns
        }
    }

    public static long factorialTR(int n){
        return factorialTRH(n,1);
    }
    /**
     * factorial tail recursive helper method
     * @param n
     * @param acc
     * @return factorial of n
     */
    public static long factorialTRH(int n, int acc){
        if (n<=1){
            return acc;
        } else{
            return factorialTRH(n-1,acc*n);
        }
    }
    /*
        problem on the board
        ni = ni-1 - 1
        ai = ai-1 * ni-1
        while(){
        a = a * n
        n = n-1
        n = n-1
        }
     */

    public static long factorialI(int n) {
        int acc = 1;
        while(n > 1){
            acc = n * acc;
            n--;
        }
        return acc;
    }

    public static long fibonacciTR(int n){
        return fibonacciTRH(n,1,0);
    }

    public static long fibonacciTRH(int n, int acc, int last){
        if (n <= 1){
            return acc;
        } else{
            return fibonacciTRH(n-1, acc*last, acc);
        }
    }

    public static long fibonacciI(int n){
        if (n<1){
            return 0;
        }

        int acc = 1;
        int last = 0;

        while(n>1){
            int temp = acc + last;
            last = acc;
            acc = temp;
            n--;
        }

        return acc;
    }

    /**
     * determine if a given number is a prime number
     * @param n
     * @return true or false
     */

    public static boolean isPrime(int n){

        if (n <= 1){
            return false;
        }
        int bound = (int) Math.sqrt(n);

        //generate numbers from 2 to sqrt(n)
        //if any generated number divides the given number
        //the given number is not prime
        for (int i = 2; i <= bound; i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * computes the sum of first n prime numbers
     * @param n
     * @return sum of n prime numbers
     */
    public static int sumPrimes(int n){
        int counter = 0;
        int sum = 0;
        int i = 0;

        while(counter < n){
            if(isPrime(i)){
                counter++;
                sum +=i;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        //int y = doubleInvestment2(1000)
        int y = doubleInvestment2(1000);
        System.out.println("It will take " + y + "years to double the amount");
        double balance = balanceAfterNYears(15,1000);
        //balance should be a little over 2000 since it's double the amount
        System.out.println("Balance at the end of 15 years" + balance);

        //tophat
        for (int i = 5; i >0 ; i--) {
            System.out.println(i + " ");
        } //5 4 3 2 1

        System.out.println("");

        //averageSalary();
        //maxSalary();
        powerOfX(10,4);

        //in class example
        //2x1, 3x1
        //last 2x10 = 20, 3x10 = 30
        for (int i = 2; i <= 20 ; i++) {
            for (int j = 1; j <= 10 ; j++) {

            }
        }

        for (int i = 0; i < 10; i++){
            System.out.println(fibonacciI(5));
        }

        System.out.println(sumPrimes(10));
    }
}
