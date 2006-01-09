package org.toryt.util_I.collections;


import java.util.Set;


/**
 * <p>Set that does not allow <code>null</code> as
 *   element.</p>
 *
 * @author Jan Dockx
 */
public interface NoNullSet extends NoNullCollection, Set {

  /* <section name="Meta Information"> */
  //------------------------------------------------------------------
  /** {@value} */
  public static final String CVS_REVISION = "$Revision$";
  /** {@value} */
  public static final String CVS_DATE = "$Date$";
  /** {@value} */
  public static final String CVS_STATE = "$State$";
  /** {@value} */
  public static final String CVS_TAG = "$Name$";
  /* </section> */

}