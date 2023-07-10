package homework1;

/** Represents likes that is used for giving on posts.
 * @author R.A.
 * @version 1.0
 * @since 2023-03-19
*/
public class Like extends Interaction{
    
    /** Creates a Like object.
     * @param id An integer which is unique id of post.
     * @param post A Post object which will be liked.
     */
    public Like(int id, Post post){
        interactionId = id;
        postId = post.PostId;
    }
}
