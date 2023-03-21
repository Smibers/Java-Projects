package rpg;

public class Player {
	private String name;
	private String status = "alive";
	private int xp = 0;
	private int level = 1;
	private int currentHit = 0;
	private int maxHit = 100;
	private int damage = 0;

	public Player(String name, int xp, int currentHit) {
		super();
		this.name = name;
		this.status = status;
		this.xp = xp;
		this.level = level;
		this.currentHit = currentHit;
		this.maxHit = maxHit;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
		this.level = xp / 100;
		if (this.level < 1) {
			this.level = 1;
		}
		;
		this.damage = (this.level * 30);
		this.maxHit = (int)(this.level*100*(1+this.level/10.0));

	}

	public int getLevel() {
		return level;
	}

	public int getCurrentHit() {
		return currentHit;
	}

	public int getMaxHit() {
		return maxHit;
	}

	public void setcurrentHit(int currentHit) {
		this.currentHit = currentHit;
	
	}

	public void setStatus(String status) {
		if (this.currentHit <= 0) {
			this.status = "dead";
		} else {
			this.status = "alive";
		}
	}

	public int getDamage() {
		return damage;
	}
	public void battle(Player player) {
		setcurrentHit(getCurrentHit()-player.getDamage());
		player.setcurrentHit(player.getCurrentHit()-this.damage);
		setXp(this.getXp()+50);
		player.setXp(player.getXp()+50);
	}
	@Override
	public String toString() {
		return "Player " + name + " is " + status + ", xp= " + xp + ", level=" + level + ", current hit points = "
				+ currentHit + ", max health= " + maxHit + ", damage= " + damage ;
	}

}
