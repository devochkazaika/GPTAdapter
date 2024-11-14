package gptadapter.adapter.controller;


import gptadapter.adapter.dto.ChatRequest;
import gptadapter.adapter.dto.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gpt/")
public class GptController {
    @PostMapping("/check/condition")
    public Integer checkCondition(@RequestParam String message) {
        return 1;
    }

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;


    @Value("${openai.api.url}")
    public String apiUrl;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        // create a request
        ChatRequest request = new ChatRequest(prompt);
        // call the API
        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}
