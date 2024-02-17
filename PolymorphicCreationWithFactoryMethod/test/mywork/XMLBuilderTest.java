package mywork;

public class XMLBuilderTest extends AbstractBuilderTest {

  @Override
  protected XMLBuilder createBuilder(String rootName) {
    return new XMLBuilder(rootName);
  }
}
