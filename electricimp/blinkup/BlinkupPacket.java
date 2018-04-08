package com.electricimp.blinkup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;

class BlinkupPacket {
    private static final int BLACK = 0;
    static final String FIELD_BITSTREAM = "bitStream";
    static final String FIELD_MODE = "mode";
    static final String FIELD_SLOW = "slow";
    static final String FIELD_SSID = "ssid";
    static final String FIELD_TRILEVEL = "trilevel";
    private static final int GRAY = 1;
    private static final int NUM_ENROLMENT_BYTES = 18;
    private static final int WHITE = 2;
    private static final int[] crc16Table = new int[]{0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, 1920, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, 5120, 54465, 54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 17280, 33601, 16640, 33217, 32897, 16448};
    private ArrayList<Integer> bitStream = new ArrayList();
    private char crc;
    private boolean triLevel = false;

    public void initWifi(String str, String str2, String str3, String str4) {
        if (str3 == null) {
            str3 = "";
        }
        if (str4 == null) {
            str4 = "";
        }
        int length = (getLength(str3) + 2) + 18;
        if (str4.length() > 0) {
            length += getLength(str4) + 2;
        }
        startPacket(length);
        addPacketData(str3, (byte) 1);
        if (str4.length() > 0) {
            addPacketData(str4, (byte) 6);
        }
        addEnrolmentPacketData(str, str2);
        finishPacket();
    }

    private int getLength(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (Throwable e) {
            Log.e("BlinkUp", Log.getStackTraceString(e));
            return 0;
        }
    }

    public void initForClearWirelessConfiguration() {
        startPacket(2);
        addByteToBitstream((byte) 7);
        addByteToBitstream((byte) 0);
        finishPacket();
    }

    public void initForFirmwareUpgrade() {
        startPacket(2);
        addByteToBitstream((byte) 4);
        addByteToBitstream((byte) 0);
        finishPacket();
    }

    public void initForWPS(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "";
        }
        startPacket((getLength(str3) + 2) + 18);
        addPacketData(str3, (byte) 3);
        addEnrolmentPacketData(str, str2);
        finishPacket();
    }

    private void addEnrolmentPacketData(String str, String str2) {
        int i = 7;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[8]);
        wrap.putLong(new BigInteger(str, 16).longValue());
        ByteBuffer wrap2 = ByteBuffer.wrap(new byte[8]);
        wrap2.putLong(new BigInteger(str2, 16).longValue());
        addByteToBitstream((byte) 5);
        addByteToBitstream((byte) 16);
        for (int i2 = 7; i2 >= 0; i2--) {
            addByteToBitstream(wrap2.get(i2));
        }
        while (i >= 0) {
            addByteToBitstream(wrap.get(i));
            i--;
        }
    }

    private void startPacket(int i) {
        this.bitStream = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            addByteToBitstreamNoCRC((byte) 85);
        }
        if (this.triLevel) {
            addByteToBitstreamNoCRCPrependBlack((byte) 42);
        } else {
            addByteToBitstreamNoCRC((byte) 42);
        }
        this.crc = '\u0000';
        addByteToBitstream((byte) i);
    }

    private void finishPacket() {
        if (this.triLevel) {
            addByteToBitstreamNoCRCPrependBlack((byte) (this.crc >> 8));
            addByteToBitstreamNoCRCPrependBlack((byte) (this.crc & 255));
            return;
        }
        addByteToBitstreamNoCRC((byte) (this.crc >> 8));
        addByteToBitstreamNoCRC((byte) (this.crc & 255));
    }

    private void addByteToBitstreamNoCRC(byte b) {
        for (int i = 7; i >= 0; i--) {
            if (((b >> i) & 1) == 0) {
                this.bitStream.add(Integer.valueOf(0));
            } else {
                this.bitStream.add(Integer.valueOf(this.triLevel ? 1 : 2));
            }
        }
    }

    private void addByteToBitstreamNoCRCPrependBlack(byte b) {
        for (int i = 7; i >= 0; i--) {
            if (((b >> i) & 1) == 0) {
                this.bitStream.add(Integer.valueOf(0));
                this.bitStream.add(Integer.valueOf(1));
            } else {
                this.bitStream.add(Integer.valueOf(0));
                this.bitStream.add(Integer.valueOf(2));
            }
        }
    }

    private void addByteToBitstream(byte b) {
        addByteToCRC(b);
        if (this.triLevel) {
            addByteToBitstreamNoCRCPrependBlack(b);
        } else {
            addByteToBitstreamNoCRC(b);
        }
    }

    private void addByteToCRC(byte b) {
        this.crc = (char) ((this.crc << 8) ^ crc16Table[((this.crc >> 8) ^ b) & 255]);
    }

    private void addPacketData(String str, byte b) {
        addByteToBitstream(b);
        try {
            byte[] bytes = str.getBytes("UTF-8");
            addByteToBitstream((byte) bytes.length);
            for (byte addByteToBitstream : bytes) {
                addByteToBitstream(addByteToBitstream);
            }
        } catch (Throwable e) {
            Log.e("BlinkUp", Log.getStackTraceString(e));
        }
    }

    public int numBits() {
        return this.bitStream.size();
    }

    public int bitAtIndex(int i) {
        return ((Integer) this.bitStream.get(i)).intValue();
    }

    public void halfSpeed() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bitStream.size(); i++) {
            arrayList.add(this.bitStream.get(i));
            arrayList.add(this.bitStream.get(i));
        }
        this.bitStream = arrayList;
    }

    public void twoThirdSpeed() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.bitStream.size(); i++) {
            arrayList.add(this.bitStream.get(i));
            if (i % 2 != 0) {
                arrayList.add(this.bitStream.get(i));
            }
        }
        this.bitStream = arrayList;
    }

    public void triLevel() {
        this.triLevel = true;
    }

    public static BlinkupPacket createFromIntent(Intent intent) {
        int i = 0;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        BlinkupPacket blinkupPacket = new BlinkupPacket();
        String string = extras.getString(FIELD_BITSTREAM);
        if (string != null) {
            while (i < string.length()) {
                blinkupPacket.bitStream.add(Integer.valueOf(string.substring(i, i + 1)));
                i++;
            }
            return blinkupPacket;
        }
        if (extras.getBoolean(FIELD_TRILEVEL, false)) {
            blinkupPacket.triLevel();
        }
        string = extras.getString("mode");
        if (string.equals(BaseBlinkupController.MODE_WIFI)) {
            blinkupPacket.initWifi(extras.getString(BaseBlinkupController.FIELD_TOKEN), extras.getString("siteid"), extras.getString("ssid"), extras.getString(BaseBlinkupController.FIELD_PASSWORD));
        } else if (string.equals(BaseBlinkupController.MODE_WPS)) {
            blinkupPacket.initForWPS(extras.getString(BaseBlinkupController.FIELD_TOKEN), extras.getString("siteid"), extras.getString(BaseBlinkupController.FIELD_PIN));
        } else if (string.equals("fwUpgrade")) {
            blinkupPacket.initForFirmwareUpgrade();
        } else if (!string.equals(BaseBlinkupController.MODE_CLEAR)) {
            return null;
        } else {
            blinkupPacket.initForClearWirelessConfiguration();
        }
        if (extras.getBoolean(FIELD_SLOW, false)) {
            blinkupPacket.halfSpeed();
        }
        return blinkupPacket;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.bitStream.size(); i++) {
            stringBuffer.append(this.bitStream.get(i));
        }
        return stringBuffer.toString();
    }
}
