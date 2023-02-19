import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main implements ActionListener {

  private JFrame frame;
  private JPanel panel;
  private JButton button11;
  private JButton button12;
  private JButton button13;
  private JButton button21;
  private JButton button22;
  private JButton button23;
  private JButton button31;
  private JButton button32;
  private JButton button33;
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

    panel.setLayout(new GridLayout(3, 3));

    panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 30, 30));

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
    if (
      (fields[0].equals("X") && fields[1].equals("X") && fields[2].equals("X")) ||
      (fields[3].equals("X") && fields[4].equals("X") && fields[5].equals("X")) ||
      (fields[6].equals("X") && fields[7].equals("X") && fields[8].equals("X")) || 
      (fields[0].equals("X") && fields[3].equals("X") && fields[6].equals("X")) ||
      (fields[1].equals("X") && fields[4].equals("X") && fields[7].equals("X")) ||
      (fields[2].equals("X") && fields[5].equals("X") && fields[8].equals("X")) ||
      (fields[0].equals("X") && fields[4].equals("X") && fields[8].equals("X")) ||
      (fields[2].equals("X") && fields[4].equals("X") && fields[6].equals("X"))) {
      playerWon = "X";
    }
    else if (
      (fields[0].equals("O") && fields[1].equals("O") && fields[2].equals("O")) ||
      (fields[3].equals("O") && fields[4].equals("O") && fields[5].equals("O")) ||
      (fields[6].equals("O") && fields[7].equals("O") && fields[8].equals("O")) || 
      (fields[0].equals("O") && fields[3].equals("O") && fields[6].equals("O")) ||
      (fields[1].equals("O") && fields[4].equals("O") && fields[7].equals("O")) ||
      (fields[2].equals("O") && fields[5].equals("O") && fields[8].equals("O")) ||
      (fields[0].equals("O") && fields[4].equals("O") && fields[8].equals("O")) ||
      (fields[2].equals("O") && fields[4].equals("O") && fields[6].equals("O"))) {
      playerWon = "X";
    }
    else if (fields[0] != "" && fields[1] != "" && fields[2] != "" && fields[3] != "" && fields[4] != "" && fields[5] != "" && fields[6] != "" && fields[7] != "" && fields[8] != "") {
      playerWon = "-";
    }
    
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
      fields[0] = "";
      fields[1] = "";
      fields[2] = "";
      fields[3] = "";
      fields[4] = "";
      fields[5] = "";
      fields[6] = "";
      fields[7] = "";
      fields[8] = "";
      playerWon = "";
      winLabel.setText("           ");
    }
  }

  public static void main(String[] args) {
    new Main();
  }
}