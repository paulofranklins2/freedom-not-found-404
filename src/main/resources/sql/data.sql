USE freedom404;

-- Minecraft
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Minecraft Torch Puzzle', 'RIDDLE', 'Craft me with a stick and coal. What am I?', 'TORCH', 'Think of basic crafting.', 'Minecraft Room 1', 'Blocks surround you in a dim hallway.', 'Darkness closes in as you hesitate.', 'Light floods the room as the torch ignites.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Minecraft Creeper Math', 'NUMBER', 'A creeper stands 5 blocks away. After moving 3 blocks closer, how far away is it?', '2', 'Subtract carefully.', 'Minecraft Room 2', 'Hissing echoes through the corridor.', 'The explosion leaves you in ruins.', 'You dodge just in time.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Minecraft Redstone Sequence', 'NUMBER', 'A redstone repeater adds 2 ticks of delay. After 3 repeaters, how many ticks have passed?', '6', 'Multiply ticks by repeaters.', 'Minecraft Room 7', 'Dust trails lead to flickering torches.', 'The circuit shorts and the room dims.', 'The gate opens with a sharp click.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Minecraft Nether Portal Count', 'NUMBER', 'A nether portal frame requires 10 obsidian. Adding 4 decorative corners uses how many total blocks?', '14', 'Base frame plus corners.', 'Minecraft Room 8', 'You face a cold obsidian arch.', 'Lava seeps from the walls.', 'Purple energy swirls to life.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Minecraft Brewing Riddle', 'RIDDLE', 'Nether wart brewed with a water bottle yields which base potion?', 'AWKWARD POTION', 'Think of the first step in brewing.', 'Minecraft Room 9', 'Bubbling cauldrons line the floor.', 'A foul cloud knocks you back.', 'A clean aroma signals success.');

-- Harry Potter
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Harry Potter Spell Puzzle', 'CIPHER', 'Uifsf jt b tfdvsf tqfmm; efdszqu ju.', 'THERE IS A SECURE SPELL', 'Caesar +1.', 'Harry Potter Room 3', 'An old tome floats before you.', 'The pages burst into flames.', 'The spell reveals a hidden door.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Harry Potter Potion Riddle', 'RIDDLE', 'I bubble in cauldrons and grant luck. Name me.', 'FELIX FELICIS', 'Liquid luck.', 'Harry Potter Room 4', 'Shelves of ingredients line the walls.', 'A cauldron overflows and you lose consciousness.', 'Golden luck shimmers around you.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Harry Potter Horcrux Count', 'NUMBER', 'How many Horcruxes did Voldemort intentionally create?', '6', 'One was accidental.', 'Harry Potter Room 10', 'A dark diary rests on a pedestal.', 'A chilling laugh echoes as you falter.', 'The diary bursts and reveals a passage.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Harry Potter Wand Wood Cipher', 'CIPHER', 'Decode this wand wood using ROT13: RYQRE', 'ELDER', 'Rotate by 13 letters.', 'Harry Potter Room 11', 'Shelves display countless wands.', 'The wands snap in protest.', 'A beam of light guides your way.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Harry Potter Quidditch Math', 'NUMBER', 'Three goals give 10 points each and the Snitch grants 150. What is the total?', '180', 'Add goals then the Snitch.', 'Harry Potter Room 12', 'Brooms circle high above.', 'Bludgers crash down around you.', 'Cheers erupt as you score.');

-- Pokemon
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Pokemon Starter Choice', 'RIDDLE', 'Fire, Water, or Grass: choose the classic first partner.', 'PIKACHU', 'Think of the iconic mascot.', 'Pokemon Room 5', 'A professor waits with three Poké Balls.', 'You walk away empty handed.', 'You gain a loyal companion.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Pokemon Evolution Math', 'NUMBER', 'A Pokemon has 2 stages. How many forms in total?', '3', 'Include the base form.', 'Pokemon Room 6', 'Bright lights swirl around you.', 'The evolution fails and the Pokemon flees.', 'The new form looks ready for battle.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Pokemon Type Weakness', 'RIDDLE', 'Which Pokemon type beats Fire but fears Grass?', 'WATER', 'Think of elemental advantages.', 'Pokemon Room 13', 'Gyms line the path ahead.', 'A wild encounter blocks you.', 'Your attack is super effective!');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Pokemon Badge Quest', 'NUMBER', 'You earned 3 badges and win 5 more. How many badges do you hold?', '8', 'Add them together.', 'Pokemon Room 14', 'A case of shining badges appears.', 'Rival trainers steal your prizes.', 'The case locks with a triumphant jingle.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Pokemon Pokedex Cipher', 'CIPHER', 'Decode this name using Caesar +1: Jwztbvs', 'IVYSAUR', 'Shift back by one.', 'Pokemon Room 15', 'Digital screens flash unknown data.', 'The device sparks and shuts off.', 'The Pokemon springs from the screen.');

-- Git themed puzzles
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Git Branch Creation', 'RIDDLE', 'What command creates a new branch named feature?', 'GIT BRANCH FEATURE', 'Remember the branch keyword.', 'GIT Room 31', 'Repositories stretch endlessly.', 'Branches tangle and trap you.', 'A clean branch sprouts ahead.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Git Commit Math', 'NUMBER', 'A branch has 5 commits. After reverting 2, how many remain?', '3', 'Subtract the reverted commits.', 'GIT Room 32', 'Commits float like specters.', 'History rewrites itself painfully.', 'Only stable commits remain.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Git Init Cipher', 'CIPHER', 'Decode this command with ROT13: tvg vag', 'GIT INIT', 'Rotate each letter by 13.', 'GIT Room 33', 'A blank repository waits.', 'Initialization fails and files vanish.', 'The repo comes to life.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Git Merge Riddle', 'RIDDLE', 'Which command merges branch dev into the current branch?', 'GIT MERGE DEV', 'Use the merge keyword.', 'GIT Room 34', 'Two histories converge before you.', 'Conflicts explode across the log.', 'The branches combine seamlessly.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Git Tag Number', 'NUMBER', 'You create tags v1, v2, and v3. How many tags exist?', '3', 'Count the versions.', 'GIT Room 35', 'Version numbers float in the air.', 'The tags scatter into fragments.', 'You grasp the correct tag count.');

-- Java themed puzzles
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Java Inheritance Riddle', 'RIDDLE', 'Which keyword allows a class to inherit from another?', 'EXTENDS', 'Think of class hierarchy.', 'Java Room 41', 'Code flows like coffee.', 'The hierarchy collapses.', 'Inheritance links form perfectly.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Java Array Index', 'NUMBER', 'An array holds 8 items. What is the index of the last one?', '7', 'Remember zero-based indexing.', 'Java Room 42', 'Arrays of numbers swirl around.', 'An IndexOutOfBounds error strikes.', 'You access the final element safely.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Java Main Method', 'RIDDLE', 'Provide the standard Java main method signature.', 'PUBLIC STATIC VOID MAIN(STRING[] ARGS)', 'It starts every application.', 'Java Room 43', 'A console awaits your command.', 'Nothing executes and silence lingers.', 'The program launches smoothly.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Java Access Modifier', 'RIDDLE', 'Which access modifier allows visibility within package and subclasses?', 'PROTECTED', 'Not public or private.', 'Java Room 44', 'Class diagrams hang in the air.', 'Encapsulation shatters disastrously.', 'Fields glow with the right protection.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Java Bytecode Math', 'NUMBER', 'A method has 25 bytes of bytecode. Adding five 2-byte instructions results in what size?', '35', 'Multiply then add.', 'Java Room 45', 'The JVM churns bytecode streams.', 'The stack overflows violently.', 'Execution continues without issue.');

-- SQL themed puzzles
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('SQL Select Unique', 'SQL', 'Which SQL clause retrieves unique rows from a table?', 'SELECT DISTINCT', 'Use it to remove duplicates.', 'SQL Room 51', 'Tables line the floor like tiles.', 'Duplicate rows swarm around you.', 'Results filter down to uniqueness.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('SQL Primary Key', 'SQL', 'Which constraint ensures a unique identifier for each row?', 'PRIMARY KEY', 'Think of table identity.', 'SQL Room 52', 'Keys jingle in the dim light.', 'Rows clash without order.', 'One key fits each record perfectly.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('SQL Order Results', 'SQL', 'Which clause sorts query results ascending or descending?', 'ORDER BY', 'It organizes the output.', 'SQL Room 53', 'Results float unordered in space.', 'Chaos reigns in the dataset.', 'Rows align neatly in sequence.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('SQL Count Function', 'SQL', 'Which aggregate function returns the number of rows in a set?', 'COUNT', 'Use it for totals.', 'SQL Room 54', 'Numbers fill endless columns.', 'Your query returns nothing.', 'Totals display with clarity.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('SQL Join Riddle', 'SQL', 'What keyword combines rows from two tables based on a related column?', 'JOIN', 'It links tables together.', 'SQL Room 55', 'Tables hover side by side.', 'Rows drift apart meaninglessly.', 'The tables lock together seamlessly.');