package com.app.TechHive.domain.services;

import com.app.TechHive.domain.DTOs.ChatRequest.ChatCompletionResponse;
import com.app.TechHive.domain.DTOs.ChatRequest.ChatMessage;
import com.app.TechHive.domain.DTOs.ChatRequest.ChatRequest;
import com.app.TechHive.domain.DTOs.ResourceResponse;
import com.app.TechHive.domain.DTOs.UserRequest;
import com.app.TechHive.domain.services.Util_Ai_Service.ObtainContentUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AI_service {
    @Value("${spring.ai.openai.api-key}")
    private String API_KEY;

    //RestClient it's like Axios in javaScript
    private final RestClient restClient;
    private final ObjectMapper mapper = new ObjectMapper();


    public AI_service(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://generativelanguage.googleapis.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    public String testModelsResponse() {
        ResponseEntity<String> response = restClient
                .get()
                .uri("/v1beta/openai/models")
                .header("Authorization", "Bearer " + API_KEY)
                .retrieve()
                .toEntity(String.class);


        return response.getBody();
    }

    public ResourceResponse getResources(ChatRequest chatRequest) throws JsonProcessingException {

        // 3. Call to Gemini API to receive response with a ChatCompletionResponse
        ChatCompletionResponse apiResponse = restClient
                .post()
                .uri("/v1beta/openai/chat/completions")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + API_KEY)
                .body(chatRequest)
                .retrieve()
                .body(ChatCompletionResponse.class);

        //4. Get only the JSON response from Gemini
        String json = ObtainContentUtil.obtainContent(apiResponse);

        // 8. Deserialize the json and return the ResourceResponse
        return mapper.readValue(json, ResourceResponse.class);
    }



}
