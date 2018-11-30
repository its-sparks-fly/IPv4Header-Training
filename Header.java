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
	private String binary;
	
	public String start(Header header) {
		//////////////////////
		// STARTS USER INPUT
		// RETURNS CONVERTED HEADER
		//////////////////////
		Input input = new Input();
		String output;
		input.setChoice();
		
		if(input.getChoice() == 1) {
			Object[] headerData = input.start(header);
			output = convertHeader(headerData);			
		} else {
			input.binaryInput(header);
			String headerData = getBinary();
			output = convertBinary(headerData);
		}
		return output;
	}
	
	private String convertHeader(Object[] headerData) {
		//////////////////////
		// CONVERTS HEADER IF INPUT IS NON-BINARY
		//////////////////////
		String output;
		output = "String: " + buildstring(headerData) + "\n" + "Binär: " + binarystring(headerData);	
		return output;
	}
	
	private String convertBinary(String headerData) {
		String[] numbers = headerData.split("\\s+");
		Object[] decimals = new Object[12];
		for(int i = 0; i< numbers.length; i++){
			if(i == 5) {
				decimals[i] = numbers[i];
			} else if (i == 10 || i == 11) { 
				decimals[i] = IPString(numbers[i]);
			} else {
				int decimalValue = Integer.parseInt(numbers[i], 2);
				decimals[i] = decimalValue;
			}
		}
		String decimalString = buildstring(decimals);
		return decimalString;
	}
	
	private String buildstring(Object[] headerData) {
		StringBuilder buildstring = new StringBuilder();
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
		StringBuilder binarystring = new StringBuilder();
		String binary = null;
		String bin = null;
		for(int i = 0; i< headerData.length; i++){
			if(!(i == 5) && !(i == 10) && !(i == 11)) {
				int decimal = (Integer) headerData[i];
				binary = Integer.toBinaryString(decimal);
				bin = String.format("%8s", binary).replace(' ', '0');
			} else if (i == 5) {
				bin = headerData[i].toString();
			} else if (i == 10 || i == 11) {
				String IP = headerData[i].toString();
				bin = binaryIP(IP);
			}
			binarystring.append(bin);
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
		String bin = null;
		
		numbers = IP.split("\\.");
		
		for(int i = 0; i< numbers.length; i++){
			int number = Integer.parseInt(numbers[i]);
			binNumber = Integer.toBinaryString(number);
			bin = String.format("%8s", binNumber).replace(' ', '0');
			binIP.append(bin);
		}
		
		String binaryIP = binIP.toString();
		return binaryIP;
	}
	
	private String IPString(String number) {
		//////////////////////
		// CONVERTS BINARY STRING (8 BITS) TO IP ADRESS
		//////////////////////	
		StringBuilder IPString = new StringBuilder();
		String[] IPBit = number.split("(?<=\\G.{" + 8 + "})");
		for(int j = 0; j< IPBit.length; j++){
			int decimalValue = Integer.parseInt(IPBit[j], 2);
			IPString.append(decimalValue);
			IPString.append(".");
		}
		IPString.deleteCharAt(IPString.length() - 1);
		return IPString.toString();	
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
	
	public void setBinary(String binary) {
		this.binary = binary;
	}
	
	public String getBinary() {
		return this.binary;
	}
	
}
