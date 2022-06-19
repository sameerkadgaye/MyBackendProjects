/**
 * 
 */
package dataStructureAndAlgorithms.otherLogicsModule.apostropheString;

/**
 * @author SAMEER KADGAYE
 *
 */

//Java String Replaces one apostrophe character (') with two ('') in the given string.
//		
//Replaces one apostrophe character (') with two ('') in the given string. Used mostly when composing SQL statements.
//
//Parameter:
//
//s String to be converted
//Return:
//
//Resulting string
public class ApostropheString {
	/** Replaces one apostrophe character (') with two ('') in the
     *  given string. Used mostly when composing SQL statements.

     *  @param s String to be converted
     *  @return Resulting string
     */
	public static void main(String[] args) {
		String adjustQuotes = adjustQuotes("'");
		System.out.println("apostrophe string is : "+adjustQuotes);
	}
	public static String adjustQuotes(String s) {
        if (s == null)
            return null;
        int startIndex = 0;
        int pos;
        StringBuffer retVal = new StringBuffer();
        while (true) {
            pos = s.indexOf('\'', startIndex);
            if (pos > -1) {
                retVal.append(s.substring(startIndex, pos));
                retVal.append("\'\'");
                startIndex = pos + 1;
            } else {
                retVal.append(s.substring(startIndex));
                break;
            }
        }
        return retVal.toString();
    }

}
