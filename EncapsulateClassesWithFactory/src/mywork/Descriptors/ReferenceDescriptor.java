package mywork.Descriptors;

import java.lang.reflect.Type;

public class ReferenceDescriptor extends AttributeDescriptor {
  private String DescriptorName;
  private Type mapperType;
  private Type forType;
  private Type remoteUserClass;

  public ReferenceDescriptor(String descriptorName, Type mapperType, Type forType) {
    super(descriptorName, mapperType, forType);
    this.DescriptorName = descriptorName;
    this.mapperType = mapperType;
    this.forType = forType;
  }

  public ReferenceDescriptor(
      String descriptorName, Type mapperType, Type forType, Type remoteUserClass) {
    super(descriptorName, mapperType, forType);
    this.remoteUserClass = remoteUserClass;
  }
}
