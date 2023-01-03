package observer;

import java.util.logging.Logger;

public class ConcreteMember implements Member{
    public UndoableStringBuilder o;

    public ConcreteMember() {
         this.o = null;
    }
    /**
     * Updates the member with the latest state of the shared UndoableStringBuilder object.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.o=usb;
        System.out.println(this+ "message received: "+o.toString());
    }
}

