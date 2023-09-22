# TodoAppUsingCleanArcheitecture

## Features
- **Task Management:** Create, update, and delete tasks effortlessly.
- **Priority Levels:** Assign priority levels to your tasks to easily identify and manage important items.
- **Due Dates:** Set due dates for tasks to keep track of deadlines.
- **Categories:** Organize your tasks into categories or projects for better organization.
- **Search and Filter:** Quickly find tasks with the search and filter options.
- **Light and Dark Mode:** Choose between light and dark themes for a personalized experience.
## Architecture

Todoify is built using modern Android development practices, ensuring a robust and maintainable codebase. Here's an overview of its architecture:
- **Clean Architecture:** The app follows a clean architecture pattern, separating concerns into layers using Multi Module: Presentation, Domain, Data, and Base.
- **MVVM (Model-View-ViewModel):** Utilizes the MVVM architectural pattern to separate UI logic from business logic.
- **Usecase and Repository Pattern:** Employs use cases to handle business logic and repositories to manage data access.
- **StateFlow and SharedFlow:** Utilizes StateFlow and SharedFlow for reactive programming to efficiently handle UI state and data flows.
- **Navigation Component:** Implements the Android Navigation Component for smooth navigation between screens.
## Built With 🛠

- **Kotlin:** The official and first-class programming language for Android development.
- **Coroutines:** Used for handling asynchronous operations efficiently.
- **Flow:** A cold asynchronous data stream for sequential value emission.
- **Android Architecture Components:** A collection of libraries for creating robust and maintainable apps.
    - **LiveData:** Data objects that notify views of database changes.
    - **ViewModel:** Stores UI-related data that survives configuration changes.
    - **ViewBinding:** Generates binding classes for XML layout files, simplifying view interaction.
- **Dependency Injection:**
    - **Hilt:** Simplifies Dagger DI integration for Android apps (main branch).
- **Room Database:** Provides a local database for storing tasks and categories.
- **Material Components for Android:** Modular and customizable Material Design UI components.
- **Glide:** An image loading library for efficiently displaying images in the app.

## Getting Started

To get started with Todoify, follow these steps:

1. Clone this repository: `git clone https://github.com/YourUsername/Todoify.git`
2. Open the project in Android Studio.
3. Build and run the app on your Android device or emulator.

## Screenshots

![Todoify Screenshots](link-to-your-screenshots)

## Contributing

We welcome contributions to improve. Please fork the repository and create a pull request with your changes.





