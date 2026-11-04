package ma.emsi.othmanemoussawi.tp2tests;

/**
 * Assistant conversationnel qui peut utiliser les outils météo.
 * L'implémentation est faite par LangChain4j (AiServices).
 */
public interface AssistantMeteo {
    // Prend un message de l'utilisateur et retourne une réponse du LLM.
    String chat(String userMessage);
}
