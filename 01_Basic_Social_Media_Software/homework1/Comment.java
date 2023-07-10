package homework1;

/** Represents a comment that people can use it under the posts.
 * @author R.A.
 * @version 1.0
 * @since 2023-03-19
*/

public class Comment extends Interaction {
    protected String content;
    /** Creates a Comment object
     * @param id An integer which is unique id of an interaction.
     * @param text A string which contains the content of comment .
     */

    public Comment(int id, String text){
        interactionId = id;
        content = text;
    }
}
