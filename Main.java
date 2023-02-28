import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main implements ActionListener {

  private JFrame frame;
  private JPanel panel;
  private JButton[] buttons = new JButton[9];
  private JLabel winLabel;
  private JButton newGame;

  private String[] fields = {"", "", "", "", "", "", "", "", ""};

  private String userTurn = "X";

  private String playerWon = "";

  public Main() {
    frame = new JFrame();
    panel = new JPanel();
    winLabel = new JLabel("               ", SwingConstants.CENTER);
    
    winLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 25));
    winLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));
    panel.setLayout(new GridLayout(3, 3));

    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton();
      buttons[i].addActionListener(this);
      panel.add(buttons[i]);
    }

    newGame = new JButton("New Game");

    newGame.addActionListener(this);

    frame.add(panel, BorderLayout.CENTER);
    frame.add(winLabel, BorderLayout.NORTH);
    frame.add(newGame, BorderLayout.SOUTH);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Tic Tac Toe");
    frame.pack();
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    CheckNewGame(e);
    for (int i = 0; i < buttons.length; i++) {
      CheckButton(e, buttons[i], i);
    }
    CheckWin();
    SetWinner();
  }

  private void CheckButton(ActionEvent e, JButton button, int index) {
    if (e.getSource() == button && fields[index] == "" && playerWon == "") {
      fields[index] = userTurn;
      button.setText(userTurn);
      ChangeTurn();
    }
  }

  private void ChangeTurn() {
    if (userTurn == "X") {
      userTurn = "O";
    }
    else if (userTurn == "O") {
      userTurn = "X";
    }
  }

  private void CheckWin() {
    if (WinCheck("X")) {
      playerWon = "X";
    }
    else if (WinCheck("O")) {
      playerWon = "O";
    }
    else if (fields[0] != "" && fields[1] != "" && fields[2] != "" && fields[3] != "" && fields[4] != "" && fields[5] != "" && fields[6] != "" && fields[7] != "" && fields[8] != "") {
      playerWon = "-";
    }
  }

  private Boolean WinCheck(String player) {
    return (
      (fields[0] == player && fields[1] == player && fields[2] == player) ||
      (fields[3] == player && fields[4] == player && fields[5] == player) ||
      (fields[6] == player && fields[7] == player && fields[8] == player) || 
      (fields[0] == player && fields[3] == player && fields[6] == player) ||
      (fields[1] == player && fields[4] == player && fields[7] == player) ||
      (fields[2] == player && fields[5] == player && fields[8] == player) ||
      (fields[0] == player && fields[4] == player && fields[8] == player) ||
      (fields[2] == player && fields[4] == player && fields[6] == player));
  }

  private void SetWinner() {
    if (playerWon == "X") {
      winLabel.setText("X won");
    }
    else if (playerWon == "O") {
      winLabel.setText("O won");
    }
    else if (playerWon == "-") {
      winLabel.setText("No one won");
    }
  }

  private void CheckNewGame(ActionEvent e) {
    if (e.getSource() == newGame) {
      for (int i = 0; i < buttons.length; i++) {
        buttons[i].setText("");
      }
      for (int i = 0; i < 9; i++) {
        fields[i] = "";
      }
      playerWon = "";
      winLabel.setText("           ");
      userTurn = "X";
    }
  }

  public static void main(String[] args) {
    new Main();
  }
}