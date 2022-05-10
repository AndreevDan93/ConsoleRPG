import java.util.Random;

class Archer extends Hero {
    public Archer() {
        this.hp = 200;
        this.mana = 50;
        this.s = 20;
        this.a = 150;
        this.i = 30;
        this.exp = 0;
        this.damage = 200;
    } //базовые значение

    @Override
    public void attack(Enemy enemy) {
        if (enemy.hp > 0 && this.hp > 0) enemy.hp -= this.damage;
        if (this.hp > 0 && enemy.hp <= 0) {
            this.exp += enemy.exp;
            isLvlUP();
        }
    }

    @Override
    public void defense(Enemy enemy) {
        Random R = new Random();

        if(enemy.hp > 0  && R.nextInt() < 7) this.hp -= enemy.damage;
        if(this.hp <= 0) System.out.print("Ваш герой был убит");


    }

    @Override
    public void isLvlUP() {
        while (this.exp >= 500) {
            this.exp -= 500;
            this.hp += 50;
            this.damage += 50;
            this.s += 10;
            this.a += 40;
            this.i += 10;
            this.mana +=10;
        }
    }

    @Override
    public void openItem(Item item) {
        this.items.add(item);
    }
    /*
                класс должен обладать всеми свойствами героя при создании лучник должен обладать следующими характеристиками:
                 здоровье - 200, мана - 50, сила - 20, ловкость - 150, интеллект - 30, опыт 0, урон - 200.
            атака по аналогии с воином, но в процессе атаки лучник имеет 30% шанс избежать урон
            лучник всегда открывает предмет - 100%
            Новый уровень дает +10 ко всем характеристикам, +50 здоровья и +50 урона и 30 ловкости.
            */
}