// COPYRIGHT_BEGIN
//
// The MIT License (MIT)
//
// Copyright (c) 2019 Wizzer Works
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

// Declare package.
package com.wizzer.mle.math;

// Import packages.
import org.junit.Test;

import static org.junit.Assert.*;

public class MlRotationUnitTest {
    @Test
    public void testConstructors() throws Exception {
        // Test default constructor.
        MlRotation rot = new MlRotation();
        assertEquals(0.0, rot.m_quat[0], 0.0);
        assertEquals(0.0, rot.m_quat[1], 0.0);
        assertEquals(0.0, rot.m_quat[2], 0.0);
        assertEquals(1.0, rot.m_quat[3], 0.0);
    }

    @Test
    public void testGetValue() throws Exception {
        // Test default constructor.
        MlRotation rot = new MlRotation();
        assertEquals(0.0, rot.m_quat[0], 0.0);
        assertEquals(0.0, rot.m_quat[1], 0.0);
        assertEquals(0.0, rot.m_quat[2], 0.0);
        assertEquals(1.0, rot.m_quat[3], 0.0);

        float v[] = new float[4];
        rot.getValue(v);
        assertEquals(0.0, v[0], 0.0);
        assertEquals(0.0, v[1], 0.0);
        assertEquals(0.0, v[2], 0.0);
        assertEquals(1.0, v[3], 0.0);

        MlVector3 axis = new MlVector3();
        float angle[] = new float[1];
        rot.getValue(axis, angle);
        assertEquals(0.0, axis.m_vector[0], 0.0);
        assertEquals(0.0, axis.m_vector[1], 0.0);
        assertEquals(1.0, axis.m_vector[2], 0.0);
        assertEquals(0.0, angle[0], 0.0);

        MlTransform m = new MlTransform();
        rot.getValue(m);
        assertEquals(1.0, m.m_matrix[0][0], 0.0);
        assertEquals(0.0, m.m_matrix[0][1], 0.0);
        assertEquals(0.0, m.m_matrix[0][2], 0.0);
        assertEquals(0.0, m.m_matrix[1][0], 0.0);
        assertEquals(1.0, m.m_matrix[1][1], 0.0);
        assertEquals(0.0, m.m_matrix[1][2], 0.0);
        assertEquals(0.0, m.m_matrix[2][0], 0.0);
        assertEquals(0.0, m.m_matrix[2][1], 0.0);
        assertEquals(1.0, m.m_matrix[2][2], 0.0);
        assertEquals(0.0, m.m_matrix[3][0], 0.0);
        assertEquals(0.0, m.m_matrix[3][1], 0.0);
        assertEquals(0.0, m.m_matrix[3][2], 0.0);
    }

    @Test
    public void tesMultiplication1() throws Exception {
        // Test default constructor.
        MlRotation rot = new MlRotation();
        assertEquals(0.0, rot.m_quat[0], 0.0);
        assertEquals(0.0, rot.m_quat[1], 0.0);
        assertEquals(0.0, rot.m_quat[2], 0.0);
        assertEquals(1.0, rot.m_quat[3], 0.0);

        MlRotation delta = new MlRotation(MlScalar.ML_SCALAR_ZERO, MlScalar.ML_SCALAR_ONE,
            MlScalar.ML_SCALAR_ZERO, 0.035f);
        rot.mul(delta);
        assertEquals(0.0, rot.m_quat[0], 0.0);
        assertEquals(0.9993880987167358, rot.m_quat[1], 0.0);
        assertEquals(0.0, rot.m_quat[2], 0.0);
        assertEquals(0.034978583455085754, rot.m_quat[3], 0.0);
    }

    @Test
    public void tesMultiplication2() throws Exception {
        // Test default constructor.
        MlRotation rot = new MlRotation();
        assertEquals(0.0, rot.m_quat[0], 0.0);
        assertEquals(0.0, rot.m_quat[1], 0.0);
        assertEquals(0.0, rot.m_quat[2], 0.0);
        assertEquals(1.0, rot.m_quat[3], 0.0);

        MlRotation delta = new MlRotation(new MlVector3(MlScalar.ML_SCALAR_ZERO, MlScalar.ML_SCALAR_ONE,
                MlScalar.ML_SCALAR_ZERO), 0.035f);
        rot.mul(delta);
        assertEquals(0.0, rot.m_quat[0], 0.0);
        assertEquals(0.017499107867479324, rot.m_quat[1], 0.0);
        assertEquals(0.0, rot.m_quat[2], 0.0);
        assertEquals(0.9998469948768616, rot.m_quat[3], 0.0);
    }
}
