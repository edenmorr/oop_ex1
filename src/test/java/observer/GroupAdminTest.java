package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {
        GroupAdmin group;
        ConcreteMember memberNum1, memberNum2;
    @Test
    void register() {
     group = new GroupAdmin();
     memberNum1 = new ConcreteMember();
     memberNum2 = new ConcreteMember();
     group.register(memberNum1);
     group.register(memberNum2);
     assertEquals(2,group.members.size());
    }

    @Test
    void unregister() {
        group = new GroupAdmin();
        memberNum1 = new ConcreteMember();
        memberNum2 = new ConcreteMember();
        group.register(memberNum1);
        group.register(memberNum2);
        assertEquals(2,group.members.size());
        group.unregister(memberNum1);
        group.unregister(memberNum2);
        assertEquals(0,group.members.size());
    }
    @Test
    void insert() {
     group = new GroupAdmin();
     memberNum1 = new ConcreteMember();
     memberNum2 = new ConcreteMember();
     group.register(memberNum1);
     group.register(memberNum2);
     assertEquals(2,group.members.size());
     group.append("how");
     group.insert(3, " doing");
     assertEquals(memberNum1.o.toString(), "how doing");
     assertEquals(memberNum2.o.toString(), "how doing");
     group.unregister(memberNum1);
     group.unregister(memberNum2);
     assertEquals(0,group.members.size());
     }

    @Test
    void Append() {
        group = new GroupAdmin();
        memberNum1 = new ConcreteMember();
        memberNum2 = new ConcreteMember();
        group.register(memberNum1);
        group.register(memberNum2);
        group.append("we");
        assertEquals(memberNum1.o.toString(), "we");
        assertEquals(memberNum2.o.toString(), "we");
        group.append(" were on");
        assertEquals(memberNum1.o.toString(), "we were on");
        assertEquals(memberNum2.o.toString(), "we were on");
        group.append(" a break");
        assertEquals(memberNum1.o.toString(), "we were on a break");
        assertEquals(memberNum2.o.toString(), "we were on a break");
    }

    @Test
    void Delete() {
        group = new GroupAdmin();
        memberNum1 = new ConcreteMember();
        memberNum2 = new ConcreteMember();
        group.register(memberNum1);
        group.register(memberNum2);
        group.append("how");
        group.insert(3, " doing");
        group.delete(0, 3);
        assertEquals(memberNum1.o.toString(), " doing");
        assertEquals(memberNum2.o.toString(), " doing");
        group.delete(0, 3);
        assertEquals(memberNum1.o.toString(), "ing");
        assertEquals(memberNum1.o.toString(), "ing");
    }
    @Test
    void undo() {
        group = new GroupAdmin();
        group.append("to be or not to be");
        group.undo();
        group.undo();//out of bound
    }
}