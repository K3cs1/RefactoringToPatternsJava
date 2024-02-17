package mywork;

import java.util.ArrayList;
import java.util.List;

public class TagNode {
  private StringBuilder attributes;
  private List<TagNode> children = new ArrayList<>();
  private TagNode parent;

  private String tagName;
  private String tagValue = "";

  public TagNode(String tagName) {
    this.tagName = tagName;
    this.attributes = new StringBuilder();
  }

  public void add(TagNode tagNode) {
    tagNode.setParent(this);
    this.children.add(tagNode);
  }

  public void addAttribute(String attribute, String value) {
    this.attributes.append(" ");
    this.attributes.append(attribute);
    this.attributes.append("='");
    this.attributes.append(value);
    this.attributes.append("'");
  }

  public void addValue(String value) {
    this.tagValue = value;
  }

  private void setParent(TagNode parent) {
    this.parent = parent;
  }

  public TagNode getParent() {
    return this.parent;
  }

  public String getTagName() {
    return this.tagName;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("<");
    if (children.isEmpty()) {
      result.append(this.tagName);
      result.append(this.attributes);
      if (!this.tagValue.isBlank()) {
        result.append(">");
        result.append(this.tagValue);
      }
      result.append("</");
      result.append(this.tagName);
      result.append(">");
      return result.toString();
    }
    result.append(this.tagName).append(this.attributes).append(">");
    for (TagNode child : children) {
      result.append(child.toString());
    }
    result.append(this.tagValue).append("</").append(this.tagName).append(">");
    return result.toString();
    //    String result = "";
    //    result += "<" + this.tagName + attributes.toString() + ">";
    //    Iterator<TagNode> it = this.children.iterator();
    //    while (it.hasNext()) {
    //      TagNode node = it.next();
    //      result += node.toString();
    //    }
    //    if (!tagValue.isEmpty()) {
    //      result += tagValue;
    //    }
    //    result += "</" + this.tagName + ">";
    //    return result;
  }
}
