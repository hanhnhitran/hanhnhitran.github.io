import pickle

class Board:
    def __init__(self):
        self.map = []
        self.player_x = None
        self.player_y = None
        self.players = [(self.player_x,self.player_y)]
        self.exit = None
        self.door_x = None
        self.door_y = None
        # map.txt
        try:
            with open('CPSC 231/map.txt', 'r') as file:
                for line in file:
                    row = list(line.strip()[:16])
                    self.map.append(row)
        except FileNotFoundError:
            print(f"Map file not found.")
        except Exception as e:
            print("Error reading map file:", str(e))
        # players.txt
        try:
            with open('Assignment 4 attached files Dec 4, 2023 953 PM\players.txt', 'r') as file: # need copy relative path to read file
                for line in file:
                    parts = line.strip().split(' ')
                    if len(parts) == 2:
                        row = int(parts[0])
                        col = int(parts[1])
                        self.players.append((row, col))
            return self.players[1]
        except FileNotFoundError:
            print(f"Players file not found.")
        except Exception as e:
            print("Error reading players file:", str(e))

        #exit.txt Assignment 4 attached files Dec 4, 2023 953 PM\map.txt
        try:
            with open('Assignment 4 attached files Dec 4, 2023 953 PM\exit.txt', 'r') as file:
                for line in file:
                    parts = line.strip().split(' ')
                    if len(parts) == 2:
                        row = int(parts[0])
                        col = int(parts[1])
                        self.exit = (row, col)
        except FileNotFoundError:
            print(f"Exit file 'exit.txt' not found.")
        except Exception as e:
            print("Error reading exit file:", str(e))

        # Validate the loaded data
        if len(self.map) != 12:
            print("Invalid map file. Expected 12 rows.")
        for row in self.map:
            if len(row) != 16:
                print("Invalid map file. Expected 16 columns in each row.")
        if len(self.players) < 1 or len(self.players) > 5:
            print("Invalid players file. Expected minimum 1 and maximum 4 rows.")
        if self.exit is None:
            print("Invalid exit file. Expected exactly 1 row.")

        # Set player and exit positions
        if len(self.players) > 0:
            self.player_y, self.player_x = self.players[0] # because after reading file 'player.txt', we have list Players [(None, None), (5, 5), (9, 9), (2, 2), (3, 4)] 
            #--> so if we wanna get the first place, we need call index 1  
        if self.exit is not None:
            self.door_y, self.door_x = self.exit

        # # Print the loaded data for testing
        # print("Map:")
        # for row in self.map:
        #     print(row)
        # print("Players:", self.players)
        # print("Exit:", self.exit)
        # print("Player position:", self.player_x, self.player_y)
        # print("Exit position:", self.door_x, self.door_y)

    def get_board(self):
        board = []
        for row in range(12):
            board_row = []
            for col in range(16):
                if row == 0 or row == 11 or col == 0 or col == 15:
                    board_row.append("#")  # Wall
                elif row == self.player_y and col == self.player_x:
                    board_row.append("P")  # Player
                elif row == self.door_y and col == self.door_x:
                    board_row.append("E")  # Exit door
                else:
                    board_row.append(" ")  # Empty space
            board.append(board_row)

        return board



    def update(self, direction):
        """
        Updates the current location of the robots on the board according to the given direction.
        
        Parameters:
        - direction: A string representing the direction ("U", "D", "L", "R") in which the robots should move.
        
        Returns:
        None
        """
        # Define the movement offsets based on the direction
        if direction == "U":
            dx, dy = 0, -1  # Move up
        elif direction == "D":
            dx, dy = 0, 1  # Move down
        elif direction == "L":
            dx, dy = -1, 0  # Move left
        elif direction == "R":
            dx, dy = 1, 0  # Move right
        else:
            return
        
        # Create a copy of the current board
        board = self.get_board()
        
        # Iterate over the rows and columns of the board
        for row in range(1, 11):  # Exclude the outer walls
            for col in range(1, 15):  # Exclude the outer walls
                if board[row][col] == "P" or board[row][col] == "E":
                    # Move the player or the door
                    new_row = row + dy
                    new_col = col + dx
                    
                    if board[new_row][new_col] == "#":
                        # Robot hits a wall and dies
                        board[row][col] = " "  # Remove the robot from the current position
                    elif board[new_row][new_col] == "E":
                        # Robot reaches the door and escapes
                        board[row][col] = " "  # Remove the robot from the current position
                    elif board[new_row][new_col] == " ":
                        # Move the robot to the new position
                        board[new_row][new_col] = board[row][col]
                        board[row][col] = " "  # Remove the robot from the current position
        
        # Update the game board
        self.set_board(board)

    def get_state(self):
        """
        Returns an integer representing the state of the game.
        
        Returns:
        - 1: All robots escaped successfully.
        - 2: All robots died.
        - 3: Some robots escaped and some died.
        - 0: Some robots are still on the board, and the game is not over yet.
        """
        board = self.get_board()
        robots = 0
        escaped_robots = 0
        died_robots = 0
        
        for row in range(1, 11):  # Exclude the outer walls
            for col in range(1, 15):  # Exclude the outer walls
                if board[row][col] == "P":
                    robots += 1
                elif board[row][col] == "E":
                    escaped_robots += 1
                elif board[row][col] == "#":
                    died_robots += 1
        
        if robots == 0:
            if escaped_robots > 0 and died_robots == 0:
                return 1  # All robots escaped successfully
            elif escaped_robots == 0 and died_robots > 0:
                return 2  # All robots died
            elif escaped_robots > 0 and died_robots > 0:
                return 3  # Some robots escaped and some died
        return 0  # Some robots are still on the board, and the game is not over yet


    def save_game(self):
        """
        Saves the entire current state of the game in a file in the current directory.
        
        Returns:
        None
        """
        state = {
            'board': self.get_board(),
            'steps': self.steps
        }
        
        with open('game_state.pickle', 'wb') as file:
            pickle.dump(state, file)

    def load_game(self):
        """
        Reads the entire state of the game from a save file in the current directory.
        
        Returns:
        None
        """
        with open('game_state.pickle', 'rb') as file:
            state = pickle.load(file)
        
        self.set_board(state['board'])
        self.steps = state['steps']

    def get_steps(self):
        """
        Returns the number of steps taken so far in the game.
        
        Returns:
        An integer representing the number of steps taken.
        """
        return self.steps

# FOR CHECK file board.py 
a = Board()
# Print the loaded data for testing
print("Map:")
for row in a.map:
    print(row)
print("Players:", a.players)
print("Exit:", a.exit)
print("Player position:", a.player_x, a.player_y)
print("Exit position:", a.door_x, a.door_y)

print(len(a.players))

