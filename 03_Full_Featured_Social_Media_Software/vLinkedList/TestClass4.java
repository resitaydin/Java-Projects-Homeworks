package vLinkedList;
import java.util.LinkedList;

/** Contains a main method to test some scenarios for the social media software.
 * @author R.A.
 * @version 1.0
 * @since 2023-04-04
*/

public class TestClass4 {
    /** Main method to test the functions
     * @param args Arguments for main
     */
    public static void main(String[] args) {
        LinkedList <Account> accounts = new LinkedList <Account> ();

        System.out.println("\n------------------SCENARIO 4 STARTS--------------------\n");

        System.out.println("Creating accounts...\n");
        accounts.add(new Account(0,"gizemsungu", "13.01.1993", "Istanbul"));
        accounts.add(new Account(1,"sibelgulmez", "10.03.1995", "Istanbul"));
        accounts.add(new Account(2,"gokhankaya", "19.03.1986", "Ankara"));
        accounts.add(new Account(3,"aaltan", "21.07.2000", "Eskişehir"));
        accounts.add(new Account(4,"deniz35", "3.11.1999", "Izmir"));
        accounts.add(new Account(5,"cicekpala", "12.02.2002", "Gaziantep"));
        accounts.add(new Account(6,"fatmakaya", "22.05.2001", "Diyarbakır"));
        accounts.add(new Account(7,"ercanogan", "31.12.2001", "Mardin"));
        accounts.add(new Account(8,"husnuyasar", "18.07.2002", "Rize"));
        accounts.add(new Account(9,"egesoylemez", "15.02.2000", "Afyon"));

        System.out.println("aaltan logs in\n");
        accounts.get(3).login(accounts);

        System.out.println("Sharing three posts\n");

        Post post1 = new Post(1, "I love OOP.");
        Post post2 = new Post(2, "Java the coffee...");
        Post post3 = new Post(3, "I like AIs.");

        accounts.get(3).addPost(post1);
        accounts.get(3).addPost(post2);
        accounts.get(3).addPost(post3);

        System.out.println("Following gizemsungu, sibelgulmez, gokhankaya and ercanogan ...\n");

        accounts.get(3).follow(accounts.get(0));
        accounts.get(3).follow(accounts.get(1));
        accounts.get(3).follow(accounts.get(2));
        accounts.get(3).follow(accounts.get(7));

        System.out.println("\nSending a message to ercanogan...");

        accounts.get(3).message("Hey man, it's been a lot since we met!", accounts.get(7));

        accounts.get(3).showHistory();

        System.out.println("Logging out from account 'aaltan'\n");
        accounts.get(3).logout();
        System.out.printf("----------------------------------------------------\n");

        System.out.println("Logging into another account (username: ercanogan)\n");
        accounts.get(7).login(accounts);

        accounts.get(7).viewProfile(accounts.get(3));
        accounts.get(7).viewPosts(accounts.get(3));

        System.out.println("\nLiking a post of aaltan..");
        accounts.get(7).addLike(post3);

        System.out.println("Liking another post of aaltan..");
        accounts.get(7).addLike(post2);

        System.out.println("Adding a comment on a post of aaltan...");
        accounts.get(7).addComment(post3,"I love it!");

        System.out.println("Adding another comment on a post of aaltan...");
        accounts.get(7).addComment(post2,"Whaatt?!");

        System.out.println("Sharing a post\n");

        Post post4 = new Post(1, "I love coding!");

        accounts.get(7).addPost(post4);

        System.out.println("\nFollowing sibelgulmez and aaltan..");

        accounts.get(7).follow(accounts.get(1));
        accounts.get(7).follow(accounts.get(3));

        accounts.get(7).checkInbox();
        accounts.get(7).viewInbox(accounts);

        System.out.println("\nSending a reply message to aaltan...");

        accounts.get(7).message("Yes mate, I miss you!", accounts.get(3));

        System.out.println("Unliking a post of aaltan");
        accounts.get(7).unlike(post2);

        System.out.println("Unfollowing sibelgulmez...");
        accounts.get(7).unfollow(accounts.get(1));

        System.out.println("Blocking aaltan");
        accounts.get(7).blockAccount(accounts.get(3));

        System.out.println("Trying to send a message to aaltan");
        accounts.get(7).message("Hi man", accounts.get(3));

        System.out.println("Uncommenting a post of aaltan");
        accounts.get(7).uncomment(post2);

        System.out.println("Unblocking aaltan\n");
        accounts.get(7).unBlockAccount(accounts.get(3));

        accounts.get(7).showHistory();

        System.out.println("\nLogging out from account 'ercanogan'\n");
        accounts.get(7).logout();

        System.out.printf("----------------------------------------------------\n");

        System.out.println("Logging into another account (username: egesoylemez)\n");
        accounts.get(9).login(accounts);

        System.out.println("egesoylemez follows different accounts....");

        for(int i=0; i<10; ++i){
            if(i!=9)
                accounts.get(9).follow(accounts.get(i));
        }

        System.out.println("\negesoylemez is viewing his own profile\n");
        accounts.get(9).viewProfile(accounts.get(2));

        System.out.println("\negesoylemez views ercanogan's profile\n");
        accounts.get(9).viewProfile(accounts.get(7));
        
        accounts.get(9).viewPosts(accounts.get(7));

        accounts.get(9).addLike(post4);

        accounts.get(9).viewPostInteractions(accounts.get(7), accounts);

        System.out.println("\n------------------SCENARIO 4 ENDS--------------------\n");
    }
}
