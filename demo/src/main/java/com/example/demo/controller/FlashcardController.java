package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Course;
import com.example.demo.security.SecurityUtils;
import com.example.demo.service.CourseService;
import com.example.demo.service.EnrollmentService;
import com.example.demo.service.LLMModels;
import com.example.demo.service.LLMService;

@Controller
@RequestMapping("/student/courses/{courseId}/flashcards")
public class FlashcardController {

    private final CourseService courseService;
    private final LLMService llmService;
    private final EnrollmentService enrollmentService;
    private final SecurityUtils securityUtils;

    public FlashcardController(CourseService courseService, LLMService llmService,
            EnrollmentService enrollmentService, SecurityUtils securityUtils) {
        this.courseService = courseService;
        this.llmService = llmService;
        this.enrollmentService = enrollmentService;
        this.securityUtils = securityUtils;
    }

    @GetMapping
    public String viewFlashcards(@PathVariable Long courseId,
            @RequestParam(defaultValue = "5") int count,
            Model model) {
        Long studentId = securityUtils.getCurrentUserId();

        if (!enrollmentService.isEnrolled(studentId, courseId)) {
            return "redirect:/student/courses";
        }

        Course course = courseService.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        List<LLMModels.Flashcard> flashcards = llmService.generateFlashcards(course.getContent(), count);

        model.addAttribute("course", course);
        model.addAttribute("flashcards", flashcards);
        return "student/courses/flashcards";
    }
}
