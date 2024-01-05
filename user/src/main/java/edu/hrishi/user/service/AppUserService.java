package edu.hrishi.user.service;

import edu.hrishi.user.dto.AppUserDto;
import edu.hrishi.user.entity.AppUser;
import edu.hrishi.user.mapper.AppUserMapper;
import edu.hrishi.user.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserDto saveUser(AppUserDto appUserDto) {
        AppUser user = AppUserMapper.INSTANCE.getAppUserFromAppUserDto(appUserDto);
        user = appUserRepository.save(user);
        return AppUserMapper.INSTANCE.getAppUserDtoFromAppUser(user);
    }

    public AppUserDto getUser(Integer id) {
        AppUser user = appUserRepository.findById(id).orElseThrow();
        return AppUserMapper.INSTANCE.getAppUserDtoFromAppUser(user);
    }
}
