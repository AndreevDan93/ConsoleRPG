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
        //������� ��������
    }

    ArrayList<Item> casts = new ArrayList<>();
    /*
        ����� ������ �������� ����� ���������� ����� ��� �������� ��� ������ �������� ���������� ����������������:
        �������� - 100, ���� - 5000, ���� - 5, �������� - 30, ��������� - 300, ���� 0, ���� - 40.
    ����� �� �������� � ������
    ������ ������� �����, ��� ����� ����������� ���� ����������� � �������� �����
    ������ ���� �������������� ���������� �����, ������� ��������� ���� ����, �� ������ �������� ������ ����.
    ����� ������� ���� +10 �� ���� ���������������, +30 ��������, 1000 ���� � +10 �����.
    � ������ ����������� ����� ����� � ���� - ��� ���� � ����!!! � ������ �������
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
        if (this.hp <= 0) System.out.println("��� ����� ��� ����");
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
        // ���� � ������ ���� �������� ����� ��� ���������� �������� 100 ���� � ������ 1000 ����� ����.
        // ����� ������������ ������� �� ������ ���������
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
                ���� ������� ��� �������� �� ������ ����� ��� 2, ��� ���������� � �� ����� �������� � ������
���������� ����
                */
}