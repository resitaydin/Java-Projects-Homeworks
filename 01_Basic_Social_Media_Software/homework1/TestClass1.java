package homework1;

/** Contains a main method to test some scenarios for the social media software.
 * @author R.A.
 * @version 1.0
 * @since 2023-03-19
*/

public class TestClass1 { 
    /** Main method to test the functions
     * @param args Arguments for main
     */
    public static void main(String[] args) {

        System.out.println("\n------------------SCENARIO 1 STARTS--------------------\n");

        Account[] accounts = new Account[3];

        System.out.println("Creating accounts...");

        accounts[0] = new Account(1,"gizemsungu", "13.01.1993", "Istanbul");
        System.out.println("An account with username gizemsungu has been created.");

        accounts[1] = new Account(2,"sibelgulmez", "10.03.1995", "Istanbul");
        System.out.println("An account with username sibelgulmez has been created.");

        accounts[2] = new Account(3,"gokhankaya", "19.03.1986", "Ankara");
        System.out.println("An account with username gokhankaya has been created.\n");

        System.out.println("Logging into an account (username: sibelgulmez)…");
        accounts[1].login(accounts);

        System.out.println("Sharing two posts…");

        Post post1 = new Post(1, "I like Java.");
        Post post2 = new Post(2, "Java the coffee...");

        accounts[1].addPost(post1);
        accounts[1].addPost(post2);
        
        System.out.println("Following gizemsungu and gokhankaya...");

        accounts[1].follow(accounts[0]);
        accounts[1].follow(accounts[2]);
        

        System.out.println("Logging out from account 'sibelgulmez'…\n\n");
        accounts[1].logout();

        System.out.println("Logging into another account (username: gokhankaya)…");
        accounts[2].login(accounts);
        
        accounts[2].viewProfile(accounts[1]);

        accounts[2].viewPosts(accounts[1]);

        System.out.println("Liking a post of sibelgulmez..");
        accounts[2].addLike(post1);

        System.out.println("Adding a comment on a post of sibelgulmez...");
        accounts[2].addComment(post1,"me too!");

        System.out.println("\nFollowing sibelgulmez and gizemsungu...");

        accounts[2].follow(accounts[1]);
        accounts[2].follow(accounts[0]);

        System.out.println("\nSending a message to gizemsungu...");

        accounts[2].message("This homework is too easy!", accounts[0]);

        System.out.println("Logging out from account 'gokhankaya'..\n");
        accounts[2].logout();

        System.out.println("Logging into another account (username: gizemsungu) … ");
        accounts[0].login(accounts);

        accounts[0].checkOutbox();
        accounts[0].checkInbox();
        accounts[0].viewInbox(accounts);
        System.out.println("--------------");
        accounts[0].viewProfile(accounts[1]);
        accounts[0].viewPosts(accounts[1]);

        accounts[0].viewPostInteractions(accounts[1], accounts);

        System.out.println("\nLiking sibelgulmez's posts...");
        accounts[0].addLike(post1);
        accounts[0].addLike(post2);

        accounts[0].viewPostInteractions(accounts[1], accounts);

        System.out.println("\n------------------SCENARIO 1 ENDS--------------------\n");

    }
}
