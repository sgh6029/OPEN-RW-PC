package test.rudp.packet;

public class ACKPacket extends RUDPPacket {
    protected ACKPacket() {
    }

    public ACKPacket(int sequenceNumber, int ackNumber) {
        init(64, sequenceNumber, 6);
        setAckNumber(ackNumber);
    }

    @Override
    public String getType() {
        return "ACK";
    }
}