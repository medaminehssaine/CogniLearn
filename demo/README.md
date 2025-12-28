# CogniLearn - Intelligent Educational Platform

CogniLearn is a modern, AI-powered educational platform designed to enhance the learning experience through intelligent features like auto-generated quizzes, smart flashcards, and an interactive AI tutor.

## 🚀 Features

### 🧠 AI-Powered Learning
- **Smart Quizzes**: Automatically generates multiple-choice quizzes from course content using Google Gemini (or a smart mock fallback).
- **Adaptive Flashcards**: Creates study flashcards instantly to help reinforce key concepts.
- **AI Tutor Chat**: A context-aware chat assistant that answers student questions based specifically on the course material.
- **Intelligent Evaluation**: Analyzes quiz performance to recommend difficulty adjustments and study focus areas.

### 📚 Course Management
- **Rich Content**: Support for comprehensive course materials.
- **Progress Tracking**: Tracks student progress through lessons and quizzes.
- **Teacher Dashboard**: Tools for instructors to manage courses and view student analytics.

### 🎨 Modern UI/UX
- **Glassmorphism Design**: A premium, modern interface with glass-like effects and smooth animations.
- **Responsive Layout**: Fully optimized for desktop and mobile devices.
- **Interactive Elements**: Dynamic hover effects, transitions, and immediate feedback.

## 🛠️ Technology Stack

- **Backend**: Java 17, Spring Boot 3.2
- **Frontend**: Thymeleaf, HTML5, CSS3 (Custom Glassmorphism), JavaScript
- **Database**: H2 In-Memory Database (for easy demo/testing)
- **AI Integration**: Google Gemini API (generative-ai-java)
- **Build Tool**: Maven

## 📂 Project Structure

The codebase is organized into a clean, layered architecture:

```
src/main/java/com/example/demo/
├── config/          # Configuration classes (Security, Data Loading)
├── controller/      # REST and MVC Controllers handling web requests
├── dto/             # Data Transfer Objects for API communication
├── entity/          # JPA Entities representing the database model
├── repository/      # Spring Data JPA Repositories for data access
├── security/        # Security configuration and authentication logic
├── service/         # Business logic layer (including LLMService)
└── DemoApplication.java  # Main entry point
```

### Key Components

- **`LLMService.java`**: The core AI engine. It handles communication with the Google Gemini API and includes a robust "Smart Mock" mode that generates realistic content even without a valid API key.
- **`ChatController.java`**: Manages the real-time AI chat interactions.
- **`QuizController.java`**: Handles quiz generation, submission, and result evaluation.

## ⚙️ Setup & Configuration

### Prerequisites
- Java 17 or higher
- Maven (wrapper included)

### Running the Application

1. **Clone the repository**
   ```bash
   git clone https://github.com/medaminehssaine/CogniLearn.git
   cd CogniLearn
   ```

2. **Configure AI (Optional)**
   Open `src/main/resources/application.properties` and add your Google Gemini API key:
   ```properties
   app.gemini.api-key=YOUR_API_KEY_HERE
   ```
   *Note: If no key is provided or if the API is rate-limited, the app automatically switches to "Smart Mock" mode.*

3. **Run the App**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the Platform**
   Open your browser and navigate to: `http://localhost:8081`

## 🧪 Smart Mock Mode

The application includes a sophisticated fallback mechanism for demonstrations. If the AI API is unavailable, **Smart Mock Mode** activates automatically:
- **Quizzes**: Generates questions by analyzing the actual text of the course.
- **Chat**: Provides context-aware responses using local string analysis.
- **Reliability**: Ensures the demo never fails during a presentation.

## 📝 License

This project is open-source and available under the MIT License.
