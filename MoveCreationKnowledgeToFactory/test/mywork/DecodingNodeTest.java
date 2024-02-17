package mywork;

import org.junit.Assert;
import org.junit.Test;

public class DecodingNodeTest {

  @Test
  public void testDecodeAmpersand() {
    NodeFactory decodeNodes = new NodeFactory();
    decodeNodes.setDecodeStringNodes(true);
    Node stringNode = decodeNodes.createStringNode(new StringBuilder("asdf"), 0, 10);
    Assert.assertNotNull(stringNode);
  }
}
