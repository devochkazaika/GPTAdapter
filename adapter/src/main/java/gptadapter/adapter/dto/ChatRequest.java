package gptadapter.adapter.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ChatRequest {
    @Value("${openai.api.model}")
    public String model;
    public List<Message> messages;
    public int n;
    public double temperature;

    public ChatRequest(String prompt) {
        this.messages = new ArrayList<>();
        this.model = "gpt-3.5-turbo";
        this.messages.add(new Message("user", prompt));
    }

}
