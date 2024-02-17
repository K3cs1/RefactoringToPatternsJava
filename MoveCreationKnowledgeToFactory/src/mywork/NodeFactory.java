package mywork;

public class NodeFactory {
  private boolean decodeStringNodes;

  public boolean isDecodeStringNodes() {
    return decodeStringNodes;
  }

  public void setDecodeStringNodes(boolean decodeStringNodes) {
    this.decodeStringNodes = decodeStringNodes;
  }

  public Node createStringNode(StringBuilder textBuffer, int textBegin, int textEnd) {

    if (decodeStringNodes) {
      return new DecodingStringNode(new StringNode(textBuffer, textBegin, textEnd));
    }
    return new StringNode(textBuffer, textBegin, textEnd);
  }
}
