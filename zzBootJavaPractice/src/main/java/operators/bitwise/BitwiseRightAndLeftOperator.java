/**
 * 
 */
package operators.bitwise;

/**
 * @author SAMEER KADGAYE
 *
 */
public class BitwiseRightAndLeftOperator {
	//Binary Number Pattern For calculation :    ....  64 32 16 8 4 2 1     //Shows In Image Also
	
	public static void main(String[] args) {
		System.out.println("<<<<<<<================== Bitwise Left Started ==================>>>>>>>");
		int a = 8;   //Binary code : 1000 = 8
		int b = 8 << 2;   //Left shift operator ni apan pahle shifting operator(8 <<) chya agother dilelya Number chya Binary kadto(i.e 8 => 1000)
						  //Ani tya binary madhe Apan ending extra zeros add karto as per shifting operator(<< 2) chya nantre dilya Number(Or Length) nusar (i.e 2 Now value is 100000).
						
						 //Manje apan 8 chya binary la 2 zeros ni ending la vadhavnar ahot.
						// i.e 1000(8) << 00(2) = 100000(32) Varchya pattern nusar
		System.out.println("Value oF Left Shift Operator Variable b is : "+b);
		System.out.println("<<<<<<<================== Bitwise Left Ended ==================>>>>>>>");
		
		
		System.out.println("<<<<<<<================== Bitwise Right Started ==================>>>>>>>");
		int aa = 8;   //Binary code : 1000 = 8
		int bb = 8 >> 2;   //Right shift operator ni apan pahle shifting operator(8 >>) chya agother dilelya Number chya Binary kadto(i.e 8 => 1000)
						  //Ani tya binary madhe Apan ending madun bits(digits manu skto) kadhun gheto as per shifting operator(>> 2) chya nantre dilya Number(Or Length) nusar (i.e 2 Now value is 10).
						
						 //Manje apan 8 chya binary la 2 length(Digits or bits) ni ending la kami karu.
						// i.e 1000(8) >> 00(2 for remove) = 10(2) Varchya pattern nusar
		System.out.println("Value oF Right Shift Operator Variable bb is : "+bb);
		System.out.println("<<<<<<<================== Bitwise Right Ended ==================>>>>>>>");
		
		
		int c = 10 + (10 >> 1);  //(i.e 10 + 7 >> 1) and then 17 >>> 1 = 1000 which 15 (binary to number)
		System.out.println(c);
	}
}
