## Star Wars Test App (for Workmate company)

Simple Android application that displays Star Wars characters using the SWAPI API.

Features:
- Character list with basic stats (height, mass, etc.).
- Search functionality with debounce.
- Detailed screen with character bio, films, and species.
- Local caching for offline access.

Tech Stack:
- Architecture: Clean Architecture + MVI.
- UI: Jetpack Compose (Material 3).
- DI: Dagger Hilt.
- Network: Retrofit, OkHttp, Kotlinx Serialization.
- Database: Room.
- Async: Coroutines & Flow.
