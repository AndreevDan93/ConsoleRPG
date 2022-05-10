import java.util.ArrayList;

abstract class Hero {

    protected String nickName;
    protected int s, a, i, exp, hp, mana; // ���� �������� ��������� ���� �������� ����
    protected int x, y; // ���������� ����� �� �����
    protected ArrayList<Item> items = new ArrayList<>(); // ������ �������� ���������
    protected int damage; // ����


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

    public abstract void attack(Enemy enemy); // ���� ����� ������ ���� ��������� � ������� �����������

    public abstract void defense(Enemy enemy);// ���� ����� ������ ���� ��������� � ������� �����������

    public abstract void isLvlUP();

    public  void openItem(Item item) {}



}