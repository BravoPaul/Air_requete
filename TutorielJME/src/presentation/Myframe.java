package presentation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.security.Provider.Service;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import tutoriel.EarthTest;

import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;
import com.sun.java.swing.plaf.windows.resources.windows;

import data.Test;

public class Myframe extends JFrame implements MouseListener,ActionListener,ItemListener{

  
	private JPanel panel1;
	private JPanel panel2;
	private JMenuBar menubar;
	private JMenu objectsMenu;
	private JMenu helpMenu;

	private JMenuItem createObjectItem;
	private JMenuItem deleteObjectItem;
	private JMenuItem getControlsItem;
	
	private JButton selectbutton;
	private JButton earthbutton;
	private JComboBox<String>[] testFields;
	private JList<String> list;
	private JScrollPane listScroller;

	
	public Myframe() {
		
		super("My Air");
		initialframe();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@SuppressWarnings({ "null", "unchecked" })
	public void initialframe() {
		
		menubar = new JMenuBar();
		objectsMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		createObjectItem = new JMenuItem("new");
		deleteObjectItem = new JMenuItem("save");
		getControlsItem = new JMenuItem("quit");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		
		objectsMenu.add(createObjectItem);
		objectsMenu.add(deleteObjectItem);
		helpMenu.add(getControlsItem);
		menubar.add(objectsMenu);
		menubar.add(helpMenu);
		this.setJMenuBar(menubar);
		this.setLayout(new BorderLayout());
	
		
		this.add(panel1,BorderLayout.PAGE_START);
		this.add(panel2,BorderLayout.PAGE_END);
		
		panel1.setPreferredSize(new Dimension(800, 200));
		panel2.setPreferredSize(new Dimension(800, 300));
		//panel1.add(panel12);
		
		
		panel1.setLayout(null);
		testFields = new JComboBox[7];
		for (int i = 0; i < 7; i++) {
			testFields[i] = new JComboBox<String>();
			testFields[i].setEditable(true);
			testFields[i].addActionListener(this);
			testFields[i].addItemListener(this);
			testFields[i].setPreferredSize(new Dimension(80, 30));
		}
		
		JLabel Jlabel1 = new JLabel("From:"); 
		Jlabel1.setBounds(10, 10, 100, 30);
		panel1.add(Jlabel1);
		
		JLabel Jlabel2 = new JLabel("Country:"); 
		Jlabel2.setBounds(120, 10, 50, 30);
		panel1.add(Jlabel2);
		
		testFields[0].setBounds(180, 10, 130, 30);
		panel1.add(testFields[0]);
		
		
		JLabel Jlabel3 = new JLabel("City:"); 
		Jlabel3.setBounds(320, 10, 50, 30);
		panel1.add(Jlabel3);	
		testFields[1].setBounds(380, 10, 130, 30);
		panel1.add(testFields[1]);
		
		JLabel Jlabel4 = new JLabel("AirPort:"); 
		Jlabel4.setBounds(520, 10, 50, 30);
		panel1.add(Jlabel4);
		
		testFields[2].setBounds(580, 10, 130, 30);
		panel1.add(testFields[2]);
		
		JLabel Jlabel5 = new JLabel("To:"); 
		Jlabel5.setBounds(10, 70, 100, 30);
		panel1.add(Jlabel5);
		
		JLabel Jlabel6 = new JLabel("Country:"); 
		Jlabel6.setBounds(120, 70, 50, 30);
		panel1.add(Jlabel6);
		
		testFields[3].setBounds(180, 70, 130, 30);
		panel1.add(testFields[3]);
		
		
		JLabel Jlabel7 = new JLabel("City:"); 
		Jlabel7.setBounds(320, 70, 50, 30);
		panel1.add(Jlabel7);	
		testFields[4].setBounds(380, 70, 130, 30);
		panel1.add(testFields[4]);
		
		JLabel Jlabel8 = new JLabel("AirPort:"); 
		Jlabel8.setBounds(520, 70, 50, 30);
		panel1.add(Jlabel8);
		testFields[5].setBounds(580, 70, 130, 30);
		panel1.add(testFields[5]);
		
		JLabel Jlabel9 = new JLabel("AirLine:"); 
		Jlabel9.setBounds(120, 130, 50, 30);
		panel1.add(Jlabel9);
		testFields[6].setBounds(180, 130, 130, 30);
		panel1.add(testFields[6]);
		
		earthbutton = new JButton("Show in 3D");
		earthbutton.setBounds(380, 130, 130, 30);
		panel1.add(earthbutton);
		
		selectbutton = new JButton("Search Flight");
		selectbutton.setBounds(580, 130, 130, 30);
		panel1.add(selectbutton);
		
		
		
		
		list = new JList<String>(); //data has type Object[]
		//list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		listScroller = new JScrollPane(list);
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JScrollBar jScrollBar = listScroller.getVerticalScrollBar();
		jScrollBar.setValue(80);
		
		jScrollBar.setVisible(true);
		
		
		panel2.setLayout(null);
		//list.setBounds(10, 0, 730, 280);
		listScroller.setBounds(10, 0, 730, 280);
		
		//panel2.add(list);
		panel2.add(listScroller);
		
		selectbutton.addMouseListener(this);
		earthbutton.addMouseListener(this);
		
		this.pack();
		this.setSize(new Dimension(800, 600));
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {	
		Test test = new Test();
		
		try {
			
			test.initialAirLine();
			test.initialAirPort();
			test.initialRoute();
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		//Collections.sort(test.airports);
		test.initialcontry();
		
		
		System.out.println(Test.cities.size());
		Myframe myframe = new Myframe();
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		if (e.getSource()==selectbutton) {
			
			String []str = null;
			
			ArrayList<String> arrayList = null;
			String scountry;
			String scity;
			String sairport;
			String dcountry;
			String dcity;
			String dairport;
			String airline;
					
			scountry = (String)testFields[0].getSelectedItem();
			scity = (String)testFields[1].getSelectedItem();
			sairport = (String)testFields[2].getSelectedItem();
			dcountry = (String)testFields[3].getSelectedItem();
			dcity = (String)testFields[4].getSelectedItem();
			dairport = (String)testFields[5].getSelectedItem();
			airline = (String)testFields[6].getSelectedItem();
		
			arrayList = MyService.getroute(scountry, scity, sairport, dcountry, dcity, dairport, airline);
			
			
			str = arrayList.toArray(new String[arrayList.size()]);
			list.setListData(str);
			
			//System.out.println(str.length);
			listScroller.revalidate();
		}
		if (e.getSource()==earthbutton) {
			
			TroisD troisD = new TroisD();
	    	troisD.simpleInitApp();
		}
			
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==testFields[0]) {
			System.out.println("xuanle");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		JComboBox<String> cb = (JComboBox)e.getSource();
		ArrayList<String> selectArrayList = null;
		
		if (cb==testFields[0]||cb==testFields[3]) {
			
			selectArrayList =  MyService.getcoutrybyname((String)cb.getEditor().getItem());
		}
		if (cb==testFields[1]||cb==testFields[4]) {
	
			selectArrayList =  MyService.getcitybyname((String)testFields[0].getEditor().getItem(),((String)cb.getEditor().getItem()));
		}
		
		if (cb==testFields[2]||cb==testFields[5]) {
			
			selectArrayList =  MyService.getportbyname((String)cb.getEditor().getItem());
		}
		
		if (selectArrayList!=null) {

			for (int i = 0; i < selectArrayList.size(); i++) {
				System.out.println(selectArrayList.get(i));
				cb.addItem(selectArrayList.get(i));
			}
		}
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==testFields[2]) {
			String string =  MyService.getcitybyairport(testFields[2].getSelectedItem().toString());
			testFields[1].setSelectedItem(string);
			String string2 =  MyService.getcoutrybyairport(testFields[2].getSelectedItem().toString());
			testFields[0].setSelectedItem(string2);
		}
		if (e.getSource()==testFields[5]) {
			String string =  MyService.getcitybyairport(testFields[5].getSelectedItem().toString());
			testFields[4].setSelectedItem(string);
			String string2 =  MyService.getcoutrybyairport(testFields[5].getSelectedItem().toString());
			testFields[3].setSelectedItem(string2);
		}
	}

}
