package com.app.TechHive.domain.services.Util_Ai_Service;

import com.app.TechHive.domain.DTOs.ChatRequest.ChatCompletionResponse;

public class ObtainContentUtil {

    public static String obtainContent(ChatCompletionResponse content) {
        // 5. Get the content
        String rawContent = content.getChoices()
                .get(0)
                .getMessage()
                .getContent();

        // 6. Print the raw content
        System.out.println("===== RAW CONTENT =====");
        System.out.println(rawContent);
        System.out.println("===== END RAW CONTENT =====");

        // 7. Get the JSON only
        String json = rawContent;
        int start = json.indexOf('{');
        int end = json.lastIndexOf('}');
        if (start != -1 && end != -1 && end > start) {
            json = json.substring(start, end + 1);
        }

        return json;
    }
}
