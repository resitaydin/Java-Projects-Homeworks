import java.util.Stack;

/**
 * @author R.A.
 * @version 1.0
 * @since 2023-04-16
 * The Password1 class represents a password and provides various methods to check its validity and structure.
*/

public class Password1 {
    private int[] alfabet;
    String password1;

    /*
     * Constructs a new Password1 object.
     */
    Password1(){
        alfabet = new int[128];
    }

    /**
     * Constructs a new Password1 object with the given password string.
     * 
     * @param password the password string to be checked
     */

    Password1(String password){
        alfabet = new int[128];
        password1 = password;
    }

    /**
     * Checks whether the given password string is valid or not.
     * A valid password contains only letter and brackets (‘{‘, ‘}’, ‘[‘, ‘]’, ‘(‘, ‘)’). Each
     * string password must contain at least 2 brackets. The minimum length of the string must be 8,
     * including the brackets (and can be more than 8)
     * 
     * @param password1 the password string to be checked
     * @return true if the password is valid, false otherwise
     * @throws IllegalArgumentException if the input password string is null or empty
     */


    public boolean isValid(String password1){
        if (password1 == null || password1.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty!");
        }
        int counter = 0;
        int charCounter = 0;
        boolean valid = false;
        if(password1.length() < 8){
            return false;
        }
        else{
            for(int i=0; i< password1.length(); ++i){
                if(password1.charAt(i) >= 65 &&  password1.charAt(i) <= 90 ){
                    charCounter++;
                    valid = true;
                }
                else if(password1.charAt(i) >= 97 &&  password1.charAt(i) <= 122){
                    charCounter++;
                    valid = true;
                }
                else if(password1.charAt(i)== 40 || password1.charAt(i) == 41 || password1.charAt(i)== 91){
                    counter++;
                    valid = true;
                }
                else if(password1.charAt(i) == 93 || password1.charAt(i) == 123 || password1.charAt(i) == 125){
                    counter++;
                    valid = true;
                }
                else{
                    valid = false;
                }
            }
        }
        return counter > 1 && valid && charCounter > 0;
    }

    /**
     * Checks whether a palindrome can be obtained using the given password string.
     * The method considers if it is possible to obtain a palindrome by rearranging the letters
     * in the string. The function ignores the brackets in the string while computing the function
     *
     * @param password1 the password string to be checked
     * @param isBracketsRemoved boolean value to be used to remove the brackets just once but not always.
     * @return true if a palindrome can be obtained using the password, false otherwise
     * @throws IllegalArgumentException if the input string is null
     */

    public boolean isPalindromePossible(String password1, boolean isBracketsRemoved){
        if(!isBracketsRemoved){
            password1 = this.removeBrackets(password1);
            isBracketsRemoved = true;
        }

        if (password1 == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        if(password1.length() == 0){
            return true;
        }

        int counter = 0, counter1 = 0, counter2 = 0;

        int size = password1.length();

        alfabet[password1.charAt(size-1)]++;

        if(size == 1){

            for(int i=0; i<alfabet.length; ++i){
                counter+=alfabet[i];
            }

            for(int i=0; i<alfabet.length; ++i){
                if(alfabet[i]%2==0){
                    counter1++;
                }
                else counter2++;
            }

            if(counter%2==0){
                if(counter1 == alfabet.length){
                    return true;
                }
                return false;
            }

            if(counter2>1){
                return false;
            }

            return true;
        }
        
        return isPalindromePossible(password1.substring(0, size -1), isBracketsRemoved);

    }

    /**
     * Checks whether the input string password contains balanced pairs of parentheses, square brackets, and curly braces.
     * 
     * @param password The string to be checked for balanced pairs of parentheses, square brackets, and curly braces.
     * @return A boolean value indicating whether the input string contains balanced pairs of parentheses, square brackets, and curly braces.
     * @throws IllegalArgumentException if the input password is null.
     */
    
    public boolean isBalancedPassword(String password) { // Stack Function
        if (password == null) {
            throw new IllegalArgumentException("Input password cannot be null");
        }

        Stack<Character> parens = new Stack<Character>();
        Stack<Character> brackets = new Stack<Character>();
        Stack<Character> braces = new Stack<Character>();
        
    
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            
            switch (ch) {
                case '{':
                    braces.push(ch);
                    break;
                case '}':
                    if (braces.isEmpty() || braces.pop() != '{') {
                        return false;
                    }
                    break;
                    
                case '(':
                    parens.push(ch);
                    break;
                case ')':
                    if (parens.isEmpty() || parens.pop() != '(') {
                        return false;
                    }
                    break;
                case '[':
                    brackets.push(ch);
                    break;
                case ']':
                    if (brackets.isEmpty() || brackets.pop() != '[') {
                        return false;
                    }
                    break;
                
                default:
                    break;
            }
        }
    
        return parens.isEmpty() && brackets.isEmpty() && braces.isEmpty();
    }

    /**
     * A helper method that removes all occurrences of the characters '{', '}', '(', ')', '[', ']' from the input string pw.
     *
     * @param pw The string to be processed.
     * @return A new string with all occurrences of the characters '{', '}', '(', ')', '[', ']' removed.
     * @throws IllegalArgumentException if the input string is null.
     */

    public String removeBrackets(String pw){ // Helper method.
        if (pw == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        String withoutBrackets = new String();
        for(int i=0; i<pw.length(); ++i){
            if(pw.charAt(i)!='{' && pw.charAt(i)!='}' && pw.charAt(i)!='(' && pw.charAt(i)!=')' && pw.charAt(i)!='[' && pw.charAt(i)!=']'){
                withoutBrackets += pw.charAt(i);
            }
        }
        return withoutBrackets;
    }
}
