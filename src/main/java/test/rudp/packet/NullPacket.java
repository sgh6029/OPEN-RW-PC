package test.rudp.packet;

public class NullPacket extends RUDPPacket {
    protected NullPacket() {
    }

    public NullPacket(int sequenceNumber) {
        init(8, sequenceNumber, 6);
    }

    @Override
    public String getType() {
        return "NUL";
    }
}