Rotate 4 README:

	By Jay Mishra and Ryan Xia, 5/6/17



Description:



	This is a variation of the classic game Connect 4. The objective is the same as the original game (players try to get four tiles in a row of their color), but with some added twists. Each turn, players can choose to either place a tile on the rack or rotate the rack 90˚ to the right or left. Tiles stack on top of each other, but change direction when the board is rotated. Additional powers include the ability to delete entire rows or columns after certain numbers of turns. These added features make the ultimate goal of getting four in a row more challenging and fun!



Instructions:



	-Players click on the start button on the home screen after reading the instructions.

	-When it is a player’s turn, they click the top of the column that they would like to drop their tile into.

	-Players may use the left arrow key to turn the board 90˚ to the left.

	-Players may use the right arrow key to turn the board 90˚. Players may not drop a tile and rotate the board on the same turn.

	-The first player to get four in a row of their color wins.



Features:



	Must-have

		- Placing colored pieces: having a way for players to to place their piece on the board following the standard connect four rules

		- Rotation: Either rotate the board and tiles left or right by 90˚

		- Gravity: Once rotated the pieces don’t stick to their original side (instead they fall according the the rules of gravity). Pieces dropped on the board will also fall according to the rules of gravity

		- GUI: Start Screen and end screen wich instructions, start, and menu buttons.

		- Background music: background music necessary to hype up the players

	Want-to-have

		- Special feature (delete row): deletes an entire row

		- Special feature (delete column): deletes an entire column

		- Special feature (BOMB): makes the next tiled place a BOMB that explodes and deletes the 8 surrounding tiles.

		- Settings Menu: select which “Special features” you want to enable or disable

		- Animations: animations of tiles falling once added to the board and exploding once deleted

	Stretch

		- AI: Computer that plays against you and beats you every time

		- Nicknames: Instead of having player 1 and player 2 on the screen, have the intro screen prompt players to type in their name

		- Online Multiplayer: Network playing that allows players to play against each other on separate computers

		- Expanded and Irregular Grids: Boards that are bigger than the standard 7X7 grid or shaped differently

		- Different Rotations: Allowing the player to rotated by different angles, such as 45˚, 180˚, etc.



Class list:



	-Tile: the pieces that are dropped into the board

	-Board: the game board

	-MenuPanel: Java panel that hold the menu

	-InstructionPanel: Java panel with all the instructions

	-Game: runs the game




	-GamePanel: Java panel that has the actual game itself
	-Powerup (Interface) : Any action that changes the game from the standard Connect 4 game (i.e. Rotating the board, deleting rows/columns, bomb tiles, nukes, etc.)
		-Rotation (rotates the board 90 degrees clockwise or counterclockwise).
		-Delete (deletes a row or column from the board)
		-Bomb (deletes the 8 tiles around the spot where it lands on the board)

Responsibility list:



	-Jay: Menu panel, Instruction panel, Game (GUI)

	-Ryan: Tile, Game (Game logic)

