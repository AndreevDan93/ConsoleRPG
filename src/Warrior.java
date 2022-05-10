class Warrior extends Hero {
    public Warrior() {
        hp = 500;
        mana = 10;
        s = 100;
        a = 50;
        i = 1;
        exp = 0;
        damage = 150;//������� ��������
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
        if (this.hp <= 0) System.out.println("��� ����� ��� ����");

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
����� ������ �������� ����� ���������� ����� ��� �������� ���� ������ �������� ���������� ����������������:
 �������� - 500, ���� - 10, ���� - 100, �������� - 50, ��������� - 1, ���� 0, ���� - 150.
 ��� ����� ����� ������� ���� ���� � �������� ���� � ����� �� ����, �������� ����������� ���� ��� �� �� �������.
 � ������ ������ ����� �������� ���� ����, ������ 500 ������ ����� ����� �������� ����� �������.
 ����� ������� ���� +10 �� ���� ���������������, +200 �������� � +20 �����.
 ���� ���� ����� ������� 1 ����, � ��� ����� ����������� 100.
            ��� ������� ���� - ����� ����� �� �������!!!
            */
}

