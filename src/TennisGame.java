public class TennisGame {

    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";

    public static String getScore(String player1Name, String player2Name, int m_firstScore, int m_secondScore) {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;
        boolean check = m_firstScore == m_secondScore;
        boolean score4 = m_firstScore >= 4 || m_secondScore >= 4;
        if (check) {
            switch (m_firstScore) {
                case 0:
                    score = new StringBuilder(LOVE_ALL);
                    break;
                case 1:
                    score = new StringBuilder(FIFTEEN_ALL);
                    break;
                case 2:
                    score = new StringBuilder(THIRTY_ALL);
                    break;
                case 3:
                    score = new StringBuilder(FORTY_ALL);
                    break;
                default:
                    score = new StringBuilder(DEUCE);
                    break;

            }
        } else if (score4) {
            int minusResult = m_firstScore - m_secondScore;
            if (minusResult == 1) {
                score = new StringBuilder(ADVANTAGE_PLAYER_1);
            } else if (minusResult == -1) {
                score = new StringBuilder(ADVANTAGE_PLAYER_2);
            } else if (minusResult >= 2) {
                score = new StringBuilder(WIN_FOR_PLAYER_1);
            } else score = new StringBuilder(WIN_FOR_PLAYER_2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = m_firstScore;
                } else {
                    score.append("-");
                    tempScore = m_secondScore;
                }
                switch (tempScore) {
                    case 0:
                        score.append(LOVE);
                        break;
                    case 1:
                        score.append(FIFTEEN);
                        break;
                    case 2:
                        score.append(THIRTY);
                        break;
                    case 3:
                        score.append(FORTY);
                        break;
                }
            }
        }
        return score.toString();
    }
}
