package gui.model;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Canvas;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ContactManager extends JFrame {

	private static Contact contacts[] = new Contact[100];
	private static int countIndexContacts=6;

	static {
		contacts[0] = new Contact(1, "Alex", "Ivanov", "+375336789854");
		contacts[1] = new Contact(2, "Ivan", "klklkj", "+375336789854");
		contacts[2] = new Contact(3, "Egor", "Shugar", "+375336789054");
		contacts[3] = new Contact(4, "Sergey", "Sol", "+375296711854");
		contacts[4] = new Contact(6, "Inna", "Ivanov", "+375255789854");
		contacts[5] = new Contact(7, "Rimma", "Sidorova", "+375326744454");
		

	}
	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField phoneTextField;
	private static int currentPosition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactManager frame = new ContactManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public ContactManager() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Nick\\eclipse-workspace\\gui\\src\\gui\\model\\png\\squirrel_PNG96436.png"));
		setTitle("MyPhoneContact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton prevButton = new JButton("<");
		prevButton.setBackground(Color.GREEN);

		prevButton.setBounds(28, 469, 89, 23);
		contentPane.add(prevButton);

		JButton nextButton = new JButton(">");
		nextButton.setBackground(Color.GREEN);
		nextButton.setVerticalAlignment(SwingConstants.TOP);
		nextButton.setBounds(127, 469, 89, 23);
		contentPane.add(nextButton);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.RED);
		btnUpdate.setVerticalAlignment(SwingConstants.TOP);

		btnUpdate.setBounds(226, 469, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelite = new JButton("DELITE");
		btnDelite.setBackground(Color.CYAN);
		btnDelite.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDelite.setBounds(320, 469, 89, 23);
		contentPane.add(btnDelite);

		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBackground(Color.MAGENTA);
		btnCreate.setVerticalAlignment(SwingConstants.BOTTOM);

		btnCreate.setBounds(416, 469, 89, 23);
		contentPane.add(btnCreate);

		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(66, 29, 75, 14);
		contentPane.add(idLabel);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 516, 672);
		contentPane.add(contentPane_1);

		JButton prevButton_1 = new JButton("<");
		prevButton_1.setBounds(28, 469, 89, 23);
		contentPane_1.add(prevButton_1);

		JButton nextButton_1_1 = new JButton(">");
		nextButton_1_1.setBounds(127, 469, 89, 23);
		contentPane_1.add(nextButton_1_1);

		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.setBounds(226, 469, 89, 23);
		contentPane_1.add(btnUpdate_1);

		JButton btnDelite_1 = new JButton("DELITE");
		btnDelite_1.setBounds(320, 469, 89, 23);
		contentPane_1.add(btnDelite_1);

		JButton btnCreate_1 = new JButton("CREATE");
		btnCreate_1.setBounds(416, 469, 89, 23);
		contentPane_1.add(btnCreate_1);

		JLabel idLabel_1 = new JLabel("ID");
		idLabel_1.setBounds(66, 29, 75, 14);
		contentPane_1.add(idLabel_1);

		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(66, 86, 75, 14);
		contentPane_1.add(lblName);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(139, 83, 114, 20);
		contentPane_1.add(nameTextField);

		JLabel lblSurname = new JLabel("SURNAME");
		lblSurname.setBounds(66, 138, 75, 14);
		contentPane_1.add(lblSurname);

		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(139, 135, 114, 20);
		contentPane_1.add(surnameTextField);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(66, 188, 75, 14);
		contentPane_1.add(lblPhone);

		phoneTextField = new JTextField();
		phoneTextField.setToolTipText("");
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(139, 185, 114, 20);
		contentPane_1.add(phoneTextField);
		
				idTextField = new JTextField();
				idTextField.setBounds(139, 26, 114, 20);
				contentPane_1.add(idTextField);
				idTextField.setColumns(10);

		ButtonGroup bg = new ButtonGroup();//
		bg.add(nextButton);
		bg.add(prevButton);

		Contact contact = contacts[currentPosition];
		if (contact != null) {
			idTextField.setText(contacts[currentPosition].getId() + "");
			nameTextField.setText(contacts[currentPosition].getName());
			surnameTextField.setText(contacts[currentPosition].getSurname());
			phoneTextField.setText(contacts[currentPosition].getPhone());
		} else {

			nextButton.setEnabled(false);

		}

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(countIndexContacts<100) {
				String id=idTextField.getText();
				Integer idInt=Integer.parseInt(id);
				String name = nameTextField.getText();
				String surname = surnameTextField.getText();
				String phone = phoneTextField.getText();
				contacts[countIndexContacts] = new Contact(idInt, name, surname, phone);
				countIndexContacts++;
			}else{
				System.out.println("Telephon directory is full!");}
			}
		});

		btnDelite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contact delite = new Contact();
				delite.setId(0);
				delite.setName("");
				delite.setSurname("");
				delite.setPhone("");
				contacts[currentPosition] = delite;
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Contact updatedContact = new Contact();
				updatedContact.setId(Integer.parseInt(idTextField.getText()));
				updatedContact.setName(nameTextField.getText());
				updatedContact.setSurname(surnameTextField.getText());
				updatedContact.setPhone(phoneTextField.getText());

				contacts[currentPosition] = updatedContact;
			}
		});

		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contact != null && currentPosition < 100) {
					currentPosition++;
					loadContact();
					prevButton.setEnabled(true);
				} else {
					nextButton.setEnabled(false);
				}
			}
		});

		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPosition > 0) {
					currentPosition--;
					loadContact();
					nextButton.setEnabled(true);
				} else {
					prevButton.setEnabled(false);
				}
			}
		});

	}

	private boolean loadContact() {
		Contact contact = contacts[currentPosition];
		if (contact != null) {
			idTextField.setText(contacts[currentPosition].getId() + "");
			nameTextField.setText(contacts[currentPosition].getName());
			surnameTextField.setText(contacts[currentPosition].getSurname());
			phoneTextField.setText(contacts[currentPosition].getPhone());
			return true;
		} else {
			return false;

		}
	}
}
