package cuoiki;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import javax.swing.*;

import ontap.hinhtron;


public class giaodien extends JFrame {
	private JPanel panel;
	private JLabel label;
	private JTextField t1,t2,t3;
	private JButton button;
	private hinhvuong hinhvuong;
	private DefaultListModel listModel;
	private JList list;
	private JScrollPane scrollPane;
	private danhsach ds;
	public  giaodien() {
		ds = new danhsach();
		setTitle("Danh sach hinh vuong");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		setVisible(true);
	}
	public void buildPanel() {
		panel = new JPanel();
		Box b1 = new Box(BoxLayout.Y_AXIS);
		Box b2 = new Box(BoxLayout.Y_AXIS);
		
		label = new JLabel("Ten: ");
		b1.add(label);
		label = new JLabel("Mau sac: ");
		b1.add(label);
		label = new JLabel("Do dai canh: ");
		b1.add(label);
		panel.add(b1);
		
		t1 = new JTextField(30);
		b2.add(t1);
		t2 = new JTextField(30);
		b2.add(t2);
		t3 = new JTextField(30);
		b2.add(t3);
		panel.add(b2);
		
		button = new JButton("Nhap ");
		button.addActionListener(new Them());
		panel.add(button);
		button = new JButton("Xoa ");
		button.addActionListener(new Xoa());
		panel.add(button);
		button = new JButton("Loc ");
		button.addActionListener(new Loc());
		panel.add(button);
		
		listModel = new DefaultListModel<hinhvuong>();
		list = new JList<hinhvuong>(listModel);
		list.setBorder(BorderFactory.createTitledBorder("Danh sach hinh vuong "));
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(350, 150));
		panel.add(scrollPane);
		
		add(panel);
	}public class Them implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			hinhvuong = new hinhvuong();
			try {
				
				hinhvuong.setTen(t1.getText());
				hinhvuong.setMausac(t2.getText());
				hinhvuong.setDodaicanh(Double.parseDouble(t3.getText()));
				hinhvuong.setDientich(Double.parseDouble(t3.getText()));
				ds.add(hinhvuong);
				listModel.addElement(hinhvuong.toString());
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(rootPane, "Loi doc du lieu "+e2);
			}
		}
		
	}
	
	
	public class Xoa implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if (listModel.size()==0) {
					JOptionPane.showMessageDialog(rootPane, "Ban chua nhap du lieu");
				}
				else {
					String ten = JOptionPane.showInputDialog("Nhap vao ten hinh muon xoa");
					for (int i = 0; i < listModel.size(); i++) {
						String a = ds.get(i).getTen();
						if (a.equals(ten)) {
							ds.xoa(a);
							listModel.remove(i);
							JOptionPane.showMessageDialog(rootPane, "Da xoa hinh vua nhap");
						}
						else 
							JOptionPane.showMessageDialog(rootPane, "Khong co hinh muon xoa");
						
					}
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(rootPane, "Loi doc du lieu "+e2);
			}
		}
		
	}public class Loc implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				File file = new File("dscachinh.txt");
				FileWriter fWriter = new FileWriter(file);
				fWriter.write("Danh sach hinh vuong co dien tich lon hon 100cm2 la: \n");
				for (int i = 0; i < listModel.size(); i++) {
					if (ds.get(i).getDientich()>100) {
						fWriter.write(ds.get(i).toString()+"\n");
					}
				}
				fWriter.close();
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(rootPane, "Loi doc du lieu "+e2);
			}
		}
	}
	
	
	public static void main (String []args) {
		new giaodien();
	}
}
