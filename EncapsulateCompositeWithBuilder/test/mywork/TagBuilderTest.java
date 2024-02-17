package mywork;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TagBuilderTest {

  @Ignore
  @Test
  public void testBuildOneNode() {
    String expectedXml = "<flavors/>";
    String actualXml = new TagBuilder("flavors").toXml();
    assertEquals(expectedXml, actualXml);
  }

  @Ignore
  @Test
  public void testBuildOneChild() {
    String expectedXml = "<flavors>" + "<flavor/>" + "</flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    builder.addChild("flavor");
    String actualXml = builder.toXml();
    assertEquals(expectedXml, actualXml);
  }

  @Ignore
  @Test
  public void testBuildChildrenOfChildren() {
    String expectedXml =
        "<flavors>"
            + "<flavor>"
            + "<requirements>"
            + "<requirement/>"
            + "</requirements>"
            + "</flavor>"
            + "</flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    builder.addChild("flavor");
    builder.addChild("requirements");
    builder.addChild("requirement");
    String actualXml = builder.toXml();
    assertEquals(expectedXml, actualXml);
  }

  @Ignore
  @Test
  public void testBuildSibling() {
    String expectedXml = "<flavors>" + "<flavor1/>" + "<flavor2/>" + "</flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    builder.addChild("flavor1");
    builder.addSibling("flavor2");
    String actualXml = builder.toXml();
    assertEquals(expectedXml, actualXml);
  }

  @Test
  public void testParents() {
    TagNode root = new TagNode("root");
    Assert.assertNull(root.getParent());
    TagNode childNode = new TagNode("child");
    root.add(childNode);
    assertEquals(root, childNode.getParent());
    assertEquals("root", childNode.getParent().getTagName());
  }

  @Ignore
  @Test
  public void testRepeatingChildrenAndGrandchildren() {
    String expectedXml =
        "<flavors>"
            + "<flavor>"
            + "<requirements>"
            + "<requirement/>"
            + "</requirements>"
            + "</flavor>"
            + "<flavor>"
            + "<requirements>"
            + "<requirement/>"
            + "</requirements>"
            + "</flavor>"
            + "</flavors>";
    TagBuilder builder = new TagBuilder("flavors");
    for (int i = 0; i < 2; i++) {
      builder.addToParent("flavors", "flavor");
      builder.addChild("flavor");
      builder.addChild("requirements");
      builder.addChild("requirement");
    }
    assertEquals(expectedXml, builder.toXml());
  }

  @Test
  public void testParentNameNotFound() {
    TagBuilder builder = new TagBuilder("flavors");
    try {
      for (int i = 0; i < 2; i++) {
        builder.addToParent("favors", "flavor");
        // should be "flavors" not "favors"
        builder.addChild("requirements");
        builder.addChild("requirement");
      }

      fail("should not allow adding to parent that doesn't exist.");
    } catch (RuntimeException runtimeException) {
      String expectedErrorMessage = "missing parent tag: favors";
      assertEquals(expectedErrorMessage, runtimeException.getMessage());
    }
  }

  @Test
  public void testAttributesAndValues() {
    String expectedXml =
        "<flavor name='Test-Driven Development'>"
            + "<requirements>"
            + "<requirement type='hardware'>"
            + "1 computer for every 2 participants"
            + "</requirement>"
            + "<requirement type='software'>"
            + "IDE"
            + "</requirement>"
            + "</requirements>"
            + "</flavor>";
    TagBuilder builder = new TagBuilder("flavor");
    builder.addAttribute("name", "Test-Driven Development");
    builder.addChild("requirements");
    builder.addToParent("requirements", "requirement");
    builder.addAttribute("type", "hardware");
    builder.addValue("1 computer for every 2 participants");
    builder.addToParent("requirements", "requirement");
    builder.addAttribute("type", "software");
    builder.addValue("IDE");
    assertEquals(expectedXml, builder.toXml());
  }
}
