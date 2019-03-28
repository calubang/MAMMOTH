package design;

import java.awt.Font;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class MButton extends JButton{
	
	public static final int HOME_MENU = 1;
	
	
	public MButton(){
		super();
	}
	public MButton(String text) {
		super(text);
	}
	public MButton(String text, Icon icon) {
		super(text, icon);
	}
	public MButton(Action action) {
		super(action);
	}
	public MButton(Icon icon) {
		super(icon);
	}
	
	public void init(int kind) {
		switch(kind) {
			case HOME_MENU:
				Font menu = new Font("Verdana", Font.BOLD , 20);
				setFont(menu);
				break;
		}
	}
}
