import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tell me size: ");
        final int width = scanner.nextInt();
        scanner.close();
        constructor(width);
    }
    public static void constructor(int width) {
        // Заполнение массива пробелами
        int high = width * 100/140;
        char arr[][] = new char[width][high];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < high; j++) {
                arr[i][j] = ' ';
            }
        }
        // Генеральный строительный цикл
        for (int i = 1, j = 0; j < high; j++, i++) {
            if (width / 2 + i < width) { // Условие для перехода от кроны к стволу
                // Внесение снежинок
                int snowFlakes = ThreadLocalRandom.current().nextInt(0, width - 1);
                arr[snowFlakes][j] = '*';
                // Определение границ
                int leftBorder = (width / 2) - i;
                int rightBorder = (width / 2) + i;
                // Заполнение границ
                arr[leftBorder][j] = '/';
                arr[rightBorder][j] = 92; // Символ правой границы
                // Наполнение иголками
                if (rightBorder - leftBorder > 2) {
                    for (int spikes = leftBorder + 1; spikes < rightBorder; spikes++){
                        arr[spikes][j] = '`';
                    }
                    // Наполнение игрушками
                    for (int countToys = leftBorder; countToys < rightBorder; countToys+=5){
                        int toys = ThreadLocalRandom.current().nextInt(leftBorder + 1, rightBorder - 1);
                        arr[toys][j] = 526; // Символ игрушки
                    }
                }
                // Наполнение нижней границы яруса
                for (int k = 0; k < width; k++) {
                    if (j % 4 == 0 && j != 0) {
                        for (int bottoms = width / 2 - i + 1; bottoms < width / 2 + i; bottoms++) {
                            arr[bottoms][j] = '~';
                        }
                    }
                    System.out.print(arr[k][j]); // Вывод строки кроны
                }
                // Смещение границ для образования нового яруса
                if (j % 4 == 0 && j != 0) {
                    i--;
                }
                System.out.println();
                continue; // Переход к новой строке кроны
            }
            // Формирование ствола
             arr[width/2 - width/10][j] = '|';
             arr[width/2 + width/10][j] = '|';
            for (int z = width/2 - width/10 + 1; z < width/2 + width/10; z+=3){
                int wood = ThreadLocalRandom.current().nextInt(width/2 - width/10 + 1, width/2 + width/10);
                arr[wood][j] = '·';

            }
             for (int k = 0; k < width; k++) {
                 System.out.print(arr[k][j]);
             }
                System.out.println();
        }
    }
}