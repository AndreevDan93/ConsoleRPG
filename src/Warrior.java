import java.util.Random;

/*
класс должен обладать всеми свойствами героя при создании воин должен обладать следующими характеристиками:
здоровье - 500, мана - 10, сила - 100, ловкость - 50, интеллект - 1, опыт 0, урон - 150.
При атаке герой наносит цели урон и получает урон в ответ от цели, действия повторяются пока кто то не победит.
        Уже мертвая цель - урона герою не наносит!!!
        */
class Warrior extends Hero {
    public Warrior() {
        this.hp = 500;
        this.mana = 10;
        this.s = 100;
        this.a = 50;
        this.i = 1;
        this.exp = 0;
        this.damage = 150;
    }


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
        if (enemy.hp > 0 && this.hp > 0) this.hp -= enemy.damage;
        if (this.hp <= 0) System.out.println("Ваш герой был убит");

    }

    @Override
    public void isLvlUP() {
        while (this.exp >= 500) {
            this.exp -= 500;
            this.hp += 200;
            this.damage += 20;
            this.s += 10;
            this.a += 10;
            this.i += 10;
            this.mana += 10;
        }

    }
    //В случае победы герой получает опыт цели, каждые 500 единиц опыта герой получает новый уровень.
    //Новый уровень дает +10 ко всем характеристикам, +200 здоровья и +20 урона.

    @Override
    public void openItem(Item item) {
        boolean flag = true;
        Random r = new Random();
        if (r.nextInt(10) >= 5) this.items.add(item);
        else flag = false;

        if (flag) {
            int count = 0;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).type == 1) count++;
                if (count == 1) {
                    if (i == items.size() - 1 && items.get(i).type == 1) {
                        this.damage += 100;
                    } else break;
                }
            }
        } else return;

    }
    //Если воин имеет предмет 1 типа, к его урону добавляется 100.

}

