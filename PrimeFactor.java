import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

public class PrimeFactor extends JFrame implements ActionListener {
    private JFrame f;
    private JButton b, ba, fa;
    private JTextArea ta;
    private JTextField tf;
    public PrimeFactor() {
        f = new JFrame("Prime Factorization Calculator");
        f.setSize(528, 304);
        f.setVisible(true);
        f.setLayout(null);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b = new JButton("Get Prime");
        JLabel l = new JLabel("Enter number: ");
        tf = new JTextField();
        ta = new JTextArea();
        ta.setEditable(false);
        b.addActionListener(this);
        l.setBounds(39, 50, 101, 20);
        f.add(l);
        tf.setBounds(215, 50, 125, 27);
        f.add(tf);
        b.setBounds(39, 124, 94, 29);
        f.add(b);
        ta.setBounds(215, 124, 250, 100);
        f.add(ta);
        ba = new JButton("Background");
        ba.addActionListener(this);
        fa = new JButton("Foreground");
        fa.addActionListener(this);
        ba.setBounds(39, 274, 111, 29);
        fa.setBounds(215, 274, 111, 29);
        f.add(ba);
        f.add(fa);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == b)
            try {
                    int num = Integer.parseInt(tf.getText());
                    if (num <= 1)
                        JOptionPane.showMessageDialog(f, "Number must be greater than 1");
                    else if (isPrime(num)) {
                        JOptionPane.showMessageDialog(f, "The number is prime.");
                        ta.setText("[1, " + num + "]");
                    } else
                        ta.setText(primeFactors(num));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Only ints allowed");
                }
        else if (e.getSource() == ba){
            Color c = JColorChooser.showDialog(this, "Choose Background Color", Color.BLACK);
            ta.setBackground(c);
        }else if (e.getSource() == fa){
            Color c = JColorChooser.showDialog(this, "Choose Foreground Color", Color.BLACK);
            ta.setForeground(c);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++)
            if (num % i == 0)
                return false;
        return true;
    }

    private static String primeFactors(int num) {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        while (num % 2 == 0) {
            primeFactors.add(2);
            num /= 2;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2)
            while (num % i == 0) {
                primeFactors.add(i);
                num /= i;
            }
        if (num > 2)
            primeFactors.add(num);
        int[] primes = new int[primeFactors.size()];
        for (int i = 0; i < primeFactors.size(); i++)
            primes[i] = primeFactors.get(i).intValue();
        return Arrays.toString(primes);
    }

    public static void main(String[] args) {
        new PrimeFactor();
    }
}
