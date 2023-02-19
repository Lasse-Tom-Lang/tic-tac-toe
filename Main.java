import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main implements ActionListener {

  private JFrame frame;
  private JPanel panel;
  private JButton button11, button12, button13, button21, button22, button23, button31, button32,  button33;
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

    button11 = new JButton();
    button12 = new JButton();
    button13 = new JButton();
    button21 = new JButton();
    button22 = new JButton();
    button23 = new JButton();
    button31 = new JButton();
    button32 = new JButton();
    button33 = new JButton();
    newGame = new JButton("New Game");

    button11.addActionListener(this);
    button12.addActionListener(this);
    button13.addActionListener(this);
    button21.addActionListener(this);
    button22.addActionListener(this);
    button23.addActionListener(this);
    button31.addActionListener(this);
    button32.addActionListener(this);
    button33.addActionListener(this);
    newGame.addActionListener(this);

    panel.add(button11);
    panel.add(button12);
    panel.add(button13);
    panel.add(button21);
    panel.add(button22);
    panel.add(button23);
    panel.add(button31);
    panel.add(button32);
    panel.add(button33);

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
    CheckButton(e, button11, 0);
    CheckButton(e, button12, 1);
    CheckButton(e, button13, 2);
    CheckButton(e, button21, 3);
    CheckButton(e, button22, 4);
    CheckButton(e, button23, 5);
    CheckButton(e, button31, 6);
    CheckButton(e, button32, 7);
    CheckButton(e, button33, 8);
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
    if (userTurn.equals("X")) {
      userTurn = "O";
    }
    else if (userTurn.equals("O")) {
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
      (fields[0].equals(player) && fields[1].equals(player) && fields[2].equals(player)) ||
      (fields[3].equals(player) && fields[4].equals(player) && fields[5].equals(player)) ||
      (fields[6].equals(player) && fields[7].equals(player) && fields[8].equals(player)) || 
      (fields[0].equals(player) && fields[3].equals(player) && fields[6].equals(player)) ||
      (fields[1].equals(player) && fields[4].equals(player) && fields[7].equals(player)) ||
      (fields[2].equals(player) && fields[5].equals(player) && fields[8].equals(player)) ||
      (fields[0].equals(player) && fields[4].equals(player) && fields[8].equals(player)) ||
      (fields[2].equals(player) && fields[4].equals(player) && fields[6].equals(player)));
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
      button11.setText("");
      button12.setText("");
      button13.setText("");
      button21.setText("");
      button22.setText("");
      button23.setText("");
      button31.setText("");
      button32.setText("");
      button33.setText("");
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