package com.fol.libraryrecord.service;

import com.fol.libraryrecord.clients.IUserClient;
import com.fol.libraryrecord.exception.LibraryRecordNotFoundException;
import com.fol.libraryrecord.exception.NoUserPermissionException;
import com.fol.libraryrecord.mapper.LibraryRecordMapper;
import com.fol.libraryrecord.model.LibraryRecord;
import com.fol.libraryrecord.repository.LibraryRecordRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LibraryRecordService implements ILibraryRecordService {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final LibraryRecordRepository libraryRecordRepository;
    private final LibraryRecordMapper libraryRecordMapper;
    private final IUserClient userService;

    @Override
    public LibraryRecord createRecord(LibraryRecord libraryRecord) {
        logger.debug("");
        Long userId = libraryRecord.getUserId();
        boolean userHavePermission = userService.doesUserHavePermission(userId);
        if (!userHavePermission) {
            logger.error("User doesn't have permission to create record");
            throw new NoUserPermissionException(userId);
        }
        return libraryRecordRepository.save(libraryRecord);
    }

    @Override
    public LibraryRecord getRecordById(long id) {
        return libraryRecordRepository.findById(id).orElseThrow(() -> {
            logger.error("Could not find record for provided id: " + id);
            return new LibraryRecordNotFoundException(id);
        });
    }

    @Override
    public List<LibraryRecord> getAllRecords() {
        return libraryRecordRepository.findAll();
    }

    @Override
    public LibraryRecord updateRecord(long id, LibraryRecord libraryRecord) {
        LibraryRecord existingRecord = libraryRecordRepository.findById(id).orElseThrow(() -> {
            logger.error("Could not update record as there is no record for provided id: " + id);
            return new LibraryRecordNotFoundException(id);
        });

        LibraryRecord updatedRecord = libraryRecordMapper.updateFieldsFromDTO(libraryRecord, existingRecord);
        return libraryRecordRepository.save(updatedRecord);
    }

    @Override
    public void deleteRecord(long id) {
        LibraryRecord existingLibraryRecord = libraryRecordRepository.findById(id).orElseThrow(() -> {
            logger.error("Could not delete record as there is no record for provided id: " + id);
            return new LibraryRecordNotFoundException(id);
        });
        libraryRecordRepository.delete(existingLibraryRecord);
    }
}
