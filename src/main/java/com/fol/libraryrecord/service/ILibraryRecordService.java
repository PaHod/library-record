package com.fol.libraryrecord.service;

import com.fol.libraryrecord.model.LibraryRecord;

import java.util.List;

public interface ILibraryRecordService {

    LibraryRecord createLibraryRecord(LibraryRecord libraryRecord);

    LibraryRecord getLibraryRecordById(long id);

    List<LibraryRecord> getAllLibraryRecords();

    LibraryRecord updateLibraryRecord(long id, LibraryRecord libraryRecord);

    void deleteLibraryRecord(long id);
}
