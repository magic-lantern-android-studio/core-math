package com.wizzer.mle.math;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by msm on 8/31/16.
 */
public class MlMath
{
    static public void convertFIntegerToByteArray(int i, byte[] b, int offset, ByteOrder type) {
        ByteBuffer.wrap(b, offset, 4).order(type).putInt(i);
    }

    static public int convertByteArrayToFInteger(byte[] b, int offset, ByteOrder type) {
        return ByteBuffer.wrap(b, offset, 4).order(type).getInt();
    }

    static public void convertFloatToByteArray(float f, byte[] b, int offset, ByteOrder type) {
        ByteBuffer.wrap(b, offset, 4).order(type).putFloat(f);
    }

    static public float convertByteArrayToFloat(byte[] b, int offset, ByteOrder type) {
        return ByteBuffer.wrap(b, offset, 4).order(type).getFloat();
    }

    static public void convertDoubleToByteArray(double d, byte[] b, int offset, ByteOrder type) {
        ByteBuffer.wrap(b, offset, 8).order(type).putDouble(d);
    }

    static public double convertByteArrayToDouble(byte[] b, int offset, ByteOrder type) {
        return ByteBuffer.wrap(b, offset, 8).order(type).getDouble();
    }

    static public void convertVector2ToByteArray(int offset, byte[] data, MlVector2 vector)
            throws IOException
    {
        if ((data.length - offset) < 8)
            throw new IOException("Invalid data array length.");

        float v[] = vector.m_vector;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN);
    }

    static public void convertByteArrayToVector2(int offset, byte[] data, MlVector2 vector)
            throws IOException
    {
        if ((data.length - offset) < 8)
            throw new IOException("Invalid data array length.");

        float x = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        float y = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN);
        vector.setValue(x, y);
    }

    static public void convertVector3ToByteArray(int offset, byte[] data, MlVector3 vector)
            throws IOException
    {
        if ((data.length - offset) < 12)
            throw new IOException("Invalid data array length.");

        float v[] = vector.m_vector;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2], data, offset, ByteOrder.BIG_ENDIAN);
    }

    static public void convertByteArrayToVector3(int offset, byte[] data, MlVector3 vector)
            throws IOException
    {
        if ((data.length - offset) < 12)
            throw new IOException("Invalid data array length.");

        float x = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        float y = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        float z = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN);
        vector.setValue(x, y, z);
    }

    static public void convertVector4ToByteArray(int offset, byte[] data, MlVector4 vector)
            throws IOException
    {
        if ((data.length - offset) < 16)
            throw new IOException("Invalid data array length.");

        float v[] = vector.m_vector;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[3], data, offset, ByteOrder.BIG_ENDIAN);
    }

    static public void convertByteArrayToVector4(int offset, byte[] data, MlVector4 vector)
        throws IOException
    {
        if ((data.length - offset) < 16)
            throw new IOException("Invalid data array length.");

        float x = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        float y = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        float z = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        float w = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN);
        vector.setValue(x, y, z, w);
    }

    static public void convertTransforrmToByteArray(int offset, byte[] data, MlTransform transform)
            throws IOException
    {
        if ((data.length - offset) < 48)
            throw new IOException("Invalid data array length.");

        float v[][] = transform.m_matrix;
        convertFloatToByteArray(v[0][0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[0][1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[0][2], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1][0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1][1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1][2], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2][0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2][1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2][2], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[3][0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[3][1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[3][2], data, offset, ByteOrder.BIG_ENDIAN);
    }

    static public void convertByteArrayToTransform(int offset, byte[] data, MlTransform transform)
            throws IOException
    {
        if ((data.length - offset) < 48)
            throw new IOException("Invalid data array length.");

        float v[][] = new float[4][3];
        v[0][0] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[0][1] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[0][2] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[1][0] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[1][1] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[1][2] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[2][0] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[2][1] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[2][2] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[3][0] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[3][1] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[3][2] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN);
        transform.setValue(v);
    }

    static public void convertRotationToByteArray(int offset, byte[] data, MlRotation rotation)
            throws IOException
    {
        if ((data.length - offset) < 16)
            throw new IOException("Invalid data array length.");

        float v[] = rotation.m_quat;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[3], data, offset, ByteOrder.BIG_ENDIAN);
    }

    static public void convertByteArrayToRotation(int offset, byte[] data, MlRotation rotation)
            throws IOException
    {
        if ((data.length - offset) < 16)
            throw new IOException("Invalid data array length.");

        float v[] = new float[4];
        v[0] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[1] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[2] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        v[3] = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN);
        rotation.setValue(v);
    }
}
