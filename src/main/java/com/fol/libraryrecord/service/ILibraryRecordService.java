package com.fol.libraryrecord.service;

import com.fol.libraryrecord.model.LibraryRecord;

import java.util.List;

public interface ILibraryRecordService {

    LibraryRecord createRecord(LibraryRecord libraryRecord);

    LibraryRecord getRecordById(long id);

    List<LibraryRecord> getAllRecords();

    LibraryRecord updateRecord(long id, LibraryRecord libraryRecord);

    void deleteRecord(long id);
}
