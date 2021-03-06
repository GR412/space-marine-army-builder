package model.fast_attack.stormhawk_interceptor;

import model.Unit;
import model.wargear.weapon.WeaponList;

public class Stormhawk_Interceptor extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Stormhawk_Interceptor()
	{
		super();
		unitName = "Stormhawk Interceptor"; 
		weapon = WeaponList.getGunshipWeapon("Las-Talon (Primary)");
	    weaponTwo = WeaponList.getGunshipWeapon("Twin-Linked Heavy Bolter (Side Hull)");
	    points = 125 + weapon.getWeaponPoints() + weaponTwo.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 12;
        sideArmour = 11;
        rearArmour = 11;
        hitPoints = 2;	
        
        unitWeaponsList.add(WeaponList.getGunshipWeapon("Las-Talon (Primary)"));
        unitWeaponsList.add(WeaponList.getGunshipWeapon("Icarus Stormcannon (Primary)"));
        
        unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Twin-Linked Heavy Bolter (Side Hull)"));
        unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Skyhammer Missile Launcher (Side Hull)"));
        unitSecondWeaponsList.add(WeaponList.getGunshipWeapon("Typhoon Missile Launcher (Side Hull)"));
	}
	
	@Override
	public String getUnitDetails()
	{
		return "|| " + "Weapons: " + weapon + " + " + weaponTwo + " || " + "Points: " + points;
	}
	
	@Override
	public String getCharacteristics()
	{		
		return "Characteristics:   BS: " + ballisticSkill  +  "   HP: " + hitPoints +
				"   Armour:   FA: " + frontArmour + "   SA: " + sideArmour + "   RA: " + rearArmour;
	}
}
