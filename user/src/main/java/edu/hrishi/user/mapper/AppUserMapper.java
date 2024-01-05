package edu.hrishi.user.mapper;


import edu.hrishi.user.dto.AppUserDto;
import edu.hrishi.user.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppUserMapper {
    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    AppUser getAppUserFromAppUserDto(AppUserDto appUserDto);

    AppUserDto getAppUserDtoFromAppUser(AppUser appUser);
}
