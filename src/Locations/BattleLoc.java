package src.Locations;
import src.Material.Trophy;
import src.Mobs.Obstacle;
import src.Player;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected Trophy trophy;

	protected BattleLoc(Player player, String name, Obstacle obstacle, Trophy trophy) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.trophy = trophy;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Şuan buradasınız : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yaşıyor !");
		System.out.print("<S>avaş veya <K>aç :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " bölgesindeki tüm düşmanları temizlediniz !");
				if (this.trophy == null){
					return true;
				}
				if (player.getInv().hasItem(this.trophy)){
					System.out.println("Bu alanın ödülü önceden de alınmış");
					return true;
				}
				player.getInv().addItem(this.trophy);
				System.out.println(this.trophy.toString() + " Kazandınız");
				return true;
			}
			
			if(player.getHealthy() <= 0) {
				System.out.println("Öldünüz !");
				return false;
			}
		
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<V>ur veya <K>aç :");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					if (Math.random() > 0.5f) {
						System.out.println("İlk siz vurdunuz !");
						obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
						afterHit();
						if (obstacle.getHealth() > 0) {
							System.out.println();
							System.out.println("Canavar size vurdu !");
							player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));


						}
					}else {
						System.out.println();
						System.out.println("Canavar önce vurdu !");
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
						if (player.getHealthy() <= 0){
							return false;
						}

						obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					}


					afterHit();
				} else {
					return false;
				}
			}

			if (obstacle.getHealth() < player.getHealthy()) {
				System.out.println("Düşmanı yendiniz !");
				player.setMoney(player.getMoney() + obstacle.getAward());
				if (obstacle.getLoot() != null){
					System.out.println("Yaratıktan " + obstacle.getLoot().toString() + " düştü.");
					player.getInv().addItem(obstacle.getLoot());
				}
				System.out.println("Güncel Paranız : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Oyuncu Değerleri\n--------------");
		System.out.println("Can:" + player.getHealthy());
		System.out.println("Hasar:" + player.getTotalDamage());
		System.out.println("Para:" + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Silah:" + player.getInv().getWeaponName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Z�rh:" + player.getInv().getArmorName());
		}
	}

	public void enemyStats() {
		System.out.println("\n" + obstacle.getName() + " Değerleri\n--------------");
		System.out.println("Can:" + obstacle.getHealth());
		System.out.println("Hasar:" + obstacle.getDamage());
		System.out.println("Ödül:" + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Oyuncu Canı:" + player.getHealthy());
		System.out.println(obstacle.getName() + " Canı:" + obstacle.getHealth());
		System.out.println();
	}

	public Trophy getTrophy(){
		return this.trophy;
	}

}
