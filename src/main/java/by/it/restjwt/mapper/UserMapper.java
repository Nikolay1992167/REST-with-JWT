package by.it.restjwt.mapper;

import by.it.restjwt.dto.UserDto;
import by.it.restjwt.dto.UserRegistrationDto;
import by.it.restjwt.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = BaseMapper.class  )
public interface UserMapper {

    User convertToDomain(UserRegistrationDto userRegistrationDto);

    @Mapping(target = "role", source = "user.role.name")
    UserDto convertToDto(User user);
}
