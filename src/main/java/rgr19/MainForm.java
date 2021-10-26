package rgr26;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//главный класс, содержащий форму расчёта

public class MainForm {

	public MainForm() {

		// Инициализация граф. интерфейса

		JFrame main_GUI = new JFrame(); // создание графического окна
		main_GUI.setTitle("Калькулятор расчёта размера платы за электроснабжение");
		main_GUI.setBounds(500, 400, 480, 405);
		main_GUI.setResizable(false); // фиксированный размер окна

		JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
		main_panel.setLayout(null);
		main_GUI.add(main_panel);

		// Создание топ-меню справки

		JMenuBar menuBar = new JMenuBar();
		JMenu helpMenu = new JMenu("Помощь");

		JMenuItem menuItem1 = new JMenuItem("Справка");
		menuItem1.addActionListener(new Help());
		helpMenu.add(menuItem1);
		menuBar.add(helpMenu);
		main_GUI.setJMenuBar(menuBar);

		// Описание параметроов комбобоксов

		String[] rateComboBoxOptions = { "Физическое лицо", "Физическое лицо (льготный)", "Юридическое лицо" };

		String[] meterModeComboBoxOptions = { "Однотарифный", "Двухтарифный" };

		JComboBox rateComboBox = new JComboBox(rateComboBoxOptions); // добавление объекта комбобокса
		ActionListener rateComboBoxListener = new ActionListener() { // создание слушателя
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) rateComboBox.getSelectedItem();
				switch (selectedItem) {
				case "Физическое лицо":
					// выбираем тариф для физлиц
					break;
				case "Физическое лицо (льготный)":
					// выбираем для льготников
					break;
				case "Юридическое лицо":
					// выбираем тариф для юриков
					break;
				}
			}
		};

		JComboBox meterModeComboBox = new JComboBox(meterModeComboBoxOptions); // добавление объекта комбобокса
		ActionListener meterModeComboBoxListener = new ActionListener() { // создание слушателя
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) rateComboBox.getSelectedItem();
				switch (selectedItem) {
				case "Однотарифный":
					// делаем активным только первые окна
					break;
				case "Двухтарифный":
					// делаем все окна активными
					break;
				}
			}
		};
		// Устанавливаем границы комбоксов, добавляем на панель

		rateComboBox.addActionListener(rateComboBoxListener); // добавление слушателя к комбобоксу
		rateComboBox.setBounds(260, 25, 170, 20); // выставление размеров окна combobox
		main_panel.add(rateComboBox); // добавление combobox на панель

		meterModeComboBox.addActionListener(meterModeComboBox); // добавление слушателя к комбобоксу
		meterModeComboBox.setBounds(260, 55, 170, 20); // выставление размеров окна combobox
		main_panel.add(meterModeComboBox); // добавление combobox на панель

		// Создание вспомогающих надписей

		JLabel label1 = new JLabel("Тип облуживаемого лица "); // Отображение текста или изображения
		label1.setBounds(30, 20, 220, 30);
		main_panel.add(label1);

		JLabel label2 = new JLabel("Режим работы прибора учёта "); // Отображение текста или изображения
		label2.setBounds(30, 50, 220, 30);
		main_panel.add(label2);

		JLabel label3 = new JLabel("Предыдущие показания счётчика 1 "); // Отображение текста или изображения
		label3.setBounds(30, 80, 220, 30);
		main_panel.add(label3);

		JLabel label4 = new JLabel("Предыдущие показания счётчика 2 "); // Отображение текста или изображения
		label4.setBounds(30, 110, 220, 30);
		main_panel.add(label4);

		JLabel label5 = new JLabel("Текущие показания счётчика 1 "); // Отображение текста или изображения
		label5.setBounds(30, 155, 220, 30);
		main_panel.add(label5);

		JLabel label6 = new JLabel("Текущие показания счётчика 2 "); // Отображение текста или изображения
		label6.setBounds(30, 185, 220, 30);
		main_panel.add(label6);

		JLabel label7 = new JLabel("СУММА К ОПЛАТЕ"); // Отображение текста или изображения
		label7.setBounds(30, 230, 220, 30);
		main_panel.add(label7);

		// Создание полей ввода

		JTextField latestMeterValueField1 = new JTextField(25); // поле предыдущих показаний счётчика 1
		latestMeterValueField1.setBounds(260, 90, 170, 20);
		main_panel.add(latestMeterValueField1);

		latestMeterValueField1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				String number = latestMeterValueField1.getText();
				int length = number.length();
				char c = evt.getKeyChar();
				if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9') {
					if (length<6) {
						latestMeterValueField1.setEditable(true);
					}else{
						latestMeterValueField1.setEditable(false);
					}
				}
			}
		});
		
		latestMeterValueField1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});

		JTextField latestMeterValueField2 = new JTextField(25); // поле предыдущих показаний счётчика 2
		latestMeterValueField2.setBounds(260, 120, 170, 20);
		main_panel.add(latestMeterValueField2);

		latestMeterValueField2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				String number = latestMeterValueField2.getText();
				int length = number.length();
				char c = evt.getKeyChar();
				if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9') {
					if (length<6) {
						latestMeterValueField2.setEditable(true);
					}else{
						latestMeterValueField2.setEditable(false);
					}
				}
			}
		});
		
		latestMeterValueField2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
			if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					evt.consume(); // ограничение ввода букв
				}
			}
		});

		JTextField actualMeterValueField1 = new JTextField(25); // поле показаний счётчика 1
		actualMeterValueField1.setBounds(260, 165, 170, 20);
		main_panel.add(actualMeterValueField1);
		actualMeterValueField1.setColumns(10);

		actualMeterValueField1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				String number = actualMeterValueField1.getText();
				int length = number.length();
				char c = evt.getKeyChar();
				if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9') {
					if (length<6) {
						actualMeterValueField1.setEditable(true);
					}else{
						actualMeterValueField1.setEditable(false);
					}
				}
			}
		});
		
		actualMeterValueField1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					evt.consume(); // ограничение ввода букв
				}
			}
		});

		JTextField actualMeterValueField2 = new JTextField(25); // поле показаний счётчика 2
		actualMeterValueField2.setBounds(260, 195, 170, 20);
		main_panel.add(actualMeterValueField2);

		actualMeterValueField2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				String number = actualMeterValueField2.getText();
				int length = number.length();
				char c = evt.getKeyChar();
				if(evt.getKeyChar()>='0' && evt.getKeyChar()<='9') {
					if (length<6) {
						actualMeterValueField2.setEditable(true);
					}else{
						actualMeterValueField2.setEditable(false);
					}
				}
			}
		});
		
		actualMeterValueField2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					evt.consume(); // ограничение ввода букв
				}
			}
		});

		JTextField amountToPayField = new JTextField(25); // поле вывода расчитанной суммы
		amountToPayField.setBounds(260, 240, 170, 20);
		main_panel.add(amountToPayField);

		amountToPayField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				evt.consume(); // ограничение ввода
			}
		});

		// Добавление кнопок

		JButton CalculationButton = new JButton("Рассчитать"); // добавляем кнопку расчёта суммы
		CalculationButton.setBounds(30, 285, 120, 40);
		CalculationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// вызываем расчёт
			}
		});

		main_panel.add(CalculationButton);

		JButton exitButton = new JButton("Выход"); // добавляем кнопку выхода
		exitButton.setBounds(310, 285, 119, 40);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		main_panel.add(exitButton);

		// Делаем панель видимой

		main_GUI.setVisible(true);
		main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		MainForm initializedMainForm = new MainForm();

	}
}