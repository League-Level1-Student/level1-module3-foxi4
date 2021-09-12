package _06_gridworld;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {
	//Instructions:
		//1. Figure out how to get a World to show. DONE

	    //2. Figure out how to add a Bug to the world (clue: you will need the Bug and Location objects) DONE

	    //3. Add another bug at a random location in the world. DONE

	    //4. Change the color of that bug to blue. DONE

	   // 5. Make the bug face to the right. DONE

	    //6. Add flowers to the left and right of the bug. DONE

	    //7. Fill the whole world with flowers! NOT DONE :(

	    //8. [Optional] Color the flowers in rows like the American flag (red & white)

	    //9. [Optional] Use a new class to make an X out of bugs.
	
	public static void main(String[] args) {
	
		World<Actor> world = new World<Actor>();
		//huh
		world.show();
		Bug bug = new Bug();
		Bug bug2 = new Bug();
		Flower flower = new Flower();
		Flower flower2 = new Flower();
		Location location = new Location(0, 9);
		Location location2 = new Location(4,3);
		Location location3 = new Location(4,2);
		Location location4 = new Location(4,4);
		world.add(location2, bug);
		world.add(location, bug2);
		world.add(location3, flower);
		world.add(location4, flower2);
		while(world.getRandomEmptyLocation() != null) {
			world.add(world.getRandomEmptyLocation(), flower); 
		}

		bug.setColor(Color.blue);
		bug.turn();
		bug.turn();
	
	}
	

	
}
