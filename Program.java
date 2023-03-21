import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

// Добавить файл с описанием интерфейса. В котором описать два метода, 
// void step(); и String getInfo(); Реализовать имнтерфейс в абстрактном классе. Создать два списка в классе main. В каждый из списков добавить по десять 
// экземнляров наследников абстрактноuj классf. Реализовать метод step() таким образом, чтобы они отображали типы персонажей.

public class Program {
    public static void main(String[] args) {

        // Random rand = new Random();
        Random random = new Random();
        ArrayList<BaseHero> list1 = new ArrayList<>();
        ArrayList<BaseHero> list2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    list1.add(new Peasant("Амар", 50, 10, 10, 23, 21));
                    break;
                // case 0:
                //     list.add(new XBowMan(getName()));
                //     break;
                case 1:
                    list1.add(new Robber("Ко", 10, 20, 40, 60, 65, 23, random.nextInt(16), random.nextInt(32)));
                    break;
                case 2:
                    list1.add(new SniperHero("Кларк", 50, 40, 20,24, 40, 45, random.nextInt(16), random.nextInt(32)));
                    break;
                case 3:
                    list1.add(new Magician("Мармар", 30, 14, 5, 10, 34, random.nextInt(16), random.nextInt(32)));
                    break;
                // default:
                //     list.add(new Sniper(getName()));
                //     break;
            }
            switch (random.nextInt(4)) {
                case 0:
                    list2.add(new Peasant("Монтар", 40, 20, 10, random.nextInt(16), random.nextInt(32)));
                    break;
                // case 0:
                //     list.add(new XBowMan(getName()));
                //     break;
                case 1:
                    list2.add(new Spearman("Монтар", 40, 20, 14, 24, random.nextInt(16), random.nextInt(32)));
                    break;
                case 2:
                    list2.add(new Crossbowman("Шаиа", 23, 21, 43, 24, 23, 12, random.nextInt(16), random.nextInt(32)));
                    break;
                case 3:
                    list2.add(new Monk("Мана", 23, 21, 34, random.nextInt(16), random.nextInt(32)));
                    break;
                // case 0:
                //     list2.add(new XBowMan(getName()));
                //     break;
                // case 1:
                //     list2.add(new Monk(getName()));
                //     break;
                // default:
                //     list2.add(new Sniper(getName()));
                //     break;
            }
        }

        ArrayList<BaseHero> allUnits = new ArrayList<>();
        allUnits.addAll(list1);
        allUnits.addAll(list2);
        allUnits.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero u1, BaseHero u2) {
                if (u1.getSpeed() == u2.getSpeed())
                    return 0;
                else if (u1.getSpeed() > u2.getSpeed())
                    return 1;
                else
                    return -1;
            }
        });

        for (BaseHero hero : allUnits) {
            System.out.printf(hero.getInfo() + " " + hero.getName() + " HP: " + hero.getHp() + ", Speed: " + hero.getSpeed() + 
            ", Position: " + "x: %d, y: %d\n", hero.position.x, hero.position.y);
        }

        System.out.println("\n");

        list1.forEach(u -> u.step(list2, list1));

        // int count = 1;
        // for (BaseHero unit : list1) {
        //     unit.position.x=1;
        //     unit.position.y = count;
        //     count++;
        // }

        // count = 1;
        // for (BaseHero unit : list2) {
        //     unit.position.x=10;
        //     unit.position.y = count;
        //     count++;
        // }

        // for (BaseHero unit : list1) {
        //     System.out.printf("%d, %d\n", unit.position.x, unit.position.y);
        // }   
    }
        // for (int i = 0; i < teamCount; i++) {
        //     int val = rand.nextInt(5);
        //     switch (val) {
        //         case 0:
        //             list1.add(new Crossbowman("Амар", 50, 10, 10, 20));
        //             break;
        //         case 1:
        //             list1.add(new Magician("Мармар", 30, 14, 5, 10));
        //             break;
        //         case 2:
        //             list1.add(new Priest("Мешаул", 60, 10, 20, 30));
        //             break;
        //         case 3:
        //             list1.add(new Robber("Ко", 10, 20, 40, 60, 65));
        //             break;
        //         default:
        //             list1.add(new SniperHero("Кларк", 50, 40, 20, 40));
        //             break;
        //     }
        //     System.out.println(list1.get(i).getInfo());

        //     switch (val) {
        //         case 0:
        //             list2.add(new Crossbowman("Амар", 50, 10, 10, 20));
        //             break;
        //         case 1:
        //             list2.add(new Magician("Мармар", 30, 14, 5, 10));
        //             break;
        //         case 2:
        //             list2.add(new Priest("Мешаул", 60, 10, 20, 30));
        //             break;
        //         case 3:
        //             list2.add(new Robber("Ко", 10, 20, 40, 60, 65));
        //             break;
        //         default:
        //             list2.add(new SniperHero("Кларк", 50, 40, 20, 40));
        //             break;
        //     }
        //     System.out.println(list2.get(i).getInfo());
            
        // }

        // list1.forEach(u -> u.step());
        // list2.forEach(u -> u.step());

        // #region ex1 Demo

        // BaseHero hero3 = new Magician();
        // System.out.println(hero3.getInfo());

        // BaseHero hero4 = new Priest();
        // System.out.println(hero4.getInfo());

        // #endregion

        // #region ex2 Attack
        // System.out.println("------");
        // System.out.println(hero3.getInfo());
        // System.out.println(hero4.getInfo());

        // hero3.Attack(hero4);
        
        // hero4.Attack(hero3);
        // System.out.println(hero3.getInfo());
        // System.out.println(hero4.getInfo());

        // #endregion

        // #region Teams

        // int teamCount = 10;
        // Random rand = new Random();
        // int magicianCount = 0;
        // int priestCount = 0;
 

        // List<BaseHero> teams = new ArrayList<>();
        // for (int i = 0; i < teamCount; i++) {
        //     if (rand.nextInt(2) == 0) {
        //         teams.add(new Priest());
        //         priestCount++;
        //     }
        //     else{
        //         teams.add(new Magician());
        //         magicianCount++;
        //     }

        //     System.out.println(teams.get(i).getInfo());
        // }
        // System.out.println();
        // System.out.printf("magicalCount: %d priestCount: %d \n\n", magicianCount, priestCount);
        
        // attack

        // #endregion

        // todo добавить ещё один класс и 
        // реализовать возможность лечения героев
    }