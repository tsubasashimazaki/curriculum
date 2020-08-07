import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

// interface: メソッドの仕様(戻り値とメソッド名、引数)のみ定義したもの。実際の処理は持たないクラスのようなもの
// implements: interfaceに定義されているメソッドを定義しているクラスだよと指定
// implements インターフェース名(ここではTagがインターフェース名)
public class helloTagServlet implements Tag {

	// データ型でPageContext,Tagがあるのかな？？？
	private PageContext pageContext;
	private Tag parentTag;

	public void setPageContext(PageContext pageContext) { //上記フィールド変数をセットするだけのメソッド
		this.pageContext = pageContext;
	}

	public void setParent(Tag parentTag) { //上記フィールド変数をセットするだけのメソッド
		this.parentTag = parentTag;
	}

	public Tag getParent() { 
		return this.parentTag;
	}
	
//	doStart(): JSPからtaglibディレクトリを指定した際に行いたい処理記述
	public int doStartTag() throws JspException {

		try {
			JspWriter outJspWriter = pageContext.getOut();
		} catch(Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	// doStartTagが終わったら実行される
	public int doEndTag() throws JspException {
		// JSPページにコントローラーで処理を行なった結果を返す(今回はHello World出力)
		return EVAL_PAGE;
	}

	public void release() {}

}

// ------------- 聞きたいことリスト -------------
// setメソッドの引数で半角スペース空いているのは何だろう
// release()は...