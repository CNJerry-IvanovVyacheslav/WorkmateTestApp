## Star Wars Test App (for Workmate company)

Simple Android application that displays Star Wars characters using the SWAPI API.

<img src= "https://github.com/CNJerry-IvanovVyacheslav/WorkmateTestApp/blob/7a6d584c1a0820eeea3356ff3f2024ededf4c2fc/photo_2026-04-27_16-52-17.jpg" width="250"> <img src= "https://github.com/CNJerry-IvanovVyacheslav/WorkmateTestApp/blob/7a6d584c1a0820eeea3356ff3f2024ededf4c2fc/photo_2026-04-27_16-52-25.jpg" width="250">

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
