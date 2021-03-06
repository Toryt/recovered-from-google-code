package org.toryt;

import java.util.List;
import java.util.Set;


/**
 * The contract of a package. This is an aggregate of class contracts and of
 * subpackage contracts, and extra tests.
 * 
 * @invar getPackage() != null;
 * @invar getSubPackageContracts() != null;
 * @invar ! getSubPackageContracts().contains(null);
 * @invar (forall Object o; getSubPackageContracts().contains(o);
 *            o instanceof PackageContract);
 * @invar getClassContracts() != null;
 * @invar ! getClassContracts().contains(null);
 * @invar (forall Object o; getClassContracts().contains(o);
 *            o instanceof ClassContract);
 * 
 * 
 * MUDO getPackage = getPackage
 * 
 */
public interface PackageContract extends Contract {

  /*<section name="Meta Information">*/
  //  ------------------------------------------------------------------
  /** {@value} */
  public static final String CVS_REVISION = "$Revision$";
  /** {@value} */
  public static final String CVS_DATE = "$Date$";
  /** {@value} */
  public static final String CVS_STATE = "$State$";
  /** {@value} */
  public static final String CVS_TAG = "$Name$";
  /*</section>*/
  
  /**
   * @basic
   */
  Package getPackage();
  
  /**
   * @basic
   */
  Set getSubPackageContracts();

  /**
   * @basic
   */
  Set getClassContracts();

  /**
   * The union of the method tests of all subpackages and class contracts.
   */
  List getMethodTests() throws TorytException;

}