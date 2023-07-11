package com.example.school.service;

import com.example.school.client.StudentClient;
import com.example.school.dto.SchoolWithStudentsResponse;
import com.example.school.dto.Student;
import com.example.school.entity.School;
import com.example.school.exception.EntityNotFoundException;
import com.example.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public SchoolWithStudentsResponse findSchoolWithStudentsById(Long schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new EntityNotFoundException("School not found"));

        List<Student> students = studentClient.findAllBySchoolId(schoolId);

        return new SchoolWithStudentsResponse(school.getName(), school.getEmail(), students);
    }
}
