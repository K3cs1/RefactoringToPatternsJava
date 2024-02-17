package mywork.Mappers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import mywork.Descriptors.AttributeDescriptor;
import mywork.Descriptors.DefaultDescriptor;
import mywork.Domain.User;

public class DescriptorMapper {
  protected List<AttributeDescriptor> CreateAttributeDescriptors() {
    List<AttributeDescriptor> result = new ArrayList<>();
    result.add(DefaultDescriptor.forInteger("remoteId", GetClass()));
    result.add(DefaultDescriptor.forDate("createdDate", GetClass()));
    result.add(DefaultDescriptor.forDate("lastChangedDate", GetClass()));
    result.add(DefaultDescriptor.forReference("createdBy", GetClass(), User.class));
    result.add(DefaultDescriptor.forReference("lastChangedBy", GetClass(), User.class));
    result.add(DefaultDescriptor.forInteger("optimisticLockVersion", GetClass()));
    return result;
  }

  private Type GetClass() {
    return DescriptorMapper.class;
  }
}
