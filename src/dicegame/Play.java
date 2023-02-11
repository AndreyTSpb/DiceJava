package dicegame;

/**
 * @author Andrey Tynyanyi
 * @version 1.0
 */

public class Play {
    public static int[] gamersResult; //Массив с результатами игроков
    private static String[] gamers;
    public String resultStr;
    private static int qntDice;

    /**
     * Запуск игры
     * @param gamers массив с игроками
     */
    public Play(String[] gamers, int qntDice){
        Play.gamers = gamers;
        Play.qntDice = qntDice;
        int winner = 0;
        int i = 1;
        Play.gamersResult = new int[gamers.length];
        while (Play.gamersResult[winner] < 7){
            winner = round(i, winner);
            i++;
            Play.gamersResult[winner] += 1; //считаем победы
            if(i > 1000) break; //ограничение на всякий случай
        }
        this.resultStr =  "Победил игрок №" + (winner+1) + " " + Play.gamers[winner];
    }

    /**
     * Игровой раунд
     * @param r - int - номер раунда
     * @param winner - int - номер победителя в предыдущем раунде
     * @return - int - номер победителя в текущем раунде
     */
    private static int round(int r, int winner){
        int[] roundResult = new int[Play.gamers.length];
        //первым бросает победитель
        roundResult[winner] = shot();
        for(int i = 0; i < Play.gamers.length; i++){
            if(i == winner) continue; //пропускаем победителя
            roundResult[i] = shot();
        }
        return testRound(roundResult); //проверка у кого больше выпало
    }

    /**
     * Проверка результатов раунда
     * @param roundResult - массив с результатами раунда
     * @return - номер победителя в раунде
     */
    private static int testRound(int[] roundResult){
        int max = roundResult[0];
        int key = 0;

        for(int i = 1; i < roundResult.length; i++){
            if( max < roundResult[i]){
                max = roundResult[i];
                key = i;
            }
        }
        return  key;
    }

    /**
     * Бросок кубиков
     * @return сумма брошеных кубиков
     */
    private static int shot(){
        int sum = 0;
        for (int i=0; i < Play.qntDice; i++){
            Dice dice = new Dice(); //бросок кубиков
            sum += dice.faceDice;
        }
        return sum; // результат
    }

    /**
     * Вывод результатов всех игроков
     */
    public void viewGamersResult(){
        System.out.println("Результаты всех игроков: ");
        for (int i = 0; i < Play.gamersResult.length; i++){
            System.out.println(Play.gamers[i] + ": " + Play.gamersResult[i]);
        }
    }

    private static void viewArrInt(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if(i == arr.length-1){
                System.out.println(arr[i]);
            }else{
                System.out.print(arr[i]+", ");
            }
        }
    }
}
