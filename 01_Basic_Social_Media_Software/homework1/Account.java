package homework1;

/** Represents an account for people to create and login, logout etc.
 * @author R.A.
 * @version 1.0
 * @since 2023-03-19
*/

public class Account {

    private int accountId;
    private String username;
    private String birthdate;
    private String location;
    private Post[] posts; 
    private int postC = 0; // counter for posts
    private Message[] messagesIn;
    private Message[] messagesOut;
    private String[] following;
    private String[] followers;
    private int followerC = 0; // counter for followers
    private int followingC = 0; // counter for following
    private int messageOutC = 0; // counter for message(s)
    private int messageInC = 0;
    private boolean loggedIn;
    private boolean isViewedPost = false; // boolean for debugging purpose.
    private Account[] blockedAccounts;
    private int blockedC = 0;

    /** Creates an account with the specified information.
     * @param accId User's unique account ID.
     * @param uName Username.
     * @param bDate User's birth date.
     * @param loc User's location.
     */

    public Account(int accId, String uName, String bDate, String loc){
        loggedIn = false;
        username = uName;
        birthdate = bDate;
        location = loc;
        following = new String[100]; // allocating memory for string.
        followers = new String[100];
        messagesIn = new Message[100];
        messagesOut = new Message[100];  
        blockedAccounts = new Account[100];
        posts = new Post[100];
        accountId = accId;
    }

    /** Get the user's login status.
     * @return A boolean representing user's login status.
     */

    public boolean isLoggedIn(){
        return loggedIn;
    }

    /** Logs in to the system.
     * @param acc Account array containing all the users that have been created.
     */

    public void login(Account[] acc){ // Revise it later.
        for(Account a : acc){
            if(a.isLoggedIn()){
                System.out.println("Someone is already logged in!\n");
                return;
            }
        }
        loggedIn = true;
    }
    /** Logs out from the system.
     */

    public void logout(){
        if(isLoggedIn())
            loggedIn = false;
        else
            System.out.println("You can't log out beacuse you're not logged in!");
    }

    /** Follows users.
     * @param other An Account object that will be followed.
     * @return A boolean about whether the operation is successful.
     */

    public boolean follow(Account other){
        if(isLoggedIn()){
            for(String element : other.followers){
                if(element == username) return false; // If the user already has that follower.
            }
            following[followingC] = other.username;
            other.followers[other.followerC] = username;
            followingC++;
            other.followerC++;
            return true;
        }
        System.out.println("You have to log in first to follow any account!");
        return false;
    }
    /** Messages to users.
     * @param content A string which contains content of the message.
     * @param other An account object that will be messaged.
     */

    public void message(String content, Account other){
        for(Account a: other.blockedAccounts){
            if(a!=null)
            if(a.username == this.username){
                System.out.println("Oops! Looks like you've been blocked by that account! You cannot message to this account!");
                return;
            }
        }

        if(!isLoggedIn()){
            System.out.println("You have to log in first to message an account!");
            return;
        }

        boolean isFollower = false;
        for(String s: other.followers){
            if(s!=null)
                if(s==username)
                    isFollower = true;
        }

        if(!isFollower){
            System.out.println("You can't message to this user, because you don't follow him/her!");
            return;
        }

        messagesOut[messageOutC] = new Message(messageOutC+1, this.accountId, other.accountId ,content);
        other.messagesIn[other.messageInC] = new Message(other.messageInC+1, this.accountId,other.accountId, content);
        messageOutC++;
        other.messageInC++;
    }

    /** Adds a post to accounts.
     * @param post A Post object that will be posted.
     */

    public void addPost(Post post){
        if(isLoggedIn()){
            posts[postC] = post;
            posts[postC].accountId = accountId;
            postC++;
        }
        else{
            System.out.println("Couldn't share the post because you're not currently logged in!");
        }
    }

    /** Views a profile.
     * @param profile an Account object whose profile will be viewed.
     */

    public void viewProfile(Account profile){
        for(Account a: profile.blockedAccounts){
            if(a!=null)
            if(a.username == this.username){
                System.out.println("Oops! Looks like you've been blocked by that account! You cannot view the profile!\n");
                return;
            }
        }

        if(!isLoggedIn()){
            System.out.println("You can't view a profile because you're not logged in!");
            return;
        }
        System.out.printf("\nViewing %s's  profile...\n", profile.username);

        System.out.printf("User ID: %d\n", profile.accountId);
        System.out.printf("Username: %s\nLocation: %s\n", profile.username, profile.location);
        System.out.printf("Birth Date: %s\n", profile.birthdate);
        System.out.printf("%s is following %d account(s) and has %d follower(s)\n", profile.username, profile.followingC, profile.followerC);

        if(profile.followerC!=0)
            System.out.printf("The followers of %s are: ",profile.username);

        for(String f: profile.followers){
            if(f!= null ) System.out.printf(" %s,", f);
            else break;

        }

        if(profile.followingC!=0)
            System.out.printf("%s is following: ", profile.username);

        for(String f: profile.following){
            if(f!= null ) System.out.printf(" %s,", f);
            else break;
        }

        System.out.printf("\n%s has %d post(s).\n\n", profile.username, profile.postC);
        
    }

    /** Views the posts of a profile.
     * @param profile An Account object whose posts will be viewed.
     */

    public void viewPosts(Account profile){
        if(!isLoggedIn()){
            System.out.println("You can't view the posts of this profile because you're not logged in!");
            return;
        }
        isViewedPost = true;

        System.out.printf("\nViewing %s's posts...\n", profile.username);
        for(Post p : profile.posts){
            if(p!=null) System.out.printf("(PostID: %d) %s: %s\n", p.PostId, profile.username, p.content);
            else{
                System.out.printf("\n");
                    break;
            }
        }
    }
    /** Blocks the desired account.
     * @param bAccount An Account object that will be blocked.
     */

    public void blockAccount(Account bAccount){ // Bonus Part
        blockedAccounts[blockedC] = bAccount;
        blockedC++;
    }
    /** Views a user's posts interactions.
     * @param profile An Account object whose posts interactions' will be viewed.
     * @param arr Account array containing all the users that have been created.
     */

    public void viewPostInteractions(Account profile, Account[] arr){
        if(!isLoggedIn()){
            System.out.println("You can't view the post interactions of this profile because you're not logged in!");
            return;
        }

        System.out.printf("\nViewing %s's posts' interactions...\n", profile.username);
        for(Post p : profile.posts){
            if(p!=null){
                System.out.println("-----------------");
                System.out.printf("(Post ID: %d): %s\n", p.PostId, p.content);
                if(p.likeC!=0)
                System.out.printf("The post was liked by the following account(s): ");
                for(Like l: p.likes){
                    if(l!=null){
                        for(Account acc: arr){
                            if(arr!=null){
                                if(acc.accountId == l.accountID){
                                    System.out.printf("%s,",acc.username);
                                }
                            }
                        }
                    }
                }

                System.out.println();

                if(p.commentC!=0)
                    System.out.printf("The post has %d comment(s)...\n", p.commentC);

                for(Comment c: p.comments){
                    if(c!=null){
                        for(Account acc: arr){
                            if(arr!=null){
                                if(acc.accountId == c.accountID){
                                    System.out.printf("Comment %d: '%s' said '%s'\n",c.interactionId,acc.username,c.content);
                                }
                            }
                        }
                    }
                }

            if(p.likeC==0) { System.out.println("The post has no likes.");}
            if(p.commentC==0) { System.out.println("The post has no comments.");}
            }
            
        }
        
    }
    /** Checks an user's Inbox
     */
    public void checkInbox(){
        System.out.println("Checking Inbox...");
        System.out.printf("There is/are %d message(s) in the inbox.\n\n", messageInC);
    }

    /** Checks an user's Outbox
     */
    public void checkOutbox(){
        System.out.println("Checking Outbox...");
        System.out.printf("There is/are %d message(s) in the outbox.\n\n", messageOutC);
    }

    /** Views an user's inbox.
     * @param acc Account array containing all the users that have been created.
     */
    public void viewInbox(Account[] acc){
        System.out.println("Viewing inbox...\n -------------------");
        for(Message m : messagesIn){
            if(m!=null) {
                System.out.printf("Message ID: %d\n", m.messageId);
                for(Account a: acc){
                    if(a!=null)
                    if(a.accountId == m.senderId){
                        System.out.printf("From: %s\n", a.username);
                    }
                    else if(a.accountId == m.receiverId){
                        System.out.printf("To: %s\n", a.username); 
                    }
                }

                System.out.printf("Message: %s\n\n", m.content);
            }
        }
    }

    /** Adds a like to a post.
     * @param p A Post object which will be liked.
     */

    public void addLike(Post p){
        if(!isViewedPost) {
            System.out.println("You need to view posts before liking a post!");
            return;
        }
        if(!isLoggedIn()){
            System.out.println("You have to log in first to interact with a post!");
            return;
        }
        for(Like l : p.likes){ // To avoid duplicaton
            if(l!=null)
            if(l.accountID == accountId){
                return;
            }
        }
        p.likes[p.likeC] = new Like(p.likeC+1, p);
        p.likes[p.likeC].accountID = accountId;
        p.likeC++;
    }

    /** Adds a comment on a post.
     * @param p // A post object that will be commented.
     * @param text // A string that contains the comment.
     */
    public void addComment(Post p, String text){
        if(!isViewedPost) {
            System.out.println("You need to view posts before commenting a post!");
            return;
        }

        if(!isLoggedIn()){
            System.out.println("You have to log in first to interact with a post!");
            return;
        }

        p.comments[p.commentC] = new Comment(p.commentC+1, text);
        p.comments[p.commentC].accountID = accountId;
        p.comments[p.commentC].postId = p.PostId;
        p.commentC++;
    }

}