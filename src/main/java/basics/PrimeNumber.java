package basics;

public class PrimeNumber {

    public static void main(String[] args) {
        new PrimeNumber().checkIfNumberIsPrime(997);
        new PrimeNumber().primeChecker(997);
    }

    private void checkIfNumberIsPrime(int inputNumber) {
        boolean isPrime = true;
        for(int i=2; i<=Math.sqrt(inputNumber); i++) {
            if (inputNumber % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }


    private void primeChecker(int inputNumber) {
            // Handle edge cases
            if (inputNumber < 2) {
                System.out.println("Not a Prime Number");
                return;
            }
            if (inputNumber == 2) {
                System.out.println("Prime Number");
                return;
            }

            // If number is even and not 2, it's not prime
            if (inputNumber % 2 == 0) {
                System.out.println("Not a Prime Number");
                return;
            }

            // Check for factors only among odd numbers
            for (int i = 3; i <= Math.sqrt(inputNumber); i += 2) {
                if (inputNumber % i == 0) {
                    System.out.println("Not a Prime Number");
                    return;
                }
            }

            System.out.println("Prime Number");
        }

}
