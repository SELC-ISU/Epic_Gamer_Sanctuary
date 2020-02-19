import acm.graphics.*;
import acm.program.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

public class TicTacToe_GUI extends Program {

	public void init() {
		GCanvas canvas = new GCanvas();
		this.add(canvas);

		JLabel labelName = new JLabel("0");
		JTextField textfieldName = new JTextField("hello");

		JButton buttonName = new JButton("yay");

		canvas.add(labelName, 100, 0);
		canvas.add(textfieldName, 50, 100);
		canvas.add(buttonName, 0, 50);
	}

	public TicTacToe_GUI() {
		setTitle("Tic Tac Toe");
	}
}