package mywork;

public class Parser {
  private NodeFactory nodeFactory = new NodeFactory();

  public NodeFactory getNodeFactory() {
    return nodeFactory;
  }

  public void setNodeFactory(NodeFactory nodeFactory) {
    this.nodeFactory = nodeFactory;
  }
}
