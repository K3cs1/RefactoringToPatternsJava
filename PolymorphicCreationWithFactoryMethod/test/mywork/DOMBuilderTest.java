package mywork;


public class DOMBuilderTest extends AbstractBuilderTest {

  @Override
  protected DOMBuilder createBuilder(String rootName) {
    return new DOMBuilder(rootName);
  }

}
