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
			System.out.println(IPv4Header(version, IHL, TOS, packetlength ,identifier, flags, offset, TTL, protocol, checksum, source, destination));	
		} else {
			// Binary-Method here!
		}
		
	}
	
	public static String IPv4Header(int version, int IHL, int TOS, int packetlength, int identifier, String flags, int offset, int TTL, int protocol, int checksum, String source, String destination) {
		String fullheader = version+"-"+IHL+"-"+TOS+"-"+packetlength+"-"+identifier+"-"+flags+"-"+offset+"-"+TTL+"-"+protocol+"-"+checksum+"-"+source+"-"+destination;
		return fullheader;
	}
}