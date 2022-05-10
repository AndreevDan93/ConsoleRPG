import java.util.ArrayList;

abstract class Hero {

    protected String nickName;
    protected int s, a, i, exp, hp, mana; // сила ловкость интеллект опыт здоровье мана
    protected int x, y; // координаты героя на карте
    protected ArrayList<Item> items = new ArrayList<>(); // список поднятых предметов
    protected int damage; // урон


    public int getMana() {
        return mana;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public void goToCursor(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public abstract void attack(Enemy enemy); // этот метод должнен быть определен в классах наследниках

    public abstract void defense(Enemy enemy);// этот метод должнен быть определен в классах наследниках

    public abstract void isLvlUP();

    public void openItem(Item item) {
        boolean flag = true;
        int r = (int) (Math.random() * 100);
        if (r <= 50) this.items.add(item);
        else flag = false;



        // метод должен добавлять предмет в список с вероятностью 50 %
        // для осуществления вероятностных процессов можно использовать случайное число от 0 до 100.
    }

}