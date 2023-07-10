/**
 * @author R.A.
 * @version 1.0
 * @since 2023-04-16
 * The Password2 class represents a password and provides various methods to check its validity and structure.
*/

public class Password2 {
    /**
     * Determines whether the input password is a valid password or not.
     * A password is considered valid if it is a positive integer between 10 and 10000.
     * 
     * @param password2 the integer value of the password to validate
     * @return true if the password is valid, false otherwise
     */

    public boolean isValid(int password2){
        if (password2 <= 10 || password2 >= 10000){
            return false;
        }

        return true;
    }

    /**
     * Checks if the given password can be divided exactly by any possible combination of the given denominations.
     * 
     * @param password2 the integer value of the password to validate
     * @param denominations the array of integers representing the denominations to check against
     * @param length the length (size) of the denominations array
     * @return true if the password can be exactly divided by any combination of denominations, false otherwise
     * @throws IllegalArgumentException if the denominations array is null
     */

    public boolean isExactDivision(int password2, int[] denominations, int length){
        if (denominations == null) {
            throw new IllegalArgumentException("Denominations array cannot be null");
        }

        if(password2 == 0){
            return true;
        }

        if (denominations == null || length == 0) {
            return false;
        }

        while(password2 / denominations[length-1]!=0){
            password2 -= denominations[length-1];
        }

        return isExactDivision(password2, denominations, length-1);

    }
}
