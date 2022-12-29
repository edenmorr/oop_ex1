import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    GroupAdmin group;
    ConcreteMember memberNum1, memberNum2;
    @Test
    public void test() {
            group = new GroupAdmin();
            memberNum1 = new ConcreteMember();
            memberNum2 = new ConcreteMember();
            logger.info(()->JvmUtilities.objectTotalSize(group));
            //register a member
            group.register(memberNum1);
            group.register(memberNum2);
            logger.info(()->"amount of time");
            logger.info(()->JvmUtilities.objectTotalSize(group));
            //unregister a member
            group.unregister(memberNum1);
            group.unregister(memberNum2);
            logger.info(()->JvmUtilities.objectTotalSize(group));
            group.append("hi");
            group.register(memberNum1);
            group.register(memberNum2);

//        assertEquals(memberNum1.o.toString(), " doing");
            group.insert(2, " how are you");
            logger.info(()->"total memory after insert:");
            assertEquals(memberNum1.o.toString(),"hi how are you");
            logger.info(()->JvmUtilities.objectTotalSize(memberNum1));
            logger.info(()->JvmUtilities.objectTotalSize(memberNum2));
            // check if they both have the same size after insert
            assertEquals(JvmUtilities.objectTotalSize(memberNum1),JvmUtilities.objectTotalSize(memberNum2));
            logger.info(() -> JvmUtilities.objectFootprint(memberNum1, memberNum2));

        // delete a range of characters
        group.delete(0,2);
        assertEquals(" how are you", memberNum1.o.toString());
        assertEquals(memberNum1.o.toString(),memberNum2.o.toString());
        logger.info(()->"total memory after delete:");
        logger.info(()->JvmUtilities.objectTotalSize(memberNum1));

        group.undo();
        assertEquals("hi how are you",memberNum1.o.toString());
        logger.info(()->"the memory after undo:");
        logger.info(()->JvmUtilities.objectTotalSize(memberNum1));
    }
    }


