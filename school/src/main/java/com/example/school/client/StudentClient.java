package com.example.school.client;

import com.example.school.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.student.url}")
public interface StudentClient {

    @GetMapping("/schools/{school-id}")
    List<Student> findAllBySchoolId(@PathVariable(name = "school-id") Long schoolId);
}
