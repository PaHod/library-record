package com.fol.libraryrecord.mapper;

import com.fol.libraryrecord.dto.RecordRequest;
import com.fol.libraryrecord.dto.RecordResponse;
import com.fol.libraryrecord.model.LibraryRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LibraryRecordMapper {

    RecordResponse modelToDTO(LibraryRecord libRecord);

    @Mapping(target = "id", ignore = true)
    LibraryRecord dtoToModel(RecordRequest libRecordDTO);

    @Mapping(target = "id", ignore = true)
    LibraryRecord updateFieldsFromDTO(LibraryRecord source, @MappingTarget LibraryRecord target);

}
