import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactor extends JFrame {
    public PrimeFactor() {
        JFrame f = new JFrame("Prime Factorization Calculator");
        f.setSize(528, 304);
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton b = new JButton("Get Prime");
        JLabel l = new JLabel("Enter number: ");
        JTextField tf = new JTextField();
        JTextArea ta = new JTextArea();
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
            }
        });
        l.setBounds(39, 50, 101, 20);
        f.add(l);
        tf.setBounds(215, 50, 125, 27);
        f.add(tf);
        b.setBounds(39, 124, 94, 29);
        f.add(b);
        ta.setBounds(215, 124, 250, 100);
        f.add(ta);
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