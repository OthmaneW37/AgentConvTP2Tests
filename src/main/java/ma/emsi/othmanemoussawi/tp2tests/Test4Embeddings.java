package ma.emsi.othmanemoussawi.tp2tests;

import dev.langchain4j.model.embedding.EmbeddingModel;
// import dev.langchain4j.model.embedding.onnx.bgesmallenv15.BgeSmallEnV15EmbeddingModel;
import dev.langchain4j.model.google.genai.GoogleGenAiEmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class Test4Embeddings {

    static String[][] couples = {
            {"Le chat dort sur le canapé.", "Un félin se repose sur le sofa."},
            {"Il fait très chaud aujourd'hui.", "Il fait très froid aujourd'hui."},
            {"J'adore programmer en Java.", "La programmation Java me passionne."},
            {"La capitale du Maroc est Rabat.", "Rabat est la capitale marocaine."},
            {"Je mange une pomme.", "La bourse a chuté hier."},
            {"Le train part à 8 heures.", "Le football est un sport populaire."}
    };

    public static void main(String[] args) {
        // Modèle intégré (gratuit, entraîné en anglais)
        // EmbeddingModel bge = new BgeSmallEnV15EmbeddingModel();

        // Modèle externe de Google (meilleur en français)
        EmbeddingModel google = GoogleGenAiEmbeddingModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-embedding-001")
                .taskType(GoogleGenAiEmbeddingModel.TaskTypeEnum.SEMANTIC_SIMILARITY)
                .timeout(Duration.ofMillis(2000))
                .build();

        for (String[] c : couples) {
            // double simBge = CosineSimilarity.between(
            //         bge.embed(c[0]).content(), bge.embed(c[1]).content());
            double simGoogle = CosineSimilarity.between(
                    google.embed(c[0]).content(), google.embed(c[1]).content());
            System.out.println(c[0] + " | " + c[1]);
            // System.out.println("   BGE = " + simBge + "   Google = " + simGoogle);
            System.out.println("   Google = " + simGoogle);
        }
    }
}