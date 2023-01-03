import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

    public class Tests {
    }

    class ConcreteMemberTest {
        public static final Logger logger = LoggerFactory.getLogger(ConcreteMemberTest.class);
        GroupAdmin group;
        ConcreteMember memberNum1, memberNum2;

        @Test
        void update() {
            group = new GroupAdmin();
            memberNum1 = new ConcreteMember();
            memberNum2 = new ConcreteMember();
            group.register(memberNum1);
            group.register(memberNum2);
            group.append("hi im");;
            group.insert(5,"new");
            assertEquals(memberNum1.o.toString(), "hi imnew");
            group.notifyObservers();
            assertEquals(memberNum1.o.toString(), "hi imnew");
            group.delete(5,8);
            group.notifyObservers();
            assertEquals(memberNum1.o.toString(), "hi im");
            logger.info(() -> JvmUtilities.objectTotalSize(memberNum1));
            assertEquals(2, group.members.size());
            assertEquals(group.members.size(), 2);
            group.unregister(memberNum1);
            group.unregister(memberNum2);
            assertTrue(group.members.isEmpty());

        }
    }

    class GroupAdminTest {
        GroupAdmin group;
        ConcreteMember memberNum1, memberNum2;
        public static final Logger logger = LoggerFactory.getLogger(GroupAdminTest.class);

        @Test
        void register() {
            group = new GroupAdmin();
            memberNum1 = new ConcreteMember();
            memberNum2 = new ConcreteMember();
            group.register(memberNum1);
            group.register(memberNum2);
            assertEquals(2, group.members.size());
            group = new GroupAdmin();
            memberNum1 = new ConcreteMember();
            memberNum2 = new ConcreteMember();
            logger.info(() -> JvmUtilities.objectTotalSize(group));
            //register a member
            group.register(memberNum1);
            group.register(memberNum2);
            logger.info(() -> "amount of time");
            logger.info(() -> JvmUtilities.objectTotalSize(group));
            //unregister a member
            group.unregister(memberNum1);
            group.unregister(memberNum2);
            logger.info(() -> JvmUtilities.objectTotalSize(group));
            group.append("hi");
            group.register(memberNum1);
            group.register(memberNum2);

        }

        @Test
        void unregister() {
            group = new GroupAdmin();
            memberNum1 = new ConcreteMember();
            memberNum2 = new ConcreteMember();
            group.register(memberNum1);
            group.register(memberNum2);
            assertEquals(2, group.members.size());
            group.unregister(memberNum1);
            group.unregister(memberNum2);
            assertEquals(0, group.members.size());
            logger.info(() -> JvmUtilities.objectTotalSize(group));
            //register a member
            group.register(memberNum1);
            group.register(memberNum2);
            logger.info(() -> "amount of time");
            logger.info(() -> JvmUtilities.objectTotalSize(group));
            //unregister a member
            group.unregister(memberNum1);
            group.unregister(memberNum2);
            logger.info(() -> JvmUtilities.objectTotalSize(group));
            group.append("hi");
            group.register(memberNum1);
            group.register(memberNum2);
        }

        @Test
        void insert() {
            group = new GroupAdmin();
            memberNum1 = new ConcreteMember();
            memberNum2 = new ConcreteMember();
            group.register(memberNum1);
            group.register(memberNum2);
            assertEquals(2, group.members.size());
            group.append("how");
            group.insert(3, " doing");
            assertEquals(memberNum1.o.toString(), "how doing");
            assertEquals(memberNum2.o.toString(), "how doing");
            logger.info(() -> "total memory after insert:");
            group.unregister(memberNum1);
            group.unregister(memberNum2);
            assertEquals(0, group.members.size());  logger.info(() -> JvmUtilities.objectTotalSize(memberNum1));
            logger.info(() -> JvmUtilities.objectTotalSize(memberNum2));
            // check if they both have the same size after insert
            assertEquals(JvmUtilities.objectTotalSize(memberNum1), JvmUtilities.objectTotalSize(memberNum2));
            logger.info(() -> JvmUtilities.objectFootprint(memberNum1, memberNum2));
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
            logger.info(() -> "total memory after append:");
            assertEquals(memberNum1.o.toString(), "we were on a break");
            assertEquals(memberNum2.o.toString(), "we were on a break");
            logger.info(() -> JvmUtilities.objectTotalSize(memberNum1));
            logger.info(() -> JvmUtilities.objectTotalSize(memberNum2));
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
            assertEquals("ing", memberNum1.o.toString());
            assertEquals(memberNum1.o.toString(), memberNum2.o.toString());
            logger.info(() -> "total memory after delete:");
            logger.info(() -> JvmUtilities.objectTotalSize(memberNum1));
        }

        @Test
        void undo() {
            group = new GroupAdmin();
            memberNum1 = new ConcreteMember();
            group.register(memberNum1);
            group.append("to be or not to be");
            assertEquals("to be or not to be", memberNum1.o.toString());
            group.undo();
            logger.info(() -> "the memory after undo:");
            logger.info(() -> JvmUtilities.objectTotalSize(memberNum1));
            group.undo();//out of bound

        }
    }





