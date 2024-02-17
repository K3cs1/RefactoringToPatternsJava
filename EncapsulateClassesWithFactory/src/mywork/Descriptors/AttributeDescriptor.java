package mywork.Descriptors;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import mywork.Domain.User;

public abstract class AttributeDescriptor {

  public final String DescriptorName;
  private final Type mapperType;
  private final Type forType;

  protected AttributeDescriptor(String descriptorName, Type mapperType, Type forType) {
    this.DescriptorName = descriptorName;
    this.mapperType = mapperType;
    this.forType = forType;
  }

  protected List<AttributeDescriptor> createAttributeDescriptors() {
    List<AttributeDescriptor> result = new ArrayList<>();
    result.add(DefaultDescriptor.forInteger("remoteId", getClass()));
    result.add(DefaultDescriptor.forDate("createdDate", getClass()));
    result.add(DefaultDescriptor.forDate("lastChangedDate", getClass()));
    result.add(
        DefaultDescriptor.forReference("createdBy", getClass(), User.class, RemoteUser.class));
    result.add(
        DefaultDescriptor.forReference("lastChangedBy", getClass(), User.class, RemoteUser.class));
    result.add(DefaultDescriptor.forInteger("optimisticLockVersion", getClass()));
    return result;
  }
}
