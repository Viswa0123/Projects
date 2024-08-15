import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int bwidth = 600;
    int bheight = 650;

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel lable = new JLabel();
    JPanel panel = new JPanel();
    JPanel bPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerY = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;
    int count = 0;

    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(bwidth, bheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        lable.setBackground(Color.GRAY);
        lable.setForeground(Color.WHITE);
        lable.setFont(new Font("Arial", Font.BOLD, 50));
        lable.setHorizontalAlignment(JLabel.CENTER);
        lable.setText("Tic-Tac-Toe");
        lable.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(lable);
        frame.add(panel, BorderLayout.NORTH);

        bPanel.setLayout(new GridLayout(3,3));
        bPanel.setBackground(Color.GRAY);
        frame.add(bPanel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tile = new JButton();
                board[i][j] = tile;
                bPanel.add(tile);

                tile.setBackground(Color.GRAY);
                tile.setForeground(Color.WHITE);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
                        JButton tile = (JButton)e.getSource();
                        if(tile.getText() == "") {
                            tile.setText(currentPlayer);
                            count++;
                            checkWinner();
                            if(!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerY : playerX;
                                lable.setText(currentPlayer + "'s turn");
                            }
                        }
                        
                    }
                });
            }
        }
    }
    void checkWinner() {
        //horizintal
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText() == "") continue;

            if (board[i][0].getText() == board[i][1].getText() && board[i][1].getText() == board[i][2].getText()) {
                for (int j = 0; j < 3; j++) {
                    setWinner(board[i][j]);
                }
                gameOver = true;
                return;
            }
        }

        //vertical
        for (int i = 0; i < 3; i++) {
            if (board[0][i].getText() == "") continue;

            if (board[0][i].getText() == board[1][i].getText() && board[1][i].getText() == board[2][i].getText()) {
                for (int j = 0; j < 3; j++) {
                    setWinner(board[i][j]);
                }

                gameOver = true;
                return;
            }
        }

        //diagnol
        if (board[0][0].getText() == board[1][1].getText() && board[1][1] == board[2][2] && board[0][0].getText() != "") {
            for (int i = 0; i < 3; i++) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }

        if (board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText() && board[0][2].getText() != "") {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            return;
        }

        if (count == 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    setTie(board[i][j]);
                }
            }
            gameOver = true;
        }
    }

    void setWinner(JButton tile) {
        tile.setForeground(Color.GREEN);
        tile.setBackground(Color.DARK_GRAY);
        lable.setText(currentPlayer + " is the winner!!!");
    }
    void setTie(JButton tile) {
        tile.setForeground(Color.RED);
        tile.setBackground(Color.DARK_GRAY);
        lable.setText("Gam is Tie");
    }
}
