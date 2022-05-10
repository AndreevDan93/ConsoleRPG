import java.util.ArrayList;

class Magician extends Hero {
    public Magician() {
        hp = 100;
        mana = 5000;
        s = 5;
        a = 30;
        i = 300;
        exp = 0;
        damage = 40;
        int fireSchool = 1;
        int watterSchool = 1;
        //базовые значение
    }

    ArrayList<Item> casts = new ArrayList<>();
    /*
        класс должен обладать всеми свойствами героя при создании маг должен обладать следующими характеристиками:
        здоровье - 100, мана - 5000, сила - 5, ловкость - 30, интеллект - 300, опыт 0, урон - 40.
    атака по аналогии с воином
    помимо обычной атаки, маг имеет возможность бить заклинанием в процессе атаки
    защита мага осуществляется магическим щитом, который полгащает весь урон, но вместо здоровья тратит ману.
    Новый уровень дает +10 ко всем характеристикам, +30 здоровья, 1000 маны и +10 урона.
    В случае возможности убить врага с руки - маг бьет с руки!!! в Первую очередь
    */

    @Override
    public void attack(Enemy enemy) {
        if (enemy.hp > 0 && this.hp > 0) {

            if (enemy.hp > this.damage) makeCast(enemy);
            else enemy.hp -= this.damage;
        }
        if (this.hp > 0 && enemy.hp <= 0) {
            this.exp += enemy.exp;
            isLvlUP();
        }

    }

    @Override
    public void defense(Enemy enemy) {
        if (enemy.hp > 0 && this.hp > 0) {
            if (enemy.hp > 0) {
                if (this.mana >= enemy.damage) this.mana -= enemy.damage;
                else if (this.mana > 0 && enemy.damage > this.mana) {
                    this.hp -= enemy.damage - this.mana;
                    this.mana = 0;
                }
                else if (mana == 0)this.hp -= enemy.damage;
            }
        }
        if (this.hp <= 0) System.out.println("Ваш герой был убит");
    }


    @Override
    public void isLvlUP() {
        while (this.exp >= 500) {
            this.exp -= 500;
            this.hp += 30;
            this.damage += 10;
            this.s += 10;
            this.a += 10;
            this.i += 10;
            this.mana += 1000;
        }
    }

    public void makeCast(Enemy enemy) {
        if (casts.size() > 0 && mana >= 100) {
            this.mana -= 100;
            enemy.hp -= 1000;
            casts.remove(casts.size() - 1);
        }
        // если в списке есть заклятия можно его произнести потратив 100 маны и нанеся 1000 урона цели.
        // после произнесения предмет из списка пропадает
    }

    @Override
    public void openItem(Item item) {
        super.openItem(item);
        if(items.contains(item)) eduCast(item);
    }

    public void eduCast(Item item) {
        if (item.type == 2) casts.add(item);
    }
                /*
                если предмет или предметы из списка имеют тип 2, это заклинания и их нужно добавить в список
заклинаний мага
                */
}