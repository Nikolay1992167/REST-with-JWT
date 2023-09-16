package by.it.restjwt.mapper;

import by.it.restjwt.dto.BaseDto;
import by.it.restjwt.entity.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseMapper {

    BaseDto convertToDto(BaseEntity baseEntity);
}
