package observer;

import org.w3c.dom.ls.LSOutput;
import java.util.EmptyStackException;
import java.util.Stack;
public class UndoableStringBuilder {
    /**
     * @author eden mor
     */
    //keeping a list of all undo() operations
    Stack<String> list;
    StringBuilder s_builder;

    public UndoableStringBuilder() {
        s_builder = new StringBuilder();
        list = new Stack<>();
    }

    @Override
    public String toString() {
        return this.s_builder.toString();
    }

    /**
     * Appends the specified string to this character sequence.
     *
     * @param str after the changes must to be pushed onto this stack.
     * @return the {@code item} argument.
     */

    public UndoableStringBuilder append(String str) {
        if (str.length() != 0) {
            list.push(this.s_builder.append(str).toString());
        }
        return this;
    }

    /**
     * Removes the characters in a substring of this sequence. The substring begins at the specified start and extends
     * to the character at index end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     *
     * @param start and end  the substring begins at the specified start and extends to the character at index end after the changes must to be pushed onto this stack.
     * @return the new argument.
     */

    public UndoableStringBuilder delete(int start, int end) {
        try {
            if (start > 0 || start < end || start <= s_builder.length()) {
                list.push(this.s_builder.delete(start, end).toString());
            }
        } catch (Exception e) {
            System.out.println("Out of bound Exception");
        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     *
     * @param offset is add to the string
     * @return the new argument.
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            if (s_builder.length() >= offset) {
                list.push(this.s_builder.insert(offset, str).toString());
            }
        } catch (Exception e) {
            System.out.println("Out of bound Exception");
        }
        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in the specified String.
     * The substring begins at the specified start and extends to
     * the character at index end - 1 or to the end of the sequence if no such character exists.
     * First the characters in the substring are removed and then the specified String is inserted at start.
     * (This sequence will be lengthened to accommodate the specified String if necessary).
     *
     * @param start and end  the string characters will be replaced at the parameters place after the changes must to be pushed onto this stack.
     * @return the new argument.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            if (0 < start || start <= s_builder.length() || start < end) {
                list.add(this.s_builder.replace(start, end, str).toString());

            }
        } catch (Exception e) {
            System.out.println("Out of bound Exception");
        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the sequence,
     *
     * @return the new argument.after the changes must be pushed into the stack.
     */
    public UndoableStringBuilder reverse() {
        if (s_builder.length() != 0)
            list.push(s_builder.reverse().toString());
        return null;
    }

    /**
     * delets the last element in the stack
     *
     * @return the last element.
     */
    public void undo() {
        s_builder = new StringBuilder();
        try {
            if (!list.isEmpty()) {
                this.list.pop();
                s_builder.append(list.peek());
            }
        } catch (Exception e) {
            System.out.println("Out of bound Exception");
        }
    }


    public static void main(String[] args) throws Exception {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("to be or not to be");
        System.out.println(usb);
        usb.replace(3, 5, "eat");
        System.out.println(usb);
        usb.replace(17, 19, "eat");
        System.out.println(usb);
        usb.reverse();
        System.out.println(usb);
        System.out.println();
        usb.undo();
        System.out.println(usb);
        usb.undo();
        System.out.println(usb);
        usb.undo();
        System.out.println(usb);
    }
    }


