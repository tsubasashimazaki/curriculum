// スーパークラス
abstract class PolimoSuper {
    protected void call() {
        // 2-2 の要件を満たす処理
        System.out.println(this.getClass());
    }
}
// サブクラス1
class PolimoSub1 extends PolimoSuper {
    @Override
    protected void call() {
        super.call();
    }
}
// サブクラス2
class PolimoSub2 extends PolimoSuper {
    @Override
    protected void call() {
        super.call();
    }
}


// 呼び出し
// サブクラス1でインスタンスを生成
PolimoSuper polimo1 = new PolimoSub1();
polimo1.call();
// サブクラス2でインスタンスを生成
PolimoSuper polimo2 = new PolimoSub2();
polimo2.call();