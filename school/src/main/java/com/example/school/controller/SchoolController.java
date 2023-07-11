package com.example.school.controller;

import com.example.school.dto.SchoolWithStudentsResponse;
import com.example.school.entity.School;
import com.example.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> save(@RequestBody School school) {
        schoolService.saveSchool(school);
        URI location = URI.create("/api/v1/schools/" + school.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<School>> findAll() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("/{school-id}/with-students")
    public ResponseEntity<SchoolWithStudentsResponse> findAllWithStudents(@PathVariable(name = "school-id") Long schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolWithStudentsById(schoolId));
    }

}
