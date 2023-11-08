package com.fol.libraryrecord.service;

import com.fol.libraryrecord.exception.LibraryRecordNotFoundException;
import com.fol.libraryrecord.exception.NoUserPermissionException;
import com.fol.libraryrecord.mapper.LibraryRecordMapper;
import com.fol.libraryrecord.model.LibraryRecord;
import com.fol.libraryrecord.remoteservice.IUserRemoteService;
import com.fol.libraryrecord.repository.LibraryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryRecordService implements ILibraryRecordService {

    private final LibraryRecordRepository libraryRecordRepository;
    private final LibraryRecordMapper libraryRecordMapper;
    private final IUserRemoteService userService;

    @Autowired
    public LibraryRecordService(LibraryRecordRepository libraryRecordRepository, LibraryRecordMapper libraryRecordMapper, IUserRemoteService userService) {
        this.libraryRecordRepository = libraryRecordRepository;
        this.libraryRecordMapper = libraryRecordMapper;
        this.userService = userService;
    }

    @Override
    public LibraryRecord createLibraryRecord(LibraryRecord libraryRecord) {
        Long userId = libraryRecord.getUserId();
        boolean userHavePermission = userService.doesUserHavePermission(userId);
        if (!userHavePermission){
            throw new NoUserPermissionException(userId);
        }

        return libraryRecordRepository.save(libraryRecord);
    }

    @Override
    public LibraryRecord getLibraryRecordById(long id) {
        return libraryRecordRepository.findById(id).orElseThrow(() -> new LibraryRecordNotFoundException(id));
    }

    @Override
    public List<LibraryRecord> getAllLibraryRecords() {
        return libraryRecordRepository.findAll();
    }

    @Transactional
    @Override
    public LibraryRecord updateLibraryRecord(long id, LibraryRecord libraryRecord) {
        LibraryRecord existingLibraryRecord = libraryRecordRepository.findById(id).orElseThrow(() -> new LibraryRecordNotFoundException(id));

        libraryRecordMapper.updateFieldsFromDTO(libraryRecord, existingLibraryRecord);
        return libraryRecordRepository.save(existingLibraryRecord);
    }

    @Override
    public void deleteLibraryRecord(long id) {
        LibraryRecord existingLibraryRecord = libraryRecordRepository.findById(id).orElseThrow(() -> new LibraryRecordNotFoundException(id));
        libraryRecordRepository.delete(existingLibraryRecord);
    }
}
