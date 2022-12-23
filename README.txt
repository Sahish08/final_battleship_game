=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 1200 Game Project README
PennKey: hsahi
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. 2D Arrays
  I used 2D Arrays to store the ocean board, which contains all the ship locations for each player, and also the target
  board, which contains all the shots that have been fired by each player. I chose a 2D Array for this purpose because
  each cell on the board could be modeled as an element in the array. I stored ints in the array to represent different
  states. For the ocean board, a 0 meant that the cell was unoccupied, -1 meant that a shot had been fired there and
  missed, 6 meant that a shot had been fired there and hit, and a number 1-5 meant it was occupied by that number ship.
  By using ints, I was able to easily compare these values, modify them, and also quickly draw connections to other data
  structures that stored specific information about each of the ships. Similarly, for the target board, -1 meant a shot
  had been fired at that cell and missed, 0 meant no shot fired, and 1 meant a shot hit. These ints could also be easily
  accessed, modified, and compared to represent different states in the game.

  2. Collections and/or Maps
  I used a TreeMap to store how much health each of a player's ships had left. I chose a TreeMap for this purpose
  because the health corresponds to a specific ship, so the ship is the key, and the health is the value. I also chose
  to make this TreeMap because iterating through the 2D Array after each turn to update the health values would be
  computationally expensive, so I can instead just get the int number of whichever ship is struck and use that to
  decrement its corresponding health value. This is why I chose a TreeMap<Integer,Integer> because having Integer keys
  allows me to use the values from my ocean board without having to change type or perform any additional conversions.
  I also used a LinkedList to store 2D Arrays representing various states of each player's ocean board. I chose this
  structure because every time a player places a ship, I can add a new 2D Array representing this change to the list. If
  the user wants to undo, I simply retrieve the last 2D Array from the LinkedList and make it the current state. This
  requires me to perform no additional calculations, and I did not have to make more methods to enable unlimited undo
  functionality.

  3. File I/O
  I used File I/O to store game state, so a user can pause and pick up where they left off. To save my game, I had to
  write out all the 2D Arrays, LinkedLists, and other variables I used to a file. My approach was essentially to use
  each new line in my output file to delineate the value for a different variable in my game state. I used spaces to
  represent new rows and commas to separate each of the columns in my 2D Arrays. By using getter methods, I was able to
  access the variables I needed from each of my different classes. To load my game, I then parsed the file line-by-line
  and used setter methods to modify the values of all my 2D Arrays, LinkedLists, and other variables. In that way, my
  program and the user can functionally tell no difference between a loaded game and a game that was not loaded. I made
  sure that no functionality was lost and that all the game state was reflected in my files.

  4. JUnit Testable Component
  I used the MVC architecture for this project. Hence, my Battleship class is a model that represents the game state
  separately from my GUI components. In my tests, I made sure to check all the basic functions of battleship, like
  whether users can place ships and fire shots to sink ships. However, I also made sure to test edge cases, such as when
  users try to place ships where one already exists or attempt to place ships diagonally. I also accommodate for when
  users accidentally guess the same spot twice by allowing them to guess again. Therefore, the JUnit testing was crucial
  for me to explore these edge cases and adjust for them in my code. I also made sure to properly use assertTrue/False
  for booleans and assertEquals for ints, so I believe that my unit tests rigorously test my model.

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  The Game class was given with the example code. It initializes the runnable class RunBattleship. Going off the MVC
  model, RunBattleship is the view for my game. It is where all the JPanels are added to a JFrame before the final
  JFrame is displayed to the user. PlayerBoard can be thought of as my hierarchical widget. Any time the user clicks
  on screen, PlayerBoard is the first widget to which it is routed. PlayerBoard then takes care of routing it further
  down to either my TargetBoard or OceanBoard widgets. PlayerBoard is also the class where I implemented my File I/O
  functionality since it has access to all of its variables and the variables of its child widgets. The OceanBoard class
  is also a widget, which takes care of handling any clicks on the ocean board. It updates the Battleship model
  accordingly and also displays information contained in the Battleship model that should be shown on the ocean board.
  The TargetBoard class is another widget, which takes care of handling any clicks on the target board. It updates the
  Battleship model and displays information contained in the Battleship model that should be shown on the target board.
  The Battleship class houses the model for my program. It is independent of my GUI components and stores information
  about each of the players as well as the status of the game. The Player class stores information for a player. This is
  where the 2D Arrays that represent each player's ship positions and shot selection are stored. By creating instances
  of the Player class, the Battleship class can access these structures to keep track of the game state as a whole. The
  FileLineIterator class is similar to what we created in TwitterBot. I used it to read my input files line-by-line, so
  I could restore the game state.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
  The most challenging part of implementing this game was getting both my ocean board and target board to update in
  synchrony. Initially, I did not have a PlayerBoard class, and my ocean board was completely separate from my target
  board, but because a mouse click on one board should update both boards, I sometimes had issues where the screen would
  display Player 2's ships on Player 1's turn. By creating the PlayerBoard class and making instances of OceanBoard and
  TargetBoard within this class, I was able to synchronously update and repaint both states, solving this issue.


- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  I think my current design is fairly separated into the MVC components. All of my variables are private, and I make
  good use of setters and getters. However, if I were to change my code a bit, I would improve the method in which I
  switch player turn. Currently, my model automatically updates turns while my controllers do it based on user clicks.
  Hence, I had to modify my code to accommodate for when my board and model have different values for whose turn it is.
  However, given the opportunity to go back, I would make sure that the turn updating was synchronized.
