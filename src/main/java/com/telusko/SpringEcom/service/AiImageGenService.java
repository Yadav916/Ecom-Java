/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.telusko.SpringEcom.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.net.URI;
import java.net.URLEncoder;
/**
 *
 * @author yadav
 */
@Service
public class AiImageGenService {

    @Value("${spring.ai.google.genai.api-key}")
    private String apiKey;

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

//private final HttpClient httpClient = HttpClient.newHttpClient();

    public byte[] generateImage(String prompt) {
        try {
            String encodedPrompt = URLEncoder.encode(prompt, StandardCharsets.UTF_8);
            String url = "https://image.pollinations.ai/prompt/" + encodedPrompt + "?width=512&height=512&nologo=true";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

            if (response.statusCode() == 200) {
                return response.body();
            }

            throw new RuntimeException("Image generation failed with status: " + response.statusCode());

        } catch (Exception e) {
            throw new RuntimeException("Error while generating image: " + e.getMessage(), e);
        }
    }
//    public byte[] generateImage(String prompt) {
//        try {
//            // 1. Endpoint using the supported image model from your key's list
//            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash-image:generateContent?key=" + apiKey;
//
//            // 2. Correct JSON payload for generateContent (NO "instances" or "parameters")
//            String jsonPayload = """
//                {
//                  "contents": [
//                    {
//                      "parts": [
//                        {
//                          "text": "%s"
//                        }
//                      ]
//                    }
//                  ],
//                  "generationConfig": {
//                    "responseModalities": ["IMAGE"]
//                  }
//                }
//                """.formatted(prompt.replace("\"", "\\\""));
//
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .header("Content-Type", "application/json")
//                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
//                    .build();
//
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//            if (response.statusCode() != 200) {
//                throw new RuntimeException("Image generation failed (" + response.statusCode() + "): " + response.body());
//            }
//
//            // 3. Extract the image from candidates -> content -> parts -> inlineData
//            JsonNode root = objectMapper.readTree(response.body());
//            JsonNode parts = root.path("candidates").get(0).path("content").path("parts");
//
//            for (JsonNode part : parts) {
//                if (part.has("inlineData")) {
//                    String base64Image = part.path("inlineData").path("data").asText();
//                    return Base64.getDecoder().decode(base64Image);
//                }
//            }
//
//            throw new RuntimeException("No image data found in response: " + response.body());
//
//        } catch (Exception e) {
//            throw new RuntimeException("Error while generating image: " + e.getMessage(), e);
//        }
//    }
}
