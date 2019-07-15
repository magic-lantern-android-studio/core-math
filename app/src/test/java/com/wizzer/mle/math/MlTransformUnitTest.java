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

package com.wizzer.mle.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class MlTransformUnitTest {
    @Test
    public void testConstructors() throws Exception {
        // Test default constructor.
        MlTransform transform = new MlTransform();
        assertTrue(transform.isZero());

        // Test constructor with individual elements initialization.
        float a11 = 0;
        float a12 = 0;
        float a13 = 0;
        float a21 = 0;
        float a22 = 0;
        float a23 = 0;
        float a31 = 0;
        float a32 = 0;
        float a33 = 0;
        float a41 = 0;
        float a42 = 0;
        float a43 = 0;

        transform = new MlTransform(a11, a12, a13, a21, a22, a23, a31, a32, a33, a41, a42, a43);
        assertTrue(transform.isZero());

        // Test constructor with array initialization.
        float a[][] = new float[4][3];
        a[0][0] = 0; a[0][1] = 0; a[0][2] = 0;
        a[1][0] = 0; a[1][1] = 0; a[1][2] = 0;
        a[2][0] = 0; a[2][1] = 0; a[2][2] = 0;
        a[3][0] = 0; a[3][1] = 0; a[3][2] = 0;

        transform = new MlTransform(a);
        assertTrue(transform.isZero());
    }

    @Test
    public void testIdentity() throws Exception {
        // Test default constructor.
        MlTransform transform = new MlTransform();
        assertTrue(transform.isZero());

        transform.makeIdentity();
        assertTrue(transform.isIdentity());

        assertEquals(1.0, transform.m_matrix[0][0], 0.0);
        assertEquals(0.0, transform.m_matrix[0][1], 0.0);
        assertEquals(0.0, transform.m_matrix[0][2], 0.0);
        assertEquals(0.0, transform.m_matrix[1][0], 0.0);
        assertEquals(1.0, transform.m_matrix[1][1], 0.0);
        assertEquals(0.0, transform.m_matrix[1][2], 0.0);
        assertEquals(0.0, transform.m_matrix[2][0], 0.0);
        assertEquals(0.0, transform.m_matrix[2][1], 0.0);
        assertEquals(1.0, transform.m_matrix[2][2], 0.0);
        assertEquals(0.0, transform.m_matrix[3][0], 0.0);
        assertEquals(0.0, transform.m_matrix[3][1], 0.0);
        assertEquals(0.0, transform.m_matrix[3][2], 0.0);

        transform = MlTransform.identity();
        assertTrue(transform.isIdentity());
    }

    @Test
    public void testDeterminant() throws Exception {
        // Test default constructor.
        MlTransform transform = MlTransform.identity();
        assertTrue(transform.isIdentity());
;
        float v = transform.determinant();
        assertEquals(1.0, v, 0.0);

        float a[][] = new float[4][3];
        a[0][0] = 6; a[0][1] = 1; a[0][2] = 1;
        a[1][0] = 4; a[1][1] = -2; a[1][2] = 5;
        a[2][0] = 2; a[2][1] = 8; a[2][2] = 7;
        a[3][0] = 0; a[3][1] = 0; a[3][2] = 0;

        transform.setValue(a);
        v = transform.determinant();
        assertEquals(-306.0, v, 0.0);
    }

    @Test
    public void testUniformScale() throws Exception {
        // Test default constructor.
        MlTransform transform = MlTransform.identity();
        assertTrue(transform.isIdentity());

        float s = 5;
        transform.setScale(s);

        assertEquals(5.0, transform.m_matrix[0][0], 0.0);
        assertEquals(0.0, transform.m_matrix[0][1], 0.0);
        assertEquals(0.0, transform.m_matrix[0][2], 0.0);
        assertEquals(0.0, transform.m_matrix[1][0], 0.0);
        assertEquals(5.0, transform.m_matrix[1][1], 0.0);
        assertEquals(0.0, transform.m_matrix[1][2], 0.0);
        assertEquals(0.0, transform.m_matrix[2][0], 0.0);
        assertEquals(0.0, transform.m_matrix[2][1], 0.0);
        assertEquals(5.0, transform.m_matrix[2][2], 0.0);
        assertEquals(0.0, transform.m_matrix[3][0], 0.0);
        assertEquals(0.0, transform.m_matrix[3][1], 0.0);
        assertEquals(0.0, transform.m_matrix[3][2], 0.0);
    }

    @Test
    public void testNonUniformScale() throws Exception {
        // Test default constructor.
        MlTransform transform = MlTransform.identity();
        assertTrue(transform.isIdentity());

        MlVector3 s = new MlVector3();
        s.m_vector[0] = 2;
        s.m_vector[1] = 4;
        s.m_vector[2] = 8;
        transform.setScale(s);

        assertEquals(2.0, transform.m_matrix[0][0], 0.0);
        assertEquals(0.0, transform.m_matrix[0][1], 0.0);
        assertEquals(0.0, transform.m_matrix[0][2], 0.0);
        assertEquals(0.0, transform.m_matrix[1][0], 0.0);
        assertEquals(4.0, transform.m_matrix[1][1], 0.0);
        assertEquals(0.0, transform.m_matrix[1][2], 0.0);
        assertEquals(0.0, transform.m_matrix[2][0], 0.0);
        assertEquals(0.0, transform.m_matrix[2][1], 0.0);
        assertEquals(8.0, transform.m_matrix[2][2], 0.0);
        assertEquals(0.0, transform.m_matrix[3][0], 0.0);
        assertEquals(0.0, transform.m_matrix[3][1], 0.0);
        assertEquals(0.0, transform.m_matrix[3][2], 0.0);
    }

    @Test
    public void testSetScaleOnly() throws Exception {
        // Initialize the transform.
        float a[][] = new float[4][3];
        a[0][0] = 6; a[0][1] = 1; a[0][2] = 1;
        a[1][0] = 4; a[1][1] = -2; a[1][2] = 5;
        a[2][0] = 2; a[2][1] = 8; a[2][2] = 7;
        a[3][0] = 0; a[3][1] = 0; a[3][2] = 0;

        MlTransform transform = new MlTransform(a);

        // Set only the nonuniform scale values, not touching translation and rotation.
        MlVector3 s = new MlVector3();
        s.m_vector[0] = 2;
        s.m_vector[1] = 4;
        s.m_vector[2] = 8;
        transform.setScaleOnly(s);

        assertEquals(1.6760088205337524, transform.m_matrix[0][0], 0.0);
        assertEquals(-0.9253019690513611, transform.m_matrix[0][1], 0.0);
        assertEquals(0.5786280632019043, transform.m_matrix[0][2], 0.0);
        assertEquals(2.053525686264038, transform.m_matrix[1][0], 0.0);
        assertEquals(1.9552825689315796, transform.m_matrix[1][1], 0.0);
        assertEquals(-2.8213295936584473, transform.m_matrix[1][2], 0.0);
        assertEquals(1.4792004823684692, transform.m_matrix[2][0], 0.0);
        assertEquals(5.916801452636719, transform.m_matrix[2][1], 0.0);
        assertEquals(5.1772027015686035, transform.m_matrix[2][2], 0.0);
        assertEquals(0, transform.m_matrix[3][0], 0.0);
        assertEquals(0, transform.m_matrix[3][1], 0.0);
        assertEquals(0, transform.m_matrix[3][2], 0.0);

        // Check whether extracted nonuniform scale values are the same as the one set above.
        MlVector3 result = new MlVector3();
        transform.getScale(result);

        assertEquals(2, result.m_vector[0], 0.000001);
        assertEquals(4, result.m_vector[1], 0.000001);
        assertEquals(8, result.m_vector[2], 0.000001);
    }

    @Test
    public void testSetTranslation() throws Exception {
        MlTransform t = MlTransform.identity();

        // Set only the translation values, not touching scale and rotation.
        MlVector3 v = new MlVector3();
        v.m_vector[0] = -1;   // Translate along x.
        v.m_vector[1] = -25;  // Translate along y.
        v.m_vector[2] = 50;   // Translate along z
        t.setTranslation(v);

        assertEquals(1, t.m_matrix[0][0], 0);
        assertEquals(0, t.m_matrix[0][1], 0);
        assertEquals(0, t.m_matrix[0][2], 0);
        assertEquals(0, t.m_matrix[1][0], 0);
        assertEquals(1, t.m_matrix[1][1], 0);
        assertEquals(0, t.m_matrix[1][2], 0);
        assertEquals(0, t.m_matrix[2][0], 0);
        assertEquals(0, t.m_matrix[2][1], 0);
        assertEquals(1, t.m_matrix[2][2], 0);
        assertEquals(-1, t.m_matrix[3][0], 0);
        assertEquals(-25, t.m_matrix[3][1], 0);
        assertEquals(50, t.m_matrix[3][2], 0);

        // Check whether extracted translation values are the same as the one set above.
        MlVector3 result = new MlVector3();
        t.getTranslation(result);

        assertEquals(-1, result.m_vector[0], 0);
        assertEquals(-25, result.m_vector[1], 0);
        assertEquals(50, result.m_vector[2], 0);
    }

    @Test
    public void testSetTranslationOnly() throws Exception {
        float a[][] = new float[4][3];
        a[0][0] = 6; a[0][1] = 1; a[0][2] = 1;
        a[1][0] = 4; a[1][1] = -2; a[1][2] = 5;
        a[2][0] = 2; a[2][1] = 8; a[2][2] = 7;
        a[3][0] = 0; a[3][1] = 0; a[3][2] = 0;

        MlTransform t = new MlTransform(a);

        // Set only the translation values, not touching scale and rotation.
        MlVector3 v = new MlVector3();
        v.m_vector[0] = -1;   // Translate along x
        v.m_vector[1] = -25;  // Translate along y
        v.m_vector[2] = 50;   // Translate along z
        t.setTranslationOnly(v);

        assertEquals(6, t.m_matrix[0][0], 0);
        assertEquals(1, t.m_matrix[0][1], 0);
        assertEquals(1, t.m_matrix[0][2], 0);
        assertEquals(4, t.m_matrix[1][0], 0);
        assertEquals(-2, t.m_matrix[1][1], 0);
        assertEquals(5, t.m_matrix[1][2], 0);
        assertEquals(2, t.m_matrix[2][0], 0);
        assertEquals(8, t.m_matrix[2][1], 0);
        assertEquals(7, t.m_matrix[2][2], 0);
        assertEquals(-1, t.m_matrix[3][0], 0);
        assertEquals(-25, t.m_matrix[3][1], 0);
        assertEquals(50, t.m_matrix[3][2], 0);

        // Check whether extracted translation values are the same as the one set above.
        MlVector3 result = new MlVector3();
        t.getTranslation(result);

        assertEquals(-1, result.m_vector[0], 0);
        assertEquals(-25, result.m_vector[1], 0);
        assertEquals(50, result.m_vector[2], 0);
    }

    @Test
    public void testSetRotationOnly() throws Exception {
        MlTransform t = MlTransform.identity();

        // Set only the rotation values, not touching scale and translation.
        MlVector3 v = new MlVector3();
        v.m_vector[0] = 10;  // Rotate 10 degrees around the x axis.
        v.m_vector[1] = 10;  // Rotate 10 degrees around the y axis.
        v.m_vector[2] = 10;  // Rotate 10 degrees around the z axis.
        t.setRotationOnly(v);

        assertEquals(0.969846248626709, t.m_matrix[0][0], 0);
        assertEquals(0.2007056623697281, t.m_matrix[0][1], 0);
        assertEquals(-0.13825835287570953, t.m_matrix[0][2], 0);
        assertEquals(-0.1710100769996643, t.m_matrix[1][0], 0);
        assertEquals(0.9646100997924805, t.m_matrix[1][1], 0);
        assertEquals(0.20070567727088928, t.m_matrix[1][2], 0);
        assertEquals(0.1736481934785843, t.m_matrix[2][0], 0);
        assertEquals(-0.1710100769996643, t.m_matrix[2][1], 0);
        assertEquals(0.969846248626709, t.m_matrix[2][2], 0);
        assertEquals(0, t.m_matrix[3][0], 0);
        assertEquals(0, t.m_matrix[3][1], 0);
        assertEquals(0, t.m_matrix[3][2], 0);

        // Check whether extracted nonuniform scale values are the same as the one set above.
        MlVector3 result = new MlVector3();
        t.getScale(result);

        assertEquals(1, result.m_vector[0], 0.000001);
        assertEquals(1, result.m_vector[1], 0.000001);
        assertEquals(1, result.m_vector[2], 0.000001);

        // Check whether extracted translation values are the same as the one set above.
        t.getTranslation(result);

        assertEquals(0, result.m_vector[0], 0.000001);
        assertEquals(0, result.m_vector[1], 0.000001);
        assertEquals(0, result.m_vector[2], 0.000001);

        // Check whether extracted translation values are the same as the one set above.
        t.getRotation(result);

        assertEquals(10, result.m_vector[0], 0.000001);
        assertEquals(10, result.m_vector[1], 0.000001);
        assertEquals(10, result.m_vector[2], 0.000001);
    }

    @Test
    public void testSetRotation() throws Exception {
        MlTransform t = new MlTransform(0,0,0,0,0,0,0,0,0,0,0,0);

        MlRotation rot = new MlRotation();
        MlVector3 axis = new MlVector3(1, 1, 1);
        float angle = MlAngle.angleToRadians(10);
        rot.setValue(axis, angle);

        t.setRotation(rot);

        assertEquals(1, t.m_matrix[0][0],0);
        assertEquals(1.560076611895056E-6, t.m_matrix[0][1],0);
        assertEquals(-1.560074110784626E-6, t.m_matrix[0][2],0);
        assertEquals(-1.560074110784626E-6, t.m_matrix[1][0],0);
        assertEquals(1, t.m_matrix[1][1],0);
        assertEquals(1.560076611895056E-6, t.m_matrix[1][2],0);
        assertEquals(1.560076611895056E-6, t.m_matrix[2][0],0);
        assertEquals(-1.560074110784626E-6, t.m_matrix[2][1],0);
        assertEquals(1, t.m_matrix[2][2],0);
        assertEquals(0, t.m_matrix[3][0],0);
        assertEquals(0, t.m_matrix[3][1],0);
        assertEquals(0, t.m_matrix[3][2],0);

        // Check whether extracted rotation values are the same as the one set above.
        MlVector3 rotation = new MlVector3();
        t.getRotation(rotation);

        assertEquals(8.938566315919161E-5, rotation.m_vector[0], 0);
        assertEquals(8.938580140238628E-5, rotation.m_vector[1], 0);
        assertEquals(8.938566315919161E-5, rotation.m_vector[2], 0);
    }
}
