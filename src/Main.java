import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Hero myHero = new Warrior();
        //    Hero myHero = new Archer();
        //    Hero myHero = new Magician();

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(30, 20, 1200)); // 1 - Пряничный человек
        enemies.add(new Enemy(2018, 1, 350)); // 2 - Туча комаров
        enemies.add(new Enemy(280, 50, 3050)); // 3 - Вор
        enemies.add(new Enemy(100500, 100500, 100500)); // 4 - Гальватрон

        //найден клад
        for (int i = 0; i < 300; i++) {
            Item item = new Item(0, 0, i % 3); // i%3 - будет задавать предмету тип 0, 1, 2
            myHero.openItem(item);  // герои получает предмет в руки
        }
        System.out.println("Всего собрано: " + myHero.items.size());

        // бой!
        int count = 1;
        for (Enemy enemy : enemies) {
            System.out.println(count++ + "-й бой:");
            System.out.println("  Герои { hp=" + myHero.hp + " mana=" + myHero.mana + " }");
            System.out.println("  Враг { hp=" + enemy.hp + " }");
            int counter = 1;
            while (myHero.hp > 0 & enemy.hp > 0) {
                System.out.println(counter++ + " раунд:");
                myHero.attack(enemy);
                myHero.defense(enemy);
                System.out.println("    Герои { hp=" + myHero.hp + " mana=" + myHero.mana + " }");
                System.out.println("    Враг { hp=" + enemy.hp + " }");
            }
            System.out.println(myHero.hp > 0 ? "Победа, герой получил опыт " + enemy.exp : "Поражение");
            System.out.printf("Герой { HP=%d, MANNA=%d, damage=%d, exp=%d }\n", myHero.hp, myHero.mana, myHero.damage, myHero.exp);
        }
    }
}