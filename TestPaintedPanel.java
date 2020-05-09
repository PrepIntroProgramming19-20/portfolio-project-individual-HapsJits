
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class TestPaintedPanel extends JPanel
{
    JFrame frame;
    JPanel panel;
    //JButton spin;
    JCheckBox spin;
    JButton color;
    JButton clicker;
    PaintedPanel paint;
    JRadioButton red;
    JRadioButton orange;
    JRadioButton yellow;
    JRadioButton green;
    JRadioButton blue;

    JRadioButton purple;

    ButtonGroup buttonGroup;
    boolean spinningRight = true;
    boolean clickergame = false;
    boolean store = false;
    
    JFrame storeFrame;
    JFrame clickerframe;
    int Bruhs = 0;
    JButton nComponent;
    JButton wComponent;
    JButton eComponent;
    JButton sComponent;
    JButton cComponent;
    
    JButton storebuy;
    JButton storeback;
    
    public String userinput;
    int multipliers = 1;
    public TestPaintedPanel() {
        frame = new JFrame();
        
        //spin = new JButton("Spin?");
        spin = new JCheckBox("Spinning left?");
        color = new JButton("Change Color");
        clicker = new JButton("Clicker Game");
        //spin.addActionListener(new Button1Listener());
        spin.addItemListener(new SpinListener());
        color.addActionListener(new Button2Listener());
        clicker.addActionListener(new Button1Listener());
        //spin.setActionCommand("Spin");
        paint = new PaintedPanel();
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(60, 60));
        buttonGroup = new ButtonGroup();
        red = new JRadioButton("Red");
        red.setActionCommand("Red");
        orange = new JRadioButton("Orange");
        orange.setActionCommand("Orange");
        yellow = new JRadioButton("Yellow");
        yellow.setActionCommand("Yellow");
        green = new JRadioButton("Green");
        green.setActionCommand("Green");
        blue = new JRadioButton("Blue");
        blue.setActionCommand("Blue");
        purple = new JRadioButton("Purple");
        purple.setActionCommand("Purple");
        frame.setSize(500, 500);
        frame.add(BorderLayout.SOUTH, spin);
        frame.add(BorderLayout.NORTH, panel);
        frame.add(paint);
        buttonGroup.add(red);
        buttonGroup.add(orange);
        buttonGroup.add(yellow);
        buttonGroup.add(green);
        buttonGroup.add(blue);
        buttonGroup.add(purple);

        panel.add(red);
        panel.add(orange);
        panel.add(yellow);
        panel.add(green);
        panel.add(blue);
        panel.add(purple);

        panel.add(color);
        panel.add(clicker);
        paint.color = Color.white;
        int period = 5;
        Timer mytimer = new Timer(period, new TimerListener());
        mytimer.start();
        frame.setVisible(true);
        
        clickerframe = new JFrame();
        nComponent = new JButton("Click the button to get started"); 
        wComponent = new JButton("The STORE");
        eComponent = new JButton("hi");
        sComponent = new JButton("Back");
        cComponent = new JButton("Click!");
        clickerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clickerframe.add(BorderLayout.NORTH, nComponent);
        clickerframe.add(BorderLayout.WEST, wComponent);
        clickerframe.add(BorderLayout.EAST, eComponent);
        clickerframe.add(BorderLayout.SOUTH, sComponent);
        clickerframe.add(BorderLayout.CENTER, cComponent);
        sComponent.addActionListener(new Button1Listener());
        cComponent.addActionListener(new Button3Listener());
        wComponent.addActionListener(new Button4Listener());
        
        storeFrame = new JFrame();
        storebuy = new JButton("The only thing you can buy");
        storeback = new JButton("Return");
        storeback.addActionListener(new Button4Listener());
        storeFrame.add(BorderLayout.CENTER, storebuy);
        storeFrame.add(BorderLayout.SOUTH, storeback);
        storeFrame.setSize(300, 300);
        
        cComponent.setSize(200, 200);
        clickerframe.setSize(300, 300);
        clickerframe.setVisible(false);
    }
    class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            animation();
        }
    }
    

    public void animation(){
        if (spinningRight == true) {
            paint.radius++;
        }
        else {
            paint.radius--;
        }
        paint.repaint();
    }
    class Button1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (clickergame == false) {
                frame.setVisible(false);
                clickerframe.setVisible(true);
                clickergame = true;
            }
            else {
                frame.setVisible(true);
                clickerframe.setVisible(false);
                clickergame = false; 
            }
        }
    }

    class SpinListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            spinningRight = !spinningRight;
        }
    }
    class Button2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String answer = buttonGroup.getSelection().getActionCommand();
            if(answer.equalsIgnoreCase("Red")) {   
                paint.color = Color.red;
            }
            else if (answer.equalsIgnoreCase("Orange")) {   
                paint.color = Color.orange;
            }
            else  if(answer.equalsIgnoreCase("Yellow")) {   
                paint.color = Color.yellow;
            }
            else  if(answer.equalsIgnoreCase("Green")) {   
                paint.color = Color.green;
            }
            else if(answer.equalsIgnoreCase("Blue")) {   
                paint.color = Color.blue;
            }
            else if(answer.equalsIgnoreCase("Purple")) {   
                paint.color = Color.magenta;
            }
            else {
                paint.color = Color.white;
            }
        }
    }
    class Button3Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            cComponent.setText("Nice Click!");
            cComponent.setSize(200, 200);
            Bruhs = Bruhs + (1 * multipliers);
            nComponent.setText("Your bruhs " + Integer.toString(Bruhs));
        }
    }
    class Button4Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (store == false) {
                clickerframe.setVisible(false);
                storeFrame.setVisible(true);
                store = true;
            }
            else {
                clickerframe.setVisible(true);
                storeFrame.setVisible(false);
                store = false; 
            }
        }
    }
    public static void main(String[] args) {
        TestPaintedPanel panel = new TestPaintedPanel();
    }
}

