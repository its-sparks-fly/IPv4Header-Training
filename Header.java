public class Header {
	private int version;
	private int IHL;
	private int TOS = 24;
	private int packetlength = 1440;
	private int identifier = 0;
	private String flags;
	private int offset = 0;
	private int TTL;
	private int protocol = 0;
	private int checksum = 0;
	private String source;
	private String destination;
	Input input = new Input();
	StringBuilder buildstring = new StringBuilder();
	StringBuilder binarystring = new StringBuilder();
	
	public String start(Header header) {
		//////////////////////
		// STARTS USER INPUT
		// RETURNS CONVERTED HEADER
		//////////////////////
		Object[] headerData = input.start(header);
		final String output = convertHeader(headerData);
		return output;
	}
	
	private String convertHeader(Object[] headerData) {
		//////////////////////
		// CONVERTS HEADER
		// BASED ON USER'S CHOICE
		//////////////////////
		int choice = input.getChoice();	
		String output;
		if(choice == 1) {
			output = buildstring(headerData);	
		} else {
			output = binarystring(headerData);
		}
		return output;
	}
	
	private String buildstring(Object[] headerData) {
		//////////////////////
		// CONVERTS ARRAY TO STRING
		// SEPARATED BY "-"
		//////////////////////
		for(int i = 0; i< headerData.length; i++){
			buildstring.append(headerData[i]);
			buildstring.append("-");
		}
		buildstring.deleteCharAt(buildstring.length() - 1);
		String headerString = buildstring.toString();
		return headerString;
	}
	
	private String binarystring(Object[] headerData) {
		//////////////////////
		// CONVERTS INPUT TO BINARY
		//////////////////////	
		String binary = null;
		for(int i = 0; i< headerData.length; i++){
			if(!(i == 5) && !(i == 10) && !(i == 11)) {
				int decimal = (Integer) headerData[i];
				binary = Integer.toBinaryString(decimal);
			} else if (i == 5) {
				binary = headerData[i].toString();
			} else if (i == 10 || i == 11) {
				String IP = headerData[i].toString();
				binary = binaryIP(IP);
			}
			binarystring.append(binary);
			binarystring.append(" ");
		}
		
		return binarystring.toString();	
	}
	
	private String binaryIP(String IP) {
		//////////////////////
		// CONVERTS IP ADRESS TO BINARY
		//////////////////////	
		String[] numbers = null;
		String binNumber = ""; 
		StringBuilder binIP = new StringBuilder();
		
		numbers = IP.split("\\.");
		
		for(int i = 0; i< numbers.length; i++){
			int number = Integer.parseInt(numbers[i]);
			binNumber = Integer.toBinaryString(number);
			binIP.append(binNumber);
		}
		
		String binaryIP = binIP.toString();
		return binaryIP;
	}
	

	//////////////////////
	// SETTER & GETTER ///
	//////////////////////
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public int getVersion() {
		return this.version;
	}
	
	private int calculateIHL() {
		// since we've got no options, this calculation is pretty static...
		IHL = (20 * 8) / 32;
		return IHL;
	}
	
	public int getIHL() {
		IHL = calculateIHL();
		return IHL;
	}
	
	public int getTOS() {
		return TOS;
	}
	
	public int getPacketLength() {
		return packetlength;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public void setFlags(int i, int j) {
		flags = "0"+i+j;
	}
	
	public String getFlags() {
		return flags;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void setTTL(int TTL) {
		this.TTL = TTL;
	}
	
	public int getTTL() {
		return this.TTL;
	}
	
	public int getProtocol() {
		return protocol;
	}
	
	public int getChecksum() {
		return checksum;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
}
