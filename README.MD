# FREEDOM NOT FOUND - 404

## Overview

_You wake up inside a locked room. Nothing around you makes sense. Every door is sealed by logic, language, and code. The walls whisper riddles, the floor hums with data, and the air tastes of encryption._

Welcome to **FREEDOM NOT FOUND - 404**, a terminal-based Java puzzle game that challenges players to escape a digital prison by solving progressively harder puzzles — each room holding secrets, clues, and consequences. From SQL queries and logic riddles to number puzzles and ciphered text, every decision you make matters. There's no going back — only decoding your way forward.

---

## Features

- Puzzle Rooms: Navigate through dozens of rooms, each with a unique theme and brain-teasing challenge.
- Categories: Choose from SQL, RIDDLE, CIPHER, or NUMBER-based puzzles.
- Difficulty Scaling: Puzzles increase in difficulty as you go deeper into the digital prison.
- Replay System: Fail or escape? Choose to play again with new categories and rooms.
- Lore + Story: Every room tells a story. Some inspire, some warn, and others mislead.
- Database Integration: Puzzles are dynamically loaded from a MariaDB database.
- Retry Limiter: Fail a puzzle three times and you may be stuck... forever.

---

## Game Flow

1. **Launch the Game**
    - The intro sets the scene. You're trapped. The only escape is through logic and knowledge.

2. **Select a Puzzle Category**
    - Options include:
        - `RIDDLE`
        - `SQL`
        - `CIPHER`
        - `NUMBER`

3. **Choose a Room**
    - Each room corresponds to a unique puzzle. Room names are thematic (e.g., `Minecraft Room 88`, `Harry Potter Room 42`, `GIT Room 31`, etc.)

4. **Solve the Puzzle**
    - Input your answer.
    - Use the hint if you're stuck.
    - Get it wrong 3 times, and the game locks you in that room... for good.

5. **Win or Lose**
    - Solve it? You advance.
    - Fail? You face the consequence.

---

## Technologies

- **Language**: Java 17+
- **Database**: MariaDB (Port 3307 default, configurable)
- **Persistence Layer**: JDBC (No ORM, for performance and transparency)
- **Modules**:
    - `PuzzleDAO` – Loads and queries puzzle data
    - `GameEngine` – Core game loop and logic
    - `CategorySelector` – Manages category input and validation
    - `RoomSelector` – Lets players pick a room from available ones
    - `ConsolePrinter` – Styled console output for immersion
    - `InputUtils` – Handles input and retry logic
    - `model.Puzzle` – Core puzzle data structure

---

## Sample Puzzle Themes

- **Minecraft**
    - Redstone riddles, command block logic, and mob puzzles.
- **Harry Potter**
    - Parseltongue ciphers, magical creatures, and potion math.
- **GTA**
    - San Andreas statistics, heist planning logic, and cheat-code decoding.
- **Perfect World**
    - Faction-based logic puzzles and gear stats riddles.
- **GIT & Programming**
    - Commit message riddles, branching puzzles, and syntax validation games.
