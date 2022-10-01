import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPanel;
    JPanel topPanel;
    JPanel middlePanel;
    JPanel bottomPanel;


    JLabel fortuneTeller;

    ImageIcon icon;

    JTextArea textArea;

    JScrollPane scroller;

    JButton readFortune;

    JButton quitButton;

    String[] fortuneArray;

    Random randNumber;

    int index;

    int lastIndex;

    public FortuneTellerFrame() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createTopPanel();
        mainPanel.add(topPanel, BorderLayout.NORTH);

        createMiddlePanel();
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createTopPanel() {
        topPanel = new JPanel();
        icon = new ImageIcon("src/fortuneteller.jpg");
        fortuneTeller = new JLabel("Forune Teller", icon, JLabel.CENTER);
        fortuneTeller.setHorizontalTextPosition(JLabel.CENTER);
        fortuneTeller.setVerticalTextPosition(JLabel.BOTTOM);
        fortuneTeller.setFont(new Font("Serif", Font.PLAIN, 48));
        topPanel.add(fortuneTeller);

    }

    public void createMiddlePanel() {
        middlePanel = new JPanel();
        textArea = new JTextArea(14, 35);
        scroller = new JScrollPane(textArea);
        textArea.setEditable(false);



        middlePanel.add(scroller);
    }

    public void createBottomPanel() {
        bottomPanel = new JPanel();

        readFortune = new JButton("Read Fortune");
        quitButton = new JButton("Quit");

        readFortune.setFont(new Font("Verdana", Font.PLAIN, 16));
        quitButton.setFont(new Font("Verdana", Font.PLAIN, 16));

        fortuneArray = new String[12];
        randNumber = new Random();

        fortuneArray[0] = "About time I got out of that cookie";
        fortuneArray[1] = "Ask your mom";
        fortuneArray[2] = "You are about to become $8.95 poorer";
        fortuneArray[3] = "The fortune you seek is in another cookie";
        fortuneArray[4] = "You love Chinese food";
        fortuneArray[5] = "You are not illiterate";
        fortuneArray[6] = "Dogs have owners, cats have staff";
        fortuneArray[7] = "run.";
        fortuneArray[8] = "I literally copied all of these from a website";
        fortuneArray[9] = "I have ran out of ideas for fortunes";
        fortuneArray[10] = "Never do anything half wa-";
        fortuneArray[11] = "Ignore previous cookie";








        readFortune.addActionListener((ActionEvent ae) -> {

            index = randNumber.nextInt(12);
            if (index != lastIndex) {
                textArea.append(fortuneArray[index] + "\n");
                lastIndex = index;
            }


        });

        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPanel.add(readFortune);
        bottomPanel.add(quitButton);

    }


}
