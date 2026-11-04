package ma.emsi.othmanemoussawi.tp2tests.outil.meteo;

public class TestMeteo {
    public static void main(String[] args) {
        MeteoTool meteoTool = new MeteoTool();
        // Paris : latitude 48.85, longitude 2.35 ; période de 3 jours qui commence aujourd'hui
        boolean pluie = meteoTool.isPluiePrevue(48.85, 2.35, 0, 3);
        System.out.println("Pluie prévue à Paris pour les 3 jours à venir : " + pluie);
    }
}
