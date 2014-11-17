package students.frame;

import java.util.Vector;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import students.logic.Group;
import students.logic.ManagementSystem;
import students.logic.Student;

public class StudentsFrame extends JFrame {

    ManagementSystem ms = ManagementSystem.getInstance();
    private JList grpList;
    private JList stdList;
    private JSpinner spYear;

    public StudentsFrame() {
        // ������������� layout ��� ���� ���������� ����� �����
        getContentPane().setLayout(new BorderLayout());

        // ������� ������� �����, ��� ����� ���� ��� ����� ����
        JPanel top = new JPanel();
        // ������������� ��� ��� layout
        top.setLayout(new FlowLayout(FlowLayout.LEFT));

        // ��������� ������������� �������
        top.add(new JLabel("��� ��������:"));
        // ������ ����-����
        //   1. ������ ������ ��������� - ������ �����
        //   2. ��������� � ������
        SpinnerModel sm = new SpinnerNumberModel(2006, 1900, 2100, 1);
        spYear = new JSpinner(sm);
        top.add(spYear);

        // ������� ������ ������ � ������ �� layout
        JPanel bot = new JPanel();
        bot.setLayout(new BorderLayout());

        // ������� ����� ������ ��� ������ ������ �����
        JPanel left = new JPanel();
        // ������ layout � ������ "������" ������ ������
        left.setLayout(new BorderLayout());
        left.setBorder(new BevelBorder(BevelBorder.RAISED));

        // �������� ������ �����
        Vector<Group> gr = new Vector<Group>(ms.getGroups());
        // ������� �������
        left.add(new JLabel("������:"), BorderLayout.NORTH);
        // ������� ���������� ������ � ��������� ��� � �������������
        // ������, ������� � ���� ������� ��� ������ �� ������ left
        grpList = new JList(gr);
        left.add(new JScrollPane(grpList), BorderLayout.CENTER);

        // ������� ������ ������ ��� ������ ������ ���������
        JPanel right = new JPanel();
        // ������ layout � ������ "������" ������ ������
        right.setLayout(new BorderLayout());
        right.setBorder(new BevelBorder(BevelBorder.RAISED));

        // �������� ������ ���������
        Vector<Student> st = new Vector<Student>(ms.getAllStudents());
        // ������� �������
        right.add(new JLabel("��������:"), BorderLayout.NORTH);
        // ������� ���������� ������ � ��������� ��� � �������������
        // ������, ������� � ���� ������� ��� ������ �� ������ right
        stdList = new JList(st);
        right.add(new JScrollPane(stdList), BorderLayout.CENTER);

        // ��������� ������ �� �������� ����� � ��������� � ������ ������
        bot.add(left, BorderLayout.WEST);
        bot.add(right, BorderLayout.CENTER);

        // ��������� ������� � ������ ������ � �����
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(bot, BorderLayout.CENTER);

        // ������ ������� �����
        setBounds(100, 100, 600, 400);
    }

    public static void main(String args[]) {
        // ������ ����� ����� ����������� � ����������� �����
        // event-dispatching thread - EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                StudentsFrame sf = new StudentsFrame();
                sf.setDefaultCloseOperation(EXIT_ON_CLOSE);
                sf.setVisible(true);
            }
        });
    }
}