# Utilisation de l'IA dans le TP 2 (tests)

J'ai utilisé Claude pour reperés et regler quelques erreurs ou je suis resté bloquer :

Problèmes rencontrés :
- gemini-2.5-flash renvoyait une erreur 404 (modèle plus disponible pour les nouveaux
  utilisateurs), puis gemini-3.8-flash une erreur 429 (quota gratuit dépassé). J'ai
  utilisé gemini-3.5-flash-lite.
- J'avais mis des dépendances dans <dependencyManagement> au lieu de <dependencies>,
  donc elles n'étaient pas téléchargées.
- Le modèle d'embeddings de Google échouait avec un timeout de 100 ms ; je l'ai mis
  à 2000 ms.
- Avec easy-rag, j'ai dû mettre en commentaire la dépendance et le code BGE.
- Le code fourni de MeteoTool ne compilait pas à cause d'un guillemet manquant dans
  name="nbJoursDebut".