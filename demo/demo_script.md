# Script de Démonstration - EduPlatform

Ce document détaille les étapes pour réaliser une démonstration complète de la plateforme **CogniLearn**.

## 1. Démarrage de l'Application

Ouvrez un terminal à la racine du projet et lancez la commande suivante :

```bash
mvn spring-boot:run
```

Attendez que l'application démarre (message `Started EduplatformApplication in ...`).
L'application sera accessible à l'adresse : `http://localhost:8080`

---

## 2. Scénario Administrateur (Gestion des Cours)

**Objectif** : Montrer la gestion de contenu et la capacité à gérer des formules complexes.

1.  **Connexion**
    *   Allez sur `http://localhost:8080/login`
    *   **Username** : `admin`
    *   **Password** : `admin123`
    *   Cliquez sur "Sign In".

2.  **Dashboard Admin**
    *   Montrez la vue d'ensemble (nombre d'étudiants, cours, etc.).
    *   Allez dans l'onglet **"Courses"**.

3.  **Exploration d'un Cours Existant**
    *   Cliquez sur le cours **"Machine Learning Fundamentals"** (créé par défaut).
    *   Montrez le contenu riche (Markdown, structure en chapitres).
    *   Expliquez que ce contenu est **indexé** pour le RAG (Retrieval Augmented Generation).

4.  **Création d'un Nouveau Cours**
    *   Cliquez sur **"Create New Course"**.
    *   **Title** : `Introduction à la Physique Quantique`
    *   **Description** : `Les bases de la mécanique quantique et de l'équation de Schrödinger.`
    *   **Content** : Copiez-collez le texte suivant pour montrer le support des formules :
        ```markdown
        # L'Équation de Schrödinger
        
        Au cœur de la mécanique quantique se trouve l'équation de Schrödinger :
        
        $$ i\hbar \frac{\partial}{\partial t} \Psi(\mathbf{r},t) = \hat{H} \Psi(\mathbf{r},t) $$
        
        Où :
        - $\Psi$ est la fonction d'onde
        - $\hat{H}$ est l'opérateur Hamiltonien
        ```
    *   Cliquez sur **"Save & Publish"**.
    *   Vérifiez que le cours apparaît et que la formule est bien rendue (si le support LaTeX est activé dans le front).

5.  **Déconnexion**
    *   Cliquez sur "Logout".

---

## 3. Scénario Étudiant (Apprentissage Adaptatif)

**Objectif** : Montrer l'expérience utilisateur, les quiz générés par IA et le feedback.

1.  **Connexion**
    *   **Username** : `student1`
    *   **Password** : `student123`

2.  **Dashboard Étudiant**
    *   Montrez la liste des cours disponibles.
    *   Vous verrez le cours "Machine Learning Fundamentals" (déjà inscrit) et le nouveau cours de Physique.

3.  **Passer un Quiz (Le Cœur de l'IA)**
    *   Allez sur le cours **"Machine Learning Fundamentals"**.
    *   Cliquez sur **"Take Quiz"**.
    *   **Note Technique** : Expliquez à ce moment que l'IA (Gemini ou Smart Mock) analyse le contenu du cours pour générer des questions *inédites*.
    *   Sélectionnez la difficulté (ex: **Medium**).
    *   Répondez aux questions générées. Faites exprès de faire une erreur pour voir le feedback.

4.  **Résultats et Feedback**
    *   À la fin du quiz, montrez la page de résultats.
    *   Mettez en avant le **Feedback IA** : "L'IA explique pourquoi la réponse est fausse en citant le cours."
    *   Montrez le score et la recommandation de niveau pour la prochaine fois.

---

## 4. Points Techniques à Souligner

Pendant la démo, n'hésitez pas à mentionner :

*   **Smart Mock Mode** : Si l'API Gemini ne répond pas (ou pas de clé), le système bascule automatiquement sur une génération locale robuste (Circuit Breaker).
*   **RAG (Retrieval Augmented Generation)** : Les questions ne sont pas inventées, elles sont basées sur les vecteurs du cours réel.
*   **Sécurité** : Les mots de passe sont hashés (BCrypt) et les rôles sont stricts (Spring Security).
*   **Architecture** : Le projet est un "Modular Monolith" prêt à passer en microservices.

---

## 5. Conclusion

Terminez en montrant la page **"Profile"** de l'étudiant avec sa progression globale.
