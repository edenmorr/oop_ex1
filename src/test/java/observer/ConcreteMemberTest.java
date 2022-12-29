package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {
    GroupAdmin group;
    ConcreteMember memberNum1, memberNum2;
    @Test
    void update() {
        group = new GroupAdmin();
        memberNum1 = new ConcreteMember();
        memberNum2 = new ConcreteMember();
        group.register(memberNum1);
        group.register(memberNum2);
        assertEquals(2,group.members.size());
        assertTrue(group.members.size()==2);
        group.unregister(memberNum1);
        group.unregister(memberNum2);
        assertTrue(group.members.isEmpty());

    }

}