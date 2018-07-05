package Tron.Tron;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;



public class Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Color color1 = new Color(2373693);
	public static final Color color2 = new Color(3632844);
	public static final Color color3 = new Color(13842231);
	public static final Color color4 = new Color(8158332);
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Lightcycle lightcycle = Lightcycle.lightcycle;
		
		
		

		g.setColor(color1);
		
		g.fillRect(0, 0, 817, 710);
		

		g.setColor(color2);

		for (Point point : lightcycle.wall)
		{
			g.fillRect(point.x * Lightcycle.SCALE, point.y * Lightcycle.SCALE, Lightcycle.SCALE, Lightcycle.SCALE);
		}	
		g.setColor(color4);
		g.fillRect(lightcycle.head.x * Lightcycle.SCALE, lightcycle.head.y * Lightcycle.SCALE, Lightcycle.SCALE, Lightcycle.SCALE);
		
		
		
      
		g.setColor(color3);

		for (Point point : lightcycle.wall2)
		{
			g.fillRect(point.x * Lightcycle.SCALE, point.y * Lightcycle.SCALE, Lightcycle.SCALE, Lightcycle.SCALE);
		}	
		g.setColor(color4);
		g.fillRect(lightcycle.head2.x * Lightcycle.SCALE, lightcycle.head2.y * Lightcycle.SCALE, Lightcycle.SCALE, Lightcycle.SCALE);
		
		
		
		g.setColor(Color.white);
		String string = "Time: " + lightcycle.time / 20;
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);
		
	

		string = "RED WIN !!!";

		if (lightcycle.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) lightcycle.dim.getHeight() / 4);
		}
		
		string = "BLUE WIN !!!";

		if (lightcycle.over2)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) lightcycle.dim.getHeight() / 4);
		}
		
		
		
		
		

		string = "Pause !";

		if (lightcycle.pause && !lightcycle.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) lightcycle.dim.getHeight() / 4);
		}
	}
}