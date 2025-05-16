package com.app.TechHive.domain.services;

import com.app.TechHive.domain.DTOs.ChatRequest.ChatMessage;
import com.app.TechHive.domain.DTOs.ChatRequest.ChatRequest;
import com.app.TechHive.domain.DTOs.ResourceResponse;
import com.app.TechHive.domain.DTOs.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    private AI_service ai_service;

    public ResponseService(AI_service ai_service) {
        this.ai_service = ai_service;
    }

    public String getModels() {
        return ai_service.testModelsResponse();
    }

    public ResourceResponse getResources(UserRequest request) throws JsonProcessingException {
        // 1. Build the message with role and message
        ChatMessage chatMessage = new ChatMessage("user", buildPrompt(request));
        // 2. Build the request with model and message
        ChatRequest chatRequest = new ChatRequest(
                "gemini-2.0-flash-lite",
                chatMessage
        );
        return ai_service.getResources(chatRequest);
    }

    private String buildPrompt(UserRequest request) {
        return String.format(
                "I want to learn %s to %s in %s; list free & paid courses, official docs, content creators & tech blogs. " +
                        "Return ONLY a raw JSON object (no markdown) with these top-level keys: " +
                        "paidCourses, freeCourses, officialSite, officialDocs, contentCreators, techBlogs. " +
                        "Each resource must have: title, description, url, platform, category. " +
                        "Allowed categories: PAID_COURSES,FREE_COURSES,OFFICIAL_SITE,OFFICIAL_DOCS,CONTENT_CREATORS,TECH_BLOGS."+
                        "All six fields must be arrays, even if they contain only one element.",
                request.getTechnology(),
                request.getObjective(),
                request.getLanguage()
        );
    }
}
