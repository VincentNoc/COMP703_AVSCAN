/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

/**
 *
 * @author jazzy-wazzy
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TimePickerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Time Picker Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        JPanel panel = new JPanel(new FlowLayout());

        // Create a custom time picker component
        CustomTimePicker timePicker = new CustomTimePicker();

        // Add the custom time picker component to the panel
        panel.add(new JLabel("Time:"));
        panel.add(timePicker);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String time = timePicker.getSelectedTime();

            // Validate and process the input time
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                sdf.setLenient(false);
                sdf.parse(time);

                // Display the selected time
                JOptionPane.showMessageDialog(frame, "Selected Time: " + time);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid time format! Please enter time in HH:mm format.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}

class CustomTimePicker extends JPanel {
    private JTextField textField;
    private JComboBox<String> comboBox;

    public CustomTimePicker() {
        setLayout(new BorderLayout());

        // Create a text field for manual input
        textField = new JTextField(10);
        textField.setEditable(false);

        // Create a combo box for predefined time options
        comboBox = new JComboBox<>();
        List<String> timeOptions = generateTimeOptions();
        for (String option : timeOptions) {
            comboBox.addItem(option);
        }
        comboBox.setEditable(true);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTime = (String) comboBox.getSelectedItem();
                if (!selectedTime.equals("Custom Time")) {
                    textField.setText(selectedTime);
                }
            }
        });

        // Add the components to the panel
        add(textField, BorderLayout.CENTER);
        add(comboBox, BorderLayout.EAST);
    }

    public String getSelectedTime() {
        return textField.getText();
    }

    private List<String> generateTimeOptions() {
        List<String> timeOptions = new ArrayList<>();
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute += 15) {
                timeOptions.add(String.format("%02d:%02d", hour, minute));
            }
        }
        timeOptions.add("Custom Time");
        return timeOptions;
    }
}


