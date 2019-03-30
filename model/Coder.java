package model;

public class Coder {		
		public String encrypt(String name){
			char[] ascii = name.toCharArray();
			for(int i = 0; i < ascii.length; i++) {
				ascii[i] = asciiAlphabet(((int)ascii[i])+i);	
			}
			StringBuilder str = new StringBuilder(String.copyValueOf(ascii));
			str.append((char)asciiNumber(ascii.length));
			str.append((char)asciiNumber(ascii.length+5));
			return str.toString();
		}
		
		private Character asciiAlphabet(int ascii) {
			int a = 65+((int)ascii)%54;
			if(a > 90 && a < 97) {
				a = a-8;
			}
			return (char)a;
		}
		
		private Character asciiNumber(int ascii) {
			int a = 48+((int)ascii)%10;
			return (char)a;
		}
		
	


}