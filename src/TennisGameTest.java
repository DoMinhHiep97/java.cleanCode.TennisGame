import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TennisGameTest {

    public static final String LOVE = "Love";
    public static final String ALL = "All";

    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String LINK = "-";
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisGameTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, LOVE + LINK + ALL},
                { 1, 1, FIFTEEN + LINK+ ALL},
                { 2, 2, THIRTY + LINK + ALL},
                { 3, 3, FORTY + LINK+ ALL},
                { 4, 4, DEUCE},

                { 1, 0, FIFTEEN + LINK + LOVE},
                { 0, 1, LOVE +LINK + FIFTEEN},
                { 2, 0, THIRTY + LINK + LOVE},
                { 0, 2, LOVE + LINK + THIRTY},
                { 3, 0, FORTY + LINK + LOVE},
                { 0, 3, LOVE + LINK + FORTY},
                { 4, 0, WIN_FOR_PLAYER_1},
                { 0, 4, WIN_FOR_PLAYER_2},

                { 2, 1, THIRTY + LINK + FIFTEEN},
                { 1, 2, FIFTEEN + LINK + THIRTY},
                { 3, 1, FORTY + LINK + FIFTEEN},
                { 1, 3, FIFTEEN + LINK + FORTY},
                { 4, 1, WIN_FOR_PLAYER_1},
                { 1, 4, WIN_FOR_PLAYER_2},

                { 3, 2, FORTY + LINK + THIRTY},
                { 2, 3, THIRTY + LINK + FORTY},
                { 4, 2, WIN_FOR_PLAYER_1},
                { 2, 4, WIN_FOR_PLAYER_2},

                { 4, 3, ADVANTAGE_PLAYER_1},
                { 3, 4, ADVANTAGE_PLAYER_2},
                { 5, 4, ADVANTAGE_PLAYER_1},
                { 4, 5, ADVANTAGE_PLAYER_2},
                { 15, 14, ADVANTAGE_PLAYER_1},
                { 14, 15, ADVANTAGE_PLAYER_2},

                { 6, 4, WIN_FOR_PLAYER_1},
                { 4, 6, WIN_FOR_PLAYER_2},
                { 16, 14, WIN_FOR_PLAYER_1},
                { 14, 16, WIN_FOR_PLAYER_2},
        });
    }

    @Test
    public void checkAllScores() {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        int m_firstScore = 0;
        int m_secondScore = 0;
        for (int i = 0; i < highestScore; i++) {
            boolean checkPlayer1Score=i < this.player1Score;
            if (checkPlayer1Score)
                m_firstScore += 1;
            boolean checkPlayer2Score=i < this.player2Score;
            if (checkPlayer2Score)
                m_secondScore += 1;
        }
        assertEquals(this.expectedScore, TennisGame.getScore("John", "Bill", m_firstScore, m_secondScore));
    }
}