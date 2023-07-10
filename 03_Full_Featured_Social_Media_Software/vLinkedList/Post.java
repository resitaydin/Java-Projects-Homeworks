package vLinkedList;
import java.util.LinkedList;

/** Represents a post for people to share.
 * @author R.A.
 * @version 1.0
 * @since 2023-03-19
*/

public class Post {
    protected int PostId;
    protected int accountId;
    protected String content;
    protected LinkedList <Like> likes;
    // protected int likeC = 0;
    // protected int commentC = 0;
    protected LinkedList <Comment> comments;

    /** Creates a Post object.
     * @param id An integer which is unique id of post.
     * @param cnt A string which is content of the post.
     */

    public Post(int id, String cnt){
        PostId = id;
        content = cnt;
        likes = new LinkedList<Like> ();
        comments = new LinkedList<Comment> ();
    }

}
