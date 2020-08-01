package study;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Set;
import java.util.Map;
/**
 * 本課題では、コレクションフレームワークのList系クラスとMap系クラスの基本的な記述を学びましょう。
 * 現場で必ず使用するものなので、ポイントをしっかり押さえておきましょう。
 *
 * 問①〜問③まであります。
 * 問②に関しては、コメントを記述してください。
 *
 */
public class Study {
    public static final String SHOP_SHOHIN_00 = "バナナ";
    public static final String SHOP_SHOHIN_01 = "牛乳";
    public static final String SHOP_SHOHIN_02 = "豚肉";
    public static final String SHOP_SHOHIN_03 = "コロッケ";
    public static void main(String args[]) {
        // ① 定数を全て使って、String型のListを記述してください。
    	List<String> shopinList = new ArrayList<String>();
    	shopinList.add(SHOP_SHOHIN_00);
    	shopinList.add(SHOP_SHOHIN_01);
    	shopinList.add(SHOP_SHOHIN_02);
    	shopinList.add(SHOP_SHOHIN_03);
        // ② 以下の「shopMap.put(shohinList.get(1), 180);」の処理について、コメントを記述してください。
        /*
         * [Mapインターフェースのputメソッドにより①で追加したshopInListの要素の追加をしています。
         * そして、putメソッドの第一引数にshopInListの配列のn番目の指定をしてKeyを取り出し、
         * 第二引数にそのKeyに紐づく値を指定しています。]
         *
         */
        LinkedHashMap<String, Integer> shopMap = new LinkedHashMap<String, Integer>();
        shopMap.put(shopinList.get(0), 125);
        shopMap.put(shopinList.get(1), 180);
        shopMap.put(shopinList.get(2), 350);
        shopMap.put(shopinList.get(3), 100);
        // ③ カリキュラムを参考に拡張for文を使って、課題の画像と同じ表示になるよう記述してください。
        // 「shohinList」と「shopMap」が保持する値を上手く利用しましょう。
        for (Map.Entry<String, Integer> food : shopMap.entrySet()) {
        	System.out.println(food.getKey() + "=" + food.getValue() + "円になります！");
        }

    }
}