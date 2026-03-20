import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
     public ElevensBoard() {
         super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
     }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        boolean output = false;
        if(selectedCards.size() == 2)
        {
            int sum = 0;
            for(Integer i : selectedCards)
            {
                Card card = cardAt(i);
                if(!(card.rank().equals("jack") || card.rank().equals("queen") || card.rank().equals("king")))
                {
                    sum += card.pointValue();
                }
            }
            if(sum == 11)
            {
                output = true;
            }
        }
        else if(selectedCards.size() == 3)
        {
            boolean allFace = true;
            for(Integer i : selectedCards)
            {
                Card card = cardAt(i);
                if(!(card.rank().equals("jack") || card.rank().equals("queen") || card.rank().equals("king")))
                {
                    allFace = false;
                }
            }
            output = allFace;
        }
        return output;
    }   

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        List<Integer> faceless = new ArrayList<Integer>();
        List<Integer> faced = new ArrayList<Integer>();
        for(Integer i : super.cardIndexes())
        {
            Card card = cardAt(i);
            if(card.rank().equals("jack") || card.rank().equals("queen") || card.rank().equals("king"))
            {
                faced.add(i);
            }
            else
            {
                faceless.add(i);
            }
        }
        if(faceless.size() >= 2)
        {
            for(int i = 0; i < faceless.size(); i++)
            {
                for(int j = i; j < faceless.size(); j++)
                {
                    List<Integer> validCheck = new ArrayList<Integer>();
                    validCheck.add(i);
                    validCheck.add(j);
                    if(isLegal(validCheck))
                    {
                        return true;
                    }
                }
            }
        }
        if(faced.size() >= 3)
        {
            for(int i = 0; i < faced.size(); i++)
            {
                for(int j = 0; j < faced.size(); j++)
                {
                    for(int n = 0; n < faced.size(); n++)
                    {
                        List<Integer> validCheck = new ArrayList<Integer>();
                        if(!(i==j || i==n || j==n))
                        {
                            validCheck.add(i);
                            validCheck.add(j);
                            validCheck.add(n);
                            if(isLegal(validCheck))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        for(int i = 0; i < selectedCards.size(); i++)
        {
            for(int j = i; j < selectedCards.size(); j++)
            {
                List<Integer> validCheck = new ArrayList<Integer>();
                validCheck.add(i);
                validCheck.add(j);
                if(isLegal(validCheck))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        for(int i = 0; i < selectedCards.size(); i++)
        {
            for(int j = 0; j < selectedCards.size(); j++)
            {
                for(int n = 0; n < selectedCards.size(); n++)
                {
                    List<Integer> validCheck = new ArrayList<Integer>();
                    if(!(i==j || i==n || j==n))
                    {
                        validCheck.add(i);
                        validCheck.add(j);
                        validCheck.add(n);
                        if(isLegal(validCheck))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
