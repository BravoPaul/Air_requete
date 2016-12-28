package presentation;

import com.jme3.app.SimpleApplication;
import com.jme3.input.ChaseCamera;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import tutoriel.EarthTest;

public class TroisD extends SimpleApplication{
	
	// TODO : Add here a static variable which will make possible 
	// to store a link to your JMonkeyEngine application 
	//private static CubesTest canvasApplication;
	private static EarthTest earthTest;
    private static Canvas canvas; // JAVA Swing Canvas
    private static Geometry geom;
	private static JFrame frame;
	private static JPanel panel;
	
	private static final float TEXTURE_LAT_OFFSET = -0.2f;
	private static final float TEXTURE_LON_OFFSET = 2.8f;
    
	public static void createNewJFrame() {

		frame = new JFrame("Java - Graphique - IHM");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.addWindowListener(new WindowAdapter(){
	        @Override
	        public void windowClosed(WindowEvent e) {
	        	// TODO : Uncomment this in order to stop the application
	        	// when the windows will be closed.
	        	 //canvasApplication.stop();
	        }
	    });
		
		panel = new JPanel(new BorderLayout());

		// Create the menus
		final JMenuBar menubar = new JMenuBar();
		final JMenu objectsMenu = new JMenu("File");
		final JMenu helpMenu = new JMenu("Help");

		final JMenuItem createObjectItem = new JMenuItem("Create an object");
		final JMenuItem deleteObjectItem = new JMenuItem("Delete an object");
		final JMenuItem getControlsItem = new JMenuItem("Get controls");

		objectsMenu.add(createObjectItem);
		objectsMenu.add(deleteObjectItem);
		helpMenu.add(getControlsItem);
		menubar.add(objectsMenu);
		menubar.add(helpMenu);
		frame.setJMenuBar(menubar);

		getControlsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFrame dial = new JFrame("Controls");
				final JPanel pane = new JPanel();
				pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

				JTextArea cautionText = new JTextArea(
						"Add some text here to describe the controls \n" + '\n');
				cautionText.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
				cautionText.setEditable(false);
				pane.add(cautionText);

				JButton okButton = new JButton("Ok");
				okButton.setSize(50, okButton.getHeight());
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dial.dispose();
					}
				});

				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
				buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
				buttonPane.add(Box.createHorizontalGlue());
				buttonPane.add(okButton);

				pane.add(buttonPane);
				pane.add(Box.createRigidArea(new Dimension(0, 5)));
				dial.add(pane);
				dial.pack();
				dial.setLocationRelativeTo(frame);
				dial.setVisible(true);
			}
		});
		
		panel.add(new JButton("Swing Components"), BorderLayout.WEST);
		
		// Add the canvas to the panel
        panel.add(canvas, BorderLayout.CENTER);
        
        frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Fix an alignment bug on Mac OS X:
        // re-add the canvas and resize the JFrame
        /*try { Thread.sleep(2000);} catch (InterruptedException ex) {}
        panel.add(canvas, BorderLayout.CENTER);
        try { Thread.sleep(1000);} catch (InterruptedException ex) {}
        frame.setSize(frame.getWidth()+1, frame.getHeight());
        frame.setSize(frame.getWidth()-1, frame.getHeight());*/
	}

    public static void main(String[] args){
        // create new JME appsettings
    	TroisD troisD = new TroisD();
    	troisD.simpleInitApp();;
    
		
    }

	@Override
	public void simpleInitApp() {
		
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1920, 1080);
		settings.setSamples(8);
		
		EarthTest earthTest = new EarthTest();
		
		
        earthTest.createCanvas();
        

        JmeCanvasContext ctx = (JmeCanvasContext) earthTest.getContext();
        canvas = ctx.getCanvas();
        Dimension dim = new Dimension(settings.getWidth(), settings.getHeight());
        canvas.setPreferredSize(dim);

        createNewJFrame();
	}

}