import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUIAllStatement extends Frame implements ActionListener {
    Label lno, lname, lm1, lm2, lm3, lres;
    Choice ch;
    TextField tname, tm1, tm2, tm3, tres;
    Button bdetails, bresult;
    Connection con;
    ResultSet rs;
    Statement st;
    ResultSet rs1, rs2;

    GUIAllStatement() {
        setLayout(new FlowLayout());
        setSize(500, 400);
        setBackground(Color.lightGray);

        lno = new Label("Student No.");
        add(lno);
        ch = new Choice();
        add(ch);

        bdetails = new Button("Details");
        add(bdetails);

        lname = new Label("Name");
        add(lname);
        tname = new TextField(15);
        add(tname);

        lm1 = new Label("Marks 1");
        add(lm1);
        tm1 = new TextField(15);
        add(tm1);

        lm2 = new Label("Marks 2");
        add(lm2);
        tm2 = new TextField(15);
        add(tm2);

        lm3 = new Label("Marks 3");
        add(lm3);
        tm3 = new TextField(15);
        add(tm3);

        bresult = new Button("Result");
        add(bresult);

        lres = new Label("Result is");
        add(lres);
        tres = new TextField(15);
        add(tres);

        // Register the ActionListener for the buttons
        bdetails.addActionListener(this);  // Register the ActionListener for Details button
        bresult.addActionListener(this);   // Register the ActionListener for Result button

        myInit();

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    void myInit() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println("Exception ");
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");
            st = con.createStatement();
            String query = "select sno from Student";
            rs = st.executeQuery(query);
            while (rs.next()) {
                ch.addItem(rs.getString(1));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == bdetails) {
                st = con.createStatement();
                int no = Integer.parseInt(ch.getSelectedItem());
                String newQuery = "Select * from Student where sno=" + no;
                rs2 = st.executeQuery(newQuery);  // Using rs2 instead of rs

                // Move the cursor to the first row
                if (rs2.next()) {
                    // Now we can safely print the data from rs2
                    System.out.println(rs2.getString(2));  // prints the student's name (or appropriate column)

                    // Set the text fields with the fetched data
                    tname.setText(rs2.getString(2));  // Student's name
                    tm1.setText(rs2.getString(3));    // Marks1
                    tm2.setText(rs2.getString(4));    // Marks2
                    tm3.setText(rs2.getString(5));    // Marks3
                } else {
                    System.out.println("No data found for this student.");
                }
            } else if (ae.getSource() == bresult) {
                // Fetch marks from the text fields
                int marks1 = Integer.parseInt(tm1.getText());
                int marks2 = Integer.parseInt(tm2.getText());
                int marks3 = Integer.parseInt(tm3.getText());

                // Check if the student has passed (assuming passing marks are 35)
                if (marks1 >= 35 && marks2 >= 35 && marks3 >= 35) {
                    tres.setText("Pass");
                } else {
                    tres.setText("Fail");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GUIAllStatement();
    }
}
