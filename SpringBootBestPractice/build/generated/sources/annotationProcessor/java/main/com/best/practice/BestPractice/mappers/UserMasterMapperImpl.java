package com.best.practice.BestPractice.mappers;

import com.best.practice.BestPractice.dtos.UserMasterDto;
import com.best.practice.BestPractice.entities.UserMasterEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-03T19:17:02+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.4.1.jar, environment: Java 13.0.9 (Azul Systems, Inc.)"
)
public class UserMasterMapperImpl implements UserMasterMapper {

    @Override
    public UserMasterEntity toEntity(UserMasterDto userMasterDto) {
        if ( userMasterDto == null ) {
            return null;
        }

        UserMasterEntity userMasterEntity = new UserMasterEntity();

        userMasterEntity.setId( userMasterDto.getId() );
        userMasterEntity.setName( userMasterDto.getName() );

        return userMasterEntity;
    }

    @Override
    public UserMasterDto toDto(UserMasterEntity userMasterEntity) {
        if ( userMasterEntity == null ) {
            return null;
        }

        UserMasterDto userMasterDto = new UserMasterDto();

        userMasterDto.setId( userMasterEntity.getId() );
        userMasterDto.setName( userMasterEntity.getName() );

        return userMasterDto;
    }
}
