USE freedom404;

-- Minecraft
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Minecraft Torch Puzzle', 'RIDDLE', 'Craft me with a stick and coal. What am I?', 'TORCH', 'Think of basic crafting.', 'Minecraft Room 1', 'Blocks surround you in a dim hallway.', 'Darkness closes in as you hesitate.', 'Light floods the room as the torch ignites.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Minecraft Creeper Math', 'NUMBER', 'A creeper stands 5 blocks away. After moving 3 blocks closer, how far away is it?', '2', 'Subtract carefully.', 'Minecraft Room 2', 'Hissing echoes through the corridor.', 'The explosion leaves you in ruins.', 'You dodge just in time.');

-- Harry Potter
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Harry Potter Spell Puzzle', 'CIPHER', 'Uifsf jt b tfdvsf tqfmm; efdszqu ju.', 'THERE IS A SECURE SPELL', 'Caesar +1.', 'Harry Potter Room 3', 'An old tome floats before you.', 'The pages burst into flames.', 'The spell reveals a hidden door.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Harry Potter Potion Riddle', 'RIDDLE', 'I bubble in cauldrons and grant luck. Name me.', 'FELIX FELICIS', 'Liquid luck.', 'Harry Potter Room 4', 'Shelves of ingredients line the walls.', 'A cauldron overflows and you lose consciousness.', 'Golden luck shimmers around you.');

-- Pokemon
INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Pokemon Starter Choice', 'RIDDLE', 'Fire, Water, or Grass: choose the classic first partner.', 'PIKACHU', 'Think of the iconic mascot.', 'Pokemon Room 5', 'A professor waits with three Poké Balls.', 'You walk away empty handed.', 'You gain a loyal companion.');

INSERT INTO puzzles (name, type, prompt, answer, hint, room_label, story_intro, consequence, success_message)
VALUES ('Pokemon Evolution Math', 'NUMBER', 'A Pokemon has 2 stages. How many forms in total?', '3', 'Include the base form.', 'Pokemon Room 6', 'Bright lights swirl around you.', 'The evolution fails and the Pokemon flees.', 'The new form looks ready for battle.');
