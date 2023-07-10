 /**
 * @author R.A.
 * @version 1.0
 * @since 2023-04-16
 * Test class which contains main method.
*/

public class Test {

    
    /**
     * Helper method to be used in main method.
     * 
     * @param usr User object
     * @param pw1 Pasword1 object
     * @param pw2 Password2 object
     * @param username String containing username
     * @param password1 Password1 containing string password
     * @param password2 Password2 containing int password
     * @param denom Denominations array
     */
    public static void testHelper(Username usr, Password1 pw1, Password2 pw2, String username, String password1, int password2, int[] denom){
        pw1 = new Password1();

        boolean b1 = usr.checkIfValidUsername(username);
        boolean b2 = pw2.isValid(password2);
        boolean b3 = pw1.isValid(password1);
        boolean b4 = usr.containsUserNameSpirit(username, password1);
        boolean b5 = pw1.isBalancedPassword(password1);
        boolean b6 = pw1.isPalindromePossible(password1, false);
        boolean b7 = pw2.isExactDivision(password2, denom, 3);
        

        if( b1 && b2 && b3 && b4 && b5 && b6 && b7){
            System.out.println("The username and passwords are valid. The door is opening, please wait...");
        }
        else if(!b1){
            System.out.println("The username is invalid. It should have letters only and it can't be empty.");
        }
        else if(!b2){
            System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
        }
        else if(!b3){
            System.out.println("The password1 is invalid. It should have at least 8 characters and 2 brackets. It should at least have one letter.");
        }
        else if(!b4){
            System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
        }
        else if(!b5){
            System.out.println("The password1 is invalid. It should be balanced.");
        }
        else if(!b6){
            System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
        }
        else if(!b7){ 
            System.out.println("The password2 is invalid. It is not compatible with the denominations.");
        }
        else{
            System.out.println("Invalid credentials.");
        }
    }

    /**
     * Main method to test methods of classes.
     * @param args is an array of String objects that will be used to test methods of classes
     */
    public static void main(String[] args) {

        int[] denom = {4,17,29};

        String username = "gokhan";
        String password1 = "{[(abacaba)]}";
        int password2 = 75;

        Password1 pw1 = new Password1(password1);
        Password2 pw2 = new Password2();
        Username usr = new Username();

        System.out.println("\n-----------------TEST CASE 1---------------------");
        testHelper(usr, pw1, pw2, username, password1, password2, denom);


        System.out.println("\n-----------------TEST CASE 2---------------------");
        testHelper(usr, pw1, pw2, "sibelgulmez", "[rac()ecar]", 74, denom);


        System.out.println("\n-----------------TEST CASE 3---------------------");
        testHelper(usr, pw1, pw2, "", "[rac()ecar]", 74, denom);


        System.out.println("\n-----------------TEST CASE 4---------------------");
        testHelper(usr, pw1, pw2, "x123abc", "[rac()ecar]", 74, denom);
        

        System.out.println("\n-----------------TEST CASE 5---------------------");
        testHelper(usr, pw1, pw2, "ahmet", "pass[]", 74, denom);


        System.out.println("\n-----------------TEST CASE 6---------------------");
        testHelper(usr, pw1, pw2, "ahmet", "abcdabcd", 74, denom);

        System.out.println("\n-----------------TEST CASE 7---------------------");
        testHelper(usr, pw1, pw2, "ahmet", "[[[()]]]", 74, denom);


        System.out.println("\n-----------------TEST CASE 8---------------------");
        testHelper(usr, pw1, pw2, "ahmet", "[hya](xyz)", 74, denom);


        System.out.println("\n-----------------TEST CASE 9---------------------");
        testHelper(usr, pw1, pw2, "ahmet", "[axhs{})", 74, denom);


        System.out.println("\n-----------------TEST CASE 10---------------------");
        testHelper(usr, pw1, pw2, "ahmet", "[r{sxayr}s]", 74, denom);
        

        System.out.println("\n-----------------TEST CASE 11---------------------");
        testHelper(usr, pw1, pw2, "ahmet", "[rac()ecar]", 28, denom);
        
        System.out.println("\n-----------------TEST CASE 12---------------------");
        testHelper(usr, pw1, pw2, "newuser", "{abeccbaxx()}", 54, denom);
        
    }
}
