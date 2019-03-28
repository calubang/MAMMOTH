package design;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;

public class MainView extends JFrame {
	//메인
	//이미지
	ImageIcon coffeeBlack = new ImageIcon(".\\src\\sample\\frappe_black.png");
	ImageIcon coffeeWhite = new ImageIcon(".\\src\\sample\\frappe_white.png");
	//button
	MButton coffee = new MButton("커피", coffeeWhite);
	
	public MainView() {
		super("Mammoth");
		setLayout(null);
		
		//이미지 크기 조절
		
		//버튼달기
		coffee.setBounds(40, 50, 200, 140);
		coffee.setBorderPainted(true);
		
		//LineBorder lb = new LineBorder(Color.WHITE, 10);
		//coffee.setBorder(lb);
		coffee.setFocusPainted(true);
		coffee.setContentAreaFilled(false);
		coffee.init(MButton.HOME_MENU);
		//coffee.setOpaque(false);
		add(coffee);
		
		
		setBounds(300, 200, 500, 500);
		this.setVisible(true);
		
		WindowAdapter wa = new WindowAdapter() {
			public void 	windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		addWindowListener(wa);
		
	}
	
	public static void main(String[] args) throws IOException {
		String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current + "\\src\\sample\\frappe_black.png");
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);
		
		new MainView();
	}
}
