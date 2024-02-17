package mywork;

public class TagBuilder {
  private TagNode rootNode;
  private TagNode currentNode;

  public TagBuilder(String rootTagName) {
    this.rootNode = new TagNode(rootTagName);
    this.currentNode = rootNode;
  }

  public void addChild(String childTagName) {
    addTo(currentNode, childTagName);
  }

  public String toXml() {
    return rootNode.toString();
  }

  public void addSibling(String siblingTagName) {
    addTo(currentNode.getParent(), siblingTagName);
  }

  private void addTo(TagNode parentNode, String tagName) {
    currentNode = new TagNode(tagName);
    parentNode.add(currentNode);
  }

  public void addToParent(String parentTagName, String childTagName) {
    TagNode parentNode = findParentBy(parentTagName);
    if (parentNode == null) {
      throw new RuntimeException("missing parent tag: " + parentTagName);
    }
    addTo(parentNode, childTagName);
  }

  private TagNode findParentBy(String parentName) {
    TagNode parentNode = currentNode;
    while (parentNode != null) {
      if (parentName.equals(parentNode.getTagName())) {
        return parentNode;
      }
      parentNode = parentNode.getParent();
    }
    return null;
  }

  public void addAttribute(String name, String value) {
    currentNode.addAttribute(name, value);
  }

  public void addValue(String value) {
    currentNode.addValue(value);
  }
}
