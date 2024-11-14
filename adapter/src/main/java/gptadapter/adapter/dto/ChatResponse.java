package gptadapter.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ChatResponse {

    private List<Choice> choices;

    @Data
    @AllArgsConstructor
    public static class Choice {

        private int index;
        private Message message;

    }
}