/*
 * MlAngle.java
 * Created on Dec 1, 2004
 */

// COPYRIGHT_BEGIN
//
// The MIT License (MIT)
//
// Copyright (c) 2019-2021 Wizzer Works
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
//  For information concerning this header file, contact Mark S. Millard,
//  of Wizzer Works at msm@wizzerworks.com.
//
//  More information concerning Wizzer Works may be found at
//
//      http://www.wizzerworks.com
//
// COPYRIGHT_END

// Declare packages.
package com.wizzer.mle.math;

// Import Java packages.
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * The <code>MlMath</code> claas provides conversion utilities for Magic Lantern math
 * data types.
 */
public class MlMath
{
    /**
     * Convert an <code>integer</code> into a byte array.
     *
     * @param i The integer to convert.
     * @param b The array that will back the new buffer.
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param type The hardware byte order. It must be either <code>BIG_ENDIAN</code>
     * or <code>LITTLE_ENDIAN</code>.
     */
    static public void convertIntegerToByteArray(int i, byte[] b, int offset, ByteOrder type) {
        ByteBuffer.wrap(b, offset, 4).order(type).putInt(i);
    }

    /**
     * Convert a byte array into an <code>integer</code>.
     *
     * @param b The array to convert.
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param type The hardware byte order. It must be either <code>BIG_ENDIAN</code>
     * or <code>LITTLE_ENDIAN</code>.
     *
     * @return An <code>integer</code> will be returned.
     */
    static public int convertByteArrayToInteger(byte[] b, int offset, ByteOrder type) {
        return ByteBuffer.wrap(b, offset, 4).order(type).getInt();
    }

    /**
     * Convert a <code>float</code> into a byte array.
     *
     * @param f The float to convert.
     * @param b The array that will back the new buffer.
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param type The hardware byte order. It must be either <code>BIG_ENDIAN</code>
     * or <code>LITTLE_ENDIAN</code>.
     */
    static public void convertFloatToByteArray(float f, byte[] b, int offset, ByteOrder type) {
        ByteBuffer.wrap(b, offset, 4).order(type).putFloat(f);
    }

    /**
     * Convert a byte array into a <code>float</code>.
     *
     * @param b The array to convert.
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param type The hardware byte order. It must be either <code>BIG_ENDIAN</code>
     * or <code>LITTLE_ENDIAN</code>.
     *
     * @return A <code>float</code> will be returned.
     */
    static public float convertByteArrayToFloat(byte[] b, int offset, ByteOrder type) {
        return ByteBuffer.wrap(b, offset, 4).order(type).getFloat();
    }

    /**
     * Convert a <code>double</code> into a byte array.
     *
     * @param d The double to convert.
     * @param b The array that will back the new buffer.
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param type The hardware byte order. It must be either <code>BIG_ENDIAN</code>
     * or <code>LITTLE_ENDIAN</code>.
     */
    static public void convertDoubleToByteArray(double d, byte[] b, int offset, ByteOrder type) {
        ByteBuffer.wrap(b, offset, 8).order(type).putDouble(d);
    }

    /**
     * Convert a byte array into a <code>double</code>.
     *
     * @param b The array that will back the new buffer.
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param type The hardware byte order. It must be either <code>BIG_ENDIAN</code>
     * or <code>LITTLE_ENDIAN</code>.
     *
     * @return A <code>double</code> will be returned.
     */
    static public double convertByteArrayToDouble(byte[] b, int offset, ByteOrder type) {
        return ByteBuffer.wrap(b, offset, 8).order(type).getDouble();
    }

    /**
     * Convert a <code><MlVector2</code> into a byte array.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The array that will back the new buffer.
     * @param vector The <code>MlVector2</code> to convert.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>8</b>.
     */
    static public void convertVector2ToByteArray(int offset, byte[] data, MlVector2 vector)
            throws IOException
    {
        if ((data.length - offset) < 8)
            throw new IOException("Invalid data array length.");

        float v[] = vector.mVector;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Convert a byte array into a <code>MlVector2</code>.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The data buffer to convert,
     * @param vector The output vector that will contain the results.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>8</b>.
     */
    static public void convertByteArrayToVector2(int offset, byte[] data, MlVector2 vector)
            throws IOException
    {
        if ((data.length - offset) < 8)
            throw new IOException("Invalid data array length.");

        float x = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        float y = convertByteArrayToFloat(data, offset, ByteOrder.BIG_ENDIAN);
        vector.setValue(x, y);
    }

    /**
     * Convert a <code><MlVector3</code> into a byte array.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The array that will back the new buffer.
     * @param vector The <code>MlVector3</code> to convert.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>12</b>.
     */
    static public void convertVector3ToByteArray(int offset, byte[] data, MlVector3 vector)
            throws IOException
    {
        if ((data.length - offset) < 12)
            throw new IOException("Invalid data array length.");

        float v[] = vector.mVector;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2], data, offset, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Convert a byte array into a <code>MlVector3</code>.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The data buffer to convert,
     * @param vector The output vector that will contain the results.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>12</b>.
     */
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

    /**
     * Convert a <code><MlVector4</code> into a byte array.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The array that will back the new buffer.
     * @param vector The <code>MlVector4</code> to convert.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>16</b>.
     */
    static public void convertVector4ToByteArray(int offset, byte[] data, MlVector4 vector)
            throws IOException
    {
        if ((data.length - offset) < 16)
            throw new IOException("Invalid data array length.");

        float v[] = vector.mVector;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[3], data, offset, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Convert a byte array into a <code>MlVector4</code>.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The data buffer to convert,
     * @param vector The output vector that will contain the results.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>16</b>.
     */
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

    /**
     * Convert a <code><MlTransform</code> into a byte array.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The array that will back the new buffer.
     * @param transform The <code>MlTransform</code> to convert.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>48</b>.
     */
    static public void convertTransforrmToByteArray(int offset, byte[] data, MlTransform transform)
            throws IOException
    {
        if ((data.length - offset) < 48)
            throw new IOException("Invalid data array length.");

        float v[][] = transform.mMatrix;
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

    /**
     * Convert a byte array into a <code>MlTransform</code>.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The data buffer to convert,
     * @param transform The output transform that will contain the results.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>48</b>.
     */
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

    /**
     * Convert a <code><MlRotation</code> into a byte array.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The array that will back the new buffer.
     * @param rotation The <code>MlRotation</code> to convert.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>16</b>.
     */
    static public void convertRotationToByteArray(int offset, byte[] data, MlRotation rotation)
            throws IOException
    {
        if ((data.length - offset) < 16)
            throw new IOException("Invalid data array length.");

        float v[] = rotation.mQuat;
        convertFloatToByteArray(v[0], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[1], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[2], data, offset, ByteOrder.BIG_ENDIAN); offset += 4;
        convertFloatToByteArray(v[3], data, offset, ByteOrder.BIG_ENDIAN);
    }

    /**
     * Convert a byte array into a <code>MlRotation</code>.
     *
     * @param offset The offset of the subarray to be used; must be non-negative
     * and no larger than array.length. The new buffer's position will be set to this value.
     * @param data The data buffer to convert,
     * @param rotation The output rotation that will contain the results.
     *
     * @throws IOException This exception is thrown if the <i>data.length</i> minus the
     * <i>offset</i> is less than <b>16</b>.
     */
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

    /**
     * Obtain the sine value of the specified angle.
     *
     * @param x The angle in degrees.
     *
     * @return The sine value of the angle is returned, in radians.
     */
    static public float mlSin(float x)
    {
        return (float)Math.sin(MlAngle.angleToRadians(x));
    }

    /**
     * Obtain the cosine value of the specified angle.
     *
     * @param x The angle in degrees.
     *
     * @return the cosine value of the angle is returned, in radians.
     */
    static public float mlCos(float x)
    {
        return (float)Math.cos(MlAngle.angleToRadians(x));
    }

    /**
     * Obtain the arc sine value of the specified angle.
     *
     * @param x The angle in radians.
     *
     * @return The arc sine value of the angle is returned, in radians.
     */
    static public float mlAsin(float x)
    {
        return MlAngle.radiansToAngle((float)Math.asin(x));
    }

    /**
     * Obtain the arc cosine value of the specified angle.
     *
     * @param x The angle in radians.
     *
     * @return The arc cosine value of the angle is returned, in degrees.
     */
    static public float mlAcos(float x)
    {
        return MlAngle.radiansToAngle((float)Math.acos(x));
    }

    /**
     * Obtain the arc tangent value of the specified angle.
     *
     * @param x The x polar coordinate value in radians.
     * @param y The y polar coordinate value in radians.
     *
     * @return The arc tangent value of the angle is returned, in degrees.
     */
    static public float mlAtan2(float x, float y)
    {
        return MlAngle.radiansToAngle((float)Math.atan2(x,y));
    }

    // Hide the default constructor.
    private MlMath() {}
}
