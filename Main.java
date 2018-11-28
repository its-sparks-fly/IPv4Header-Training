import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner eingabe = new Scanner(System.in);
		Input input = new Input();
		Header header = input.start(eingabe);
		
		System.out.println("Soll die Ausgabe binär (0) oder als String (1) erfolgen?");
		int choice = eingabe.nextInt();
		eingabe.close();
		
		int version = header.getVersion();
		int IHL = header.getIHL();
		int TOS = header.getTOS();
		int packetlength = header.getPacketLength();
		int identifier = header.getIdentifier();
		String flags = header.getFlags();
		int offset = header.getOffset();
		int TTL = header.getTTL();
		int protocol = header.getProtocol();
		int checksum = header.getChecksum();
		String source = header.getSource();
		String destination = header.getDestination();
		
		if(choice == 1) {
			Object[] headerData = {version, IHL, TOS, packetlength ,identifier, flags, offset, TTL, protocol, checksum, source, destination};
			System.out.println(buildstring(headerData));	
		} else {
			// Binary-Method here!
		}
		
	}
	
	private static String buildstring(Object[] headerData) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i< headerData.length; i++){
			stringBuilder.append(headerData[i]);
			stringBuilder.append("-");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		String headerString = stringBuilder.toString();
		return headerString;
	}
}
