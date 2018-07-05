package Tron.Tron;



import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * @author Jaryt Bustard
 */
public class Lightcycle  implements ActionListener, KeyListener
{

	public static Lightcycle lightcycle;
	

	public JFrame jframe;

	public Panel Panel;

	public Timer timer = new Timer(20, this);

	public ArrayList<Point> wall = new ArrayList<Point>();
	public ArrayList<Point> wall2 = new ArrayList<Point>();

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;

	public int ticks = 0, direction = DOWN, direction2 = UP, time;

	public Point head, head2;

	public boolean over = false, over2 = false, pause;

	public Dimension dim;

	public Lightcycle()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("TRON");
		jframe.setVisible(true);
		jframe.setSize(817, 710);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(Panel = new Panel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		startGame();
	}

	public void startGame()
	{
		over = false;
		over2=false;
		pause = false;
		time = 0;		
		ticks = 0;
		direction = DOWN;
		direction2 = UP;
		head = new Point(0, -1);
		head2 = new Point(79,66 );
		wall.clear();
		wall2.clear();
		timer.start();
	}

	public void actionPerformed(ActionEvent arg0)
	{
		Panel.repaint();
		ticks++;

		if (ticks % 2 == 0 && head != null && !over && !pause)
		{
			time++;

			wall.add(new Point(head.x, head.y));

			if (direction == UP)
			{
				if (head.y - 1 >= 0 && CheckCollision(head.x, head.y - 1))
				{
					head = new Point(head.x, head.y - 1);
				}
				else
				{
					over = true;

				}
			}

			if (direction == DOWN)
			{
				if (head.y + 1 < 67 && CheckCollision(head.x, head.y + 1))
				{
					head = new Point(head.x, head.y + 1);
				}
				else
				{
					over = true;
				}
			}

			if (direction == LEFT)
			{
				if (head.x - 1 >= 0 && CheckCollision(head.x - 1, head.y))
				{
					head = new Point(head.x - 1, head.y);
				}
				else
				{
					over = true;
				}
			}

			if (direction == RIGHT)
			{
				if (head.x + 1 < 80 && CheckCollision(head.x + 1, head.y))
				{
					head = new Point(head.x + 1, head.y);
				}
				else
				{
					over = true;
				}
			}

		}
		
		
		if (ticks % 2 == 0 && head2 != null && !over && !pause)
		{

			wall2.add(new Point(head2.x, head2.y));

			if (direction2 == UP)
			{
				if (head2.y - 1 >= 0 && CheckCollision(head2.x, head2.y - 1))
				{
					head2 = new Point(head2.x, head2.y - 1);
				}
				else
				{
					over2 = true;

				}
			}

			if (direction2 == DOWN)
			{
				if (head2.y + 1 < 67 && CheckCollision(head2.x, head2.y + 1))
				{
					head2 = new Point(head2.x, head2.y + 1);
				}
				else
				{
					over2 = true;
				}
			}

			if (direction2 == LEFT)
			{
				if (head2.x - 1 >= 0 && CheckCollision(head2.x - 1, head2.y))
				{
					head2 = new Point(head2.x - 1, head2.y);
				}
				else
				{
					over2 = true;
				}
			}

			if (direction2 == RIGHT)
			{
				if (head2.x + 1 < 80 && CheckCollision(head2.x + 1, head.y))
				{
					head2 = new Point(head2.x + 1, head2.y);
				}
				else
				{
					over2 = true;
				}
			}

		}
	}

	public boolean CheckCollision(int x, int y)
	{
		for (Point point : wall)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		
		for (Point point : wall2)
		{
			if (point.equals(new Point(x, y)))
			{
				return false;
			}
		}
		return true;
	}
	
	
	

	

	public static void main(String[] args)
	{
		lightcycle = new Lightcycle();
	}

	
	
	public void keyPressed(KeyEvent e)
	{
		int i = e.getKeyCode();

		if ((i == KeyEvent.VK_Q ) && direction != RIGHT)
		{
			direction = LEFT;
		}

		if ((i == KeyEvent.VK_D ) && direction != LEFT)
		{
			direction = RIGHT;
		}

		if ((i == KeyEvent.VK_Z ) && direction != DOWN)
		{
			direction = UP;
		}

		if ((i == KeyEvent.VK_S ) && direction != UP)
		{
			direction = DOWN;
		}
		
		
		if (( i == KeyEvent.VK_LEFT) && direction2 != RIGHT)
		{
			direction2 = LEFT;
		}

		if (( i == KeyEvent.VK_RIGHT) && direction2 != LEFT)
		{
			direction2 = RIGHT;
		}

		if (( i == KeyEvent.VK_UP) && direction2 != DOWN)
		{
			direction2 = UP;
		}

		if (( i == KeyEvent.VK_DOWN) && direction2 != UP)
		{
			direction2 = DOWN;
		}


		if (i == KeyEvent.VK_SPACE)
		{
			if (over || over2)
			{
				startGame();
			}
			else
			{
				pause = !pause;
			}
		}
	}

	
	public void keyReleased(KeyEvent e)
	{
	}

	
	public void keyTyped(KeyEvent e)
	{
	}

}
