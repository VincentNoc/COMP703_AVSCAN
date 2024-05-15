package TimePicker;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimePickerExample extends JFrame {
    private JComboBox<String> timeComboBox;

    public TimePickerExample() {
        setTitle("Time Picker Demo");
        setSize(150, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create a dropdown menu for selecting time in 15-minute increments
        String[] times = generateTimes();
        timeComboBox = new JComboBox<>(times);
        timeComboBox.setEditable(true); // Make the dropdown editable
        timeComboBox.setEditor(new CustomComboBoxEditor()); // Use custom editor

        // Create a button to display the selected time
        JButton showTimeButton = new JButton("Show Selected Time");
        showTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTime = (String) timeComboBox.getSelectedItem();
                if (selectedTime == null) {
                    JOptionPane.showMessageDialog(TimePickerExample.this,
                            "Please select or enter a valid time.");
                    return;
                }
                JOptionPane.showMessageDialog(TimePickerExample.this,
                        "Selected Time: " + selectedTime);
            }
        });

        // Create a panel and add components to it
        JPanel panel = new JPanel();
        panel.add(timeComboBox);
        panel.add(showTimeButton);

        // Add the panel to the frame
        add(panel);

        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private String[] generateTimes() {
        String[] times = new String[24 * 4]; // 24 hours * 4 quarters per hour
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        for (int i = 0; i < times.length; i++) {
            times[i] = sdf.format(calendar.getTime());
            calendar.add(Calendar.MINUTE, 15);
        }
        return times;
    }

    // Custom ComboBoxEditor to allow editing the text field directly
    private class CustomComboBoxEditor extends BasicComboBoxEditor {
        private JTextField textField;

        public CustomComboBoxEditor() {
            super();
            textField = (JTextField) editor;
            textField.setEditable(true);
            textField.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
        }

        @Override
        public Component getEditorComponent() {
            return editor;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimePickerExample().setVisible(true);
            }
        });
    }
}
