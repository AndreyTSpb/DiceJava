package dicegame;

import java.util.Scanner;

/**
 * @author Andrey Tynyanyi
 * @version 1.0
 */

public class DiceGame {

    private static Scanner scanner = new Scanner(System.in); //Для ввода с клавиатуры
    private static int qntGamers; //Кол-во игроков
    private static int qntDice; //Кол-во кубиков
    private static String[] gamers; //Массив с игроками

    public static void main(String[] arg){
        DiceGame.enterGamers(); //Добавление играков в игру
        Play play = new Play(DiceGame.gamers, DiceGame.qntDice); //Запуск игры
        System.out.println(play.resultStr); //Вывод победителя
        play.viewGamersResult();
    }

    /**
     * Ввод играков в игру
     */
    public static void enterGamers(){
        //количество игроков
        while (DiceGame.qntGamers < 2) {
            System.out.print("Количество игроков в игре: ");
            DiceGame.qntGamers = DiceGame.scanner.nextInt();
        }
        //количество кубиков
        while (DiceGame.qntDice < 3){
            System.out.print("Укажите количество кубиков для игры: ");
            DiceGame.qntDice = DiceGame.scanner.nextInt();
        }
        //Создаем массив с нужным кол-м пользователей
        DiceGame.gamers = new String[DiceGame.qntGamers];
        //Заполняем массив игроками
        for(int i = 0; i < DiceGame.gamers.length-1; i++)
        {
            System.out.print("Ведити имя игрока №" + (i+1) + ": ");
            DiceGame.gamers[i] = DiceGame.scanner.next();
        }
        //последним добавляем компьютер
        DiceGame.gamers[DiceGame.qntGamers-1] = "Компьютер";
    };
}
