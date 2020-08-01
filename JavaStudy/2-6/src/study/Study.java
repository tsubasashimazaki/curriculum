package study;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * 本課題では、基本的な日付操作クラスの使い方を学びましょう。
 *
 * 問①から問③まであります。
 * 問②に関しては、コメントを記述してください。
 *
 * ※この課題に関しては課題実施日によって結果が異なるため、出力結果が個々で異なります。
 */
public class Study {
    public static void main(String args[]) {
        // Dateクラスのインスタンスを生成
        Date now = new Date();
        // 問① ローカル変数「now」を使用し、本日の日付を表示してください。
        System.out.println(now);

        // Calendarクラスのインスタンスを生成
        Calendar calendar = Calendar.getInstance();
        // 問② 以下の「Calendar.MONTH) + 1」の処理は、想定していない値となる可能性があります。
        // その理由をコメントへ記述してください。
        // [(Calendar.MONTH) + 1の処理は現在の取得した月に+1する為(今回だど7月 +1)、
        // 未来の情報(3年後など)を取得する際に13月, 14月という表示になってしまう為です。
        // また、年の加算減算をしてくれない為です。]
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DATE));
        // 問③ 上記の「calendar」を使用し、本日から1年2ヶ月15日先の日付を表示しなさい。
        // - この課題に関しては課題実施日によって結果が異なりますので、Wiki課題の画像とは結果が異なります。
        // - また、うるう年の場合は設定内容が正しくとも日付がズレて表示される可能性があります。
        System.out.println(calendar.get(Calendar.YEAR) + 1);
        System.out.println(calendar.get(Calendar.MONTH) + 3);
        System.out.println(calendar.get(Calendar.DATE) + 15);
        // うるう年判定
        printLeapYear(calendar.get(Calendar.YEAR));
    }
    /**
     * うるう年判定
     * 問③で日付がズレる可能性があるため補足として出力
     * @param year
     */
    private static void printLeapYear(final int year) {
        System.out.println(year + "年は、うるう年" + (Year.isLeap(year) ? "です。" : "ではありません。"));
    }
}