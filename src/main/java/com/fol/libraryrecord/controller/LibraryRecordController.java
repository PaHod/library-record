package com.fol.libraryrecord.controller;

import com.fol.libraryrecord.dto.LibraryRecordDTO;
import com.fol.libraryrecord.mapper.LibraryRecordMapper;
import com.fol.libraryrecord.model.LibraryRecord;
import com.fol.libraryrecord.service.ILibraryRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/library-records")
@Api(value = "Library Records")
public class LibraryRecordController {

    private final ILibraryRecordService libraryRecordService;
    private final LibraryRecordMapper libraryRecordMapper;

    @Autowired
    public LibraryRecordController(ILibraryRecordService libraryRecordService, LibraryRecordMapper libraryRecordMapper) {
        this.libraryRecordService = libraryRecordService;
        this.libraryRecordMapper = libraryRecordMapper;
    }

    @ApiOperation(value = "Create LibraryRecord from the JSON provided in request body.")
    @ApiResponse(responseCode = "201",
            description = "LibraryRecord successfully created",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<LibraryRecordDTO> createLibraryRecord(@RequestBody LibraryRecordDTO libraryRecordDTO) {
        LibraryRecord libraryRecord =
                libraryRecordService.createLibraryRecord(libraryRecordMapper.dtoToModel(libraryRecordDTO));
        return ResponseEntity.ok(libraryRecordMapper.modelToDTO(libraryRecord));
    }

    @ApiOperation(value = "Get LibraryRecord by ID.")
    @GetMapping("/{id}")
    public ResponseEntity<LibraryRecordDTO> getLibraryRecordById(@PathVariable("id") long id) {
        LibraryRecord libraryRecord = libraryRecordService.getLibraryRecordById(id);
        return ResponseEntity.ok(libraryRecordMapper.modelToDTO(libraryRecord));
    }

    @ApiOperation(value = "Get all LibraryRecords.")
    @GetMapping
    public ResponseEntity<List<LibraryRecordDTO>> getAllLibraryRecords() {
        List<LibraryRecord> libraryRecords = libraryRecordService.getAllLibraryRecords();
        ArrayList<LibraryRecordDTO> libraryRecordDTOs = libraryRecords.stream().map(this.libraryRecordMapper::modelToDTO).collect(Collectors.toCollection(ArrayList::new));
        return ResponseEntity.ok(libraryRecordDTOs);

    }

    @ApiOperation(value = "Update LibraryRecord by ID form the JSON provided in request body.")
    @PutMapping("/{id}")
    public ResponseEntity<LibraryRecordDTO> updateLibraryRecord(@PathVariable("id") long id, @RequestBody LibraryRecordDTO libraryRecordDTO) {

        LibraryRecord libraryRecord =
                libraryRecordService.updateLibraryRecord(id, libraryRecordMapper.dtoToModel(libraryRecordDTO));
        return ResponseEntity.ok(libraryRecordMapper.modelToDTO(libraryRecord));
    }

    @ApiOperation(value = "Removes LibraryRecord by ID.")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteLibraryRecord(@Parameter(description = "LibraryRecord ID") @PathVariable("id") long id) {
        libraryRecordService.deleteLibraryRecord(id);
    }
}
