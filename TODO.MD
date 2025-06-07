# TODO - FREEDOM NOT FOUND - 404

## Core Mechanics
- [x] Puzzle category selector with input validation loop
- [x] Room selector based on category
- [x] Load puzzles dynamically from MariaDB
- [x] Limit player retries (3 attempts max)
- [x] Game over message on failed puzzle

## Enhancements
- [ ] Add ASCII-based intro animation
- [ ] Create save game functionality
- [ ] Expand story intros and consequences for each room
- [ ] Implement leaderboard/local score tracking
- [ ] Create visual puzzle editor (external tool)

## Database Tasks
- [x] Create puzzle schema and seed initial entries
- [x] Insert at least 200+ diverse puzzles
- [ ] Add support for themed batch imports
- [ ] Write SQL view for puzzles by category

## UX / Console Polish
- [x] Use consistent ConsolePrinter borders and alignment
- [ ] Highlight wrong attempts with subtle warning tone
- [x] Add support for color-coded output if supported

## Stretch Goals
- [ ] Build JavaFX GUI version
- [ ] Multiplayer puzzle competition mode
- [ ] Add achievements for solving specific themed rooms

## New Ideas
- [ ] Create unit tests for puzzle logic
- [ ] Implement difficulty levels for puzzles
- [ ] Option to skip intro animation via config
- [ ] Provide Docker setup for database
- [ ] Randomize puzzle order each session
- [ ] Add command-line option for debug mode
- [ ] Write integration tests for database connection

---

Progress saved at every major milestone. Contribute carefully. This game is watching.
