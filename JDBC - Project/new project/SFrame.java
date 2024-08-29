import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class SFrame extends Frame implements ActionListener{

    TextField tSTU_ID,tSTU_NAME,tSTU_ADD;
    Label lSTU_ID,lSTU_NAME,lSTU_ADD;

    Button bfirst,bnext,bprevious,blast;

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    SFrame(){
        setLayout(new FlowLayout());

        setBackground(Color.red);

        setSize(400,200);

        lSTU_ID = new Label("Id: ");
        add(lSTU_ID);
        tSTU_ID = new TextField(20);
        add(tSTU_ID);

        lSTU_NAME = new Label("Name: ");
        add(lSTU_NAME);
        tSTU_NAME = new TextField(20);
        add(tSTU_NAME);

        lSTU_ADD = new Label("Address: ");
        add(lSTU_ADD);
        tSTU_ADD = new TextField(20);
        add(tSTU_ADD);

        bfirst= new Button("First");
        add(bfirst);
        bfirst.addActionListener(this);

        blast= new Button("Last");
        add(blast);
        blast.addActionListener(this);

        bnext= new Button("Next");
        add(bnext);
        bnext.addActionListener(this);

        bprevious= new Button("Previous");
        add(bprevious);
        bprevious.addActionListener(this);

        setVisible(true);

        getConnection();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w){
                System.exit(0);
            }
        });

        }

    void getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://192.168.102.190:3306/mydb", "root", "tiger");
            if(con!=null)
            System.out.println("Connection Established successfully .....");
            else
            System.out.println("Connection NOT Established  .....");
            st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

            rs=st.executeQuery("select * from student2");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae){
        boolean found=false;
        try{
        if (ae.getSource()==bfirst){
            rs.first();
            found=true;
        }else if (ae.getSource()==blast){
            rs.last();
            found=true;
        }
        else if (ae.getSource()==bnext){
            rs.next();
            found=true;
        }
        else if (ae.getSource()==bprevious){
            rs.previous();
            found=true;
        }
        if (found){
            tSTU_ID.setText(rs.getString(1));
            tSTU_NAME.setText(rs.getString(2));
            tSTU_ADD.setText(rs.getString(3));
        }
    }catch(Exception e){
        e.printStackTrace();

    }
            
    }
    public static void main(String[] args){
        new SFrame();        
    }
    
}