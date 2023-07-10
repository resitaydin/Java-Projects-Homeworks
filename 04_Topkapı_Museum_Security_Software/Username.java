import java.util.Stack;

/**
 * @author R.A.
 * @version 1.0
 * @since 2023-04-16
 * The Username class represents a password and provides various methods to check its validity and structure.
*/

public class Username {
    /**
    * Determines whether the input username is valid.
    * A valid username contains only letters and
    * the minimum length of the string is 1 (and can be more than 1).
    @param username the string value of the username to validate
    @return true if the username is valid, false otherwise
    @throws IllegalArgumentException if the username is null
    */

    public boolean checkIfValidUsername(String username){ // Recursive function
        if(username.length() < 1 || Character.isDigit(username.charAt(0))){
            return false;
        }
        else if(!Character.isDigit(username.charAt(0))){

            if(username.length() == 1){
                return true;
            }
            return checkIfValidUsername(username.substring(1));
        }
        return true;      
    }

    /**

    Determines whether the input password contains any characters from the username using stack approach.
    @param username the string value of the username to check against
    @param password1 the string value of the password to validate
    @return true if the password contains any characters from the username, false otherwise
    @throws IllegalArgumentException if either username or password1 is null
    */

    public boolean containsUserNameSpirit(String username, String password1){ // Stack Function
        if (username == null || password1 == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        Stack <Character> pw = new Stack <> ();  
        for(int i=0; i< password1.length(); ++i){
            pw.push(password1.charAt(i));
        }

        while(!pw.isEmpty()){
            for(int i=0; i< username.length(); ++i){
                if(username.charAt(i) == pw.peek()){
                    return true;
                }
            }
            pw.pop();
        }

        return false;
        
    }
}
