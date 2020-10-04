# Tic Tac Toe

Here's the famous X and O game open to budding Android developers. The codebase, replete with documentation, provides enough hand-holding in itself.

## Highlights

- Activity to activity navigation with `Intent`s by passing extras
- 2D arrays in Java with Android components -> `TextView[][] arr;` for each slot on the board
- Event handling by using `View.OnClickListener` for clicking slots and displaying 'X' or 'O'
- Handling `View` visibility with `setVisibility()` to show / hide player and winning status messages
- Setting color of `TextView`s with `setTextColor()`

## Concepts

- A typical Tic Tac Toe game uses a 9X9 matrix of X or O
- A player is declared winner if either all elements of any 3 rows, 3 columns or the 2 diagonals are marked by either all X or all O
- _Boundary condition:_ A player shouldn't be able to click on an existing slot and replace an X with a O or vice versa
- _Boundary condition:_ Even if you detach click handlers for each slot as and when it is clicked, there could be a case where the game is over yet a few slots are empty that can still be clicked - we need a function that can set or unset click handlers on all slots together
- If there's a winner, the row, column or diagonal that has the winning triplet should be colored green
- If the game's over, an appropriate status message must be displayed

## Future Scope

- UI can be revamped to look more gamified
- `TextView` slots can be replaced with images that look more like a cross and circle for representing the 'X' and 'O'
- Scoreboard feature can be included
- Instead of coloring the winning triplet green, a line sequence can be drawn over it
- Animations can be added

## Is that all?

If you think the information here is scarce, you'd be happy to know that the source code is well documented and sufficient in itself to understand how the codebase works on a line-to-line basis.

Made with :heart: by `theGeekyLad`