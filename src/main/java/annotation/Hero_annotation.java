package annotation;

import annotation.MyColumn;
import annotation.MyEntity;
import annotation.MyGeneratedValue;
import annotation.MyId;
import annotation.MyTable;

@MyEntity
@MyTable(name="hero_")
public class Hero_annotation {
	private int id;
	private String name;
	private int damage;
	private int armor;
	
	@MyId
	@MyGeneratedValue(strategy = "identity")
	@MyColumn("id_")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@MyColumn("name_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@MyColumn("damage_")
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	@MyColumn("armor_")
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
}
