package test.rudp.packet;

public class RSTPacket extends RUDPPacket {
    protected RSTPacket() {
    }

    @Override
    public String getType() {
        return "RST";
    }
}