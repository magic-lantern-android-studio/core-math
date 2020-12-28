/*
 * MlTransform.java
 * Created on Dec 1, 2004
 */

// COPYRIGHT_BEGIN
//
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

// Declare package.
package com.wizzer.mle.math;

/**
 * This class implements a 4x3 affine matrix of floating-point elements.
 */
public class MlTransform
{
    // The internal matrix.
    public float[][] mMatrix = new float[4][3];
    
    /**
     * The default constructor.
     */
    public MlTransform()
    {
        super();
        setZero();
    }

    /**
     * A constructor given all 12 elements in row-major order.
     * 
     * @param a11 Element for row 0, column 0.
     * @param a12 Element for row 0, column 1.
     * @param a13 Element for row 0, column 2.
     * @param a21 Element for row 1, column 0.
     * @param a22 Element for row 1, column 1.
     * @param a23 Element for row 1, column 2.
     * @param a31 Element for row 2, column 0.
     * @param a32 Element for row 2, column 1.
     * @param a33 Element for row 2, column 2.
     * @param a41 Element for row 3, column 0.
     * @param a42 Element for row 3, column 1.
     * @param a43 Element for row 3, column 2.
     */
    public MlTransform(
        float a11, float a12, float a13,
    	float a21, float a22, float a23,  
    	float a31, float a32, float a33,  
    	float a41, float a42, float a43)
    {
        super();
        mMatrix[0][0] = a11; mMatrix[0][1] = a12; mMatrix[0][2] = a13;
        mMatrix[1][0] = a21; mMatrix[1][1] = a22; mMatrix[1][2] = a23;
        mMatrix[2][0] = a31; mMatrix[2][1] = a32; mMatrix[2][2] = a33;
        mMatrix[3][0] = a41; mMatrix[3][1] = a42; mMatrix[3][2] = a43;
    }

    /**
     * A constructor given an array of 4x3 floating-point
     * values.
     * 
     * @param m The array of elements.
     */
    public MlTransform(float m[][])
    {
        super();
        setValue(m);
    }

    /**
     * Set the value of the transform based on an array of
     * 4 x 3 floating-point values.
     * 
     * @param m The array of elements to set.
     */
    public final void setValue(float m[][])
    {
        mMatrix[0][0] = m[0][0]; mMatrix[0][1] = m[0][1]; mMatrix[0][2] = m[0][2];
        mMatrix[1][0] = m[1][0]; mMatrix[1][1] = m[1][1]; mMatrix[1][2] = m[1][2];
        mMatrix[2][0] = m[2][0]; mMatrix[2][1] = m[2][1]; mMatrix[2][2] = m[2][2];
        mMatrix[3][0] = m[3][0]; mMatrix[3][1] = m[3][1]; mMatrix[3][2] = m[3][2];
    }
    
    /**
     * Set the value of the transform based on the specified <code>MlTransform</code>.
     * 
     * @param m The tranform to use to set <b>this</b>'s value.
     */
    public final void setValue(MlTransform m)
    {
        mMatrix[0][0] = m.mMatrix[0][0]; mMatrix[0][1] = m.mMatrix[0][1]; mMatrix[0][2] = m.mMatrix[0][2];
        mMatrix[1][0] = m.mMatrix[1][0]; mMatrix[1][1] = m.mMatrix[1][1]; mMatrix[1][2] = m.mMatrix[1][2];
        mMatrix[2][0] = m.mMatrix[2][0]; mMatrix[2][1] = m.mMatrix[2][1]; mMatrix[2][2] = m.mMatrix[2][2];
        mMatrix[3][0] = m.mMatrix[3][0]; mMatrix[3][1] = m.mMatrix[3][1]; mMatrix[3][2] = m.mMatrix[3][2];
    }
    
    /**
     * Get the value of the tranform.
     * 
     * @return The value is returned as an array of
     * 4 x 3 floating-point values.
     */
    public final float[][] getValue()
    {
        float[][] m = new float[4][3];
        m[0][0] = mMatrix[0][0]; m[0][1] = mMatrix[0][1]; m[0][2] = mMatrix[0][2];
        m[1][0] = mMatrix[1][0]; m[1][1] = mMatrix[1][1]; m[1][2] = mMatrix[1][2];
        m[2][0] = mMatrix[2][0]; m[2][1] = mMatrix[2][1]; m[2][2] = mMatrix[2][2];
        m[3][0] = mMatrix[3][0]; m[3][1] = mMatrix[3][1]; m[3][2] = mMatrix[3][2];
        return m;
    }
    
    /**
     * Sets matrix to be identity.
     */
    public final void makeIdentity()
    {
        mMatrix[0][0] = 1f; mMatrix[0][1] = 0f; mMatrix[0][2] = 0f;
        mMatrix[1][0] = 0f; mMatrix[1][1] = 1f; mMatrix[1][2] = 0f;
        mMatrix[2][0] = 0f; mMatrix[2][1] = 0f; mMatrix[2][2] = 1f;
        mMatrix[3][0] = 0f; mMatrix[3][1] = 0f; mMatrix[3][2] = 0f;
    }
    
    /**
     * Create an identity transform.
     * 
     * @return Returns an identity matrix.
     */
    static public final MlTransform identity()
    {
        MlTransform trans = new MlTransform();
        trans.makeIdentity();
        return trans;
    }
    
    // Check matrix m for identity.
    private boolean checkIdentity(float[][] m)
    {
        if ((m[0][0] == 1) && (m[0][1] == 0) && (m[0][2] == 0) &&
            (m[1][0] == 0) && (m[1][1] == 1) && (m[1][2] == 0) &&
            (m[2][0] == 0) && (m[2][1] == 0) && (m[2][2] == 1) &&
            (m[3][0] == 0) && (m[3][1] == 0) && (m[3][2] == 0))
            return true;
        else
            return false;    
    }
    
    /**
     * Returns whether matrix is identity.
     * 
     * @return <b>true</b> is returned if <b>this</b> is an identity
     * matrix. Otherwise, <b>false</b> will be returned.
     */
    public final boolean isIdentity()
    {
        return checkIdentity(mMatrix);
    }
    
    /**
     * Set all components to zero.
     */
    public final void setZero()
    {
        mMatrix[0][0] = 0f; mMatrix[0][1] = 0f; mMatrix[0][2] = 0f;
        mMatrix[1][0] = 0f; mMatrix[1][1] = 0f; mMatrix[1][2] = 0f;
        mMatrix[2][0] = 0f; mMatrix[2][1] = 0f; mMatrix[2][2] = 0f;
        mMatrix[3][0] = 0f; mMatrix[3][1] = 0f; mMatrix[3][2] = 0f;
    }
    
    /**
     * Returns whether matrix is all zeros.
     * 
     * @return <b>true</b> is returned if <b>this</b> is a zero-ed out
     * matrix. Otherwise, <b>false</b> will be returned.
     */
    public final boolean isZero()
    {
        if ((mMatrix[0][0] == 0) && (mMatrix[0][1] == 0) && (mMatrix[0][2] == 0) &&
            (mMatrix[1][0] == 0) && (mMatrix[1][1] == 0) && (mMatrix[1][2] == 0) &&
            (mMatrix[2][0] == 0) && (mMatrix[2][1] == 0) && (mMatrix[2][2] == 0) &&
            (mMatrix[3][0] == 0) && (mMatrix[3][1] == 0) && (mMatrix[3][2] == 0))
            return true;
        else
            return false;
    }
    
    // Returns determinant of 3x3 submatrix composed of given row indices (0-3).
    private float det3(int r1, int r2, int r3)
    {
        return (((mMatrix[r1][0] * mMatrix[r2][1]) * mMatrix[r3][2])
             +  ((mMatrix[r1][1] * mMatrix[r2][2]) * mMatrix[r3][0])
             +  ((mMatrix[r1][2] * mMatrix[r2][0]) * mMatrix[r3][1])
             -  ((mMatrix[r1][0] * mMatrix[r2][2]) * mMatrix[r3][1])
             -  ((mMatrix[r1][1] * mMatrix[r2][0]) * mMatrix[r3][2])
             -  ((mMatrix[r1][2] * mMatrix[r2][1]) * mMatrix[r3][0]));
    }
    
    /**
     * Returns determinant of upper-left 3x3 matrix.
     * 
     * @return The dterminant is returned.
     */ 
    public final float determinant()
    {
        return (det3(0, 1, 2));
    }

    /**
     * Factors a matrix m into 5 pieces: m = r s r^ u t, where r^
     * means transpose of r, and r and u are rotations, s is a scale,
     * and t is a translation. Any projection information is returned
     * in proj.
     * 
     * @param r The rotation of the transform.
     * @param s The scale of the transform.
     * @param u The rotation of the transform.
     * @param t The translation of the transform.
     * @param proj The projection of the transform.
     * 
     * @return <b>true</b> is returned if <b>this</b> tranform was successfully
     * factored. Otherwise <b>false<>/b will be returned upon failer.
     */
    public final boolean factor(MlTransform r, MlVector3 s, MlTransform u,
	       MlVector3 t, MlTransform proj)
    {
        /*
         * Variable declarations from the original source:
         *
         * n    : order of matrix A
         * eivec: true if eigenvectors are desired, false otherwise.
         * a    : Array [1:n, 1:n] of numbers, assumed symmetric!
         *
         * a    : Superdiagonal elements of the original array a are destroyed.
         *        Diagonal and subdiagonal elements are untouched.
         * d    : Array [1:n] of eigenvalues of a.
         * v    : Array [1:n, 1:n] containing (if eivec = TRUE), the eigenvectors of
         *        a, with the kth column being the normalized eigenvector with
         *        eigenvalue d[k].
         * rot  : The number of jacobi rotations required to perform the operation.
         */
        float       det;        /* Determinant of matrix A */
        float       det_sign;   /* -1 if det < 0, 1 if det > 0 */
        float       scratch;
        int         i, j;
        int[]       junk = new int[0];
        MlTransform a = new MlTransform();
        MlTransform b = new MlTransform();
        MlTransform si = new MlTransform();
        float[]     evalues = new float[3];
        MlVector3[] evectors = new MlVector3[3];
        
        a.setValue(this);
        proj.makeIdentity();
        scratch = MlScalar.ML_SCALAR_ONE;
        
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 3; j++)
            {
                a.mMatrix[i][j] = a.mMatrix[i][j] * scratch;
            }
            t.mVector[i] = (mMatrix[3][i] * scratch);
            a.mMatrix[3][i] = MlScalar.ML_SCALAR_ZERO;
        }
        
        /* (3) Compute det A. If negative, set sign = -1, else sign = 1 */
        det = a.determinant();
        det_sign = (det < MlScalar.ML_SCALAR_ZERO ? -MlScalar.ML_SCALAR_ONE : MlScalar.ML_SCALAR_ONE);
        if ((det_sign * det) < 1e-12)
            return false;  // Singular.
        
        /* (4) B = A * A^  (here A^ means A transpose) */
        b.setValue(a.mul(a.transpose()));
        
        b.jacobi3(evalues, evectors, junk);

        // Find min / max eigenvalues and do ratio test to determine singularity.
        
        r.setValue(new MlTransform(
            evectors[0].mVector[0], evectors[0].mVector[1], evectors[0].mVector[2],
        	evectors[1].mVector[0], evectors[1].mVector[1], evectors[1].mVector[2],
        	evectors[2].mVector[0], evectors[2].mVector[1], evectors[2].mVector[2],
        	MlScalar.ML_SCALAR_ZERO, MlScalar.ML_SCALAR_ZERO, MlScalar.ML_SCALAR_ZERO));
        
        /* Compute s = sqrt(evalues), with sign. Set si = s-inverse */
        si.makeIdentity();
        for (i = 0; i < 3; i++)
        {
            s.mVector[i] = (det_sign * (float)Math.sqrt(evalues[i]));
            si.mMatrix[i][i] = (1 / s.mVector[i]);
        }
        
        /* (5) Compute U = R^ S! R A. */
        //u.setValue(r.mul(si.mul(r.transpose().mul(a))));
        u.setValue(((r.mul(si)).mul(r.transpose()).mul(a)));
        
        return true;
    }

	// Diagonalizes 3x3 matrix. See comment for factor().
    private void jacobi3(float evalues[], MlVector3 evectors[], int[] rots)
    {
		float     sm;                // smallest entry
		float     theta;             // angle for Jacobi rotation
		float     c, s, t;           // cosine, sine, tangent of theta
		float     tau;               // sine / (1 + cos)
		float     h, g;              // two scrap values
		float     thresh;            // threshold below which no rotation done
		float[]   b = new float[3];  // more scratch
		float[]   z = new float[3];  // more scratch
		int       p, q, i, j;
		float[][] a = new float[3][3];
		
		// Initializations.
		for (i = 0; i < 3; i++)
		{
		  b[i] = evalues[i] = mMatrix[i][i];
		  z[i] = MlScalar.ML_SCALAR_ZERO;
		  for (j = 0; j < 3; j++) {
		      evectors[i].mVector[j] = (i == j) ? MlScalar.ML_SCALAR_ONE : MlScalar.ML_SCALAR_ZERO;
		      a[i][j] = mMatrix[i][j];
		  }
		}
		
		rots[0] = 0;
		
		// Why 50? I don't know--it's the way the folks who wrote the
		// algorithm did it:
		for (i = 0; i < 50; i++)
		{
		  sm = MlScalar.ML_SCALAR_ZERO;
		  for (p = 0; p < 3 - 1; p++)
		      for (q = p+1; q < 3; q++)
		          sm += Math.abs(a[p][q]);
		
		  if (sm == MlScalar.ML_SCALAR_ZERO)
		      return;
		
		  thresh = (i < 3 ?
		            (sm * 0.022222222222f ) :
		            MlScalar.ML_SCALAR_ZERO);
		
		  for (p = 0; p < 3 - 1; p++)
		  {
		      for (q = p+1; q < 3; q++)
		      {
		  
		          g = (float)(100.0 * (Math.abs(a[p][q])));
		  
		          if (i > 3 && (Math.abs(evalues[p]) + g == Math.abs(evalues[p])) &&
		                       (Math.abs(evalues[q]) + g == Math.abs(evalues[q])))
		              a[p][q] = MlScalar.ML_SCALAR_ZERO;
		  
		          else if (Math.abs(a[p][q]) > thresh)
		          {
		              h = evalues[q] - evalues[p];
		      
		              if (Math.abs(h) + g == Math.abs(h))
		                  t = (a[p][q] / h);
		              else {
		                  theta = (MlScalar.ML_SCALAR_HALF * h / a[p][q]);
		                  t = (float)(1 / (Math.abs(theta) + Math.sqrt(MlScalar.ML_SCALAR_ONE + (theta * theta))));
		                  if (theta < MlScalar.ML_SCALAR_ZERO)  t = -t;
		              }
		              // End of computing tangent of rotation angle
		      
		              c = (float)(1 / (Math.sqrt(MlScalar.ML_SCALAR_ONE + (t * t))));
		              s = (t * c);
		              tau = (s / (MlScalar.ML_SCALAR_ONE + c));
		              h = (t * a[p][q]);
		              z[p]    -= h;
		              z[q]    += h;
		              evalues[p] -= h;
		              evalues[q] += h;
		              a[p][q] = MlScalar.ML_SCALAR_ZERO;
		      
		              for (j = 0; j < p; j++)
		              {
		                  g = a[j][p];
		                  h = a[j][q];
		                  a[j][p] = g - (s * (h + (g * tau)));
		                  a[j][q] = h + (s * (g - (h * tau)));
		              }
		      
		              for (j = p+1; j < q; j++)
		              {
		                  g = a[p][j];
		                  h = a[j][q];
		                  a[p][j] = g - (s * (h + (g * tau)));
		                  a[j][q] = h + (s * (g - (h * tau)));
		              }
		      
		              for (j = q+1; j < 3; j++)
		              {
		                  g = a[p][j];
		                  h = a[q][j];
		                  a[p][j] = g - (s * (h + (g * tau)));
		                  a[q][j] = h + (s * (g - (h * tau)));
		              }
		      
		              for (j = 0; j < 3; j++)
		              {
		                  g = evectors[j].mVector[p];
		                  h = evectors[j].mVector[q];
		                  evectors[j].mVector[p] = g - (s * (h + (g * tau)));
		                  evectors[j].mVector[q] = h + (s * (g - (h * tau)));
		              }
		          }
		          rots[0]++;
		      }
		  }
		  
		  for (p = 0; p < 3; p++)
		  {
		      evalues[p] = b[p] += z[p];
		      z[p] = MlScalar.ML_SCALAR_ZERO;
		  }
		}
    }

	/**
	 * This method finds the inverse of an affine matrix.
	 * The last column MUST be [0 0 0 1] for this to work.
	 * This is taken from graphics gems 2, page 603
	 * 
	 * computes the inverse of a 3d affine matrix; i.e. a matrix with a 
	 * dimensionality of 4 where the right column has the entries (0,0,0,1).
	 * 
	 * This procedure treats the 4 by 4 matrix as a block matrix and calculates
	 * the inverse of one submatrix for a significant performance 
	 * improvement over a general procedure that can invert any nonsingular matrix.
	 * 
	 *               -1 
	 *    -1   |    |      |  -1    |
	 *   M   = |A  0|  =   | A     0|
	 *         |    |      |        |
	 *         |    |      |   -1   |
	 *         |C  1|      |-CA    1|
	 * 
	 * where   M is a 4 by 4 matrix,
	 *         A is the 3 by 3 upper left submatrix of M,
	 *         C is the 1 by 3 lower left submatrix of M.
	 * Input:
	 *    in - 3D affine matrix
	 * Output:
	 *    out - inverse of 3D affine matrix
	 * Returned Value:
	 *    inverse matrix if input matrix is nonsingular and affine
	 *    unchanged otherwise
	 * 
	 * @return A new tranform is returned.
	 */
    public final MlTransform inverse()
    {
	    // Trivial case
	    if (checkIdentity(mMatrix))
	        return MlTransform.identity();
	
	    float[][] result = new float[4][3];
	
	    // Calculate the determinant of submatrix A and determine if the matrix
	    // is singular as limited by the double precision floating 
	    // point data representation.
	
	    float det_1;
	    float pos, neg, temp;
	
	    pos = neg = MlScalar.ML_SCALAR_ZERO;
	    temp =  ((mMatrix[0][0] * mMatrix[1][1]) * mMatrix[2][2]);
		if (temp >= MlScalar.ML_SCALAR_ZERO) pos += temp;
		else neg += temp;
	
	    temp =  ((mMatrix[0][1] * mMatrix[1][2]) * mMatrix[2][0]);
		if (temp >= MlScalar.ML_SCALAR_ZERO) pos += temp;
		else neg += temp;

	    temp =  ((mMatrix[0][2] * mMatrix[1][0]) * mMatrix[2][1]);
		if (temp >= MlScalar.ML_SCALAR_ZERO) pos += temp;
		else neg += temp;

	    temp = -((mMatrix[0][2] * mMatrix[1][1]) * mMatrix[2][0]);
		if (temp >= MlScalar.ML_SCALAR_ZERO) pos += temp;
		else neg += temp;

	    temp = -((mMatrix[0][1] * mMatrix[1][0]) * mMatrix[2][2]);
		if (temp >= MlScalar.ML_SCALAR_ZERO) pos += temp;
		else neg += temp;

	    temp = -((mMatrix[0][0] * mMatrix[1][2]) * mMatrix[2][1]);
		if (temp >= MlScalar.ML_SCALAR_ZERO) pos += temp;
		else neg += temp;

	    det_1 = pos + neg;
	
	    // XXX - May want to make this a variable.
		float PRECISION_LIMIT = (float)1.0e-15;

	    // Is the submatrix A singular?
	    temp = det_1 / (pos - neg);
	    if (Math.abs(temp) < PRECISION_LIMIT)
	        return new MlTransform(mMatrix);

	    // Calculate inverse(A) = adj(A) / det(A)
	    det_1 = 1 / det_1;
	    result[0][0] =  ((mMatrix[1][1] * mMatrix[2][2]) - (mMatrix[1][2] * mMatrix[2][1]) * det_1);
	    result[1][0] = -((mMatrix[1][0] * mMatrix[2][2]) - (mMatrix[1][2] * mMatrix[2][0]) * det_1);
	    result[2][0] =  ((mMatrix[1][0] * mMatrix[2][1]) - (mMatrix[1][1] * mMatrix[2][0]) * det_1);
	    result[0][1] = -((mMatrix[0][1] * mMatrix[2][2]) - (mMatrix[0][2] * mMatrix[2][1]) * det_1);
	    result[1][1] =  ((mMatrix[0][0] * mMatrix[2][2]) - (mMatrix[0][2] * mMatrix[2][0]) * det_1);
	    result[2][1] = -((mMatrix[0][0] * mMatrix[2][1]) - (mMatrix[0][1] * mMatrix[2][0]) * det_1);
	    result[0][2] =  ((mMatrix[0][1] * mMatrix[1][2]) - (mMatrix[0][2] * mMatrix[1][1]) * det_1);
	    result[1][2] = -((mMatrix[0][0] * mMatrix[1][2]) - (mMatrix[0][2] * mMatrix[1][0]) * det_1);
	    result[2][2] =  ((mMatrix[0][0] * mMatrix[1][1]) - (mMatrix[0][1] * mMatrix[1][0]) * det_1);
	
	    // Calculate -C * inverse(A)
	    result[3][0] = -( (mMatrix[3][0] * result[0][0]) +
	                      (mMatrix[3][1] * result[1][0]) +
	                      (mMatrix[3][2] * result[2][0]) );
	    result[3][1] = -( (mMatrix[3][0] * result[0][1]) +
	                      (mMatrix[3][1] * result[1][1]) +
	                      (mMatrix[3][2] * result[2][1]) );
	    result[3][2] = -( (mMatrix[3][0] * result[0][2]) +
	                      (mMatrix[3][1] * result[1][2]) +
	                      (mMatrix[3][2] * result[2][2]) );
	
	    return new MlTransform(result);
	}
    
    // Returns transpose of matrix
    public final MlTransform transpose()
    {
        return new MlTransform(
                mMatrix[0][0], mMatrix[1][0], mMatrix[2][0],
                mMatrix[0][1], mMatrix[1][1], mMatrix[2][1],
                mMatrix[0][2], mMatrix[1][2], mMatrix[2][2],
                0f, 0f, 0f);
    }
    
    //  Multiplies matrix by given matrix on right. this = this * trans.
    public final MlTransform mulRight(MlTransform trans)
    {
        // Trivial cases.
        if (checkIdentity(trans.mMatrix))
            return this;
        else if (checkIdentity(mMatrix))
        {
            setValue(trans.mMatrix);
            return this;
        }
        
        float[][] tmp = new float[4][3];
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp[i][j] = ((mMatrix[i][0] * trans.mMatrix[0][j]) +
                             (mMatrix[i][1] * trans.mMatrix[1][j]) +
                             (mMatrix[i][2] * trans.mMatrix[2][j]));
        
        for (int i = 0; i < 3; i++)
            tmp[3][i] = ((mMatrix[3][0] * trans.mMatrix[0][i]) +
                         (mMatrix[3][1] * trans.mMatrix[1][i]) +
                         (mMatrix[3][2] * trans.mMatrix[2][i]) +
                         trans.mMatrix[3][i]);

        // Save calculated value.
        setValue(tmp);
        
        return this;
    }
    
    //  Multiplies matrix by given matrix on left. this = trans * this.
    public final MlTransform mulLeft(MlTransform trans)
    {
        // Trivial cases.
        if (checkIdentity(trans.mMatrix))
            return this;
        else if (checkIdentity(mMatrix))
        {
            setValue(trans.mMatrix);
            return this;
        }
        
        float[][] tmp = new float[4][3];
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp[i][j] = ((trans.mMatrix[i][0] * mMatrix[0][j]) +
                             (trans.mMatrix[i][1] * mMatrix[1][j]) +
                             (trans.mMatrix[i][2] * mMatrix[2][j]));
        
        for (int i = 0; i < 3; i++)
            tmp[3][i] = ((trans.mMatrix[3][0] * mMatrix[0][i]) +
                         (trans.mMatrix[3][1] * mMatrix[1][i]) +
                         (trans.mMatrix[3][2] * mMatrix[2][i]) +
                         mMatrix[3][i]);

        // Save calculated value.
        setValue(tmp);
        
        return this;
    }
    
    // Multiplies matrix by given column vector, giving vector result
    public final void mulMatrixVec(MlVector3 src, MlVector3 dst)
    {
        float x,y,z;
        
        float[] v = new float[3];
        src.getValue(v);
        
        x = (mMatrix[0][0] * v[0]) + (mMatrix[0][1] * v[1]) +
        	(mMatrix[0][2] * v[2]);
        y = (mMatrix[1][0] * v[0]) + (mMatrix[1][1] * v[1]) +
    		(mMatrix[1][2] * v[2]);
        z = (mMatrix[2][0] * v[0]) + (mMatrix[2][1] * v[1]) +
    		(mMatrix[2][2] * v[2]);

        dst.setValue(x,y,z);
    }
    
    // Multiplies given row vector by matrix, giving vector result
    public final void mulVecMatrix(MlVector3 src, MlVector3 dst)
    {
        float x,y,z;
        
        float[] v = new float[3];
        src.getValue(v);
        
        x = (v[0] * mMatrix[0][0]) + (v[1] * mMatrix[1][0]) +
            (v[2] * mMatrix[2][0]) + mMatrix[3][0];
        y = (v[0] * mMatrix[0][1]) + (v[1] * mMatrix[1][1]) +
        	(v[2] * mMatrix[2][1]) + mMatrix[3][1];
        z = (v[0] * mMatrix[0][2]) + (v[1] * mMatrix[1][2]) +
        	(v[2] * mMatrix[2][2]) + mMatrix[3][2];

        dst.setValue(x,y,z);
    }
    
    // Multiplies given row vector by matrix, giving vector result
    // src is assumed to be a direction vector, so translation part of
    // matrix is ignored.
    public final void mulDirMatrix(MlVector3 src, MlVector3 dst)
    {
        float x,y,z;
        
        float[] v = new float[3];
        src.getValue(v);
        
        x = (v[0] * mMatrix[0][0]) + (v[1] * mMatrix[1][0]) +
        	(v[2] * mMatrix[2][0]);
        y = (v[0] * mMatrix[0][1]) + (v[1] * mMatrix[1][1]) +
    		(v[2] * mMatrix[2][1]);
        z = (v[0] * mMatrix[0][2]) + (v[1] * mMatrix[1][2]) +
    		(v[2] * mMatrix[2][2]);

        dst.setValue(x,y,z);
    }
    
    public final MlTransform mul(MlTransform m)
    {
        return mulRight(m);
    }
    
    public final MlTransform mul(MlTransform left, MlTransform right)
    {
        MlTransform m = new MlTransform();
        m.setValue(left);
        m.mul(right);
        return m;
    }

    // Equality comparison within given tolerance, for each component
    public final boolean equals(MlTransform trans, float tolerance)
    {
        int i, j;
        float d;

        for (i = 0; i < 4; i++)
            for (j = 0; j < 3; j++)
            {
                d = mMatrix[i][j] - trans.mMatrix[i][j];
                if (Math.abs(d) > tolerance)
                    return false;
            }

        return true;
    }

    // Decomposes the matrix into a translation, rotation, scale,
    // and scale orientation.  Any projection information is discarded.
    // The decomposition depends upon choice of center point for
    // rotation and scaling, which is optional as the last parameter.
    // Note that if the center is 0, decompose() is the same as
    // factor() where "t" is translation, "u" is rotation, "s" is scaleFactor,
    // and "r" is ScaleOrientattion.
    public final void getTransform(MlVector3 translation,
		      MlRotation rotation,
		      MlVector3 scaleFactor,
		      MlRotation scaleOrientation,
		      MlVector3 center)
    {
        MlTransform so = new MlTransform();
        MlTransform rot = new MlTransform();
        MlTransform proj = new MlTransform();
        if (! center.equals(new MlVector3(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO)))
        {
	        // To get fields for a non-0 center, we
	        // need to decompose a new matrix "m" such
	        // that [-center][m][center] = [this]
	        // i.e., [m] = [center][this][-center]
            MlTransform m = new MlTransform();
            MlTransform c = new MlTransform();
            m.setTranslation(center.unaryNegate());
            m.mulLeft(this);
            c.setTranslation(center);
            m.mulLeft(c);
            m.factor(so,scaleFactor,rot,translation,proj);
        } else
            factor(so,scaleFactor,rot,translation,proj);

        // Have to transpose because factor 
        // gives us transpose of correct answer.
        scaleOrientation.setValue(so.transpose());

        rotation.setValue(rot);
    }
    
    public final void getTransform(MlVector3 t, MlRotation r,
		      MlVector3 s, MlRotation so)
	{
        getTransform(t, r, s, so, new MlVector3(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO));
    }

    // Sets the given transform to the matrix constructed from the given 
    // translation, fixed rotation, and scale vectors
    // Note: Uses scale - rotate - translate order with rotation order Z-Y-X
    public final void setTransform(MlVector3 translation, MlVector3 rotation, 
		MlVector3 scale)
    {
        float [] t = new float[3];
        translation.getValue(t);
        float [] r = new float[3];
        rotation.getValue(r);
        float [] s = new float[3];
        scale.getValue(s);
        setTransform(t,r,s);
    }
    
    private void setTransform(float[] translation, float[] rotation, float[] scale)
    {
        setScale(scale);
        applyRotation(rotation);
        setTranslationOnly(translation);
    }

	//  Sets the given transform to the matrix constructed from the given 
	//  translation, fixed angle rotation, and nonuniformScale*scale vectors
	//  Note: Uses scale - rotate - translate order with rotation order Z-Y-X
    public final void setTransform(MlVector3 translation,
    	MlVector3 rotation, MlVector3 nonuniformScale, float scale)
	{
        float [] t = new float[3];
        translation.getValue(t);
        float [] r = new float[3];
        rotation.getValue(r);
        float [] s = new float[3];
        nonuniformScale.getValue(s);

        float[] newScale = new float[3];
		for (int i = 0; i < 3; i++)
		    newScale[i] = (scale * s[i]);
		setTransform(t, r, newScale);
	}

	// Composes the matrix from translation, rotation, scale, etc.
    public final void setTransform(MlVector3 translation, MlRotation rotation,
        MlVector3 scaleFactor, MlRotation scaleOrientation, MlVector3 center)
	{
		//#define TRANSLATE(vec) m.setTranslation(vec), mulLeft(m)
		//#define ROTATE(rot)    rot.getValue(m), mulLeft(m)
		
		MlTransform m = new MlTransform();
		
		makeIdentity();
		
		if (! translation.equals(
		    new MlVector3(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO)))
		{
			m.setTranslation(translation);
			mulLeft(m);
		}
		
		if (! center.equals(
		    new MlVector3(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO)))
		{
			m.setTranslation(center);
			mulLeft(m);
		}
		
		if (! rotation.equals(
		    new MlRotation(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ONE)))
		{
			rotation.getValue(m);
			mulLeft(m);
		}
		
		if (! scaleFactor.equals(
		    new MlVector3(MlScalar.ML_SCALAR_ONE,MlScalar.ML_SCALAR_ONE,MlScalar.ML_SCALAR_ONE)))
		{
			MlRotation so = scaleOrientation;
			if (! so.equals(
			    new MlRotation(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ONE)))
			{
				so.getValue(m);
				mulLeft(m);
			}
			
			m.setScale(scaleFactor);
			mulLeft(m);
			
			if (! so.equals(
			    new MlRotation(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ONE)))
			{
				so.invert();
				so.getValue(m);
				mulLeft(m);
			}
		}

		if (! center.equals (
		    new MlVector3(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO)))
		{
			m.setTranslation(center.unaryNegate());
			mulLeft(m);
		}
	}
    
    public final void setTransform(MlVector3 t, MlRotation r, MlVector3 s)
    {
        setTransform(t, r, s,
		     new MlRotation(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ONE), 
		     new MlVector3(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO));
    }
    
	public final void setTransform(MlVector3 t, MlRotation r, MlVector3 s, MlRotation so)
    {
	    setTransform(t, r, s, so, new MlVector3(MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO,MlScalar.ML_SCALAR_ZERO));
	}

    /**
     * Get the nonuniform scales (x, y, z) of the transformation
     * as a vector of 3 components.
     *
     * @param scale The result is returned in this Vector.
     */
    public final void getScale(MlVector3 scale)
    {
        float[] s = new float[3];

        /*
        for (int i = 0; i < 3; i++)
        {
            s[i] = (mMatrix[i][0] * mMatrix[i][0]) +
                   (mMatrix[i][1] * mMatrix[i][1]) +
                   (mMatrix[i][2] * mMatrix[i][2]);
            s[i] = (float)Math.sqrt(s[i]);
        }
        */
        this.getScale(s);
            
        scale.setValue(s);
    }

    // Gets the X, Y, and Z nonuniform scales of the transformation
    /**
     * Get the nonuniform scales (x, y, z) of the transformation
     * as a array of 3 components.
     *
     * @param scale The result is returned in this array.
     */
    public final void getScale(float[] scale)
    {
        for (int i = 0; i < 3; i++)
        {
            scale[i] = (mMatrix[i][0] * mMatrix[i][0]) +
                       (mMatrix[i][1] * mMatrix[i][1]) +
                       (mMatrix[i][2] * mMatrix[i][2]);
            scale[i] = (float)Math.sqrt(scale[i]);
        }
    }

    // Sets matrix to scale by given uniform factor
    public final void setScale(float scale)
    {
        mMatrix[0][0] = scale; mMatrix[0][1] = 0f; mMatrix[0][2] = 0f;
        mMatrix[1][0] = 0f; mMatrix[1][1] = scale; mMatrix[1][2] = 0f;
        mMatrix[2][0] = 0f; mMatrix[2][1] = 0f; mMatrix[2][2] = scale;
        mMatrix[3][0] = 0f; mMatrix[3][1] = 0f; mMatrix[3][2] = 0f;
    }

    // Sets matrix to scale by given vector.
    public final void setScale(MlVector3 scale)
    {
        float[] v = new float[3];
        scale.getValue(v);
        setScale(v);
    }
    
    private void setScale(float[] v)
    {
        mMatrix[0][0] = v[0]; mMatrix[0][1] = 0f; mMatrix[0][2] = 0f;
        mMatrix[1][0] = 0f; mMatrix[1][1] = v[1]; mMatrix[1][2] = 0f;
        mMatrix[2][0] = 0f; mMatrix[2][1] = 0f; mMatrix[2][2] = v[2];
        mMatrix[3][0] = 0f; mMatrix[3][1] = 0f; mMatrix[3][2] = 0f;
    }

	//  Sets the scales of the given transform to the X,Y,Z nonuniform scales
	//  contained in the given new scale vector
    public final void setScaleOnly(MlVector3 scale)
    {
        // Get translation.
        float[] translation = new float[3];
        getTranslation(translation);
        
        // Get rotation.
        float[] rotation = new float[3];
        getRotation(rotation);
        
        // Set transform.
        float[] s = new float[3];
        scale.getValue(s);
        setTransform(translation,rotation,s);
    }
    
	// Gets the the X,Y,Z fixed rotations from the transformation matrix  
	// and returns it in the given rotation vector.
	// Note: normalizes angles to positive degrees
	public final void getRotation(MlVector3 rotation)
    {
	    float[] r = new float[3];
	    getRotation(r);
	    rotation.setValue(r);
    }
	
	/**
	 * Get the rotation as an array of 3 components (theta x, theta y, theta z).
     * <p>
     * This algorithm can result in Gimbal lock. Use quaternion rotations to avoid
     * this.
     * </p>
	 * 
	 * @param r The result is returned in this array.
	 */
	public final void getRotation(float r[])
	{
        float[][] t = new float[4][3];
        int i, j;

        // Normalize the rotation matrix portion of the transform.
        for (i = 0; i < 3; i++)
        {
             float total = MlScalar.ML_SCALAR_ZERO;

             for (j = 0; j < 3; j++)
             {
                 t[i][j] = mMatrix[i][j];
                 total += t[i][j] * t[i][j];
             }
             if (total != MlScalar.ML_SCALAR_ZERO)
             {
                 total = (float)Math.sqrt(total);
                 for (j = 0; j < 3; j++)
                     t[i][j] = t[i][j] / total;
             }
        }
        
        // Get Y rotation
        r[1] = MlAngle.angleToDegrees(MlMath.mlAsin(t[2][0]));

        if (Math.abs(t[2][0] - MlScalar.ML_SCALAR_ONE) > 0.001) 
        {
            // Get X and Z rotations
            r[0] = MlAngle.angleToDegrees((float)MlMath.mlAtan2(-t[2][1],t[2][2]));
            r[2] = MlAngle.angleToDegrees((float)MlMath.mlAtan2(-t[1][0],t[0][0]));
        } else
        {
            // Have Gimbal lock -- lost Z degree of freedom, so
            // express rotation as only a X rotation.
            // This can be avoided by moving to quaternion rotations!
            r[0] = MlAngle.angleToDegrees((float)MlMath.mlAtan2(t[0][1],t[2][1]));
            r[2] = MlScalar.ML_SCALAR_ZERO;
        }

        for (i = 0; i < 3; i++)
            if (r[i] < MlScalar.ML_SCALAR_ZERO)
                r[i] += 360;
	}

    /**
     * Get rotation component of transform.
     * <p>
     * Gets the quaternion rotation contained in the transform matrix.
     * </p>
     *
     * @param rotation The output parameter containing the rotation.
     */
    public final void getRotation(MlRotation rotation)
    {
        rotation.setValue(this);
    }

    /**
     * Get the rotation as an array of 4 components (angle, theta x, theta y, theta z).
     * <p>
     * This algorithm can result in Gimbal lock. Use quaternion rotations to avoid
     * this.
     * </p>
     *
     * @param r The result is returned in this array.
     */
    public final void getAxisAngleRotation(float r[])
    {
        float[][] t = new float[4][3];
        int i, j;

        // Normalize the rotation matrix portion of the transform.
        for (i = 0; i < 3; i++)
        {
            float total = MlScalar.ML_SCALAR_ZERO;

            for (j = 0; j < 3; j++)
            {
                t[i][j] = mMatrix[i][j];
                total += t[i][j] * t[i][j];
            }
            if (total != MlScalar.ML_SCALAR_ZERO)
            {
                total = (float)Math.sqrt(total);
                for (j = 0; j < 3; j++)
                    t[i][j] = t[i][j] / total;
            }
        }

        float[][] m = new float[3][3];
        double[] axisAngle = toAxisAngle(m);
        r[0] = (float)axisAngle[0];
        r[1] = (float)axisAngle[1];
        r[2] = (float)axisAngle[2];
        r[3] = (float)axisAngle[3];
    }

    /*
     * This requires a pure rotation matrix 'm' as input.
     */
    private double[] toAxisAngle(float[][] m)
    {
        double angle, x, y, z;    // variables for result
        double epsilon = 0.01; // margin to allow for rounding errors
        double epsilon2 = 0.1; // margin to distinguish between 0 and 180 degrees

        // Optional check that input is pure rotation, 'isRotationMatrix' is defined at:
        // http://www.euclideanspace.com/maths/algebra/matrix/orthogonal/rotation/
        assert isRotationMatrix(m) : "not valid rotation matrix" ;  // for debugging

        if ((Math.abs(m[0][1] - m[1][0]) < epsilon)
                && (Math.abs(m[0][2] - m[2][0]) < epsilon)
                && (Math.abs(m[1][2] - m[2][1]) < epsilon))
        {
            // Singularity found.

            // First check for identity matrix which must have +1 for all terms
            // in leading diagonal and zero in other terms.
            if ((Math.abs(m[0][1] + m[1][0]) < epsilon2)
                    && (Math.abs(m[0][2] + m[2][0]) < epsilon2)
                    && (Math.abs(m[1][2] + m[2][1]) < epsilon2)
                    && (Math.abs(m[0][0] + m[1][1] + m[2][2]-3) < epsilon2))
            {
                // This singularity is identity matrix so angle = 0
                double[] axisAngle = new double[4]; // zero angle, arbitrary axis
                axisAngle[0] = 0; axisAngle[1] = 1; axisAngle[2] = 0; axisAngle[3] = 0;
                return axisAngle;
            }

            // Otherwise this singularity is angle = 180.
            angle = Math.PI;
            double xx = (m[0][0] + 1) / 2;
            double yy = (m[1][1] + 1) / 2;
            double zz = (m[2][2] + 1) / 2;
            double xy = (m[0][1] + m[1][0]) / 4;
            double xz = (m[0][2] + m[2][0]) / 4;
            double yz = (m[1][2] + m[2][1]) / 4;
            if ((xx > yy) && (xx > zz)) { // m[0][0] is the largest diagonal term
                if (xx < epsilon) {
                    x = 0;
                    y = 0.7071;
                    z = 0.7071;
                } else {
                    x = Math.sqrt(xx);
                    y = xy / x;
                    z = xz / x;
                }
            } else if (yy > zz) { // m[1][1] is the largest diagonal term
                if (yy < epsilon) {
                    x = 0.7071;
                    y = 0;
                    z = 0.7071;
                } else {
                    y = Math.sqrt(yy);
                    x = xy / y;
                    z = yz / y;
                }
            } else { // m[2][2] is the largest diagonal term so base result on this
                if (zz < epsilon) {
                    x = 0.7071;
                    y = 0.7071;
                    z = 0;
                } else {
                    z = Math.sqrt(zz);
                    x = xz / z;
                    y = yz / z;
                }
            }

            double[] axisAngle = new double[4]; // return 180 deg rotation
            axisAngle[0] = angle; axisAngle[1] = x; axisAngle[2] = y; axisAngle[3] = z;
            return axisAngle;
        }
        // As we have reached here there are no singularities so we can handle normally.
        double s = Math.sqrt((m[2][1] - m[1][2]) * (m[2][1] - m[1][2])
                + (m[0][2] - m[2][0]) * (m[0][2] - m[2][0])
                + (m[1][0] - m[0][1]) * (m[1][0] - m[0][1])); // used to normalise
        if (Math.abs(s) < 0.001) s = 1;
        // Prevent divide by zero, should not happen if matrix is orthogonal and should be
        // caught by singularity test above, but I've left it in just in case
        angle = Math.acos((m[0][0] + m[1][1] + m[2][2] - 1) / 2);
        x = (m[2][1] - m[1][2]) / s;
        y = (m[0][2] - m[2][0]) / s;
        z = (m[1][0] - m[0][1]) / s;

        double[] axisAngle = new double[4];
        axisAngle[0] = angle; axisAngle[1] = x; axisAngle[2] = y; axisAngle[3] = z;
        return axisAngle;
    }

    /*
     * This checks that the input is a pure rotation matrix 'm'.
     * The condition for this is:
     * R' * R = I
     * and
     * det(R) =1
     */
    private boolean isRotationMatrix(float[][] m)
    {
        double epsilon = 0.01; // margin to allow for rounding errors
        if (Math.abs(m[0][0]*m[0][1] + m[0][1]*m[1][1] + m[0][2]*m[1][2]) > epsilon) return false;
        if (Math.abs(m[0][0]*m[2][0] + m[0][1]*m[2][1] + m[0][2]*m[2][2]) > epsilon) return false;
        if (Math.abs(m[1][0]*m[2][0] + m[1][1]*m[2][1] + m[1][2]*m[2][2]) > epsilon) return false;
        if (Math.abs(m[0][0]*m[0][0] + m[0][1]*m[0][1] + m[0][2]*m[0][2] - 1) > epsilon) return false;
        if (Math.abs(m[1][0]*m[1][0] + m[1][1]*m[1][1] + m[1][2]*m[1][2] - 1) > epsilon) return false;
        if (Math.abs(m[2][0]*m[2][0] + m[2][1]*m[2][1] + m[2][2]*m[2][2] - 1) > epsilon) return false;
        return (Math.abs(det(m)-1) < epsilon);
        // det is defined here:
        // http://www.euclideanspace.com/maths/algebra/matrix/functions/determinant/threeD/
    }

    // Assumes matrix indices start from 0 (0, 1 and 2)
    // The value of the determinant for a 3×3 matrix is:
    //    det = m11 m22 m33 + m12 m23 m31 + m13 m21 m32 - m11 m23 m32 - m12 m 21 m33 - m13 m22 m31
    public double det(float[][] m)
    {
        double value =
            m[0][0]*m[1][1]*m[2][2] + m[0][1]*m[1][2]*m[2][0] +
            m[0][2]*m[1][0]*m[2][1] - m[0][0]*m[1][2]*m[2][1] -
            m[0][1]*m[1][0]*m[2][2] - m[0][2]*m[1][1]*m[2][0];
        return value;
    }
    /**
     * Set the rotation component of the transform.
     *
     * Sets matrix to the rotation matrix given by the new rotation.
     *
     * @param newRotation The rotation to set.
     */
    public void setRotation(MlRotation newRotation)
    {
        if (newRotation != null) {
            newRotation.getValue(this);
        }
    }

    /**
     * Set the rotation component of the transform.
     *
     * Sets only the rotation matrix of the transform to the rotation specified
     * by the given rotation quaternion, without otherwise disturbing the rest
     * of the transformation matrix.
     *
     * @param rotation The rotation matrix to set.
     */
    public void setRotationOnly(MlRotation rotation)
    {
        if (rotation != null) {
            MlVector3 translation = new MlVector3();
            MlVector3 scale = new MlVector3();
            getTranslation(translation);
            getScale(scale);

            setTransform(translation, rotation, scale);
        }
    }

    /**
     * Set the rotation component of the transform.
     *
     * Sets only the rotation matrix of the transform to the X,Y,Z fixed angle
     * rotations specified by the given rotation vector, without otherwise
     * disturbing the rest of the transformation matrix.
     *
     * @param rotation The rotation vector to set.
     */
    void setRotationOnly(MlVector3 rotation)
    {
        if (rotation != null) {
            MlVector3 translation = new MlVector3();
            MlVector3 scale = new MlVector3();
            getTranslation(translation);
            getScale(scale);

            setTransform(translation, rotation, scale);
        }
    }

    // Applies the fixed angle rotation to the matrix
    public final void applyRotation(MlVector3 rotation)
    {
        float[] r = new float[3];
        rotation.getValue(r);
        applyRotation(r);
    }
    
    public final void applyRotation(float[] r)
    {
        MlTransform mat = new MlTransform();
        mat.makeIdentity();

        // Apply Z Rotation
        if (r[2] != MlScalar.ML_SCALAR_ZERO)
        {
            float angle = MlAngle.degreesToAngle(r[2]);
            float sz = MlMath.mlSin(angle);
            float cz = MlMath.mlCos(angle);
            mat.mMatrix[0][0] = cz;
            mat.mMatrix[0][1] = sz;
            mat.mMatrix[1][0] = -sz;
            mat.mMatrix[1][1] = cz;
            mat.mMatrix[2][2] = MlScalar.ML_SCALAR_ONE;
            mat.mMatrix[0][2] = mat.mMatrix[1][2] = mat.mMatrix[2][0] =
            mat.mMatrix[2][1] = mat.mMatrix[3][0] = mat.mMatrix[3][1] =
            mat.mMatrix[3][2] = MlScalar.ML_SCALAR_ZERO;
            mulRight(mat);
        }

        // Apply Y Rotation
        if (r[1] != MlScalar.ML_SCALAR_ZERO)
        {
            float angle = MlAngle.degreesToAngle(r[1]);
            float sy = MlMath.mlSin(angle);
            float cy = MlMath.mlCos(angle);
            mat.mMatrix[0][0] = cy;
            mat.mMatrix[0][2] = -sy;
            mat.mMatrix[1][1] = MlScalar.ML_SCALAR_ONE;
            mat.mMatrix[2][0] = sy;
            mat.mMatrix[2][2] = cy;
            mat.mMatrix[0][1] = mat.mMatrix[1][0] = mat.mMatrix[1][2] =
            mat.mMatrix[2][1] = mat.mMatrix[3][0] = mat.mMatrix[3][1] =
            mat.mMatrix[3][2] = MlScalar.ML_SCALAR_ZERO;
            mulRight(mat);
         }

        // Apply X Rotation
        if (r[0] != MlScalar.ML_SCALAR_ZERO)
        {
            float angle = MlAngle.degreesToAngle(r[0]);
            float sx = MlMath.mlSin(angle);
            float cx = (float)MlMath.mlCos(angle);
            mat.mMatrix[0][0]= MlScalar.ML_SCALAR_ONE;
            mat.mMatrix[1][1] = cx;
            mat.mMatrix[1][2] = sx;
            mat.mMatrix[2][1] = -sx;
            mat.mMatrix[2][2] = cx;
            mat.mMatrix[0][1] = mat.mMatrix[0][2] = mat.mMatrix[1][0] =
            mat.mMatrix[2][0] = mat.mMatrix[3][0] = mat.mMatrix[3][1] =
            mat.mMatrix[3][2] = MlScalar.ML_SCALAR_ZERO;
            mulRight(mat);
        }
    }
    
	// Sets the given translation vector to the X,Y,Z translations contained 
	// in the given transformation matrix
    public final void getTranslation(MlVector3 translation)
    {
        float[] v = new float[3];
        getTranslation(v);
        translation.setValue(v);
    }
    
    public final void getTranslation(float[] v)
    {
        for (int i = 0; i < 3; i++)
            v[i] = mMatrix[3][i];
    }
    
    // Sets matrix to the translation matrix given by the vector
    public final void setTranslation(MlVector3 translation)
    {
        float[] t = new float[3];
        translation.getValue(t);

        mMatrix[0][0] = 1f; mMatrix[0][1] = 0f; mMatrix[0][2] = 0f;
        mMatrix[1][0] = 0f; mMatrix[1][1] = 1f; mMatrix[1][2] = 0f;
        mMatrix[2][0] = 0f; mMatrix[2][1] = 0f; mMatrix[2][2] = 1f;
        mMatrix[3][0] = t[0]; mMatrix[3][1] = t[1]; mMatrix[3][2] = t[2];
     }

    // Sets the translation of the given transform to the X,Y,Z translations 
    // contained in the given new translation vector.
    public final void setTranslationOnly(MlVector3 translation)
    {
        float[] t = new float[3];
        translation.getValue(t);
        setTranslationOnly(t);
    }

    private void setTranslationOnly(float[]t)
    {
        for (int i = 0; i < 3; i++)
            mMatrix[3][i] = t[i];
    }
    
    // Adds the given X,Y,Z translations to the existing translation
    // contained in the transform
    public final void applyTranslation(MlVector3 translation)
    {
        float[] t = new float[3];
        translation.getValue(t);

        for (int i = 0; i < 3; i++)
            mMatrix[3][i] = mMatrix[3][i] + t[i];
    }

}
