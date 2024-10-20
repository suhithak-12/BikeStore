import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LoginGUI extends Frame implements ActionListener {
    private TextField usernameField, passwordField;
    private Button loginButton;

    public LoginGUI() {
        setTitle("Login Page");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label usernameLabel = new Label("Username:");
        usernameField = new TextField(20);

        Label passwordLabel = new Label("Password:");
        passwordField = new TextField(20);
        passwordField.setEchoChar('*');

        loginButton = new Button("Login");
        loginButton.addActionListener(this);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Easy check for credentials
        if (username.equals("admin") && password.equals("admin")) {
            // Open the menu window
            OwnerMenuGUI Ownermenu = new OwnerMenuGUI(this);
            Ownermenu.setVisible(true);
            // Close the login window
            setVisible(false);
        } else if (username.equals("mechanic") && password.equals("password")) {
            // Open the menu window
            MechanicMenuGUI Mechanicmenu = new MechanicMenuGUI(this);
            Mechanicmenu.setVisible(true);
            // Close the login window
            setVisible(false);
        } else {
            // Display an error message for incorrect login
            System.out.println("Incorrect username or password");
        }
    }
}

class OwnerMenuGUI extends Frame {
    private LoginGUI loginGUI;

    public OwnerMenuGUI(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
        setTitle("Menu");
        setSize(300, 200);
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);


        // Panel for the welcome label
        Panel welcomePanel = new Panel();
        welcomePanel.setLayout(new FlowLayout());
        Label welcomeLabel = new Label("Welcome, Admin!");
        welcomePanel.add(welcomeLabel);

        // Panel for the buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        Button option1 = new Button("Transactions");
        Button option2 = new Button("Bike Inventory");
        Button option3 = new Button("Customers");
        buttonPanel.add(option1);
        buttonPanel.add(option2);
        buttonPanel.add(option3);

        // Add components to the frame
        add(welcomePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the transaction menu
                Menutrans menuTrans = new Menutrans(OwnerMenuGUI.this);
                menuTrans.setVisible(true);
                setVisible(false);
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BikeGUI bike = new BikeGUI(OwnerMenuGUI.this);
                bike.setVisible(true);
                setVisible(false);
            }
        });

        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cgui c = new Cgui(OwnerMenuGUI.this);
                c.setVisible(true);
                setVisible(false);
            }
        });

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                driverBike.close();
                System.exit(0);
            }
        });
    }

    public LoginGUI getLoginGUI() {
        return this.loginGUI;
    }
}

class MechanicMenuGUI extends Frame {
    private LoginGUI loginGUI;

    public MechanicMenuGUI(LoginGUI loginGUI) {
        this.loginGUI = loginGUI;
        setTitle("Menu");
        setSize(300, 200);
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);

        // Panel for the welcome label
        Panel welcomePanel = new Panel();
        welcomePanel.setLayout(new FlowLayout());
        Label welcomeLabel = new Label("Welcome, Mechanic!");
        welcomePanel.add(welcomeLabel);

        // Panel for the buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(1, 1));
        Button option1 = new Button("Bike Inventory");

        buttonPanel.add(option1);

        // Add components to the frame
        add(welcomePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BikeGUI bike = new BikeGUI(MechanicMenuGUI.this);
                bike.setVisible(true);
                setVisible(false);
            }
        });

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                driverBike.close();
                System.exit(0);
            }
        });
    }

    public LoginGUI getLoginGUI() {
        return loginGUI;
    }
}

class Cgui extends Frame {
    private OwnerMenuGUI menuGUI;

    public Cgui(OwnerMenuGUI menuGUI) {
        this.menuGUI = menuGUI;
        setTitle("Customer Options");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        // Panel for the welcome label
        Panel welcomePanel = new Panel();
        welcomePanel.setLayout(new FlowLayout());
        Label welcomeLabel = new Label("Customer Details");
        welcomePanel.add(welcomeLabel);

        // Panel for the buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        Button option1 = new Button("View All Customers");
        Button option2 = new Button("Search for Customer");
        buttonPanel.add(option1);
        buttonPanel.add(option2);

        add(option1);
        add(option2);

        option1.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CustHist hist = new CustHist(Cgui.this);
                    hist.setVisible(true);
                    setVisible(false);
                }
            }
        );

        option2.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CustGUI cust = new CustGUI(Cgui.this);
                    cust.setVisible(true);
                    setVisible(false);
                }
            }
        );

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menuGUI.setVisible(true);
                dispose();
            }
        });
    }

    public OwnerMenuGUI getMenuGUI() {
        return menuGUI;
    }
}

class CustHist extends Frame {
    @SuppressWarnings("unused")
    private final Cgui cgui;
    ArrayList<customer> customerList;

    public CustHist(Cgui cgui) {
        this.cgui = cgui;
        setTitle("Customer Details");
        setSize(500, 300);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        customerList = driverCustomer.exportList();

        Label details = new Label("All Customers");
        details.setFont(new Font("Consolas", Font.BOLD, 15));

        add(details);

        // Create a TextArea to display the list of bikes
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Make it read-only
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        // Populate TextArea with bikes
        StringBuilder sb = new StringBuilder();
        for (customer viewCustomer : customerList) {
            sb.append("\n").append("Customer ID: ").append(viewCustomer.getCID()).append("\n");
            sb.append("First Name: ").append(viewCustomer.getFName()).append("\n");
            sb.append("Last Name: ").append(viewCustomer.getLName()).append("\n");
            sb.append("Address: ").append(viewCustomer.getAddress()).append("\n");
            sb.append("Phone Number: ").append(viewCustomer.getPhone()).append("\n");
        }
        textArea.setText(sb.toString());
        add(textArea, BorderLayout.CENTER);

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cgui.setVisible(true);
                dispose();
            }
        });
    }
}

class CustGUI extends Frame {
    @SuppressWarnings("unused")
    private final Cgui cgui;
    ArrayList<customer> customerList;

    public CustGUI(Cgui cgui) {
        this.cgui = cgui;
        setTitle("Customer Search");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        customerList = driverCustomer.exportList();

        Label phoneLabel = new Label("Phone Number:");
        Label phoneformat = new Label("format: xxx-xxx-xxxx");
        TextField custPhone = new TextField(20);
        Button enter = new Button("Submit");

        enter.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String pnum = custPhone.getText();
                    int custID = driverCustomer.findCustomerByPhone(pnum);
                    customer foundCust = null;

                    for (customer cust : customerList){
                        if (cust.ID == custID){
                            foundCust = cust;
                            break;
                        }
                    }

                    CustPhone phone = new CustPhone(CustGUI.this, foundCust);
                    phone.setVisible(true);

                    if (custID != -1) {
                        phone.setVisible(true);
                    } else {
                        Label searchFound = new Label("No Customer Found");
                        phone.setFont(new Font("Consolas", Font.BOLD, 15));
                        phone.add(searchFound);
                        phone.setVisible(true);
                    }

                    setVisible(false);
                }
            }
        );

        add(phoneLabel);
        add(phoneformat);
        add(custPhone);
        add(enter);

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cgui.setVisible(true);
                dispose();
            }
        });
    }
}

class CustPhone extends Frame {
    @SuppressWarnings("unused")
    private final CustGUI custGUI;

    public CustPhone(CustGUI custGUI, customer foundCust) {
        this.custGUI = custGUI;
        setTitle("Search Results");
        setSize(500, 275);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label headerLabel = new Label("Search Results:");
        headerLabel.setAlignment(Label.CENTER);
        headerLabel.setFont(new Font("Consolas", Font.BOLD, 15));
        add(headerLabel);

        // Create a TextArea to display the list of bikes
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Make it read-only
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        // Populate TextArea with bikes
        StringBuilder sb = new StringBuilder();

        if (foundCust != null){
            sb.append("\n").append("Customer ID: ").append(foundCust.getCID()).append("\n");
            sb.append("First Name: ").append(foundCust.getFName()).append("\n");
            sb.append("Last Name: ").append(foundCust.getLName()).append("\n");
            sb.append("Address: ").append(foundCust.getAddress()).append("\n");
            sb.append("Phone Number: ").append(foundCust.getPhone()).append("\n");

            textArea.setText(sb.toString());
            add(textArea, BorderLayout.CENTER);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                custGUI.setVisible(true);
                dispose();
            }
        });
    }
}

//transactions

class Menutrans extends Frame {
    @SuppressWarnings("unused")
    private OwnerMenuGUI menuGUI;

    public Menutrans(OwnerMenuGUI menuGUI) {
        this.menuGUI = menuGUI;
        setTitle("Transaction Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Button option1 = new Button("View Transactions");
        Button option2 = new Button("New Transaction");
        Button option3 = new Button("Close Old Transaction");
        Button option4 = new Button("Get New Receipt");

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open submenu for new transaction
                viewTrans view = new viewTrans(Menutrans.this);
                view.setVisible(true); 
                //new NewTransactionMenu(Menutrans.this).setVisible(true);
                setVisible(false);
            }
        });

        // Action listener for the "New Transaction" button
        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open submenu for new transaction
                NewTransactionMenu newT = new NewTransactionMenu(Menutrans.this);
                newT.setVisible(true); 
                //new NewTransactionMenu(Menutrans.this).setVisible(true);
                setVisible(false);
            }
        });

        // Action listener for the "Close Transaction" button
        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt for transaction ID
                closeFindTransaction TransID = new closeFindTransaction(Menutrans.this);
                TransID.setVisible(true);
                //new TransactionIDDialog(Menutrans.this).setVisible(true);
                setVisible(false);
            }
        });

        // Action listener for the "receipt" button
        option4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt for transaction ID
                getInitialReceipt receipt = new getInitialReceipt(Menutrans.this);
                receipt.setVisible(true);
                driverTransaction.close();
                //new TransactionIDDialog(Menutrans.this).setVisible(true);
                setVisible(false);
            }
        });

        add(option1);
        add(option2);
        add(option3);
        add(option4);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menuGUI.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

// Inner class for the closeTransaction
class closeFindTransaction extends Frame {
    @SuppressWarnings("unused")
    private Menutrans menutrans;

    public closeFindTransaction(Menutrans menutrans) {
        this.menutrans = menutrans;
        setTitle("Close Transaction");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label = new Label("Input Rented Bike ID:");
        TextField textField = new TextField(10); // text field for transaction number
        Button submitButton = new Button("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bikeID = Integer.parseInt(textField.getText()); 
                bike returnBike = driverBike.searchIDNoArray(bikeID);
        
                closeTransaction closeT = new closeTransaction(menutrans, returnBike);
                
                if (returnBike == null) {
                    Label searchFound = new Label("No Bike Found");
                    closeT.setFont(new Font("Consolas", Font.BOLD, 15));
                    closeT.removeAll();
                    closeT.add(searchFound);
                    closeT.setVisible(true);
                } else if ((returnBike.getstateBike()).equals("Out")) {
                    // Remove all components from the closeTransaction frame
                    closeT.setVisible(true);
                } else {
                    Label searchFound = new Label("Bike is not rented");
                    closeT.setFont(new Font("Consolas", Font.BOLD, 15));
                    closeT.removeAll();
                    closeT.add(searchFound);
                    closeT.setVisible(true);
                }
                dispose();
            }
        });

        add(label);
        add(textField);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

class closeTransaction extends Frame {
    @SuppressWarnings("unused")
    private Menutrans menutrans;
    ArrayList<transaction> allTransaction;
    transaction foundTransaction;

    public closeTransaction(Menutrans menutrans, bike foundBike) {
        this.menutrans = menutrans;
        setTitle("Close Transaction");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        if (foundBike != null){

            allTransaction = driverTransaction.exportList();

            for (transaction i : allTransaction){
                if (((i.getBikeId()) == (foundBike.getID()))&&!(i.getStatus())){
                    foundTransaction = i;
                }
            }

            if (foundTransaction != null){

                Label label1 = new Label("Start Date: "+foundTransaction.getStartDate());
                Label label2 = new Label("End Date: ");
                Label label3 = new Label("format: 01-29-2004");
                TextField endDate = new TextField(10);
                Label label4 = new Label("\n");
                Label label5 = new Label("Number of Days Out: ");
                TextField daysOut = new TextField(10);
                Button submitButton = new Button("Submit");

                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // update transaction
                        int inputDaysOut = Integer.parseInt(daysOut.getText());
                        String inputEndDate = endDate.getText();
                        foundTransaction.setEndDate(inputEndDate);
                        foundTransaction.setDuration(inputDaysOut);
                        foundTransaction.setStatus(true);
                        foundBike.setstateBike("In");

                        // send to final receipt
                        getFinalReceipt receipt = new getFinalReceipt(menutrans, foundTransaction, foundBike);
                        receipt.setVisible(true);
                        //new TransactionIDDialog(Menutrans.this).setVisible(true);
                        dispose();
                    }
                });

                add(label1);
                add(label2);
                add(label3);
                add(label3);
                add(endDate);
                add(label4);
                add(label5);
                add(daysOut);
                add(submitButton);
            }
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

class getFinalReceipt extends Frame{
    @SuppressWarnings("unused")
    private final Menutrans menutrans;
    finalReceipt receipt;

    public getFinalReceipt(Menutrans menutrans, transaction closeTransaction, bike outBike) {
        this.menutrans = menutrans;
        setTitle("Receipt");
        setSize(500, 275);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        receipt = new finalReceipt(closeTransaction, outBike);

        Label viewT = new Label("Receipt");
        viewT.setAlignment(Label.CENTER);
        viewT.setFont(new Font("Consolas", Font.BOLD, 15));
        add(viewT);


        // Create a TextArea to display the list of bikes
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Make it read-only
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        // Populate TextArea with bikes
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ID: ").append(receipt.getCustID()).append("\n");
        sb.append("Bike ID: ").append(closeTransaction.getBikeId()).append("\n");
        sb.append("Rent Date: ").append(closeTransaction.getStartDate()).append("\n");
        sb.append("Return Date: ").append(closeTransaction.getEndDate()).append(" Days\n\n");
        sb.append("Total: ").append(receipt.getTotal()).append("\n");
        textArea.setText(sb.toString());
        add(textArea, BorderLayout.CENTER);

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

    }
}

class getInitialReceipt extends Frame{
    @SuppressWarnings("unused")
    private final Menutrans menutrans;
    ArrayList<transaction> currTransactionList;
    initialReceipt receipt;

    public getInitialReceipt(Menutrans menutrans) {
        this.menutrans = menutrans;
        setTitle("Receipt");
        setSize(500, 275);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        currTransactionList = driverTransaction.exportCurrList();
        receipt = new initialReceipt(currTransactionList);

        Label viewT = new Label("Receipt");
        viewT.setAlignment(Label.CENTER);
        viewT.setFont(new Font("Consolas", Font.BOLD, 15));
        add(viewT);


        // Create a TextArea to display the list of bikes
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Make it read-only
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        // Populate TextArea with bikes
        StringBuilder sb = new StringBuilder();
        sb.append("Customer ID: ").append(receipt.getCustID()).append("\n");
        for (transaction viewTransaction : currTransactionList) {
            sb.append("Bike ID: ").append(viewTransaction.getBikeId()).append("\n");
            sb.append("Start Date: ").append(viewTransaction.getStartDate()).append("\n");
            sb.append("Due in: ").append(viewTransaction.getEstimateDate()).append(" Days\n\n");
        }
        sb.append("Total: ").append(receipt.getTotal()).append("\n");
        textArea.setText(sb.toString());
        add(textArea, BorderLayout.CENTER);

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                driverTransaction.close();
                menutrans.setVisible(true);
                dispose();
            }
        });

    }
}

class viewTrans extends Frame{
    @SuppressWarnings("unused")
    private final Menutrans menutrans;
    ArrayList<transaction> transactionList;

    public viewTrans(Menutrans menutrans) {
        this.menutrans = menutrans;
        setTitle("Transaction History");
        setSize(500, 275);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        transactionList = driverTransaction.exportList();

        Label viewT = new Label("Transaction History");
        viewT.setAlignment(Label.CENTER);
        viewT.setFont(new Font("Consolas", Font.BOLD, 15));
        add(viewT);

        // Create a TextArea to display the list of bikes
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Make it read-only
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        // Populate TextArea with bikes
        StringBuilder sb = new StringBuilder();
        for (transaction viewTransaction : transactionList) {
            sb.append("Transaction ID: ").append(viewTransaction.getTransId()).append("\n");
            sb.append("Customer ID: ").append(viewTransaction.getCustId()).append("\n");
            sb.append("Bike ID: ").append(viewTransaction.getBikeId()).append("\n");
            sb.append("Start Date: ").append(viewTransaction.getStartDate()).append("\n");
            sb.append("End Date: ").append(viewTransaction.getEndDate()).append("\n");
            sb.append("Estimated Days Out: ").append(viewTransaction.getEstimateDate()).append("\n");
            sb.append("Amount Due: ").append(viewTransaction.getAmountDue()).append("\n");
            sb.append("Amount Paid: ").append(viewTransaction.getAmountPaid()).append("\n");
            sb.append("Completed: ").append(viewTransaction.getStatus()).append("\n\n");
        }
        textArea.setText(sb.toString());
        add(textArea, BorderLayout.CENTER);

        // Add window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

    }
}

// Inner class for the submenu of "New Transaction" option
class NewTransactionMenu extends Frame {
    @SuppressWarnings("unused")
    private Menutrans menutrans;

    public NewTransactionMenu(Menutrans menutrans) {
        this.menutrans = menutrans;
        setTitle("New Transaction Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label = new Label("New Transaction");
        Button option1 = new Button("New Customer");
        Button option2 = new Button("Existing Customer");

        add(label);
        add(option1);
        add(option2);

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open submenu for new transaction
                NewCustomer newCust = new NewCustomer(NewTransactionMenu.this);
                newCust.setVisible(true); 
            }
        });

        // Action listener for the "New Transaction" button
        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open submenu for new transaction
                OldCustomer oldCust = new OldCustomer(NewTransactionMenu.this);
                oldCust.setVisible(true); 
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

class addNewTransaction extends Frame {
    @SuppressWarnings("unused")
    private NewTransactionMenu menutrans;

    public addNewTransaction(NewTransactionMenu menutrans, int custID) {
        this.menutrans = menutrans;
        setTitle("Add New Transaction Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label1 = new Label("Bike ID: ");
        TextField bikeID = new TextField(10);
        Label label2 = new Label("Start Date: ");
        Label label3 = new Label("format: 01-29-2004");
        TextField startDate = new TextField(10);
        Label label4 = new Label("\n");
        Label label5 = new Label("Estimated Days Out: ");
        TextField estDays = new TextField(10);
        Button submitButton = new Button("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int intbikeID = Integer.parseInt(bikeID.getText());
                int intestDays = Integer.parseInt(estDays.getText());
                driverTransaction.newTransaction(custID, intbikeID, startDate.getText(), intestDays);
                addMoreTransaction anotherTransaction = new addMoreTransaction(menutrans, custID);
                anotherTransaction.setVisible(true);
                dispose();
            }
        });

        add(label1);
        add(bikeID);
        add(label2);
        add(label3);
        add(startDate);
        add(label4);
        add(label4);
        add(label5);
        add(estDays);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

class addMoreTransaction extends Frame {
    @SuppressWarnings("unused")
    private NewTransactionMenu menutrans;

    public addMoreTransaction(NewTransactionMenu menutrans, int custID) {
        this.menutrans = menutrans;
        setTitle("Add Another Transaction Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label1 = new Label("Add Another Transaction?");
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addNewTransaction newTransaction = new addNewTransaction(menutrans, custID);
                newTransaction.setVisible(true); 
                //new NewTransactionMenu(Menutrans.this).setVisible(true);
                setVisible(false);
            }
        });

        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new TransactionIDDialog(Menutrans.this).setVisible(true);
                setVisible(false);
                menutrans.setVisible(true);
                dispose();
            }
        });

        add(label1);
        add(yesButton);
        add(noButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

//new customer
class NewCustomer extends Frame {
    @SuppressWarnings("unused")
    private NewTransactionMenu newTransMenu;

    public NewCustomer(NewTransactionMenu menutrans) {
        this.newTransMenu = menutrans;
        setTitle("New Customer Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label1 = new Label("Customer First Name: ");
        TextField firstName = new TextField(10);
        Label label2 = new Label("Customer Last Name: ");
        TextField lastName = new TextField(10);
        Label label3 = new Label("Customer Address: ");
        TextField address = new TextField(10);
        Label label4 = new Label("Customer Phone Number: ");
        Label label5 = new Label("format: xxx-xxx-xxxx");
        TextField phoneNumber = new TextField(10);
        Button submitButton = new Button("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open submenu for new transaction
                driverCustomer.createNewCustomer(firstName.getText(), lastName.getText(), address.getText(), phoneNumber.getText());
                driverCustomer.close();
                addNewTransaction newTransaction = new addNewTransaction(menutrans, driverCustomer.findCustomerByPhone(phoneNumber.getText()));
                newTransaction.setVisible(true); 
                //new NewTransactionMenu(Menutrans.this).setVisible(true);
                setVisible(false);
            }
        });
        
        add(label1);
        add(firstName);
        add(label2);
        add(lastName);
        add(label3);
        add(address);
        add(label4);
        add(phoneNumber);
        add(label5);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

class OldCustomer extends Frame {
    @SuppressWarnings("unused")
    private NewTransactionMenu newTransMenu;
    ArrayList<customer> customerList;

    public OldCustomer(NewTransactionMenu menutrans) {
        this.newTransMenu = menutrans;
        setTitle("Old Customer Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        customerList = driverCustomer.exportList();

        Label label1 = new Label("Enter Customer Phone Number: ");
        TextField phoneNumber = new TextField(10);
        Button submitButton = new Button("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int foundCustID = driverCustomer.findCustomerByPhone(phoneNumber.getText());
                System.out.println(""+phoneNumber.getText());
                // Open submenu for new transaction
                if (foundCustID != -1){
                    addNewTransaction newTransaction = new addNewTransaction(menutrans, foundCustID);
                    newTransaction.setVisible(true); 
                    //new NewTransactionMenu(Menutrans.this).setVisible(true);
                    setVisible(false);
                } else {
                    menutrans.setVisible(true);
                    dispose();
                }
            }
        });
        
        add(label1);
        add(phoneNumber);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                menutrans.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

class BikeGUI extends Frame {
    @SuppressWarnings("unused")
    private OwnerMenuGUI ownerMenuGUI;
    @SuppressWarnings("unused")
    private MechanicMenuGUI mechanicMenuGUI;

    public BikeGUI(OwnerMenuGUI ownerMenuGUI) {
        this.ownerMenuGUI = ownerMenuGUI;
        this.mechanicMenuGUI = null;
        setTitle("Bikes Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Button option1 = new Button("View Bikes");
        Button option2 = new Button("Updates Bikes");

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Viewbikes bike = new Viewbikes(BikeGUI.this);
                bike.setVisible(true);
                //new Viewbikes(BikeGUI.this).setVisible(true);
                setVisible(false);
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startUpdatebikes update = new startUpdatebikes(BikeGUI.this);
                update.setVisible(true);
                //new Updatebikes(BikeGUI.this).setVisible(true);
                setVisible(false);
            }
        });
        add(option1);
        add(option2);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                ownerMenuGUI.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }

    public BikeGUI(MechanicMenuGUI mechanicMenuGUI) {
        this.mechanicMenuGUI = mechanicMenuGUI;
        setTitle("Bikes Menu");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Button option1 = new Button("View Bikes");
        Button option2 = new Button("Updates Bikes");

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Viewbikes bike = new Viewbikes(BikeGUI.this);
                bike.setVisible(true);
                //new Viewbikes(BikeGUI.this).setVisible(true);
                setVisible(false);
            }
        });

        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startUpdatebikes update = new startUpdatebikes(BikeGUI.this);
                update.setVisible(true);
                //new Updatebikes(BikeGUI.this).setVisible(true);
                setVisible(false);
            }
        });
        add(option1);
        add(option2);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mechanicMenuGUI.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }
}

class Viewbikes extends Frame {
    @SuppressWarnings("unused")
    private final BikeGUI bikeGUI;

    public Viewbikes(BikeGUI bikeGUI) {
        this.bikeGUI = bikeGUI;
        setTitle("View Bikes");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label = new Label("View Bikes");
        Button option1 = new Button("All bikes");
        Button option2 = new Button("Search By ID");

        add(label);
        add(option1);
        add(option2);

        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Allbikes all = new Allbikes(bikeGUI);
                all.setVisible(true);
                //new Viewbikes(BikeGUI.this).setVisible(true);
                setVisible(false);
            }
        });


        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchID search = new SearchID(bikeGUI);
                search.setVisible(true);
                //new Updatebikes(BikeGUI.this).setVisible(true);
                setVisible(false);
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bikeGUI.setVisible(true);
                dispose();
            }
        });

        //setVisible(true);
    }
}

class Allbikes extends Frame {
    @SuppressWarnings("unused")
    private final BikeGUI bikeGUI;
    private ArrayList<bike> bikeList;

    public Allbikes(BikeGUI bikeGUI) {
        this.bikeGUI = bikeGUI;
        setTitle("All Bikes");
        setSize(500, 300);
        setLayout(new BorderLayout());

        setLocationRelativeTo(null);

        // Retrieve the bike list from driverBike
        bikeList = driverBike.exportList();

        Label details = new Label("All Bikes");
        details.setFont(new Font("Consolas", Font.BOLD, 15));

        add(details, BorderLayout.NORTH);

        // Create a TextArea to display the list of bikes
        TextArea textArea = new TextArea();
        textArea.setEditable(false); // Make it read-only
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        // Populate TextArea with bikes
        StringBuilder sb = new StringBuilder();
        for (bike viewBike : bikeList) {
            sb.append("ID: ").append(viewBike.getID()).append("\n");
            sb.append("Type: ").append(viewBike.gettype()).append("\n");
            sb.append("Size: ").append(viewBike.getsize()).append("\n");
            sb.append("Make: ").append(viewBike.getmake()).append("\n");
            sb.append("Model: ").append(viewBike.getmodel()).append("\n");
            sb.append("Rate: ").append(viewBike.getrate()).append("\n");
            sb.append("Deposit: ").append(viewBike.getdeposit()).append("\n");
            sb.append("State of Bike: ").append(viewBike.getstateBike()).append("\n");
            sb.append("Notes: ").append(viewBike.getnotes()).append("\n\n");
        }
        textArea.setText(sb.toString());
        add(textArea, BorderLayout.CENTER);

        // Add window listener to show BikeGUI when closing Allbikes
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bikeGUI.setVisible(true);
                dispose();
            }
        });

        // Make the frame visible
        setVisible(true);
    }
}

class SearchID extends Frame {
    @SuppressWarnings("unused")
    private final BikeGUI bikeGUI;
    private ArrayList<bike> bikeList;

    public SearchID(BikeGUI bikeGUI){
        this.bikeGUI = bikeGUI;
        setTitle("Search Bikes");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label = new Label("Bike ID");
        TextField textField = new TextField(10);
        Button submitButton = new Button("Submit");

        // Retrieve the bike list from driverBike
        bikeList = driverBike.exportList();


        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bikeId = textField.getText();
                bike foundBike = driverBike.searchID(Integer.parseInt(bikeId), bikeList);

                if(foundBike != null){
                    IDfound found = new IDfound(bikeGUI, foundBike);
                    found.setVisible(true);
                }else{
                    IDfound found = new IDfound(bikeGUI, null);
                    found.setVisible(true);

                    Label searchFound = new Label("No Bike Found");
                    searchFound.setFont(new Font("Consolas", Font.BOLD, 15));
                    found.add(searchFound);
                    found.setVisible(true);
                }
                setVisible(false);
                
            }
        });

        add(label);
        add(textField);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bikeGUI.setVisible(true);
                dispose();
            }
        });
    }
}

class IDfound extends Frame{
    @SuppressWarnings("unused")
    private final BikeGUI bikeGUI;

    public IDfound(BikeGUI bikeGUI, bike foundBike){
        this.bikeGUI = bikeGUI;
        setTitle("ID found");
        setSize(500, 275);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label headerLabel = new Label("Search Results:");
        headerLabel.setAlignment(Label.CENTER);
        headerLabel.setFont(new Font("Consolas", Font.BOLD,15));
        add(headerLabel);

        if (foundBike != null){
            // Create a TextArea to display the list of bikes
            TextArea textArea = new TextArea();
            textArea.setEditable(false); // Make it read-only
            textArea.setFont(new Font("Arial", Font.PLAIN, 12));

            // Populate TextArea with bikes
            StringBuilder sb = new StringBuilder();
            sb.append("ID: ").append(foundBike.getID()).append("\n");
            sb.append("Type: ").append(foundBike.gettype()).append("\n");
            sb.append("Size: ").append(foundBike.getsize()).append("\n");
            sb.append("Make: ").append(foundBike.getmake()).append("\n");
            sb.append("Model: ").append(foundBike.getmodel()).append("\n");
            sb.append("Rate: ").append(foundBike.getrate()).append("\n");
            sb.append("Deposit: ").append(foundBike.getdeposit()).append("\n");
            sb.append("State of Bike: ").append(foundBike.getstateBike()).append("\n");
            sb.append("Notes: ").append(foundBike.getnotes()).append("\n\n");
            textArea.setText(sb.toString());
            add(textArea, BorderLayout.CENTER);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bikeGUI.setVisible(true);
                dispose();
            }
        });
    }
}

class startUpdatebikes extends Frame {
    @SuppressWarnings("unused")
    private final BikeGUI bikeGUI;

    public startUpdatebikes(BikeGUI bikeGUI) {
        this.bikeGUI = bikeGUI;
        setTitle("Updates Bikes");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        Label label = new Label("Enter Bike ID");
        TextField textField = new TextField(10);
        Button submitButton = new Button("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int bikeId = Integer.parseInt(textField.getText());
                Updatebikes update = new Updatebikes(bikeGUI, bikeId);
                update.setVisible(true);
                dispose();
            }
        });
        add(label);
        add(textField);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bikeGUI.setVisible(true);
                dispose();
            }
        });

        //setVisible(true);
    }
}

class Updatebikes extends Frame {
    @SuppressWarnings("unused")
    private final BikeGUI bikeGUI;

    public Updatebikes(BikeGUI bikeGUI, int ID) {
        this.bikeGUI = bikeGUI;
        setTitle("Updates Bikes");
        setSize(300, 200);
        setLayout(new FlowLayout());

        setLocationRelativeTo(null);

        bike updatingBike = driverBike.searchIDNoArray(ID);

        Label label = new Label("Update Old Info:");
        Label label2 = new Label("\n");
        TextField rate = new TextField(10);
        rate.setText(""+updatingBike.getrate());
        Label label3 = new Label("\n");
        TextField deposit = new TextField(10);
        deposit.setText(""+updatingBike.getdeposit());
        Label label4 = new Label("\n");
        TextField state = new TextField(10);
        state.setText(""+updatingBike.getstateBike());
        Label label5 = new Label("\n");
        TextField notes = new TextField(10);
        notes.setText(""+updatingBike.getnotes());
        Button submitButton = new Button("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                float newrate = Float.parseFloat(rate.getText());
                float newdeposit = Float.parseFloat(deposit.getText());
                String newstate = state.getText();
                String newnotes = notes.getText();

                updatingBike.setrate(newrate);
                updatingBike.setdeposit(newdeposit);
                updatingBike.setstateBike(newstate);
                updatingBike.setnotes(newnotes);
                driverBike.close();
                
                bikeGUI.setVisible(true);
                dispose();
            }
        });
        add(label);
        add(label2);
        add(rate);
        add(label3);
        add(deposit);
        add(label4);
        add(state);
        add(label5);
        add(notes);
        add(submitButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                bikeGUI.setVisible(true);
                dispose();
            }
        });

        //setVisible(true);
    }
}