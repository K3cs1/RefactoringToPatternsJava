package mywork;

public class StringParser extends Parser {
  public Node find(StringBuilder textBuffer, int textBegin, int textEnd) {
    NodeFactory nodeFactory = new NodeFactory();
    return nodeFactory.createStringNode(textBuffer, textBegin, textEnd);
  }
}
