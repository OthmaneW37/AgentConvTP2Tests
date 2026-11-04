package ma.emsi.othmanemoussawi.tp2tests;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.model.output.TokenUsage;

public class Test2Couts {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        ChatResponse response = model.chat(UserMessage.from("Qu'est-ce qu'un LLM ? Réponds en 2 phrases."));
        System.out.println(response.aiMessage().text());

        TokenUsage usage = response.tokenUsage();
        int in = usage.inputTokenCount();
        int out = usage.outputTokenCount();
        System.out.println("Tokens en entrée : " + in);
        System.out.println("Tokens en sortie : " + out);

        // Prix gemini-3.5-flash-lite : 0,30 $ / million en entrée, 2,50 $ / million en sortie
        double cout = in * 0.30 / 1_000_000 + out * 2.50 / 1_000_000;
        System.out.println("Coût de la requête : " + cout + " $");
        System.out.println("Nombre de requêtes pour dépenser 1 $ : " + (long) (1 / cout));
    }
}