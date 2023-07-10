package vLDLinkedList;

/** Represents a message for people to send each other.
 * @author R.A.
 * @version 1.0
 * @since 2023-03-19
*/
public class Message {
    
    protected int messageId ;
    protected int senderId;
    protected int receiverId;
    protected String content;

    /** Creates a Message object.
     * @param msgId An integer representing unqie message Id.
     * @param senderID An integer representing sender's account Id.
     * @param receiverID An integer representing receiver's account Id.
     * @param msg A string holds the content of the message.
     */
    Message(int msgId, int senderID, int receiverID, String msg){
        messageId = msgId;
        senderId = senderID;
        receiverId = receiverID;
        content = msg;  
    }
}
