package org.toryt;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.peopleware.bean_II.Beans;


/**
 * <p>Static methods to retrieve {@link TestObjectList} instances.</p>
 * 
 * @author    Jan Dockx
 * @author    PeopleWare n.v.
 */
public final class Cases {

  /*<section name="Meta Information">*/
  //------------------------------------------------------------------

  /** {@value} */
  public static final String CVS_REVISION = "$Revision$";
  /** {@value} */
  public static final String CVS_DATE = "$Date$";
  /** {@value} */
  public static final String CVS_STATE = "$State$";
  /** {@value} */
  public static final String CVS_TAG = "$Name$";

  /*</section>*/


  private final static List TOL_JAVA_LANG_INTEGER
      = Arrays.asList(
                new Integer[] {new Integer(0),
                               new Integer(1),
                               new Integer(-1),
                               new Integer(Integer.MAX_VALUE),
                               new Integer(Integer.MIN_VALUE),
                               new Integer(-Integer.MIN_VALUE),
                               new Integer(Integer.MAX_VALUE - 1),
                               new Integer(Integer.MIN_VALUE + 1),
                               new Integer(5),
                               new Integer(45),
                               new Integer(511),
                               new Integer(512),
                               new Integer(513),
                               new Integer(1023),
                               new Integer(1024),
                               new Integer(1025),
                               new Integer(-5),
                               new Integer(-45),
                               new Integer(-511),
                               new Integer(-512),
                               new Integer(-513),
                               new Integer(-1023),
                               new Integer(-1024),
                               new Integer(-1025)});
  
  private final static List TOL_JAVA_LANG_LONG
      = Arrays.asList(
            new Long[] {new Long(0),
                        new Long(1),
                        new Long(-1),
                        new Long(Long.MAX_VALUE),
                        new Long(Long.MIN_VALUE),
                        new Long(-Long.MIN_VALUE),
                        new Long(Long.MAX_VALUE - 1),
                        new Long(Long.MIN_VALUE + 1),
                        new Long(-Integer.MIN_VALUE),
                        new Long(Integer.MAX_VALUE),
                        new Long(Integer.MAX_VALUE - 1),
                        new Long(Integer.MIN_VALUE + 1),
                        new Long(5),
                        new Long(45),
                        new Long(511),
                        new Long(512),
                        new Long(513),
                        new Long(1023),
                        new Long(1024),
                        new Long(1025),
                        new Long(4 * Integer.MAX_VALUE),
                        new Long(10 * Integer.MAX_VALUE),
                        new Long(100000 * Integer.MAX_VALUE),
                        new Long(Long.MAX_VALUE / 4),
                        new Long(Long.MAX_VALUE / 2),
                        new Long(-5),
                        new Long(-45),
                        new Long(-511),
                        new Long(-512),
                        new Long(-513),
                        new Long(-1023),
                        new Long(-1024),
                        new Long(-1025),
                        new Long(Integer.MIN_VALUE),
                        new Long(4 * Integer.MIN_VALUE),
                        new Long(10 * Integer.MIN_VALUE),
                        new Long(100000 * Integer.MIN_VALUE),
                        new Long(Long.MIN_VALUE / 4),
                        new Long(Long.MIN_VALUE / 2)});

  
  private final static List TOL_JAVA_LANG_OBJECT
      = Arrays.asList(new Object[] {new Object()});

//  private final static TestObjectList TOL_JAVA_LANG_THROWABLE
//      = new TOL_Throwable(true);

  private final static List TOL_JAVA_LANG_STRING
      = Arrays.asList(
            new String[] {"",
                      "Jan Dockx",
                      "this is a test sentence with more then 1024 characters"
                        + "*0 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*1 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*2 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*3 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*4 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*5 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*6 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*7 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*8 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890"
                        + "*9 12345678901234567890123456789012345678901234567890"
                        +    "12345678901234567890123456789012345678901234567890",
                      "J",
                      "Jan",
                      "JanD",
                      " JanD",
                      "JanD ",
                      " Jan Dockx",
                      "Jan Dockx ",
                      " Jan Dockx ",
                      " JanD "});
  
  private final static Map TEST_OBJECT_LISTS = new HashMap();
  
  static {
    TEST_OBJECT_LISTS.put(Integer.class.getName(), TOL_JAVA_LANG_INTEGER);
    TEST_OBJECT_LISTS.put(Long.class.getName(), TOL_JAVA_LANG_LONG);
    TEST_OBJECT_LISTS.put(Object.class.getName(), TOL_JAVA_LANG_OBJECT);
//    TEST_OBJECT_LISTS.put(Throwable.class.getName(), TOL_JAVA_LANG_THROWABLE);
    TEST_OBJECT_LISTS.put(String.class.getName(), TOL_JAVA_LANG_STRING);
  }

  /**
   * Return a {@link TestObjectList} that contains {@link TestObjectFactory}
   * instances that generate test objects of type <code>fqcn</code>. This
   * method first looks in a map for a matching entry. If no match is
   * found, we look for a class in the same package as <code>fqcn</code>,
   * with name <code>Beans.prefixedFqcn({@link #TOL_PREFIX}, fqcn)</code>.
   * If no match is found in that way, we look for a constant with name
   * {@link #TOL_CONSTANT_NAME} in a class in the same package as
   * <code>fqcn</code>, with name
   * <code>Beans.prefixedFqcn({@link #TEST_PREFIX}, fqcn)</code>.
   * If no match is found still, we try to generate an automatic
   * {@link BeanTestObjectList} for type <code>fqcn</code>. If this still
   * fails, we throw an {@link TestObjectListNotFoundException}.<br />
   * If a match is found outside the map, it is added to the map,
   * which so functions as a cache.
   * 
   * @param fqcn
   *        The fully qualified class name of the type we want a
   *        {@link TestObjectList} for.
   */
  public static List findTestObjectList(String fqcn)
      throws TorytException {
    List result = null;
    result = (List)TEST_OBJECT_LISTS.get(fqcn);
    if (result != null) {
      return result;
    }
    // not found in map, look for separate class
    result = findTOLClass(fqcn);
    if (result != null) {
      return cached(fqcn, result);
    }
    // not found as separate class; look for class variable
    result = findTOLVariable(fqcn);
    if (result != null) {
      return cached(fqcn, result);
    }
    // not found as class variable; try auto BeanTOL
    result = createBTOL(fqcn);
    if (result != null) {
      return cached(fqcn, result);
    }
    // BeanTOL impossible; give up
    throw new TorytException(null, null);
  }
 
  private static List cached(String key, List tol) {
    TEST_OBJECT_LISTS.put(key, tol);
    return tol;
  }
  
  /**
   * <strong>= {@value}</strong>
   */
  public static final String TOL_PREFIX = "_TOL_";
  
  /**
   * <strong>= {@value}</strong>
   */
  public static final String TEST_PREFIX = "_Test_";
  
  private static List findTOLClass(String totn)
      throws TorytException {
    try {
      return (List)Beans.
                  instantiatePrefixed(null, TOL_PREFIX, totn);
    }
    catch (IOException e) {
      throw new TorytException(null, null);
//                               "class "
//                          + Beans.prefixedFqcn(TOL_PREFIX, totn)
//                          + " found, but failed to read",
//                          e);
    }
    catch (ClassNotFoundException e) {
      return null;
    }
  }
  
  /**
   * <strong>= {@value}</strong>
   */
  public static final String TOL_CONSTANT_NAME = "TEST_OBJECT_LIST";
  
  private static List findTOLVariable(String totn)
      throws TorytException {
    try {
      return (List)Beans.constant(
                 Beans.prefixedFqcn(TEST_PREFIX, TOL_CONSTANT_NAME),
                 totn);
    }
    catch (NullPointerException e) {
      throw new TorytException(null, e);
    }
    catch (SecurityException e) {
      throw new TorytException(null, e);
    }
    catch (IllegalArgumentException e) {
      throw new TorytException(null, e);
    }
    catch (LinkageError e) {
      throw new TorytException(null, e);
    }
    catch (ClassNotFoundException e) {
      return null;
    }
    catch (NoSuchFieldException e) {
      return null;
    }
    catch (IllegalAccessException e) {
      throw new TorytException(null, e);
    }
  }
  
  private static /*Bean*/List  createBTOL(String totn)
      throws TorytException {
    Object createAWarning;
    return null; // MUDO stub
  }
  
  /**
   * Convenience method to look for {@link TestObjectList} instances
   * based on a type, instead of on a FQCN.
   * 
   * @see #findTestObjectList(String)
   * 
   * @pre type != null;
   * @return findTestObjectList(type.getName());
   * @throws TestObjectListNotFoundException
   * @throws TestFault
   */
  public static List findTestObjectList(Class type)
      throws TorytException {
    assert type != null;
    return findTestObjectList(type.getName());
  }

//  /**
//   * Convenience method to look for {@link TestObjectList} instances,
//   * and immediately return a list iterator of that instance.
//   * 
//   * @see #findTestObjectList(String)
//   * 
//   * @return findTestObjectList(fqcn).listIterator();
//   * @throws TestObjectListNotFoundException
//   * @throws TestFault
//   */
//  public static ListIterator findTestObjectListIterator(String fqcn)
//      throws TestObjectListNotFoundException, TestFault {
//    return findTestObjectList(fqcn).listIterator();
//  }
//
//  /**
//   * Convenience method to look for {@link TestObjectList} instances,
//   * and immediately return a list iterator of that instance, given
//   * a start index.
//   * 
//   * @see #findTestObjectList(String)
//   * 
//   * @return findTestObjectList(fqcn).listIterator();
//   * @throws TestObjectListNotFoundException
//   * @throws TestFault
//   * @throws IndexOutOfBoundsException
//   */
//  public static ListIterator findTestObjectListIterator(String fqcn, int startIndex)
//      throws TestObjectListNotFoundException, TestFault, IndexOutOfBoundsException {
//    return findTestObjectList(fqcn).listIterator(startIndex);
//  }
  
}
