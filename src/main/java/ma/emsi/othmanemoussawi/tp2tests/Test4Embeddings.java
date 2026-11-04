package ma.emsi.othmanemoussawi.tp2tests;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.bgesmallenv15.BgeSmallEnV15EmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

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
        EmbeddingModel bge = new BgeSmallEnV15EmbeddingModel();
        for (String[] c : couples) {
            Embedding e1 = bge.embed(c[0]).content();
            Embedding e2 = bge.embed(c[1]).content();
            double sim = CosineSimilarity.between(e1, e2);
            System.out.println(c[0] + " | " + c[1] + " -> " + sim);
        }
    }
}