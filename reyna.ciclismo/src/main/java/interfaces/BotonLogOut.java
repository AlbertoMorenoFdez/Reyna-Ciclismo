package interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BotonLogOut extends JButton {

	public BotonLogOut() {
		setForeground(new Color(78, 1, 23));
		setBackground(new Color(245, 196, 74));
		setText("LogOut");

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(255, 255, 255));
				setBackground(new Color(0, 0, 50));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(new Color(78, 1, 23));
				setBackground(new Color(245, 196, 74));
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}

		});

	}

}
