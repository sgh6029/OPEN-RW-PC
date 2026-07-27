package test.rudp.packet;

public class FINPacket extends RUDPPacket {
    protected FINPacket() {
    }

    public FINPacket(int sequenceNumber) {
        init(2, sequenceNumber, 6);
    }

    @Override
    public String getType() {
        return "FIN";
    }
}