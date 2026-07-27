package test.rudp.packet;

import java.io.IOException;

public class EAKPacket extends ACKPacket {
    private int[] additionalAcks;

    protected EAKPacket() {
    }

    public EAKPacket(int sequenceNumber, int ackNumber, int[] additionalAcks) {
        init(32, sequenceNumber, 6 + additionalAcks.length);
        setAckNumber(ackNumber);
        this.additionalAcks = additionalAcks;
    }

    @Override
    public String getType() {
        return "EAK";
    }

    public int[] getAdditionalAcks() {
        return additionalAcks;
    }

    @Override
    public byte[] toBytes() {
        byte[] base = super.toBytes();
        for (int i = 0; i < additionalAcks.length; i++) {
            base[4 + i] = (byte) (additionalAcks[i] & 0xFF);
        }
        return base;
    }

    @Override
    protected void parseData(byte[] data, int offset, int length) {
        try {
            super.parseData(data, offset, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        additionalAcks = new int[length - 6];
        for (int i = 0; i < additionalAcks.length; i++) {
            additionalAcks[i] = data[offset + 4 + i] & 0xFF;
        }
    }
}