package mywork.Descriptors;

import mywork.Domain.User;

import java.lang.reflect.Type;
import java.util.Date;

public class DefaultDescriptor extends AttributeDescriptor {
  public final String DescriptorName;
  private final Type mapperType;
  private final Type forType;

  protected DefaultDescriptor(String descriptorName, Type mapperType, Type forType) {
    super(descriptorName, mapperType, forType);
    this.DescriptorName = descriptorName;
    this.mapperType = mapperType;
    this.forType = forType;
  }

  public static AttributeDescriptor forDate(String descriptorName, Type mapperType) {
    return new DefaultDescriptor(descriptorName, mapperType, Date.class);
  }

  public static AttributeDescriptor forInteger(String descriptorName, Type mapperType) {
    return new DefaultDescriptor(descriptorName, mapperType, Integer.TYPE);
  }

  public static ReferenceDescriptor forReference(
      String createdBy, Type mapperType, Type forType, Type remoteUserClass) {
    return new ReferenceDescriptor(createdBy, mapperType, forType, remoteUserClass);
  }

  public static ReferenceDescriptor forReference(String createdBy, Type mapperType, Type forType) {
    return new ReferenceDescriptor(createdBy, mapperType, forType);
  }
}
