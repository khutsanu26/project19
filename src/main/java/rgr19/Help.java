package rgr26;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Help implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		JFrame Panel = new JFrame(); // Создание графического окна
		Panel.setTitle("Справка");
		Panel.setBounds(800, 300, 600, 600);
		Panel.setResizable(false); // Фиксированный размер окна

		JPanel sec_panel = new JPanel(); // Панель - используется для организации компонентов в окне
		sec_panel.setLayout(null); // Устанавливается менеджер компоновки
		Panel.add(sec_panel);

		// Инструкция
		JLabel Helping = new JLabel("Инструкция и дальше много текста");
		Helping.setBounds(200, 150, 500, 30);
		
        //Логотип
		ImageHelp imgLabel = new ImageHelp();
		imgLabel.setBounds(200, 30, 200, 200);
		imgLabel.setVisible(true);
	
		// Кнопка возврата
		JButton button_back = new JButton("Закрыть справку");
		button_back.setBounds(200, 500, 200, 40);
		button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel.dispose(); // Закрытие окна информации
			}
		});

		sec_panel.add(imgLabel);
		sec_panel.add(button_back);
		sec_panel.add(Helping);
		Panel.setVisible(true);
		
		Panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
