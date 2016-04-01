package com.wizzer.mle.math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class MlVector2UnitTest {
    @Test
    public void testConstructors() throws Exception {
        MlVector2 vector = new MlVector2();
        vector.m_vector[0] = (float) 1.0;
        vector.m_vector[1] = (float) 1.0;

        assertEquals(1.0, vector.m_vector[0], 0.0);
        assertEquals(1.0, vector.m_vector[1], 0.0);

        vector = new MlVector2((float) 2.0, (float) 2.0);

        assertEquals(2.0, vector.m_vector[0], 0.0);
        assertEquals(2.0, vector.m_vector[1], 0.0);

        float[] v = new float[2];
        v[0] = (float) 3.0;
        v[1] = (float) 3.0;
        vector = new MlVector2(v);

        assertEquals(3.0, vector.m_vector[0], 0.0);
        assertEquals(3.0, vector.m_vector[1], 0.0);

        MlVector2 vectorCopy = new MlVector2(vector);

        assertEquals(3.0, vectorCopy.m_vector[0], 0.0);
        assertEquals(3.0, vectorCopy.m_vector[1], 0.0);
    }

    @Test
    public void testIsZero() throws Exception {
        MlVector2 vector = new MlVector2();

        assertTrue(vector.isZero());

        vector.m_vector[0] = (float)1.0;

        assertFalse(vector.isZero());
    }

    @Test
    public void testDotProduct() throws Exception {
        MlVector2 vector1 = new MlVector2();
        MlVector2 vector2 = new MlVector2((float)1.0, (float)1.0);

        assertEquals(0.0, vector1.dot(vector2), 0.0);

        vector1.m_vector[0] = 1;
        vector1.m_vector[1] = 1;

        assertEquals(2.0, vector1.dot(vector2), 0.0);

        vector1.m_vector[0] = 2;
        vector1.m_vector[1] = 2;

        assertEquals(4.0, vector1.dot(vector2), 0.0);

        vector2.m_vector[0] = 3;
        vector2.m_vector[1] = 3;

        assertEquals(12.0, vector1.dot(vector2), 0.0);
    }
}
