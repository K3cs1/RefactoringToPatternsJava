package MyWork;

import org.junit.Test;

public abstract class AbstractBuilderTest {

    public OutputBuilder builder;

    protected abstract OutputBuilder createBuilder(String rootName);

    @Test(expected = RuntimeException.class)
    public void testAddAboveRoot() throws RuntimeException {
//        String invalidResult =
//                "<orders>" +
//                        "<order>" +
//                        "</order>" +
//                        "</orders>" +
//                        "<customer>" +
//                        "</customer>";

        String rootName = "orders";
        builder = createBuilder(rootName);

        builder.addBelow("order");

        builder.addAbove("customer");
    }
}
