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
    } //������� ��������

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
        if(this.hp <= 0) System.out.print("��� ����� ��� ����");


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
                ����� ������ �������� ����� ���������� ����� ��� �������� ������ ������ �������� ���������� ����������������:
                 �������� - 200, ���� - 50, ���� - 20, �������� - 150, ��������� - 30, ���� 0, ���� - 200.
            ����� �� �������� � ������, �� � �������� ����� ������ ����� 30% ���� �������� ����
            ������ ������ ��������� ������� - 100%
            ����� ������� ���� +10 �� ���� ���������������, +50 �������� � +50 ����� � 30 ��������.
            */
}