package com.fol.libraryrecord.controller;

import com.fol.libraryrecord.dto.RecordRequest;
import com.fol.libraryrecord.dto.RecordResponse;
import com.fol.libraryrecord.mapper.LibraryRecordMapper;
import com.fol.libraryrecord.model.LibraryRecord;
import com.fol.libraryrecord.service.ILibraryRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/records")
@Api(value = "Library Records")
public class LibraryRecordController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    //todo call UserClient
    private final ILibraryRecordService libraryRecordService;
    private final LibraryRecordMapper libraryRecordMapper;

    @ApiOperation(value = "Create LibraryRecord from the JSON provided in request body.")
    @ApiResponse(responseCode = "201", description = "LibraryRecord successfully created", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<RecordResponse> createLibraryRecord(@RequestBody RecordRequest recordRequest) {
        logger.info("");
        LibraryRecord libraryRecord = libraryRecordService.createRecord(libraryRecordMapper.dtoToModel(recordRequest));
        return ResponseEntity.ok(libraryRecordMapper.modelToDTO(libraryRecord));
    }

    @ApiOperation(value = "Get LibraryRecord by ID.")
    @GetMapping("/{id}")
    public ResponseEntity<RecordResponse> getLibraryRecordById(@PathVariable("id") long id) {
        logger.info("");
        LibraryRecord libraryRecord = libraryRecordService.getRecordById(id);
        return ResponseEntity.ok(libraryRecordMapper.modelToDTO(libraryRecord));
    }

    @ApiOperation(value = "Get all LibraryRecords.")
    @GetMapping
    public ResponseEntity<List<RecordResponse>> getAllLibraryRecords() {
        List<LibraryRecord> libraryRecords = libraryRecordService.getAllRecords();
        ArrayList<RecordResponse> libraryRecordRequests = libraryRecords.stream()
                        .map(this.libraryRecordMapper::modelToDTO)
                        .collect(Collectors.toCollection(ArrayList::new));
        return ResponseEntity.ok(libraryRecordRequests);

    }

    @ApiOperation(value = "Update LibraryRecord by ID form the JSON provided in request body.")
    @PutMapping("/{id}")
    public ResponseEntity<RecordResponse> updateLibraryRecord(@PathVariable("id") long id, @RequestBody RecordRequest recordRequest) {
        LibraryRecord libraryRecord = libraryRecordService.updateRecord(id, libraryRecordMapper.dtoToModel(recordRequest));
        return ResponseEntity.ok(libraryRecordMapper.modelToDTO(libraryRecord));
    }

    @ApiOperation(value = "Removes LibraryRecord by ID.")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteLibraryRecord(@Parameter(description = "LibraryRecord ID") @PathVariable("id") long id) {
        libraryRecordService.deleteRecord(id);
    }
}
