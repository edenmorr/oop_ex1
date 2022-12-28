package observer;

import java.util.logging.Logger;

public class ConcreteMember implements Member{
    public UndoableStringBuilder o;

    public ConcreteMember() {
         this.o = new UndoableStringBuilder();
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.o=usb;
        System.out.println(this+ "message received: "+o.toString());
    }
}

