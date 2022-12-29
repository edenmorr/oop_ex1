package observer;

import java.util.LinkedList;
import java.util.List;

public class GroupAdmin implements Sender {
    public UndoableStringBuilder o;
    public List<Member> members;

    public GroupAdmin() {
        this.o = new UndoableStringBuilder();
        this.members = new LinkedList<>();
    }
    /**
     *
     * @param obj subscribe
     */
    @Override
    public void register(Member obj) {
        this.members.add(obj);
    }

    /**
     *
     * @param obj unsubscribe
     */
    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);
    }
    /**
     *
     * @return how many members there are
     */
    public  int numberOfmembers(){
        return members.size();
    }

    /**
     *
     * @param obj Inserts the string into
     * @param offset this character sequence.
     */
    @Override
    public void insert(int offset, String obj) {
        this.o.insert(offset, obj);
        notifyObservers();
    }
    /**
     *
     * @param obj Appends the specified string to this character sequence.
     */
    @Override
    public void append(String obj) {
    this.o.append(obj);
        notifyObservers();
    }

    /**
     *
     * @param start Removes the characters in a substring of this sequence.
     * @param end "" "" "" "" ....
     */
    @Override
    public void delete(int start, int end) {
    this.o.delete(start, end);
    }

    private void notifyObservers() {
        for (Member obj : this.members) {
            obj.update(o);
        }
    }
    /**
     * Erases the last change done to the document, reverting
     *     it to an older state.
     */
        @Override
    public void undo() {
    this.o.undo();
    }
}
