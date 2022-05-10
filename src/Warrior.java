class Warrior extends Hero {
    public Warrior() {
        hp = 500;
        mana = 10;
        s = 100;
        a = 50;
        i = 1;
        exp = 0;
        damage = 150;//базовые значение
        int rage = 0;
    }


    @Override
    public void attack(Enemy enemy) {
        if (enemy.hp > 0 && this.hp > 0) {
            enemy.hp -= this.damage;
        }
        if (this.hp > 0 && enemy.hp <= 0) {
            this.exp += enemy.exp;
            isLvlUP();
        }
    }

    @Override
    public void defense(Enemy enemy) {
        if (enemy.hp > 0 && this.hp > 0) {
            if (enemy.hp > 0) this.hp -= enemy.damage;
        }
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
        }

    }

    @Override
    public void openItem(Item item) {
        boolean flag = true;
        int r = (int) (Math.random() * 100);
        if (r <= 50) this.items.add(item);
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
        }else return;

    }

    /*
класс должен обладать всеми свойствами героя при создании воин должен обладать следующими характеристиками:
 здоровье - 500, мана - 10, сила - 100, ловкость - 50, интеллект - 1, опыт 0, урон - 150.
 При атаке герой наносит цели урон и получает урон в ответ от цели, действия повторяются пока кто то не победит.
 В случае победы герой получает опыт цели, каждые 500 единиц опыта герой получает новый уровень.
 Новый уровень дает +10 ко всем характеристикам, +200 здоровья и +20 урона.
 Если воин имеет предмет 1 типа, к его урону добавляется 100.
            Уже мертвая цель - урона герою не наносит!!!
            */
}

