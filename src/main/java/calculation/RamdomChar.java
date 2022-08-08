package calculation;

public class RamdomChar {
	
	    public String getRandomString(int i) {
			
			//Math.random()を使った10文字のランダムな文字列
			//ランダムな10文字のString
			StringBuilder builder;
			/*Stringクラスは一度セットした値を変更できない
			 *StringBuilderは,Stringと違いループ処理の際に
			 *新しく変数の保存スペースを作らなくて済む
			 */
			String theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			//create the StringBuffer
	        builder = new StringBuilder(i); 
	        /*
	         * StringBuilderはシングルスレッド（バッチ処理のような直列処理）向き
	         * StringBuffferはマルチスレッド（並列処理）向き
	         * */
	        
	        for (int m = 0; m < i; m++) { 

	            // generate numeric
	            int myindex 
	                = (int)(theAlphaNumericS.length() 
	                        * Math.random()); 
	            //math.ramdomで0以上1未満の整数を生成
	            //myindexは0～35番目を生成する(Aが0番目で9が35番目)

	            // add the characters
	            builder.append(theAlphaNumericS 
	                        .charAt(myindex)); 
	            //appendは大量に文字をつなげるときに適しているStringBuilderクラスのメゾット
	            //対象文字列.append(追加文字列)
	            //charAtは文字列のｎ番目を抜き出す(先頭は0文字目とみなす)
	            
	        } 

	       
	        //型をString型に変換するToStringメソッド
	    	return  builder.toString(); 
	    }
	    

}
