import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import  javax.swing.*;
import static java.lang.Integer.*;

public class Student extends JFrame
{

    private int numberOfGroup;
    private int[] progressOfStudent;

    Fio fio=new Fio();

    private JButton buttonExecute = new JButton("Execute");

    private JTextField inputSurname=new JTextField("",10);
    private JTextField inputName=new JTextField("",10);
    private JTextField inputPatronymic=new JTextField("",10);
    private JTextField inputNumberOfGroup=new JTextField("",10);
    private JTextField inputProgressOfStudent=new JTextField("",10);

    private JLabel labelSurname=new JLabel("Surname:");
    private JLabel labelName=new JLabel("Name:");
    private JLabel labelPatronymic=new JLabel("Patronymic:");
    private JLabel labelNumberOfGroup=new JLabel("NumberOfGroup:");
    private JLabel labelProgressOfStudent=new JLabel("ProgressOfStudent (without spaces):");

    public  Student()
    {
        super("Information about student");
        this.setBounds(100,100,900,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container=this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));

        container.add(labelSurname);
        container.add(inputSurname);
        container.add(labelName);
        container.add(inputName);
        container.add(labelPatronymic);
        container.add(inputPatronymic);
        container.add(labelNumberOfGroup);
        container.add(inputNumberOfGroup);
        container.add(labelProgressOfStudent);
        container.add(inputProgressOfStudent);

        buttonExecute.addActionListener(new ButtonEventListener());
        container.add(buttonExecute);
    }

    class ButtonEventListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String str1=inputProgressOfStudent.getText();
            progressOfStudent=new int[str1.length()];
            for (int i = 0; i < str1.length(); i++)
             {
                 progressOfStudent[i] = parseInt(String.valueOf(str1.charAt(i)));
             }


             float averageMark = 0;
             if (progressOfStudent.length > 0)
                {
                    float sum = 0;
                    for (int value : progressOfStudent)
                    {
                        sum += value;
                    }
                    averageMark = sum / progressOfStudent.length;
                }

             fio.setName(inputName.getText());
            fio.setSurname(inputSurname.getText());
            fio.setPatronymic(inputPatronymic.getText());
            numberOfGroup = Integer.parseInt(inputNumberOfGroup.getText());

            String message="";
            message+="Surname: " + fio.getSurname()+"\n";
            message+="Name: " + fio.getName()+"\n";
            message+="Patronymic: " + fio.getPatronymic()+"\n";
            message+="Number of group: " + numberOfGroup+"\n";
            message+="Progress: " + Arrays.toString(progressOfStudent) +"\n";
            message+= "Average mark: "+ Math.floor(averageMark) ;

            JOptionPane.showMessageDialog(null,message,"Information about student",JOptionPane.PLAIN_MESSAGE);
        }
    }
}
