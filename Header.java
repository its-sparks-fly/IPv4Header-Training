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