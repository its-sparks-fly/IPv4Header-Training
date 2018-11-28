import java.util.Scanner;
public class Input {
	
	public Header start(Scanner eingabe) {
		
		Header header = new Header();
		
		System.out.println("Bitte geben Sie die Version der IP ein:");
		int version = eingabe.nextInt();
		header.setVersion(version);
		
		System.out.println("Fragmentieren? 0-Ja, 1-Nein");
		int flag1 = eingabe.nextInt();		
		System.out.println("Weitere Fragmente? 1-Ja, 0-Nein");
		int flag2 = eingabe.nextInt();
		header.setFlags(flag1, flag2);
		
		System.out.println("Bitte geben Sie eine TTL ein:");
		int TTL = eingabe.nextInt(); 
		header.setTTL(TTL);
		
		System.out.println("Bitte geben Sie Quell-IP-Adresse ein:");
		String Source = eingabe.next(); 
		header.setSource(Source);
		
		System.out.println("Bitte geben Sie Ziel-IP-Adresse ein:");
		String Destination = eingabe.next(); 
		header.setDestination(Destination);
		
		return header;
	}
	
}