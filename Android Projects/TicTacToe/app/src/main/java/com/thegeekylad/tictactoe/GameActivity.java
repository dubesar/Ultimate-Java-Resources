package com.thegeekylad.tictactoe;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] players = new String[] {"X", "O"};  // player 'X' is at index 0 and 'O' at 1
    private int currPlayer;  // together with 'players' can be used to know who's playing right now -> players[currPlayer]
    private int countClicks = 0;  // used to terminate the game when countClicks == 9 (max. 9 clicks on the board completes the game with no wins)

    private TextView[][] matrix;  // a a 9X9 matrix since each 'X' and 'O' slot on the board is actually a TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        currPlayer = getIntent().getIntExtra("startPlayer", 0);  // earlier we passed this value along with the intent to know who starts the game -> 'X' or 'O'
        ((TextView) findViewById(R.id.currPlayerText)).setText(players[currPlayer]);  // "Player: X" text at the top of the board is set to either 'X' or 'O'

        initMatrix();

    }

    /**
     * The logic of happens when you click on an empty slot while playing.
     * @param view  The TextView object of the slot that you clicked on. This slot is to be set as 'X' or 'O' based on whoever the current player is.
     */
    @Override
    public void onClick(View view) {
        countClicks++;
        ((TextView) view).setText(players[currPlayer]);

        // if there is definitely a winner -> either 'X' or 'O' has a triad
        if (computeWinner()) return;

        // if the players have clicked 9 times, intuitively, it means they've tapped on all slots of the board since there's no winner yet, the game is over
        if (countClicks == 9) {
            onGameOver();
            return;
        }

        view.setOnClickListener(null);  // this slot shouldn't be capable of being clicked again
        currPlayer = (currPlayer + 1) % 2;  // 0 -> 'X' and 1 -> 'O' so switch to the opponent
        ((TextView) findViewById(R.id.currPlayerText)).setText(players[currPlayer]);  // "Player: X" is updated with the opponent
    }

    /**
     * Allows or disallows players from tapping on slots on the board.
     * @param shouldSet If true, TextView slots are bound to an onClick() or existing binding is removed (in case the game is over).
     */
    private void setUnsetListeners(boolean shouldSet) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (shouldSet) matrix[i][j].setOnClickListener(this);
                else matrix[i][j].setOnClickListener(null);
            }
        }
    }

    /**
     * The 9X9 matrix of slots is bound to each of the TextViews so that letters 'X' and 'O' can be set
     */
    private void initMatrix() {
        matrix = new TextView[][] {
                new TextView[] {findViewById(R.id.t00), findViewById(R.id.t01), findViewById(R.id.t02)},
                new TextView[] {findViewById(R.id.t10), findViewById(R.id.t11), findViewById(R.id.t12)},
                new TextView[] {findViewById(R.id.t20), findViewById(R.id.t21), findViewById(R.id.t22)}
        };
        setUnsetListeners(true);  // connects each of the slots with an onClick()
    }

    /**
     * Two TextView slots contain same the value if (1) they're not empty and (2) their values (fetched by getText()) are the same.
     * @param x The first TextView slot for comparison
     * @param y The second TextView slot for comparison
     * @return  If true, the slots in concern contain the same values, else they don't.
     */
    private boolean isSameAs(TextView x, TextView y) {
        return !TextUtils.isEmpty(x.getText().toString()) && x.getText().toString().equals(y.getText().toString());
    }

    /**
     * If either of the rows, columns or diagonals contain the same value -> 'X' or 'O', it implies there's a clear winner.
     * @return  If the above logic is falsy, false is returned
     */
    private boolean computeWinner() {

        // check horizontally and vertically
        for (int i = 0; i < 3; i++) {
            if (isSameAs(matrix[i][0], matrix[i][1]) && isSameAs(matrix[i][1], matrix[i][2])) {
                onDone('r', i);
                return true;
            } else if (isSameAs(matrix[0][i], matrix[1][i]) && isSameAs(matrix[1][i], matrix[2][i])) {
                onDone('c', i);
                return true;
            }
        }

        // checking diagonals
        if (isSameAs(matrix[0][0], matrix[1][1]) && isSameAs(matrix[1][1], matrix[2][2])) {
            onDone('d', 0);
            return true;
        } else if (isSameAs(matrix[2][0], matrix[1][1]) && isSameAs(matrix[1][1], matrix[0][2])) {
            onDone('d', 1);
            return true;
        }

        // no winner yet
        return false;
    }

    /**
     * If there's no clear winner, hide the view that displays "Player: X" in favor of "No wins :("
     */
    private void onGameOver() {
        findViewById(R.id.gameView).setVisibility(View.GONE);
        findViewById(R.id.overView).setVisibility(View.VISIBLE);
        setUnsetListeners(false);  // so that the players can't tap any slot to overwrite values
    }

    /**
     * Shows which player won the game, removes slot handlers so that users cannot tap on any
     * TextView and highlights the winning sequence in green color
     * @param type  Can be wither 'r' for row, 'c' for column or 'd' for diagonal.
     * @param rc    In case of 'r' and 'c', it refers to the row or column that contains the
     *              winning sequence and in case of 'd', 0 is understood as the left diagonal
     *              and 1 as the right.
     */
    private void onDone(char type, int rc) {

        // showing winning status
        findViewById(R.id.playerText).setVisibility(View.GONE);  // "Player: " text is removed (which is different from 'hiding' a view)
        ((TextView) findViewById(R.id.currPlayerText)).setText(players[currPlayer]);  // winning player letter is shown
        ((TextView) findViewById(R.id.currPlayerText)).setTextColor(ColorStateList.valueOf(Color.GREEN));  // winning player letter is colored green
        findViewById(R.id.winsText).setVisibility(View.VISIBLE);  // "wins!" text is displayed
        ((TextView) findViewById(R.id.winsText)).setTextColor(ColorStateList.valueOf(Color.GREEN));  // "wins!" text is colored green

        // detaches all click handlers so that players cannot continue playing
        setUnsetListeners(false);

        // based on where the winning sequence is -> row, column or diagonal, the appropriate sequence is colored green
        switch (type) {
            case 'r':
                matrix[rc][0].setTextColor(ColorStateList.valueOf(Color.GREEN));
                matrix[rc][1].setTextColor(ColorStateList.valueOf(Color.GREEN));
                matrix[rc][2].setTextColor(ColorStateList.valueOf(Color.GREEN));
                break;
            case 'c':
                matrix[0][rc].setTextColor(ColorStateList.valueOf(Color.GREEN));
                matrix[1][rc].setTextColor(ColorStateList.valueOf(Color.GREEN));
                matrix[2][rc].setTextColor(ColorStateList.valueOf(Color.GREEN));
                break;
            case 'd':
                switch (rc) {
                    case 0:
                        matrix[0][0].setTextColor(ColorStateList.valueOf(Color.GREEN));
                        matrix[1][1].setTextColor(ColorStateList.valueOf(Color.GREEN));
                        matrix[2][2].setTextColor(ColorStateList.valueOf(Color.GREEN));
                        break;
                    case 1:
                        matrix[2][0].setTextColor(ColorStateList.valueOf(Color.GREEN));
                        matrix[1][1].setTextColor(ColorStateList.valueOf(Color.GREEN));
                        matrix[0][2].setTextColor(ColorStateList.valueOf(Color.GREEN));
                        break;
                }
        }
    }
}