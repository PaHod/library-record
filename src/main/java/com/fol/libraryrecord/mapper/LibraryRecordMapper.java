package com.fol.libraryrecord.mapper;

import com.fol.libraryrecord.dto.LibraryRecordDTO;
import com.fol.libraryrecord.model.LibraryRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LibraryRecordMapper {

    LibraryRecordDTO modelToDTO(LibraryRecord libRecord);

    @Mapping(target = "id", ignore = true)
    LibraryRecord dtoToModel(LibraryRecordDTO libRecordDTO);

    @Mapping(target = "id", ignore = true)
    LibraryRecord updateFieldsFromDTO(LibraryRecord source, @MappingTarget LibraryRecord target);

}
