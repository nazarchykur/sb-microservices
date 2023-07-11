package com.example.school.dto;

import lombok.Data;

import java.util.List;

public record SchoolWithStudentsResponse(String name, String email, List<Student> students) {
}
