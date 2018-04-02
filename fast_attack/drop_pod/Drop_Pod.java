package fast_attack.drop_pod;

import gui.model.Unit;
import wargear.weapon.WeaponList;

public class Drop_Pod extends Unit 
{
	protected int frontArmour, sideArmour, rearArmour, hitPoints;
	
	public Drop_Pod()
	{
		super();
		unitName = "Drop Pod"; 
        weapon = WeaponList.getTerminator("Storm Bolter");
		points = 35 + weapon.getWeaponPoints();
        ballisticSkill = 4;
        frontArmour = 12;
        sideArmour = 12;
        rearArmour = 12;
        hitPoints = 3;	
               
        unitWeaponsList.add(WeaponList.getTerminator("Storm Bolter"));
        unitWeaponsList.add(WeaponList.getDrop_PodWeapon("Deathwind Launcher"));
	}
}
