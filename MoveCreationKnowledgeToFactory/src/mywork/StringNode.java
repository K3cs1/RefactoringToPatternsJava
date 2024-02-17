package mywork;

public class StringNode extends Node {
  public StringNode(StringBuilder textBuffer, int textBegin, int textEnd) {}

  public StringNode(StringNode stringNode) {
    super();
  }

  public static Node createStringNode(
      StringBuilder textBuffer, int textBegin, int textEnd, boolean shouldDecode) {
    if (shouldDecode) {
      return new DecodingStringNode(new StringNode(textBuffer, textBegin, textEnd));
    }
    return new StringNode(textBuffer, textBegin, textEnd);
  }
}
