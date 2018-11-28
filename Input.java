import java.util.Scanner;

public class Input {
	private int choice;
	Scanner eingabe = new Scanner(System.in);
	
	public Object[] start(Header header) {
		//////////////////////
		// STARTS USER INPUT
		// RETURNS USER INPUT + FULL HEADER DATA
		//////////////////////
		
		setChoice();
		
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
		
		eingabe.close();
		
		int finalversion = header.getVersion();
		int IHL = header.getIHL();
		int TOS = header.getTOS();
		int packetlength = header.getPacketLength();
		int identifier = header.getIdentifier();
		String flags = header.getFlags();
		int offset = header.getOffset();
		int finalTTL = header.getTTL();
		int protocol = header.getProtocol();
		int checksum = header.getChecksum();
		String source = header.getSource();
		String destination = header.getDestination();
		Object[] headerData = {
			finalversion, 
			IHL, 
			TOS, 
			packetlength,
			identifier, 
			flags, 
			offset, 
			finalTTL, 
			protocol, 
			checksum, 
			source, 
			destination
		};
		
		return headerData;
	}
	
	private void setChoice() {
		//////////////////////
		// LETS USER CHOOSE IF BINARY OR STRING OUTPUT
		//////////////////////		
		System.out.println("Soll die Ausgabe binär (0) oder als String (1) erfolgen?");
		choice = eingabe.nextInt();
		
	}
	
	public int getChoice() {
		return choice;
	}
}
