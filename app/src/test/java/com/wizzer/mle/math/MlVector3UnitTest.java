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

package com.wizzer.mle.math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class MlVector3UnitTest
{
    @Test
    public void testConstructors() throws Exception {
        MlVector3 vector = new MlVector3();
        vector.mVector[0] = (float) 1.0;
        vector.mVector[1] = (float) 1.0;
        vector.mVector[2] = (float) 1.0;

        assertEquals(1.0, vector.mVector[0], 0.0);
        assertEquals(1.0, vector.mVector[1], 0.0);
        assertEquals(1.0, vector.mVector[2], 0.0);

        vector = new MlVector3((float) 2.0, (float) 2.0, (float) 2.0);

        assertEquals(2.0, vector.mVector[0], 0.0);
        assertEquals(2.0, vector.mVector[1], 0.0);
        assertEquals(2.0, vector.mVector[2], 0.0);

        float[] v = new float[3];
        v[0] = (float) 3.0;
        v[1] = (float) 3.0;
        v[2] = (float) 3.0;
        vector = new MlVector3(v);

        assertEquals(3.0, vector.mVector[0], 0.0);
        assertEquals(3.0, vector.mVector[1], 0.0);
        assertEquals(3.0, vector.mVector[2], 0.0);

        MlVector3 vectorCopy = new MlVector3(vector);

        assertEquals(3.0, vectorCopy.mVector[0], 0.0);
        assertEquals(3.0, vectorCopy.mVector[1], 0.0);
        assertEquals(3.0, vectorCopy.mVector[2], 0.0);
    }

    @Test
    public void testIsZero() throws Exception {
        MlVector3 vector = new MlVector3();

        assertTrue(vector.isZero());

        vector.mVector[0] = (float)1.0;

        assertFalse(vector.isZero());
    }

    @Test
    public void testDotProduct() throws Exception {
        MlVector3 vector1 = new MlVector3();
        MlVector3 vector2 = new MlVector3((float)1.0, (float)1.0, (float)1.0);

        assertEquals(0.0, vector1.dot(vector2), 0.0);

        vector1.mVector[0] = 1;
        vector1.mVector[1] = 1;
        vector1.mVector[2] = 1;

        assertEquals(3.0, vector1.dot(vector2), 0.0);

        vector1.mVector[0] = 2;
        vector1.mVector[1] = 2;
        vector1.mVector[2] = 2;

        assertEquals(6.0, vector1.dot(vector2), 0.0);

        vector2.mVector[0] = 3;
        vector2.mVector[1] = 3;
        vector2.mVector[2] = 3;

        assertEquals(18.0, vector1.dot(vector2), 0.0);
    }
}
