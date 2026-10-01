import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class OneLastBell extends JFrame implements ActionListener {

    JLabel timeLabel;
    JLabel titleLabel;
    JLabel descriptionLabel;
    JLabel questionLabel;
    JLabel progressLabel;

    JButton option1;
    JButton option2;
    JButton option3;

    JButton nextButton;
    JButton memoryButton;
    JButton kulwantButton;
    JButton statisticsButton;

    JProgressBar progressBar;

    String playerName;
    int currentActivity = 0;

    ArrayList<String> memoryBook = new ArrayList<>();

    // Scores used for the final Sai Chit
    int energeticScore = 0;
    int socialScore = 0;
    int peacefulScore = 0;
    int memoryMakerScore = 0;

    // --------------------------------------------------
    // TIME
    // --------------------------------------------------

    String[] times = {
        "5:00 AM",
        "7:15 AM",
        "8:45 AM",
        "9:00 AM",
        "12:00 PM",
        "1:00 PM",
        "4:00 PM",
        "5:00 PM",
        "6:00 PM",
        "Festival Day",
        "7:00 PM",
        "8:00 PM",
        "10:30 PM",
        "One Last Question"
    };

    // --------------------------------------------------
    // TITLES
    // --------------------------------------------------

    String[] titles = {
        "Suprabhatam",
        "Breakfast",
        "Morning Prayers",
        "College Begins",
        "Lunch Time",
        "Afternoon Classes",
        "Snacks",
        "Free Time",
        "Bhajans",
        "Puttaparthi / Festival",
        "Dinner",
        "Study Hours",
        "Lights Out",
        "One Last Memory"
    };

    // --------------------------------------------------
    // DESCRIPTIONS
    // --------------------------------------------------

    String[] descriptions = {
        "The bell rings. A new day at the hostel begins.",
        "Breakfast time. Everyone is slowly making their way to the dining hall.",
        "8:45 already?! Time for prayers.",
        "The first college bell has officially started the day.",
        "One hour of lunch and a little time with friends.",
        "The afternoon session begins.",
        "The most important bell of the afternoon... SNACKS!",
        "Finally! One hour to breathe.",
        "The evening bell rings. Time for bhajans.",
        "Festival day! Everyone gets ready to go together.",
        "Dinner time. The day is almost over.",
        "Study hours begin. Books open... hopefully.",
        "The day is finally coming to an end.",
        "If you could relive ONE moment of your SSSIHL life..."
    };

    // --------------------------------------------------
    // QUESTIONS
    // --------------------------------------------------

    String[] questions = {
        "The 5:00 AM bell rings. What do you do?",
        "It's breakfast time. What's your style?",
        "8:45 AM! What happens?",
        "College is starting. How are you entering class?",
        "Lunch bell! What's your first thought?",
        "Afternoon class begins. Be honest...",
        "4:00 PM! SNACKS!",
        "You finally have free time. What do you do?",
        "6:00 PM. Bhajan time.",
        "It's a festival day. What sounds best?",
        "Dinner time. What's happening?",
        "Study hours begin. What is your strategy?",
        "10:30 PM. What happens now?",
        "If you could relive ONE moment of your SSSIHL life, what would it be?"
    };

    // --------------------------------------------------
    // OPTIONS
    // --------------------------------------------------

    String[][] options = {

        {
            "I'm already ready!",
            "Just five more minutes...",
            "Wait and see what everyone else does."
        },

        {
            "Reach early. Food first!",
            "Go with my friends.",
            "Walk slowly... no hurry."
        },

        {
            "I'm already there!",
            "RUN! RUN! RUN!",
            "How is it already 8:45?!"
        },

        {
            "Enter early and settle down.",
            "Come normally with friends.",
            "Enter with the 'sorry sir/ma'am' face."
        },

        {
            "Food first!",
            "Find my friends.",
            "Walk fast before the line gets long."
        },

        {
            "Fully focused.",
            "Trying very hard not to sleep.",
            "My body is in class, but my mind is somewhere else."
        },

        {
            "Straight to snacks!",
            "Find my friends first.",
            "Sit for five minutes... then disappear."
        },

        {
            "Talk with my friends.",
            "Check my keypad phone.",
            "Lie down for a while."
        },

        {
            "Ready before the bell!",
            "Go when everyone goes.",
            "I'll come in five minutes..."
        },

        {
            "Go with everyone.",
            "Find my friends and enjoy the day.",
            "Just enjoy the little moments."
        },

        {
            "Go straight to dinner.",
            "Wait for my friends.",
            "Discuss the whole day while eating."
        },

        {
            "Focus completely.",
            "Study and talk a little.",
            "Open the book and remember everything except studying."
        },

        {
            "Sleep immediately!",
            "Talk for five minutes first.",
            "Continue talking... sleep can wait."
        },

        {
            "A morning / hostel memory.",
            "A memory with my friends.",
            "A festival / Puttaparthi memory."
        }
    };


    // ==================================================
    // CONSTRUCTOR
    // ==================================================

    OneLastBell() {

        playerName = JOptionPane.showInputDialog(
                null,
                "Welcome to One Last Bell!\n\nWhat is your name?",
                "One Last Bell",
                JOptionPane.QUESTION_MESSAGE
        );

        if (playerName == null || playerName.trim().isEmpty()) {
            playerName = "Anonymous";
        }

        setTitle("One Last Bell - A Day at SSSIHL");

        setSize(850, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createInterface();

        showActivity();

        setVisible(true);
    }


    // ==================================================
    // CREATE INTERFACE
    // ==================================================

    void createInterface() {

        setLayout(new BorderLayout(10, 10));

        // -----------------------------
        // TOP
        // -----------------------------

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.setBackground(
                new Color(255, 239, 210)
        );

        timeLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        timeLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        28
                )
        );

        titleLabel = new JLabel(
                "",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        24
                )
        );

        JPanel headingPanel =
                new JPanel(
                        new GridLayout(2, 1)
                );

        headingPanel.setOpaque(false);

        headingPanel.add(timeLabel);
        headingPanel.add(titleLabel);

        topPanel.add(
                headingPanel,
                BorderLayout.CENTER
        );

        add(
                topPanel,
                BorderLayout.NORTH
        );


        // -----------------------------
        // CENTER
        // -----------------------------

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(
                new BoxLayout(
                        centerPanel,
                        BoxLayout.Y_AXIS
                )
        );

        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        40,
                        20,
                        40
                )
        );


        descriptionLabel =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );

        descriptionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        descriptionLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        17
                )
        );


        questionLabel =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );

        questionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        questionLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        19
                )
        );


        centerPanel.add(descriptionLabel);

        centerPanel.add(
                javax.swing.Box.createVerticalStrut(20)
        );

        centerPanel.add(questionLabel);

        centerPanel.add(
                javax.swing.Box.createVerticalStrut(25)
        );


        // -----------------------------
        // OPTION BUTTONS
        // -----------------------------

        option1 = new JButton();
        option2 = new JButton();
        option3 = new JButton();

        option1.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        option2.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        option3.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);


        centerPanel.add(option1);

        centerPanel.add(
                javax.swing.Box.createVerticalStrut(10)
        );

        centerPanel.add(option2);

        centerPanel.add(
                javax.swing.Box.createVerticalStrut(10)
        );

        centerPanel.add(option3);


        add(
                centerPanel,
                BorderLayout.CENTER
        );


        // -----------------------------
        // BOTTOM
        // -----------------------------

        JPanel bottomPanel =
                new JPanel(
                        new BorderLayout()
                );


        progressLabel =
                new JLabel(
                        "",
                        SwingConstants.CENTER
                );


        progressBar =
                new JProgressBar(
                        0,
                        times.length
                );

        progressBar.setStringPainted(true);


        JPanel progressPanel =
                new JPanel(
                        new BorderLayout()
                );

        progressPanel.add(
                progressLabel,
                BorderLayout.NORTH
        );

        progressPanel.add(
                progressBar,
                BorderLayout.CENTER
        );


        // -----------------------------
        // BOTTOM BUTTONS
        // -----------------------------

        nextButton =
                new JButton("Next Bell 🔔");

        memoryButton =
                new JButton("Memory Book 📖");

        kulwantButton =
                new JButton("Kulwant Hall 🏛️");

        statisticsButton =
                new JButton("Statistics 📊");


        nextButton.addActionListener(this);

        memoryButton.addActionListener(this);

        kulwantButton.addActionListener(this);

        statisticsButton.addActionListener(this);


        JPanel buttonsPanel =
                new JPanel();

        buttonsPanel.add(nextButton);

        buttonsPanel.add(memoryButton);

        buttonsPanel.add(kulwantButton);

        buttonsPanel.add(statisticsButton);


        bottomPanel.add(
                progressPanel,
                BorderLayout.NORTH
        );

        bottomPanel.add(
                buttonsPanel,
                BorderLayout.SOUTH
        );


        add(
                bottomPanel,
                BorderLayout.SOUTH
        );
    }


    // ==================================================
    // SHOW ACTIVITY
    // ==================================================

    void showActivity() {

        if (currentActivity >= times.length) {

            showFinalScreen();

            return;
        }


        timeLabel.setText(
                times[currentActivity]
        );

        titleLabel.setText(
                titles[currentActivity]
        );


        descriptionLabel.setText(
                "<html><center>"
                        + descriptions[currentActivity]
                        + "</center></html>"
        );


        questionLabel.setText(
                "<html><center>"
                        + questions[currentActivity]
                        + "</center></html>"
        );


        option1.setText(
                options[currentActivity][0]
        );

        option2.setText(
                options[currentActivity][1]
        );

        option3.setText(
                options[currentActivity][2]
        );


        option1.setVisible(true);
        option2.setVisible(true);
        option3.setVisible(true);


        progressBar.setValue(
                currentActivity
        );


        progressLabel.setText(
                "Bell "
                        + (currentActivity + 1)
                        + " of "
                        + times.length
        );


        nextButton.setEnabled(false);

        revalidate();

        repaint();
    }


    // ==================================================
    // BUTTON EVENTS
    // ==================================================

    public void actionPerformed(
            ActionEvent e
    ) {

        Object source = e.getSource();


        if (source == option1) {

            saveChoice(0);
        }


        else if (source == option2) {

            saveChoice(1);
        }


        else if (source == option3) {

            saveChoice(2);
        }


        else if (source == nextButton) {

            currentActivity++;

            showActivity();
        }


        else if (source == memoryButton) {

            showMemoryBook();
        }


        else if (source == kulwantButton) {

            kulwantHall();
        }


        else if (source == statisticsButton) {

            showStatistics();
        }
    }


    // ==================================================
    // SAVE CHOICE
    // ==================================================

    void saveChoice(int choice) {

        String selectedAnswer =
                options[currentActivity][choice];


        // Add to memory book

        memoryBook.add(
                times[currentActivity]
                        + " - "
                        + titles[currentActivity]
                        + ": "
                        + selectedAnswer
        );


        // ------------------------------------------
        // Sai Chit scoring
        // ------------------------------------------

        if (choice == 0) {

            energeticScore++;
        }


        if (choice == 1) {

            socialScore++;
        }


        if (choice == 2) {

            peacefulScore++;
        }


        if (choice == 1 || choice == 2) {

            memoryMakerScore++;
        }


        // ------------------------------------------
        // Save answer to responses.txt
        // ------------------------------------------

        saveResponseToFile(
                times[currentActivity],
                questions[currentActivity],
                selectedAnswer
        );


        JOptionPane.showMessageDialog(
                this,
                "You chose:\n\n"
                        + selectedAnswer
                        + "\n\nMemory saved! ❤️",
                "Memory Collected",
                JOptionPane.INFORMATION_MESSAGE
        );


        nextButton.setEnabled(true);
    }


    // ==================================================
    // SAVE RESPONSE TO TXT FILE
    // ==================================================

    void saveResponseToFile(
            String time,
            String question,
            String answer
    ) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "responses.txt",
                            true
                    );


            writer.write(
                    playerName
                            + " | "
                            + time
                            + " | "
                            + question
                            + " | "
                            + answer
                            + "\n"
            );


            writer.close();
        }

        catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not save response.",
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ==================================================
    // MEMORY BOOK
    // ==================================================

    void showMemoryBook() {

        if (memoryBook.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Your Memory Book is still empty.\n\n"
                            + "Choose some options first! ❤️",
                    "Memory Book",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }


        StringBuilder text =
                new StringBuilder();


        text.append(
                "📖 MEMORY BOOK OF "
                        + playerName.toUpperCase()
                        + "\n\n"
        );


        for (String memory : memoryBook) {

            text.append("• ")
                    .append(memory)
                    .append("\n\n");
        }


        JTextArea area =
                new JTextArea(
                        text.toString()
                );

        area.setEditable(false);

        area.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        15
                )
        );


        JScrollPane scrollPane =
                new JScrollPane(area);


        scrollPane.setPreferredSize(
                new Dimension(
                        650,
                        400
                )
        );


        JOptionPane.showMessageDialog(
                this,
                scrollPane,
                "Your Memory Book 📖",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // ==================================================
    // KULWANT HALL
    // ==================================================

    void kulwantHall() {

        String memory =
                JOptionPane.showInputDialog(
                        this,
                        "What do you remember most about your experience at Kulwant Hall?",
                        "Kulwant Hall",
                        JOptionPane.QUESTION_MESSAGE
                );


        if (memory != null
                && !memory.trim().isEmpty()) {


            memoryBook.add(
                    "Kulwant Hall: "
                            + memory
            );


            saveResponseToFile(
                    "Kulwant Hall",
                    "What do you remember most about your experience at Kulwant Hall?",
                    memory
            );


            JOptionPane.showMessageDialog(
                    this,
                    "That memory belongs in your Memory Book. ❤️",
                    "Memory Saved",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }


    // ==================================================
    // STATISTICS
    // ==================================================

    void showStatistics() {

        File file =
                new File(
                        "responses.txt"
                );


        if (!file.exists()) {

            JOptionPane.showMessageDialog(
                    this,
                    "No responses have been collected yet.",
                    "Statistics",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }


        int[] counts =
                new int[3];


        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file)
                    );


            String line;


            while ((line = reader.readLine()) != null) {

                for (int q = 0;
                     q < options.length;
                     q++) {


                    for (int i = 0;
                         i < 3;
                         i++) {


                        if (line.endsWith(
                                " | "
                                        + options[q][i]
                        )) {

                            counts[i]++;

                            break;
                        }
                    }
                }
            }


            reader.close();
        }


        catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not read responses.txt",
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        JFrame graphFrame =
                new JFrame(
                        "One Last Bell - Statistics"
                );


        graphFrame.setSize(
                800,
                600
        );


        graphFrame.setLocationRelativeTo(
                this
        );


        graphFrame.add(
                new BarGraphPanel(counts)
        );


        graphFrame.setVisible(true);
    }


    // ==================================================
    // FINAL SCREEN
    // ==================================================

    void showFinalScreen() {

        getContentPane().removeAll();


        JPanel finalPanel =
                new JPanel(
                        new BorderLayout()
                );


        finalPanel.setBackground(
                new Color(
                        255,
                        239,
                        210
                )
        );


        JLabel heading =
                new JLabel(
                        "THE LAST BELL...",
                        SwingConstants.CENTER
                );


        heading.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        32
                )
        );


        finalPanel.add(
                heading,
                BorderLayout.NORTH
        );


        JLabel message =
                new JLabel(
                        "<html><center>"
                                + "The day is over...<br><br>"
                                + "Tomorrow the bell will ring again at 5:00 AM...<br><br>"
                                + "But one day there will be no 5:00 AM bell.<br>"
                                + "No rushing for breakfast.<br>"
                                + "No evening bhajans.<br>"
                                + "No study hours.<br>"
                                + "No random conversations in the hostel.<br><br>"
                                + "<b>You were living the memories while you were busy making them.</b>"
                                + "</center></html>",
                        SwingConstants.CENTER
                );


        message.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        19
                )
        );


        finalPanel.add(
                message,
                BorderLayout.CENTER
        );


        JButton chitButton =
                new JButton(
                        "🌸 Pick a Chit 🌸"
                );


        chitButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );


        chitButton.addActionListener(
                e -> showSaiChit()
        );


        finalPanel.add(
                chitButton,
                BorderLayout.SOUTH
        );


        setContentPane(finalPanel);

        revalidate();

        repaint();
    }


    // ==================================================
    // SAI CHIT SCREEN
    // ==================================================

    void showSaiChit() {

        getContentPane().removeAll();


        JPanel chitPanel =
                new JPanel(
                        new BorderLayout()
                );


        chitPanel.setBackground(
                new Color(
                        255,
                        220,
                        170
                )
        );


        // ------------------------------------------
        // Heading
        // ------------------------------------------

        JLabel heading =
                new JLabel(
                        "🌸 YOUR SAI CHIT 🌸",
                        SwingConstants.CENTER
                );


        heading.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        30
                )
        );


        heading.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );


        chitPanel.add(
                heading,
                BorderLayout.NORTH
        );


        // ------------------------------------------
        // YOUR IMAGE
        // ------------------------------------------

        ImageIcon originalIcon =
                new ImageIcon(
                        "sai_chit.png"
                );


        JLabel imageLabel =
                new JLabel();


        if (originalIcon.getIconWidth() > 0) {

            Image image =
                    originalIcon.getImage()
                            .getScaledInstance(
                                    800,
                                    430,
                                    Image.SCALE_SMOOTH
                            );


            imageLabel.setIcon(
                    new ImageIcon(image)
            );
        }


        else {

            imageLabel.setText(
                    "Image not found: sai_chit.png"
            );

            imageLabel.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            20
                    )
            );
        }


        imageLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );


        chitPanel.add(
                imageLabel,
                BorderLayout.CENTER
        );


        // ------------------------------------------
        // PICK CHIT BUTTON
        // ------------------------------------------

        JButton pickButton =
                new JButton(
                        "✨ Pick My Chit ✨"
                );


        pickButton.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        20
                )
        );


        pickButton.addActionListener(
                e -> revealChit()
        );


        JPanel buttonPanel =
                new JPanel();


        buttonPanel.setBackground(
                new Color(
                        255,
                        220,
                        170
                )
        );


        buttonPanel.add(
                pickButton
        );


        chitPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );


        setContentPane(chitPanel);

        revalidate();

        repaint();
    }


    // ==================================================
    // REVEAL SAI CHIT
    // ==================================================

    void revealChit() {

        String title;

        String message;


        // ------------------------------------------
        // Determine chit
        // ------------------------------------------

        if (socialScore >= energeticScore
                && socialScore >= peacefulScore
                && socialScore >= memoryMakerScore) {


            title =
                    "THE PEOPLE PERSON";


            message =
                    "For you, SSSIHL was never just about "
                            + "the places. It was about the people "
                            + "beside you.\n\n"
                            + "The friends, conversations and "
                            + "ordinary moments became special "
                            + "because you shared them.";
        }


        else if (energeticScore >= peacefulScore
                && energeticScore >= memoryMakerScore) {


            title =
                    "THE EARLY BELL";


            message =
                    "If there was a bell, you were probably "
                            + "already there!\n\n"
                            + "You embraced the rhythm of the day "
                            + "and made every little moment count.";
        }


        else if (peacefulScore >= memoryMakerScore) {


            title =
                    "THE PEACEFUL SOUL";


            message =
                    "You knew when to slow down and enjoy "
                            + "the little moments.\n\n"
                            + "Sometimes the quiet moments are "
                            + "the ones we remember the longest.";
        }


        else {


            title =
                    "THE MEMORY MAKER";


            message =
                    "You didn't follow every moment perfectly...\n\n"
                            + "You made it memorable.\n\n"
                            + "Those random conversations, funny "
                            + "moments and little adventures "
                            + "became part of your story.";
        }


        // ------------------------------------------
        // Create chit card
        // ------------------------------------------

        JPanel card =
                new JPanel();


        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );


        card.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );


        JLabel top =
                new JLabel(
                        "🌸 YOUR SAI CHIT 🌸"
                );


        top.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        top.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        22
                )
        );


        JLabel titleLabel =
                new JLabel(
                        title
                );


        titleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        titleLabel.setFont(
                new Font(
                        "Serif",
                        Font.BOLD,
                        26
                )
        );


        JLabel messageLabel =
                new JLabel(
                        "<html><center>"
                                + message.replace(
                                        "\n",
                                        "<br>"
                                )
                                + "</center></html>"
                );


        messageLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        messageLabel.setFont(
                new Font(
                        "Serif",
                        Font.PLAIN,
                        17
                )
        );


        JLabel ending =
                new JLabel(
                        "Keep these memories close. ❤️"
                );


        ending.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        ending.setFont(
                new Font(
                        "Serif",
                        Font.ITALIC,
                        17
                )
        );


        card.add(top);


        card.add(
                javax.swing.Box.createVerticalStrut(15)
        );


        card.add(titleLabel);


        card.add(
                javax.swing.Box.createVerticalStrut(20)
        );


        card.add(messageLabel);


        card.add(
                javax.swing.Box.createVerticalStrut(20)
        );


        card.add(ending);


        JOptionPane.showMessageDialog(
                this,
                card,
                "Your Sai Chit",
                JOptionPane.PLAIN_MESSAGE
        );


        showEnding();
    }


    // ==================================================
    // FINAL MESSAGE
    // ==================================================

    void showEnding() {

        JOptionPane.showMessageDialog(
                this,
                "The timetable ends here,\n"
                        + "but your memories don't. ❤️\n\n"
                        + "Thank you for playing,\n"
                        + playerName + "!",
                "One Last Bell",
                JOptionPane.INFORMATION_MESSAGE
        );
    }


    // ==================================================
    // BAR GRAPH
    // ==================================================

    class BarGraphPanel extends JPanel {

        int[] counts;


        BarGraphPanel(int[] counts) {

            this.counts = counts;

            setBackground(
                    new Color(
                            255,
                            248,
                            235
                    )
            );
        }


        protected void paintComponent(
                Graphics g
        ) {

            super.paintComponent(g);


            Graphics2D g2 =
                    (Graphics2D) g;


            int width =
                    getWidth();

            int height =
                    getHeight();


            // --------------------------------------
            // Title
            // --------------------------------------

            g2.setFont(
                    new Font(
                            "SansSerif",
                            Font.BOLD,
                            24
                    )
            );


            g2.drawString(
                    "One Last Bell - Choice Statistics",
                    180,
                    45
            );


            // --------------------------------------
            // Find highest value
            // --------------------------------------

            int max = 1;


            for (int value : counts) {

                if (value > max) {

                    max = value;
                }
            }


            int baseY =
                    height - 100;


            int barWidth =
                    120;


            int gap =
                    70;


            // --------------------------------------
            // Draw bars
            // --------------------------------------

            for (int i = 0; i < 3; i++) {

                int barHeight =
                        (int)
                        (
                            ((double) counts[i]
                            / max)
                            * 300
                        );


                int x =
                        100
                        + i
                        * (barWidth + gap);


                int y =
                        baseY - barHeight;


                g2.fillRect(
                        x,
                        y,
                        barWidth,
                        barHeight
                );


                g2.drawString(
                        "Option "
                                + (i + 1),
                        x + 25,
                        baseY + 30
                );


                g2.drawString(
                        "" + counts[i],
                        x + 50,
                        y - 10
                );
            }
        }
    }


    // ==================================================
    // MAIN
    // ==================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new OneLastBell()
        );
    }
}