Connect 4.0 README:

	By Jay Mishra and Ryan Xia, 5/16/17



Description:



	This is a variation of the classic game Connect 4. The objective is the same as the original game (players try to get four tiles in a row of their color), but with some added twists. Each turn, players can choose to either place a tile on the rack or shift the tiles to the right or left of the board. Tiles stack on top of each other. Additional powers include the ability to delete entire rows or columns after certain numbers of turns. These added features make the ultimate goal of getting four in a row more challenging and fun!



Instructions:



	-Players click on the start button on the home screen after reading the instructions.

	-When it is a player’s turn, they click on the column that they would like to drop their tile into.

	-Players may use the left arrow key to turn the board 90˚ to the left. (NOT DONE)

	-Players may use the right arrow key to turn the board 90˚. Players may not drop a tile and rotate the board on the same turn. (NOT DONE)

	-The first player to get four in a row of their color wins.



Features:



	Must-have

		- Placing colored pieces: having a way for players to to place their piece on the board following the standard connect four rules (DONE)

		- Rotation: Either rotate the board and tiles left or right by 90˚ (NOT DONE)

		- Gravity: Once rotated the pieces don’t stick to their original side (instead they fall according the the rules of gravity). Pieces dropped on the board will also fall according to the rules of gravity (NOT DONE)

		- GUI: Start Screen and end screen wich instructions, start, and menu buttons. (NOT DONE)

		- Background music: background music necessary to hype up the players (NOT DONE)

	Want-to-have

		- Special feature (delete row): deletes an entire row (NOT DONE)

		- Special feature (delete column): deletes an entire column (DONE)

		- Special feature (BOMB): makes the next tiled place a BOMB that explodes and deletes the 8 surrounding tiles. (DONE)

		- Settings Menu: select which “Special features” you want to enable or disable (NOT DONE)

		- Animations: animations of tiles falling once added to the board and exploding once deleted (NOT DONE)

	Stretch

		- AI: Computer that plays against you and beats you every time (NOT DONE)

		- Nicknames: Instead of having player 1 and player 2 on the screen, have the intro screen prompt players to type in their name (NOT DONE)

		- Online Multiplayer: Network playing that allows players to play against each other on separate computers (NOT DONE)

		- Expanded and Irregular Grids: Boards that are bigger than the standard 7X7 grid or shaped differently (NOT DONE)

		- Different Rotations: Allowing the player to rotated by different angles, such as 45˚, 180˚, etc. (NOT DONE)



Class list:



	-Tile: the object that represents a piece that is dropped into the board

	-GamePanel: Java panel  tha holds and runs the game

	-MenuPanel: Javapanel that hold the menu

	-InstructionPanel: Java panel with all the instructions
	
	-SettingsPanel: Java panel that holds the game settings
	
	-Main: The class that holds the main method and runs the program
	
	-KeyHandler: A temporary class left over from the AnimationDemoAP that is currently being used to handle keyboard interactions but will probably be removed later.

	

Responsibility list:



	-Jay: Has set up the basic structure of the program (all the Java panels and Main class), coded the graphical component of the game and wrote the winner method that checks if either player has won the game. Added a feature that allows players to delete columns of tiles using the keyboard.

	-Ryan: Tile, Improved the graphical portion of the game by adding a feature that allows players to add tiles using the mouse instead of forcing them to use the keyboard. Made it so that columns become highlighted in gray when a player mouses over them. Added a rough version of a feature that allows players to move tiles to different sides of the board.

