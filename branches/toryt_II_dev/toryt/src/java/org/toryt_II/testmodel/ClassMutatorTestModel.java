package org.toryt_II.testmodel;

import java.lang.reflect.Method;

import org.toryt.support.priorityList.PriorityList;




/**
 * A model of a constructor to test.
 *
 * @author Jan Dockx
 *
 * @invar toryt:cC org.toryt_II.contract.Collections;
 * @invar getTestFactoryList() != null;
 * @invar getTestFactoryList().getElementType() == TestFactory.class;
 */
public class ClassMutatorTestModel extends MethodTestModel {

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



  /*<property name="class mutator">*/
  //------------------------------------------------------------------

  /**
   * @basic
   * @init null;
   */
  public final Method getClassMutator() {
    return getMethod();
  }

  /**
   * @post new.getMethod() == method;
   */
  public final void setClassMutator(Method classMutator) {
    setMethod(classMutator);
  }

  /*</property>*/



  public PriorityList getTestFactoryList() {
    // TODO Auto-generated method stub
    return null;
  }

}