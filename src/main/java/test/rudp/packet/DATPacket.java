package test.rudp.packet;

import java.io.IOException;

public class DATPacket extends RUDPPacket {
    private byte[] payload;

    protected DATPacket() {
    }

    public DATPacket(int sequenceNumber, int ackNumber, byte[] data, int offset, int length) {
        init(64, sequenceNumber, 6 + length);
        setAckNumber(ackNumber);
        payload = new byte[length];
        System.arraycopy(data, offset, payload, 0, length);
    }

    @Override
    public int getLength() {
        return payload.length + super.getLength();
    }

    @Override
    public String getType() {
        return "DAT";
    }

    public byte[] getPayload() {
        return payload;
    }

    @Override
    public byte[] toBytes() {
        byte[] base = super.toBytes();
        System.arraycopy(payload, 0, base, 6, payload.length);
        return base;
    }

    @Override
    public void parseData(byte[] data, int offset, int length) {
        try {
            super.parseData(data, offset, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        payload = new byte[length - 6];
        System.arraycopy(data, offset + 6, payload, 0, payload.length);
    }
}