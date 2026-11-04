package ma.emsi.othmanemoussawi.tp2tests;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class Test3Traducteur {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        // Template avec 1 paramètre : le texte à traduire
        PromptTemplate template1 = PromptTemplate.from("Traduis le texte suivant en anglais : {{texte}}");
        Prompt prompt1 = template1.apply(Map.of("texte", "J'aime apprendre l'intelligence artificielle."));
        System.out.println(model.chat(prompt1.text()));

        // Template avec 2 paramètres : la langue et le texte
        PromptTemplate template2 = PromptTemplate.from("Traduis le texte suivant en {{langue}} : {{texte}}");
        Prompt prompt2 = template2.apply(Map.of(
                "langue", "espagnol",
                "texte", "Le soleil brille aujourd'hui à Casablanca."));
        System.out.println(model.chat(prompt2.text()));
    }
}