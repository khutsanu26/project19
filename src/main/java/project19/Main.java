package project19;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;

public class Main extends Frame implements ActionListener {
  Label lb1;
  
  Label lb2;
  
  Label lb3;
  
  Label lb_ans;
  
  Label lb_ans2;
  
  Label lb_ans3;
  
  TextField txt1;
  
  TextField txt2;
  
  TextField txt3;
  
  Button btn1;
  
  Button btn2;
  
  Car2114 img1;
  
  DecimalFormat dec = new DecimalFormat("#0.00");
  
  public Main() {
    addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent we) {
            System.exit(0);
          }
        });
    this.lb1 = new Label("Стоимость автомобиля");
    this.lb2 = new Label("Годовой процент");
    this.lb3 = new Label("Срок займа в месяцах");
    this.lb_ans = new Label("");
    this.lb_ans2 = new Label("");
    this.lb_ans3 = new Label("");
    this.txt1 = new TextField(10);
    this.txt2 = new TextField(10);
    this.txt3 = new TextField(10);
    this.btn1 = new Button("Вычислить");
    this.btn2 = new Button("Сброс");
    this.img1 = new Car2114();
    add(this.img1);
    add(this.lb1);
    add(this.txt1);
    add(this.lb2);
    add(this.txt2);
    add(this.lb3);
    add(this.txt3);
    add(this.btn1);
    add(this.btn2);
    add(this.lb_ans);
    add(this.lb_ans2);
    add(this.lb_ans3);
    setSize(350, 450);
    setTitle("AutoFees");
    setLayout(new BoxLayout(this, 1));
    this.btn1.addActionListener(this);
    this.btn2.addActionListener(this);
  }
  
  public void actionPerformed(ActionEvent ae) {
    double a = 0.0D, b = 0.0D;
    int c = 0;
    try {
      a = Double.parseDouble(this.txt1.getText());
      if (a > 2.0E7D) {
        this.txt1.setText("МАКСИМУМ 20М");
        return;
      } 
    } catch (NumberFormatException e) {
      this.txt1.setText("Введите число!");
    } 
    try {
      b = Double.parseDouble(this.txt2.getText());
      if (b > 20.0D) {
        this.txt2.setText("МАКСИМУМ 20");
        return;
      } 
    } catch (NumberFormatException e) {
      this.txt2.setText("Введите число!");
    } 
    try {
      c = Integer.parseInt(this.txt3.getText());
      if (c > 72) {
        this.txt3.setText("72");
        return;
      } 
    } catch (NumberFormatException e) {
      this.txt3.setText("Введите число!");
    } 
    double d = b / 12.0D;
    if (ae.getSource() == this.btn1) {
      double x = a;
      for (int i = 0; i < c; i++)
        x += x * d / 100.0D; 
      this.lb_ans.setText("ИТОГО:" + this.dec.format(x) + " руб");
      this.lb_ans2.setText("НАЧИСЛЕННЫЕ ПРОЦЕНТЫ" + this.dec.format(x - a) + " руб");
      this.lb_ans3.setText("ЕЖЕМЕС ПЛАТЁЖ" + this.dec.format((x - a) / c) + " руб");
    } 
    if (ae.getSource() == this.btn2) {
      this.lb_ans.setText("");
      this.lb_ans2.setText("");
      this.lb_ans3.setText("");
    } 
  }
  
  public static void main(String[] args) {
    Main clc = new Main();
    clc.setVisible(true);
  }
  
  class Car2114 extends Component {
    BufferedImage img;
    
    public void paint(Graphics g) {
      g.drawImage(this.img, 0, 0, 250, 200, null);
    }
    
    public Car2114() {
      try {
        this.img = ImageIO.read(new URL("https://images-eds-ssl.xboxlive.com/image?url=wHwbXKif8cus8csoZ03RWwcxuUQ9WVT6xh5XaeeZD02wEfGZeuD.XMoGFVYkwHDqOvKL5.b64ptqP4wCgGHRTxwx1P_DSfovQtLEySE1pNzNK42XWRtEDSaVa412Zj4eNFPxK5ViMa9ywAVcCPaUuqBYg_n_45gsGgbj79L5TQM-"));
      } catch (IOException e) {
        e.printStackTrace();
      } 
    }
    
    public Dimension getPreferredSize() {
      return new Dimension(this.img.getWidth(), this.img.getHeight());
    }
  }
}
