package ma.emsi.othmanemoussawi.tp2tests;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test1 {
    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        // Essai 1 : question simple
        System.out.println(model.chat("Qu'est-ce qu'un LLM ? Réponds en 2 phrases."));

        // Essai 2 : l'heure
        System.out.println(model.chat("Quelle heure est-il ?"));

        // Essai 3 : le nom
        System.out.println(model.chat("Bonjour, je m'appelle Othmane Moussawi."));
        System.out.println(model.chat("Comment je m'appelle ?"));
    }
}