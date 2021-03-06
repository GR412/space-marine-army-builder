package model;

import java.io.Serializable;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.wargear.weapon.Weapon;

public class UnitSquad implements Serializable, Iterable<Unit> //unit squad super class
{
	protected String squadName, unitName; //user defined name of the squad, name to be used in the output display of each member of a squad   
	protected List<Unit> unitList; //an aggregation of units
	protected int max, min; //max and min amount of members permitted in a unit squad
	
	public UnitSquad(String squadName) //creates a new array list of units with a user defined name
	{
		this.squadName = squadName;
		unitList = new ArrayList<>();
	}
	
	public Iterator<Unit> iterator() //allows the unit squad to be cycled through
	{
		return unitList.iterator();
	}
	
	/*public void setName (String name) 
	{
		this.squadName = name;
	}
	
	public String getName() 
	{
		return squadName;		
	}*/
	
	public void addUnit (Unit u) //adds a single unit member to the unit squad list
	{
		unitList.add(u);						
	}
	
	public void addUnitSquad ()//adds the default amount of unit members to the unit squad list at once 
	{
		for (int i = 0; i < min; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Unit());		
		}			
	}
	
	public void weaponUpgrade(Weapon weapon, int member) //chooses a unit member from the squad and upgrades their first weapon
	{
		getUnit(member).unitWeaponUpgrade(weapon);				   				
	}
	
	public void secondWeaponUpgrade(Weapon weapon, int member) //chooses a unit member from the squad and upgrades their second weapon
	{
		getUnit(member).unitSecondWeaponUpgrade(weapon);				   				
	}
	
	/*public void updateUnitSize(int number)
	{
		for (int i = 0; i < number; i++)
		{
			if (unitList.size() < max)
				unitList.add(new Unit());		
		}		
	}*/
	
	public String SquadWeaponsCheck() //this is actually specified as needed for each specific unit squad
	{
		int weaponCount = 0;
		String message = "";		
		return message;
	}
	
	public String SquadSizeCheck() //ensures a unit squad is neither too big nor to small
    {
    	String message = "";
    	
    	if (unitList.size() > max)
    	message =  "A " + unitName + "Squad must not exceed " + max + " members";
    	
    	else if (unitList.size() < min)
    		message =  "A " + unitName + "Squad must not fall short of " + min + " members";
    	   	
    	return message;   		   	
    }
		
	public void removeUnit (int number) //remove a single member from a squad, specified by the squad member index value
	{
		unitList.remove(number);		
	}
	
	/*public void clearUnitList()
	{
		unitList.clear();
	}*/
	
	public int unitListSize() //returns the current size of the unit squad list
	{
		return unitList.size();
	}
		
	public int getLastIndex() //returns an index value of the last member of the unit squad list
	{
		return unitList.size() -1;
	}
	
	public Unit getUnit(int index) //returns a unit from the unit squad list at a given index
	{
		Unit u = null;
        if (0 <= index && index < unitList.size())
          u = unitList.get(index);
        
         else 
           u = null;
        
        return u;
	}
			
	public String getUnitSquad() //returns the output of a unit squad, this output is overridden for vehicle unit squads  
	{
		String s = "\n" + unitName + "Squad: " + this.squadName 
		+ "\n" + 
		unitList.get(0).getCharacteristics() 
		+ "\n" +
		"Total Squad Points: " + getSquadPoints() + "\n\n";		
		
		for (int i = 0; i < unitList.size(); i++)
			s = s + "(" + (i+1)+ ")" + " " + unitName + " " + unitList.get(i).getUnitDetails() + "\n";
		
		return s;
	}
	
	@Override 
	public String toString() //allows the unit squad format to be presented in a readable format
	{
		return this.getUnitSquad();
	}
	
	public void setMaxSize (int size) //sets the max size of a squad
	{
		this.max = size;
	}
	
	/*public int getMaxSize()
	{
		return max;
	}*/
	
	public void setMinSize (int size) //sets the min size of a squad
	{
		this.min = size;
	}
	
	/*public int getMinSize()
	{
		return min;
	}*/
		
	/*public void setScoutSquadWeapons(int index, Weapon weapon)
	{
		unitList.get(index);		
	}*/
	
	public int getSquadPoints () //returns the total unit squad points value of all unit squad members combined
	{
		int total = 0;
		
		for (int i = 0; i < unitList.size(); i++)
			total = total + unitList.get(i).getUnitPoints();
		
		return total; 
	}
	
	/*public ObservableList<Weapon> getUnitWeapons()
	{
		Unit u = new Unit();
		ObservableList<Weapon> unitWeaponsOList = FXCollections.observableArrayList(u.unitWeaponsList);
		return unitWeaponsOList;
	}
	
	public ObservableList<Weapon> getUnitSecondWeapons()
	{
		Unit u = new Unit();
		ObservableList<Weapon> unitSecondWeaponsOList = FXCollections.observableArrayList(u.unitSecondWeaponsList);
		return unitSecondWeaponsOList;
	}*/	
}
	
