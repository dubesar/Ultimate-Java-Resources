/*
Reference: https://www.geeksforgeeks.org/flyweight-design-pattern/
 */



// A Java program to demonstrate working of FlyWeight Pattern with example of VAlorant Game
import java.util.Random;
import java.util.HashMap;

// A common interface for all Agents
interface Agent
{
	public void assignWeapon(String weapon);
	public void mission();
}

// An Attacker must have weapon and mission
class Attacker implements Agent
{
	// Intrinsic Attribute
	private final String TASK;

	// Extrinsic Attribute
	private String weapon;

	public Attacker()
	{
		TASK = "PLANT A Spike";
	}
	public void assignWeapon(String weapon)
	{
		// Assign a weapon
		this.weapon = weapon;
	}
	public void mission()
	{
		//Work on the Mission
		System.out.println("Attackers with weapon "
						+ weapon + "|" + " Task is " + TASK);
	}
}

// A Defender must have weapon and mission just like an Attacker
class Defender implements Agent
{
	// Intrinsic Attribute
	private final String TASK;

	// Extrinsic Attribute
	private String weapon;

	public Defender()
	{
		TASK = "DIFFUSE Spike";
	}
	public void assignWeapon(String weapon)
	{
		this.weapon = weapon;
	}
	public void mission()
	{
		System.out.println("Defenders with weapon "
						+ weapon + "|" + " Task is " + TASK);
	}
}

// Class used to get an Agent using HashMap (Returns) an existing Agent if an Agent of given type exists.
// Else creates a new Agent and returns it.
class HavenMap
{
	/* HashMap stores the reference to the object
	of Attackers or Defender */
	private static HashMap <String, Agent> hm =
						new HashMap<String, Agent>();

	// Method to get an Agent
	public static Agent getAgent(String type)
	{
		Agent p = null;

		/* If an object for Attackers or Defender has already been
		created simply return its reference */
		if (hm.containsKey(type))
				p = hm.get(type);
		else
		{
			/* create an object of Attackers or Defender */
			switch(type)
			{
			case "Attacker":
				System.out.println("Attackers Created");
				p = new Attacker();
				break;
			case "Defender":
				System.out.println("Defenders Created");
				p = new Defender();
				break;
			default :
				System.out.println("Unreachable code!");
			}

			// Once created insert it into the HashMap
			hm.put(type, p);
		}
		return p;
	}
}

// Driver class
public class Valorant
{
	// All Agent types and weapon (used by getRandAgentType()
	// and getRandWeapon()
	private static String[] AgentType =
					{"Attacker", "Defender"};
	private static String[] weapons =
	{"Phantom", "Vandal", "Sheriff","Operator", "Spectre","Ares","Odin"};


	// Driver code
	public static void main(String args[])
	{
		/* Assume that we have a total of 10 Agents
		in the game. */
		for (int i = 0; i < 10; i++)
		{
			/* getAgent() is called simply using the class
			name since the method is a static one */
			Agent p = HavenMap.getAgent(getRandAgentType());

			/* Assign a weapon chosen randomly uniformly
			from the weapon array */
			p.assignWeapon(getRandWeapon());

			// Send this Agent on a mission
			p.mission();
		}
	}

	// Utility methods to get a random Agent type and
	// weapon
	public static String getRandAgentType()
	{
		Random r = new Random();

		// Will return an integer between [0,2)
		int randInt = r.nextInt(AgentType.length);

		// return the Agent stored at index 'randInt'
		return AgentType[randInt];
	}
	public static String getRandWeapon()
	{
		Random r = new Random();

		// Will return an integer between [0,5)
		int randInt = r.nextInt(weapons.length);

		// Return the weapon stored at index 'randInt'
		return weapons[randInt];
	}
}

