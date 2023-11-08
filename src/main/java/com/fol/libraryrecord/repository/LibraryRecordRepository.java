package com.fol.libraryrecord.repository;

import com.fol.libraryrecord.model.LibraryRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRecordRepository extends JpaRepository<LibraryRecord, Long> {
}
